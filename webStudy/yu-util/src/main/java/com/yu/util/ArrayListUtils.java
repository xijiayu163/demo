package com.yu.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayListUtils {

	/**
	 * ArrayList顺序去重复
	 * @author LiLanke
	 * @serialData  2016年4月20日09:44:23
	 * @param arlList
	 */
	public static void removeDuplicateWithOrder(ArrayList arlList) {
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = arlList.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (set.add(element)){
				newList.add(element);
			}
		}
		arlList.clear();
		arlList.addAll(newList);
	}
	
	/**
	 * 把一个List拆分为几个大小一样的List
	 * @author LiLanke
	 * @date 2016年9月13日-上午10:47:30
	 * @version 3.6
	 * @param targe  源list
	 * @param size		大小 100
	 * @return
	 */
	public static List<List<String>>  createList(List<String> targe,int size) {  
        List<List<String>> listArr = new ArrayList<List<String>>();  
        //获取被拆分的数组个数  
        int arrSize = targe.size()%size==0?targe.size()/size:targe.size()/size+1;  
        for(int i=0;i<arrSize;i++) {  
            List<String>  sub = new ArrayList<String>();  
            //把指定索引数据放入到list中  
            for(int j=i*size;j<=size*(i+1)-1;j++) {  
                if(j<=targe.size()-1) {  
                    sub.add(targe.get(j));  
                }  
            }  
            listArr.add(sub);  
        }  
        return listArr;  
    }  

	/**
	 * 一个把List<String>转化为以","隔开的字符串的方法
	 * @author LiLanke
	 * @date 2016年9月13日-上午10:54:49
	 * @version 3.6
	 * @param stringList list集合
	 * @return
	 */
	public static String listToString(List<String> stringList){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }
	
	/**
	 * 把一个字符串拆分成List<String>集合
	 * @author LiLanke
	 * @date 2016年9月13日-下午7:53:29
	 * @version 3.6
	 * @param str    要拆分的字符串
	 * @param sign 拆分符
	 * @return
	 */
	public static List<String> stringToList(String str,String sign){
		String[] array = str.split(sign);
		List<String> abcList = new ArrayList<String>();
		for (String item : array)
		{
			if(!abcList.contains(item)){
				abcList.add(item);	
			}
		}
		return abcList;
	}
	/**
	 * int数组转成list集合
	 * @author LiLanke
	 * @date 2016年10月28日-下午9:57:48
	 * @version 3.7
	 * @param intArr 整型数组
	 * @return 一个list集合
	 */
	public static List<Integer> intArrToList(Integer[] intArr){
		List<Integer> resultList=new ArrayList<Integer>();
		for (Integer item : intArr) {
			resultList.add(item);
		}
		return resultList;
	}

}
