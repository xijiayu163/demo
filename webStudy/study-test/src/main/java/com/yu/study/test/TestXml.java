package com.yu.study.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.yu.study.dao.po.UserPo;

public class TestXml {
	public static void main(String[] args) {
		testSerializeList();
	}
	
	@SuppressWarnings("unused")
	private static void testSerialize(){
		UserPo userPo = new UserPo();
		userPo.setAccountUid("accountUid1");
		userPo.setAge(1);
		userPo.setCompany("company1");
		userPo.setUserName("userName1");
		userPo.setUserPassword("userPassword1");
		
		XStream xs = new XStream();
		try {
			FileOutputStream fs = new FileOutputStream("D:/employeedata.txt");
			xs.toXML(userPo, fs);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private static void testDeserialize(){
		XStream xs = new XStream(new DomDriver());
		try {
			FileInputStream fis = new FileInputStream("D:/employeedata.txt");
			UserPo e = (UserPo) xs.fromXML(fis);
			System.out.println(e.toString());
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private static void testSerializeList(){
		List<UserPo> userPos = new ArrayList<>();
		UserPo userPo = new UserPo();
		userPo.setAccountUid("accountUid1");
		userPo.setAge(1);
		userPo.setCompany("company1");
		userPo.setUserName("userName1");
		userPo.setUserPassword("userPassword1");
		userPos.add(userPo);
		userPo = new UserPo();
		userPo.setAccountUid("accountUid2");
		userPo.setAge(2);
		userPo.setCompany("company2");
		userPo.setUserName("userName2");
		userPo.setUserPassword("userPassword2");
		userPos.add(userPo);
		
		XStream xs = new XStream();
		try {
			FileOutputStream fs = new FileOutputStream("D:/employeedata.txt");
			xs.toXML(userPos, fs);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		/*<list>
		  <com.yu.study.dao.po.UserPo>
		    <userName>userName1</userName>
		    <userPassword>userPassword1</userPassword>
		    <accountUid>accountUid1</accountUid>
		    <age>1</age>
		    <company>company1</company>
		  </com.yu.study.dao.po.UserPo>
		  <com.yu.study.dao.po.UserPo>
		    <userName>userName2</userName>
		    <userPassword>userPassword2</userPassword>
		    <accountUid>accountUid2</accountUid>
		    <age>2</age>
		    <company>company2</company>
		  </com.yu.study.dao.po.UserPo>
		</list>*/
	}
	
	@SuppressWarnings("unused")
	private static void testDeserializeList(){
		XStream xs = new XStream(new DomDriver());
		try {
			FileInputStream fis = new FileInputStream("D:/employeedata.txt");
			List<UserPo> userPos = (List<UserPo>) xs.fromXML(fis);
			System.out.println(userPos.size());
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private static void testSerializeList2(){
		List<UserPo> userPos = new ArrayList<>();
		UserPo userPo = new UserPo();
		userPo.setAccountUid("accountUid1");
		userPo.setAge(1);
		userPo.setCompany("company1");
		userPo.setUserName("userName1");
		userPo.setUserPassword("userPassword1");
		userPos.add(userPo);
		userPo = new UserPo();
		userPo.setAccountUid("accountUid2");
		userPo.setAge(2);
		userPo.setCompany("company2");
		userPo.setUserName("userName2");
		userPo.setUserPassword("userPassword2");
		userPos.add(userPo);
		
		XStream xs = new XStream();
		//设置根元素名  
		xs.alias("userPos", List.class);  
		//设置子元素名  
		xs.alias("user", UserPo.class);  
        
		try {
			FileOutputStream fs = new FileOutputStream("D:/employeedata.txt");
			xs.toXML(userPos, fs);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
//		<userPos>
//		  <user>
//		    <userName>userName1</userName>
//		    <userPassword>userPassword1</userPassword>
//		    <accountUid>accountUid1</accountUid>
//		    <age>1</age>
//		    <company>company1</company>
//		  </user>
//		  <user>
//		    <userName>userName2</userName>
//		    <userPassword>userPassword2</userPassword>
//		    <accountUid>accountUid2</accountUid>
//		    <age>2</age>
//		    <company>company2</company>
//		  </user>
//		</userPos>
	}
	
	private static void testDeserializeList2(){
		XStream xs = new XStream(new DomDriver());
		//设置根元素名  
		xs.alias("userPos", List.class);  
		//设置子元素名  
		xs.alias("user", UserPo.class); 
		try {
			FileInputStream fis = new FileInputStream("D:/employeedata.txt");
			List<UserPo> userPos = (List<UserPo>) xs.fromXML(fis);
			System.out.println(userPos.size());
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
