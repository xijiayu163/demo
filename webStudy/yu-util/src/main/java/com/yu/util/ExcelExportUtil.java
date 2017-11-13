package com.yu.util;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang3.StringUtils;

import com.yu.util.enums.Excel;

/**
 * 通用excel操作，主要将数据转换为excel文件
 * @author Cassie He
 * @date 2016年1月19日 上午11:34:13
 * @since 2.11
 */
@SuppressWarnings(value={"rawtypes","unchecked"})
public class ExcelExportUtil{
	private static final String _TITLE = "Sheet1";
	
	/**
	 * 将数据集输出到Excel
	 * <br><b><font color=red>注：当excel文档出现10万级别的大数据文件可能导致OOM内存溢出</font></b>
	 * @author Cassie He
	 * @date 2016年1月19日 下午2:22:18
	 * @since 2.11
	 * @param title 工作簿名称
	 * @param pojoClass 数据集对象类型
	 * @param dataSet 数据集
	 * @param out 文件输出流
	 */
	public static void exportExcel(String title, Class pojoClass, Collection dataSet, OutputStream out) {
		//使用userModel模式实现的，当excel文档出现10万级别的大数据文件可能导致OOM内存溢出
		exportExcelInUserModel(title, pojoClass, dataSet, out);
		//使用eventModel实现，可以一边读一边处理，效率较高，但是实现复杂，暂时未实现
	}
	/**
	 * 将数据集输出到Excel
	 * <br><b><font color=red>注：当excel文档出现10万级别的大数据文件可能导致OOM内存溢出</font></b>
	 * @author Cassie He
	 * @date 2016年1月19日 下午2:20:29
	 * @since 2.11
	 * @param pojoClass 数据集对象类型
	 * @param dataSet 数据集
	 * @param out 文件输出流
	 */
	public static void exportExcel(Class pojoClass, Collection dataSet, OutputStream out) {
		//使用userModel模式实现的，当excel文档出现10万级别的大数据文件可能导致OOM内存溢出
		exportExcelInUserModel(null, pojoClass, dataSet, out);
		//使用eventModel实现，可以一边读一边处理，效率较高，但是实现复杂，暂时未实现
	}

