package com.yu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UpdateFileUtil {
	/**
	 * 更改指定文件的某一部分数据
	 * 
	 * @param file
	 * @param isContainsStr
	 * @param spliceStr
	 */
	public static void updateFileData(String file, String isContainsStr, String spliceStr) {
		try {
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file)),
					"utf-8"));// 数据流读取文件

			StringBuffer strBuffer = new StringBuffer();
			for (String temp = null; (temp = bufReader.readLine()) != null; temp = null) {
				if (temp.contains(isContainsStr)) {
					temp = temp.substring(0, temp.indexOf(isContainsStr)) + spliceStr;
				}
				strBuffer.append(temp);
				strBuffer.append(System.getProperty("line.separator"));// 行与行之间的分割
			}
			bufReader.close();

			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			out.println(strBuffer.toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}