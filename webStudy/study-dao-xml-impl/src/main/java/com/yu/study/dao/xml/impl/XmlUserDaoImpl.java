package com.yu.study.dao.xml.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.yino.util.CollectionUtil;
import com.yu.study.common.search.SearchWrapper;
import com.yu.study.dao.UserDao;
import com.yu.study.dao.po.UserPo;

/**xml 持久层实现，未启用
 * @author xijia
 *
 */
public class XmlUserDaoImpl implements UserDao{

	public List<UserPo> findAll(){
		XStream xs = new XStream(new DomDriver());
		try {
			FileInputStream fis = new FileInputStream("D:/employeedata.txt");
			@SuppressWarnings("unchecked")
			List<UserPo> userPos = (List<UserPo>) xs.fromXML(fis);
			return userPos;
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("文件不存在！",ex);
		}
	}
	
	@Override
	public UserPo get(Serializable id) {
		List<UserPo> users = findAll();
		return CollectionUtil.getFirstMatch(users, "accountUid", id);
	}

	@Override
	public int insert(UserPo entity) {
		List<UserPo> userPos = findAll();
		userPos.add(entity);
		XStream xs = new XStream();
		try {
			FileOutputStream fs = new FileOutputStream("D:/employeedata.txt");
			xs.toXML(userPos, fs);
			return 1;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("文件不存在！",e);
		}
	}

	@Override
	public int update(UserPo entity) {
		List<UserPo> userPos = findAll();
		for(UserPo user:userPos){
			if(user.getAccountUid().equals(entity.getAccountUid())){
				user.setAccountUid(entity.getAccountUid());
				user.setAge(entity.getAge());
				user.setCompany(entity.getCompany());
				user.setUserName(entity.getUserName());
				user.setUserPassword(entity.getUserPassword());
			}
		}
		
		XStream xs = new XStream();
		try {
			FileOutputStream fs = new FileOutputStream("D:/employeedata.txt");
			xs.toXML(userPos, fs);
			return 1;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("文件不存在！",e);
		}
	}

	@Override
	public int deleteById(Serializable id) {
		List<UserPo> userPos = findAll();
		Iterator<UserPo> iterator = userPos.iterator();
		while(iterator.hasNext()){
			UserPo user = iterator.next();
			if(user.getAccountUid().equals(id)){
				iterator.remove();
			}
		}
		
		XStream xs = new XStream();
		try {
			FileOutputStream fs = new FileOutputStream("D:/employeedata.txt");
			xs.toXML(userPos, fs);
			return 1;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("文件不存在！",e);
		}
	}

	@Override
	public int delete(Serializable[] ids) {
		return 0 ;
	}

	@Override
	public SearchWrapper find(SearchWrapper searchWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SearchWrapper searchWrapper) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SearchWrapper find(SearchWrapper searchWrapper, boolean ignoreNoEffectCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrderByCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
