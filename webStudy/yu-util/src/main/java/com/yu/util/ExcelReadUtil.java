package com.yu.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


/**
 * 读取表格中的数据(读取不能进行共用)
 * @author Wangxinglong
 * @version V3.6
 * @date 2016年9月14日 上午11:30:02
 */
public class ExcelReadUtil{
	
	/**
	 * 
	 * @author Wangxinglong
	 * @version V3.6
	 * @date 2016年9月18日 上午9:10:14
	 * @param filePath
	 * @param filePath
	 * @param row 
	 * @param column 
	 * @return
	 */
	/**
	 * 获取表格中指定的列的数据(仅适用于取电话号只能解析包括2003及以下版本的)
	 * @author Wangxinglong
	 * @version V3.7
	 * @date 2016年10月19日 下午1:39:29
	 * @param filePath
	 * @param tempSheetNo 第几张表(从1开始)
	 * @param tempRow  要在第几行取值的列数（从1开始）
	 * @param tempColumn 要在第几列取值的列数（从1开始）
	 * @return
	 */
	public static List<String> readExcelValueVersion2003(String filePath,Integer tempSheetNo,Integer tempRow ,Integer tempColumn){
		Workbook book = null;
		//计算校验表的基本配置
		Integer sheetNo = checkNo(tempSheetNo);
		Integer row = checkNo(tempRow);
		Integer column = checkNo(tempColumn);
		List<String> phoneNoList = new ArrayList<String>();
		try {
			if(!StringUtil.isEmpty(filePath)){
				InputStream is = new FileInputStream(filePath);
				book = Workbook.getWorkbook(is);
				// 获得第一个工作表对象
	            Sheet sheet = book.getSheet(sheetNo);
	            //获取行
	            int rows=sheet.getRows();
	            //获取列
	            //int columns=sheet.getColumns();
	            // 遍历每行每列的单元格(因为第一行是标题所以从第二行开始)
	            for(int  r = row ;r<rows;r++){
	                    Cell cell = sheet.getCell(column, r);
	                    String phoneNo = cell.getContents();
	                    //对数据进行校验
	                    if(!StringUtil.isEmpty(phoneNo)){
	                    	//进行数据校验(使用正则校验)
	                    	boolean bool = RegexUtil.matcherPhone(phoneNo);
	                    	if(bool){
	                    		phoneNoList.add(phoneNo);
	                    	}
	                    }
	                }
	            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phoneNoList;
	}
	

	/**
	 * 校验电话号码是否存在不符合格式的(只能解析包括2003及以下版本的)
	 * @author Wangxinglong
	 * @version V3.7
	 * @date 2016年10月19日 下午1:40:25
	 * @param filePath
	 * @param tempSheetNo
	 * @param tempRow
	 * @param tempColumn
	 * @return
	 */
	public static String readExcelPhoneNoAndNoCheckVersion2003(String filePath,Integer tempSheetNo,Integer tempRow ,Integer tempColumn){
		Workbook book = null;
		//计算校验表的基本配置
		Integer sheetNo = checkNo(tempSheetNo);
		Integer row = checkNo(tempRow);
		Integer column = checkNo(tempColumn);
		List<String> phoneNoList = new ArrayList<String>();
		try {
			if(!StringUtil.isEmpty(filePath)){
				InputStream is = new FileInputStream(filePath);
				book = Workbook.getWorkbook(is);
				// 获得第一个工作表对象
	            Sheet sheet = book.getSheet(sheetNo);
	            //获取行
	            int rows=sheet.getRows();
	            //获取列
	            //int columns=sheet.getColumns();
	            // 遍历每行每列的单元格(因为第一行是标题所以从第二行开始)
	            for(int  r = row ;r < rows;r++){
	                    Cell cell = sheet.getCell(column, r);
	                    String phoneNo = cell.getContents();
	                    //对数据进行校验
	                    if(!StringUtil.isEmpty(phoneNo)){
	                    	//进行数据校验(使用正则校验)
	                    	boolean bool = RegexUtil.matcherPhone(phoneNo);
	                    	if(bool){
	                    		phoneNoList.add(phoneNo);
	                    	}else{
	                    		return "fail";
	                    	}
	                    }
	                }
	            }
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		if(CollectionUtils.isEmpty(phoneNoList)){
			return "fail";
		}
		return "success";
	}
	
	/**
	 * 读取表格获取电话号码列表(默认只读第一张表格，版本是2007版本以上)
	 * @author Wangxinglong
	 * @version V3.7
	 * @date 2016年10月19日 下午1:41:18
	 * @param filePath
	 * @param row
	 * @param column
	 * @return
	 */
	public static List<String> readExcelValueVersion2007(String filePath,Integer row ,Integer column){
		Integer sheetNo = 0;
		List<String> phoneNoList = readExcelValueVersion2007(filePath,sheetNo,row,column);
		return phoneNoList;
	}
	
	
	
	/**
	 * 读取表格获取电话号码列表(默认只读第一张表格，版本是2007版本以上)
	 * @author Wangxinglong
	 * @version V3.6
	 * @date 2016年9月28日 下午2:17:15
	 * @param filePath
	 * @param row  插曲的数据从第几行开始查询,从自然数开始(方法已近进行自然数调整)
	 * @param column 插曲的数据从第几列开始查询,从自然数开始(方法已近进行自然数调整)
	 * @param sheetNo  表格中的第几张表格，从自然数开始(方法已近进行自然数调整,不能是负数)
	 * @return
	 */
	public static List<String> readExcelValueVersion2007(String filePath,Integer tempSheetNo,Integer tempRow ,Integer tempColumn){
		//计算表格配置
		Integer sheetNo = checkNo(tempSheetNo);
		Integer row = checkNo(tempRow);
		Integer column = checkNo(tempColumn);
		try {
			File file = new File(filePath);
			InputStream inputStream = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			//获取表格
			XSSFSheet sheet = workBook.getSheetAt(sheetNo);
			
			//总行数(即最后一行的行号,从0算起)
			Integer rowCount = sheet.getLastRowNum();
		    String cellValue = null;
		    List<String> list = new ArrayList<String>();
		    
		    for(int i = row; i <= rowCount; i++){
		    	cellValue = getCellValue(i,column,sheet);
		    	if(!StringUtil.isEmpty(cellValue)){
		    		//格式校验
		    		boolean bool = RegexUtil.matcherPhone(cellValue);
		    		if(bool){
		    			list.add(cellValue);
		    		}
		    	}
		    }
		    return list;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	/**
	 * 计算校验表的表码和行和列号
	 * @author Wangxinglong
	 * @version V3.6
	 * @date 2016年9月28日 下午3:08:06
	 */
	private static Integer checkNo(Integer tempNo){
		if(IntegerUtils.isNotZero(tempNo) && tempNo >= 1){
			tempNo = tempNo - 1;
		}
		if(tempNo == null){
			tempNo = 0;
		}
		return tempNo;
	}
	
	
	
	/**
	 * 获取单元格内容并返回字符串
	 * @author Wangxinglong
	 * @version V3.6
	 * @date 2016年9月28日 下午3:22:46
	 * @param i
	 * @param column
	 * @param sheet
	 * @return
	 */
	private static String getCellValue(int i,int column,XSSFSheet sheet){
		XSSFRow rows = sheet.getRow(i);
		XSSFCell cell = rows.getCell(column);
		//读取电话号码时，进行这样格式化，否则不能正确输出
	    DecimalFormat format = new DecimalFormat("#");
	    String cellValue = null;
		switch(cell.getCellType()){
		case XSSFCell.CELL_TYPE_NUMERIC:
			cellValue = format.format(cell.getNumericCellValue());
			break;
		case XSSFCell.CELL_TYPE_STRING:
			cellValue = (cell.getStringCellValue());
			break;
		default:  
            cellValue = null;	
		}
		return cellValue;
	}
	
	/**
	 * 校验表格中的号码及格式(2007)
	 * @author Wangxinglong
	 * @version V3.7
	 * @date 2016年10月19日 下午1:41:58
	 * @param filePath
	 * @param row
	 * @param column
	 * @return
	 */
	public static String readExcelPhoneNoAndNoCheckVersion2007(String filePath,Integer row ,Integer column){
		Integer sheetNo = 0;
		String str = readExcelPhoneNoAndNoCheckVersion2007(filePath,sheetNo,row,column);
		return str;

		
	}
	
	/**
	 * 校验表格中的号码及格式(2007)
	 * @author Wangxinglong
	 * @version V3.7
	 * @date 2016年10月19日 下午1:42:26
	 * @param filePath
	 * @param tempSheetNo
	 * @param tempRow
	 * @param tempColumn
	 * @return
	 */
	public static String readExcelPhoneNoAndNoCheckVersion2007(String filePath,Integer tempSheetNo,Integer tempRow ,Integer tempColumn){
		// 计算表格配置
		Integer sheetNo = checkNo(tempSheetNo);
		Integer row = checkNo(tempRow);
		Integer column = checkNo(tempColumn);
		List<String> list = new ArrayList<String>();
		try {
			File file = new File(filePath);
			InputStream inputStream = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			// 获取表格
			XSSFSheet sheet = workBook.getSheetAt(sheetNo);

			// 总行数(即最后一行的行号,从0算起)
			Integer rowCount = sheet.getLastRowNum();
			String cellValue = null;
			
			for (int i = row; i <= rowCount; i++) {
				cellValue = getCellValue(i, column, sheet);
				if (!StringUtil.isEmpty(cellValue)) {
					// 格式校验
					boolean bool = RegexUtil.matcherPhone(cellValue);
					if (bool) {
						list.add(cellValue);
					}else{
						return "fail";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		if(CollectionUtils.isEmpty(list)){
			return "fail";
		}
		return "success";
	}
	

	
	/**
	 * 自测的方法
	 * @author Wangxinglong
	 * @version V3.6
	 * @date 2016年9月14日 上午11:37:53
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	public static void readExcelPhoneNo1(String filePath){
		Workbook book = null;
		try {
			if(!StringUtil.isEmpty(filePath)){
				InputStream is = new FileInputStream(filePath);
				book = Workbook.getWorkbook(is);
				// 获得第一个工作表对象
	            Sheet sheet = book.getSheet(0);
	            //获取行
	            int rows=sheet.getRows();
	            //获取列
	            int columns=sheet.getColumns();
	            // 遍历每行每列的单元格
	            for(int i=0;i<rows;i++){
	                for(int j=0;j<columns;j++){
	                    Cell cell = sheet.getCell(j, i);
	                    String result = cell.getContents();
	                    if(j==0){
	                        System.out.print("标题++++++++"+result+" ");
	                    }
	                    if(j==1){
	                        System.out.print("内容++++++++"+result+" ");
	                    }
	                    if((j+1)%2==0){ 
	                        System.out.println();
	                    }
	                }
	            }
	            System.out.println("========");
	            // 得到第一列第一行的单元格
	            Cell cell1 = sheet.getCell(0, 0);
	            String result = cell1.getContents();
	            System.out.println(result);
	            System.out.println("========");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 测试问题
	 * @author Wangxinglong
	 * @version V3.6
	 * @date 2016年9月14日 下午3:38:29
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String filepath = "http://192.168.2.74:84/resource//smsmasstask/filePath/201609141125036723.xls";
		// 开始时间
		Long startTime = System.currentTimeMillis();
		System.out.println("------------"+startTime+"------------");
		readExcelPhoneNo1(filepath);
		// 结束时间
		Long endTime = System.currentTimeMillis();
		System.out.println("------------"+endTime+"------------");
	}
	
	
	public void test1(){
		String tempPath = "http://192.168.2.74:84/resource//smsmasstask/filePath/201609141125036723.xls";
		//String downloadPhotoUrl = MimspPropertyConfig.getProperty("photo_server");
		String downloadPhotoUrl = "D:/mimsp_resource";
		String path = tempPath.substring(tempPath.indexOf("/smsmasstask"));
		System.out.println("++++++"+path+"+++++++++");
		String filepath = downloadPhotoUrl + path; 
		// 开始时间http://192.168.2.74:84/resource//smsmasstask/filePath/201609141125036723.xls
		Long startTime = System.currentTimeMillis();
		System.out.println("------------"+startTime+"------------");
		readExcelPhoneNo1(filepath);
		// 结束时间
		Long endTime = System.currentTimeMillis();
		System.out.println("------------"+endTime+"------------");
	}
	
	
}




