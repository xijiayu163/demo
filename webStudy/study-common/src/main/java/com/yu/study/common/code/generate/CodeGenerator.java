package com.yu.study.common.code.generate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

import com.yu.util.FileUtil;

public class CodeGenerator {
	private String scanPoDirectory;
	private String poPackage;
	private String daoPackage;
	private String daoImplPackage;
	private String doServicePackage;
	private String doServiceImplPackage;
	private String dosPackage;
	private String exportDirectory="F:\\github\\study\\demo\\webStudy\\generateFiles";
	private String line ="\r\n";
	private Map<String, String> primaryKeyMap = new HashMap<>();
	
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	public String getDaoPackage() {
		return daoPackage;
	}
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	public String getDaoImplPackage() {
		return daoImplPackage;
	}
	public void setDaoImplPackage(String daoImplPackage) {
		this.daoImplPackage = daoImplPackage;
	}
	public String getDoServicePackage() {
		return doServicePackage;
	}
	public void setDoServicePackage(String doServicePackage) {
		this.doServicePackage = doServicePackage;
	}
	public String getDoServiceImplPackage() {
		return doServiceImplPackage;
	}
	public void setDoServiceImplPackage(String doServiceImplPackage) {
		this.doServiceImplPackage = doServiceImplPackage;
	}
	public String getDosPackage() {
		return dosPackage;
	}
	public void setDosPackage(String dosPackage) {
		this.dosPackage = dosPackage;
	}
	public String getExportDirectory() {
		return exportDirectory;
	}
	public void setExportDirectory(String exportDirectory) {
		this.exportDirectory = exportDirectory;
	}
	public String getScanPoDirectory() {
		return scanPoDirectory;
	}
	public void setScanPoDirectory(String scanPoDirectory) {
		this.scanPoDirectory = scanPoDirectory;
	}
	
	private String removePoPrefix(String poName,String suffix){
		int lastIndexOf = poName.lastIndexOf(suffix);
		return poName.substring(0,lastIndexOf);
	}
	
	private String getDaoName(String poName){
		return removePoPrefix(poName,"Po")+"Dao";
	}
	
	private String getDaoImplName(String poName){
		return  removePoPrefix(poName,"Po")+"DaoImpl";
	}
	
	private String getDoName(String poName){
		return  removePoPrefix(poName,"Po")+"Do";
	}
	
	private String getDoServiceName(String poName){
		return  removePoPrefix(poName,"Po")+"DoService";
	}
	
	private String getDoServiceImplName(String poName){
		return  removePoPrefix(poName,"Po")+"DoServiceImpl";
	}
	