	private static void exportExcelInUserModel(String title, Class pojoClass, Collection dataSet, OutputStream out) {
		try {
			// 首先检查数据看是否是正确的
			if (dataSet == null || dataSet.size() == 0) {
				throw new Exception("导出数据为空！");
			}
			if (out == null || pojoClass == null) {
				throw new Exception("传入参数不能为空！");
			}
			// 创建新的一页
			String sheetTitle = StringUtils.isBlank(title) ? _TITLE : title;
			// 声明一个工作薄
			WritableWorkbook workbook = Workbook.createWorkbook(out);
			// 生成一个表格
			WritableSheet sheet = workbook.createSheet(sheetTitle, 0);

			// 标题
			List<String> exportFieldTitle = new ArrayList<String>();
			List<Integer> exportFieldWidth = new ArrayList<Integer>();
			// 拿到所有列名，以及导出的字段的get方法
			List<Method> methodObj = new ArrayList<Method>();
			Map<String, Method> convertMethod = new HashMap<String, Method>();
			// 得到所有方法
			Method methods[] = pojoClass.getDeclaredMethods();
			// 得到所有字段
			Field fileds[] = pojoClass.getDeclaredFields();
			for (int i = 0; i < methods.length; i++) {//支持方法注解
				Method method = methods[i];
				Excel excel = method.getAnnotation(Excel.class);
				// 如果设置了annottion
				if (excel != null) {
					// 添加到标题
					exportFieldTitle.add(excel.exportName());
					// 添加标题的列宽
					exportFieldWidth.add(excel.exportFieldWidth());
					methodObj.add(method);
					String methodName = method.getName();
					if (!methodName.endsWith("Convert") && excel.exportConvertSign() == 1) {
						StringBuffer getConvertMethodName = new StringBuffer(methodName);
						getConvertMethodName.append("Convert");
						Method getConvertMethod = pojoClass.getMethod(getConvertMethodName.toString(), new Class[] {});
						convertMethod.put(methodName, getConvertMethod);
					}
				}
			}
			// 遍历整个filed
			for (int i = 0; i < fileds.length; i++) {//支持属性注解
				Field field = fileds[i];
				
				Excel excel = field.getAnnotation(Excel.class);
				// 如果设置了annottion
				if (excel != null) {
					// 添加到标题
					exportFieldTitle.add(excel.exportName());
					// 添加标题的列宽
					exportFieldWidth.add(excel.exportFieldWidth());
					// 添加到需要导出的字段的方法
					String fieldname = field.getName();
					StringBuffer getMethodName = new StringBuffer("get");
					getMethodName.append(fieldname.substring(0, 1).toUpperCase());
					getMethodName.append(fieldname.substring(1));

					Method getMethod = pojoClass.getMethod(getMethodName.toString(), new Class[] {});

					methodObj.add(getMethod);
					if (excel.exportConvertSign() == 1) {
						StringBuffer getConvertMethodName = new StringBuffer("get");
						getConvertMethodName.append(fieldname.substring(0, 1).toUpperCase());
						getConvertMethodName.append(fieldname.substring(1));
						getConvertMethodName.append("Convert");
						Method getConvertMethod = pojoClass.getMethod(getConvertMethodName.toString(), new Class[] {});
						convertMethod.put(getMethodName.toString(), getConvertMethod);
					}
				}
			}
			int index = 0;
			// 产生表格标题行
			for (int i = 0, exportFieldTitleSize = exportFieldTitle.size(); i < exportFieldTitleSize; i++) {
				Label header = new Label(i, index, exportFieldTitle.get(i));
				WritableCellFormat cellFormat = new WritableCellFormat();  
				cellFormat.setAlignment(jxl.format.Alignment.CENTRE);//居中对其
				header.setCellFormat(cellFormat);
				sheet.addCell(header);
				sheet.setColumnView(i, exportFieldWidth.get(i));
			}
			Iterator its = dataSet.iterator();
			// 循环插入剩下的集合
			while (its.hasNext()) {
				//从第二行开始写，第一行是标题
				index++;
				Object t = its.next();
				for (int k = 0, methodObjSize = methodObj.size(); k < methodObjSize; k++) {
					Method getMethod = methodObj.get(k);
					Object value = null;
					if (convertMethod.containsKey(getMethod.getName())) {
						Method cm = convertMethod.get(getMethod.getName());
						value = cm.invoke(t, new Object[] {});
					} else {
						getMethod.setAccessible(true);
						value = getMethod.invoke(t, new Object[]{});
					}
					Label label = new Label(k, index, null !=value ? value.toString() : "");
					WritableCellFormat cellFormat = new WritableCellFormat();  
					cellFormat.setAlignment(jxl.format.Alignment.CENTRE);  
					label.setCellFormat(cellFormat);
					sheet.addCell(label);
				}
			}
			// 把创建的内容写入到输出流中，并关闭输出流
			workbook.write();
			workbook.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 构造一个模拟的List来测试，实际使用时，这个集合用从数据库中查出来
		Demo pojo2 = new Demo();
		pojo2.setName("第一行数据");
		pojo2.setAge(28);
		pojo2.setSex(2);
		pojo2.setDesc("abcdefghijklmnop");
		pojo2.setBirthDate(new Date());
		pojo2.setIsVip(true);
		List list = new ArrayList();
		list.add(pojo2);
		for (int i = 0; i < 9999; i++) {
			Demo pojo = new Demo();
			pojo.setName("一二三四五六七八九");
			pojo.setAge(22);
			pojo.setSex(1);
			pojo.setDesc("abcdefghijklmnop");
			pojo.setBirthDate(new Date());
			pojo.setIsVip(false);
			list.add(pojo);
		}
		// 构造输出对象，可以从response输出，直接向用户提供下载
		OutputStream out = new FileOutputStream("D://testOne.xls");
		// 开始时间
		Long l = System.currentTimeMillis();
		ExcelExportUtil.exportExcel("测试", Demo.class, list, out);
		out.close();
		// 结束时间
		Long s = System.currentTimeMillis();

	}
}

class Demo {
	@Excel(exportName = "患者姓名", exportFieldWidth = 18, exportConvertSign = 0, importConvertSign = 0)//属性注解
	private String name;
	@Excel(exportName = "年龄", exportFieldWidth = 4, exportConvertSign = 0, importConvertSign = 0)
	private Integer age;
	private Integer sex;
	@Excel(exportName = "出生日期", exportFieldWidth = 20, exportConvertSign = 1, importConvertSign = 1)
	private Date birthDate;
	@Excel(exportName = "描述", exportFieldWidth = 30, exportConvertSign = 0, importConvertSign = 0)
	private String desc;
	@Excel(exportName = "是否VIP", exportFieldWidth = 7, exportConvertSign = 1, importConvertSign = 1)
	private Boolean isVip;

	// convertSign=1时必须加入转化方法 不加入会报错 返回值为String 用于翻译
	// convertSign=0不需翻译，不用书写转化
	// 导入需要 set ,导出需要get
	@Excel(exportName = "ddd", exportFieldWidth = 4)//方法注解
	public String getTest(Integer i, Integer j) {
		return i+"dksjf"+j;
	}
	@Excel(exportName = "性别", exportFieldWidth = 4, exportConvertSign=1)//方法注解
	public String getSexConvert() {
		if (sex == 1) {
			return "男";
		} else if (sex == 2) {
			return "女";
		} else {
			return "";
		}
	}
	public void setSexConvert(String text) {
		if ("男".equals(text)) {
			sex = 1;
		}
		if ("女".equals(text)) {
			sex = 2;
		}
	}
	public String getBirthDateConvert() {
		if (birthDate == null) {
			return "";
		}
		return "2015-11-11";
	}
	public void setBirthDateConvert(String text) {
		if (text != null && !"".equals(text.trim())) {
			birthDate = new Date();
		}
	}
	public String getIsVipConvert() {
		if (isVip == null) {
			return "";
		}
		if (isVip) {
			return "是";
		} else {
			return "否";
		}
	}
	public void setIsVipConvert(String text) {
		if ("是".equals(text)) {
			isVip = true;
		}
		if ("否".equals(text)) {
			isVip = false;
		}
	}
	// getter and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Boolean getIsVip() {
		return isVip;
	}
	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

}