	private void writeTxtFile(String content, File fileName) throws Exception {
		RandomAccessFile mm = null;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName);
			o.write(content.getBytes("UTF-8"));
			o.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (mm != null) {
				mm.close();
			}
		}
	} 
	
	public void generateDoJavaFile(String poName) throws Exception{
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(String.format("package %s;",getDosPackage())+line); 
		sBuilder.append(line);
		sBuilder.append(String.format("import %s.%s;",getPoPackage(),poName)+line); 
		sBuilder.append(line);
		
		sBuilder.append(String.format("public class %s extends %s{",getDoName(poName),poName)+line); 
		sBuilder.append("	private static final long serialVersionUID = 1L;"+line);
		sBuilder.append("}");
		System.out.println(sBuilder.toString());
		
		String folder = getExportDirectory()+File.separator+"dos";
		FileUtil.newFolder(folder);
		File f = new File(folder+File.separator+getDoName(poName)+".java");
		f.createNewFile(); 
		writeTxtFile(sBuilder.toString(),f);
		
//		package com.yu.study.dos;
//
//		import com.yu.study.dao.po.UserPo;
//
//		public class UserDo extends UserPo{
//			private static final long serialVersionUID = 1L;
//		}

	}
	
	public void generateDaoJavaFile(String poName) throws Exception{
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(String.format("package %s;",getDaoPackage())+line); 
		sBuilder.append(line);
		sBuilder.append("import com.yu.study.common.dao.BaseDao;"+line);
		sBuilder.append(String.format("import %s.%s;",getPoPackage(),poName)+line); 
		sBuilder.append(line);
		
		sBuilder.append(String.format("public interface %s extends BaseDao<%s>{",getDaoName(poName),poName)+line); 
		sBuilder.append(line);
		sBuilder.append("}");
		System.out.println(sBuilder.toString());
		
		String folder = getExportDirectory()+File.separator+"dao";
		FileUtil.newFolder(folder);
		File f = new File(folder+File.separator+getDaoName(poName)+".java");
		f.createNewFile(); 
		writeTxtFile(sBuilder.toString(),f);
		
//		package com.yu.study.dao;
//
//		import com.yu.study.common.dao.BaseDao;
//		import com.yu.study.dao.po.OrderPo;
//
//		public interface OrderDao extends BaseDao<OrderPo>{
//
//		}

	}
	
	public void generateDaoImplJavaFile(String poName) throws Exception{
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(String.format("package %s;",getDaoImplPackage())+line); 
		sBuilder.append(line);
		sBuilder.append("import org.springframework.stereotype.Repository;"+line);
		sBuilder.append("import com.yu.study.common.dao.BaseDaoImpl;"+line);
		sBuilder.append(String.format("import %s.%s;",getDaoPackage(),getDaoName(poName))+line); 
		sBuilder.append(String.format("import %s.%s;",getPoPackage(),poName)+line);
		sBuilder.append(line);
		
		sBuilder.append("@Repository"+line);
		sBuilder.append(String.format("public class %s extends BaseDaoImpl<%s> implements %s{",getDaoImplName(poName),poName,getDaoName(poName))+line); 
		sBuilder.append(line);
		sBuilder.append("}");
		System.out.println(sBuilder.toString());
		
		String folder = getExportDirectory()+File.separator+"daoImpl";
		FileUtil.newFolder(folder);
		File f = new File(folder+File.separator+getDaoImplName(poName)+".java");
		f.createNewFile(); 
		writeTxtFile(sBuilder.toString(),f);
		
//		package com.yu.study.dao.impl;
//
//		import org.springframework.stereotype.Repository;
//
//		import com.yu.study.common.dao.BaseDaoImpl;
//		import com.yu.study.dao.OrderDao;
//		import com.yu.study.dao.po.OrderPo;
//
//		@Repository
//		public class OrderDaoImpl extends BaseDaoImpl<OrderPo> implements OrderDao{
//			
//		}

	}
	
	public void generateDoServiceJavaFile(String poName) throws Exception{
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(String.format("package %s;",getDoServicePackage())+line); 
		sBuilder.append(line);
		sBuilder.append("import com.yu.study.common.service.BaseService;"+line);
		sBuilder.append(String.format("import %s.%s;",getDosPackage(),getDoName(poName))+line); 
		sBuilder.append(line);
		
		sBuilder.append(String.format("public interface %s extends BaseService<%s>{",getDoServiceName(poName),getDoName(poName))+line); 
		sBuilder.append(line);
		sBuilder.append("}");
		System.out.println(sBuilder.toString());
		
		String folder = getExportDirectory()+File.separator+"doService";
		FileUtil.newFolder(folder);
		File f = new File(folder+File.separator+getDoServiceName(poName)+".java");
		f.createNewFile(); 
		writeTxtFile(sBuilder.toString(),f);

//		package com.yu.study.service.dos;
//
//		import com.yu.study.common.service.BaseService;
//		import com.yu.study.dos.OrderDo;
//
//		public interface OrderDoService extends BaseService<OrderDo>{
//			
//		}
	}
	
	public void generateDoServiceImplJavaFile(String poName) throws Exception{
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(String.format("package %s;",getDoServiceImplPackage())+line); 
		sBuilder.append(line);
		sBuilder.append("import org.springframework.stereotype.Service;"+line);
		sBuilder.append("import com.yu.study.common.service.BaseDoServiceImpl;"+line);
		sBuilder.append(String.format("import %s.%s;",getPoPackage(),poName)+line); 
		sBuilder.append(String.format("import %s.%s;",getDosPackage(),getDoName(poName))+line);
		sBuilder.append(String.format("import %s.%s;",getDoServicePackage(),getDoServiceName(poName))+line);
		sBuilder.append(line);
		
		sBuilder.append("@Service"+line);
		sBuilder.append(String.format("public class %s extends BaseDoServiceImpl<%s,%s> implements %s{"
				,getDoServiceImplName(poName),getDoName(poName),poName,getDoServiceName(poName))+line); 
		sBuilder.append(line);
		sBuilder.append("	@Override"+line);
		sBuilder.append("	public String getIdentifierName() {"+line);
		sBuilder.append(String.format("		return \"%s\";",primaryKeyMap.get(poName))+line);
		sBuilder.append("	}"+line);
		sBuilder.append("}"+line);
		System.out.println(sBuilder.toString());
		
		String folder = getExportDirectory()+File.separator+"doServiceImpl";
		FileUtil.newFolder(folder);
		File f = new File(folder+File.separator+getDoServiceImplName(poName)+".java");
		f.createNewFile(); 
		writeTxtFile(sBuilder.toString(),f);

//		package com.yu.study.service.dos.impl;
//
//		import org.springframework.stereotype.Service;
//
//		import com.yu.study.common.service.BaseDoServiceImpl;
//		import com.yu.study.dao.po.OrderPo;
//		import com.yu.study.dos.OrderDo;
//		import com.yu.study.service.dos.OrderDoService;
//
//		@Service
//		public class OrderDoServiceImpl extends BaseDoServiceImpl<OrderDo, OrderPo> implements OrderDoService{
//
//			@Override
//			public String getIdentifierName() {
//				return "orderUid";
//			}
//		}

	}
	
	public void clearDirectory(){
		String folder = getExportDirectory()+File.separator+"dos";
		FileUtil.deleteDir(folder);
		folder = getExportDirectory()+File.separator+"dao";
		FileUtil.deleteDir(folder);
		folder = getExportDirectory()+File.separator+"daoImpl";
		FileUtil.deleteDir(folder);
		folder = getExportDirectory()+File.separator+"doService";
		FileUtil.deleteDir(folder);
		folder = getExportDirectory()+File.separator+"doServiceImpl";
		FileUtil.deleteDir(folder);
		
	}
	
	public void doGenerate() throws Exception{
		IOFileFilter fiter = new IOFileFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return true;
			}
			
			@Override
			public boolean accept(File file) {
				return !file.getName().endsWith("Example.java");
			}
		};
		
		Collection<File> listFiles = FileUtils.listFiles(new File(getScanPoDirectory()), fiter, fiter);
		for(File f:listFiles){
			String poName = f.getName().replace(".java", "");
			String primaryKey = getPrimaryKey(f);
			primaryKeyMap.put(poName, primaryKey);
		}
		for(File f:listFiles){
			String poName = f.getName().replace(".java", "");
			generateDoJavaFile(poName);
			generateDaoJavaFile(poName);
			generateDaoImplJavaFile(poName);
			generateDoServiceJavaFile(poName);
			generateDoServiceImplJavaFile(poName);
		}
		System.out.println("ok");
	}
	
	private String getPrimaryKey(File fileName) throws Exception {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			try {
				String read = null;
				while ((read = bufferedReader.readLine()) != null) {
					if(read.contains("private String")){
						String str = read.replace("private String", "").replace(";", "");
						str= str.trim();
						return str;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		
		throw new RuntimeException("读取错误!");
	}
	
	
	public static void main(String[] args) throws Exception {
		CodeGenerator generator = new CodeGenerator();
		generator.clearDirectory();
		generator.setScanPoDirectory("F:\\github\\study\\demo\\webStudy\\study-dao\\src\\main\\java\\com\\yu\\study\\dao\\po");
		generator.setPoPackage("com.yu.study.dao.po");
		generator.setDosPackage("com.yu.study.dos");
		generator.setDaoPackage("com.yu.study.dao");
		generator.setDaoImplPackage("com.yu.study.dao.impl");
		generator.setDoServicePackage("com.yu.study.service.dos");
		generator.setDoServiceImplPackage("com.yu.study.service.dos.impl");
		generator.doGenerate();
		
//		generator.generateDoJavaFile("OrderPo");
//		generator.generateDaoJavaFile("OrderPo");
//		generator.generateDaoImplJavaFile("OrderPo");
//		generator.generateDoServiceJavaFile("OrderPo");
//		generator.generateDoServiceImplJavaFile("OrderPo");
	}



}
