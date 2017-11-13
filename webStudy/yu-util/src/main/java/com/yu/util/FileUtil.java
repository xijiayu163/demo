package com.yu.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 文件相关操作
 * 
 * @author Cassie He
 * @date 2015年9月14日 上午11:40:35
 * @since 2.7
 */
public class FileUtil {
	/**
	 * 创建临时文件
	 * 
	 * @author Cassie He
	 * @date 2015年9月14日 上午11:40:48
	 * @since 2.7
	 * @param request
	 *            用于获取工程跟路径
	 * @param folder
	 *            文件目录<br/>
	 *            1.生成的临时文件保存目录<br/>
	 *            2.目录不存在是会自动创建
	 * @param suffix
	 *            文件类型（扩展名）例如：.xls
	 * @return
	 */
	public static File createFile(HttpServletRequest request, String folder, String suffix) {
		String path = request.getServletContext().getRealPath("/" + folder);
		File fileTmp = new File(path);// 文件地址
		if (!fileTmp.exists()) {// 不存在
			fileTmp.mkdirs();// 创建地址
		}
		Date date = new Date();
		StringBuffer filePath = new StringBuffer(path);
		char separtorChar = File.separatorChar;// 分隔符，采用系统分隔符以兼容不同系统分隔符不同问题
		filePath.append(separtorChar).append(Long.toString(date.getTime())).append(suffix);// 以时间戳作为临时文件名
		return new File(filePath.toString());
	}
	
	/**
	 * 生成文件名  <br/>
	 * 由yyyyMMddHHmmss+随机5个字符+后缀  <br/>
	 * 如：20131201112434SDFW0.jsp
	 * @author Cassie He
	 * @date 2016年12月1日 上午10:15:24
	 * @since 3.8
	 * @param suffix 文件后缀名
	 * @return 文件名 
	 */
	public static String generatorFileNameByDateRandom(String suffix) {
		Assert.hasText(suffix);
		return DateUtil.format(new Date()).concat(RandomUtil.generateString(5)).concat(suffix);
	}
	/**
	 * 生成文件名  <br/>
	 * 由yyyyMMddHHmmss+随机4个字符+后缀  <br/>
	 * 如：20131201112434SDFW0.jsp
	 * @author Cassie He
	 * @date 2016年12月1日 上午10:15:24
	 * @since 3.8
	 * @param suffix 文件后缀名
	 * @return 文件名 
	 */
	public static String generatorFileNameByDateRandomToNum(String suffix) {
		Assert.hasText(suffix);
		return DateUtil.format(new Date()).concat(RandomUtil.generateMixNum(4)).concat(suffix);
	}
 
	/**
	 * 生成指定的文件地址
	 * @author Cassie He
	 * @date 2016年12月1日 上午10:24:53
	 * @since 3.8
	 * @param folder 文件夹 
	 * @param suffix 后缀
	 * @return
	 */
	public static String generatorFilePath(String folder, String suffix) {
		Assert.hasText(folder);
		return folder.concat(generatorFileNameByDateRandomToNum(suffix));
	}

	/**
	 * 下载文件
	 * @author Cassie He
	 * @date 2015年9月14日 上午11:43:32
	 * @since 2.7
	 * @param request
	 *            请求对象
	 * @param response
	 *            响应对象
	 * @param fileName
	 *            下载时显示的文件名
	 * @param downloadFile
	 *            需要下载的文件
	 * @return 下载是否成功状态
	 */
	public static void download(HttpServletRequest request, HttpServletResponse response, String fileName,
			File downloadFile) {
		try {
			String downloadFileName = downloadFile.getName();// 获取文件名
			int index = downloadFileName.lastIndexOf(".");// 得到文件名下标
			String suffix = downloadFileName.substring(index, downloadFileName.length());// 得到文件扩展名
			String displayName = DateUtil.format(new Date());
			if(StringUtils.hasText(fileName)) {
				displayName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");// 处理下载中文文件名乱码问题
			}
			response.setContentType(request.getServletContext().getMimeType(downloadFile.getName()));// 获取文件所属枚举类型
			response.setHeader("Content-Disposition", "attachment;filename=" + displayName + suffix);// 设置下载的文件名
			OutputStream out = response.getOutputStream();// 输出
			out.write(FileUtils.readFileToByteArray(downloadFile));// 将文件内容写入流中
			downloadFile.delete();// 删除文件
			out.close();// 关闭流
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载文件
	 * @author Cassie He
	 * @date 2016年8月10日 下午2:06:21
	 * @version 3.4.2
	 * @since 3.4.2
	 * @param request
	 * @param response
	 * @param fileName 下载文件的显示名称
	 * @param downloadPath 下载文件路径
	 */
	public static void download(HttpServletRequest request, HttpServletResponse response, String fileName,
			String downloadPath) {
		Assert.notNull(downloadPath);
		File downloadFile =new File(downloadPath);
		FileUtil.download(request, response, fileName, downloadFile);
	}
	
	/**
	 * 远程下载文件
	 * @author Cassie He
	 * @date 2016年9月21日 上午11:43:32
	 * @since 3.6
	 * @param request
	 *            请求对象
	 * @param response
	 *            响应对象
	 * @param fileName
	 *            下载时显示的文件名
	 * @param downloadURL
	 *            需要下载的文件
	 * @return 下载是否成功状态
	 * @throws IOException 
	 */
	public static void remodeDownload(HttpServletRequest request, HttpServletResponse response, String fileName,
		String downloadURL) throws IOException {
		URL url = new URL(downloadURL);
		URLConnection connection = url.openConnection();
		connection.setDoInput(true);// 设置是否要从 URL 连接读取数据,默认为true
		connection.connect();
		InputStream is = connection.getInputStream();
		int index = downloadURL.lastIndexOf(".");// 得到文件名下标
		String downloadFileName = fileName + downloadURL.substring(index, downloadURL.length());// 得到文件扩展名
		response.setContentType(request.getServletContext().getMimeType(url.getFile()));// 获取文件所属枚举类型
		response.setHeader("Content-Disposition", "attachment;filename=" +  new String(downloadFileName.getBytes("UTF-8"), "iso-8859-1"));// 设置下载的文件名
		OutputStream out = response.getOutputStream();// 输出
		byte[] buffer = new byte[4 * 1024];
		int byteRead = -1;
		while ((byteRead = (is.read(buffer))) != -1) {
			out.write(buffer, 0, byteRead);
		}
		out.flush();
		is.close();
		out.close();
	}

	/**
	 * 获取文件的类型 如： .txt
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos).toString();
	}

	/**
	 * 新建目录
	 * 
	 * @param folderPath
	 *            String 如 c:/fqf
	 * @return boolean
	 */
	public static void newFolder(String folderPath) {
		try {
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdir();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 新建目录，深层目录
	 * 
	 * @param folderPath
	 */
	public static void newFolderDeep(String folderPath) {
		try {
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断文件路径是否存在
	 * 
	 * @param filePath
	 * @return
	 */
	public static boolean exists(String filePath) {

		boolean result = false;
		try {
			File file = new File(filePath);
			if (file != null && file.exists()) {
				result = true;
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	/**
	 * 读取指定远程地址的内容
	 * @author Cassie He
	 * @date 2016年11月30日 下午3:45:12
	 * @since 3.8
	 * @param urlPath 远程地址
	 * @return 文件内容
	 * @throws IOException
	 */
	public static String getRemodeFileContentByUrlPath(String urlPath) throws IOException {
		URL url = new URL(urlPath);
		InputStream is = url.openStream();
		InputStreamReader read = new InputStreamReader(is, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		StringBuffer content = new StringBuffer("");
        while(bufferedReader.ready()){
        	content.append(bufferedReader.readLine());
        }
        read.close();
        return content.toString();
	}
	
	/**
	 * 文件转换成字节流
	 *
	 * @author yuxijia
	 * @date 2017年1月3日 
	 * @since 3.9.0
	 *
	 * @param filePath
	 * @return
	 */
	public static byte[] File2byte(String filePath)  
    {  
        byte[] buffer = null;  
        try  
        {  
            File file = new File(filePath);  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            byte[] b = new byte[1024];  
            int n;  
            while ((n = fis.read(b)) != -1)  
            {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        }  
        catch (FileNotFoundException e)  
        {  
            e.printStackTrace();  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
        return buffer;  
    } 
	
	/**
	 * 字节流保存成文件
	 *
	 * @author yuxijia
	 * @date 2017年1月3日 
	 * @since 3.9.0
	 *
	 * @param buf
	 * @param filePath
	 * @param fileName
	 */
	public static void byte2File(byte[] buf, String filePath, String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists() && dir.isDirectory()) {
				dir.mkdirs();
			}
			file = new File(filePath + File.separator + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(buf);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 递归删除目录下的所有文件及子目录下所有文件
	 *
	 * @author yuxijia
	 * @date 2017年3月23日 
	 * @since 4.2.0
	 *
	 * @param dir
	 * @return
	 */
	public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
    
	/**
	 * 清空指定的目录并删除该目录
	 *
	 * @author yuxijia
	 * @date 2017年3月23日 
	 * @since 4.2.0
	 *
	 * @param dir
	 * @return
	 */
    public static boolean deleteDir(String dir){
    	File file = new File(dir);
    	return deleteDir(file);
    }
    
    /**
     * 文件拷贝
     *
     * @author yuxijia
     * @date 2017年3月23日 
     * @since 4.2.0
     *
     * @param src
     * @param des
     */
    public static void fileCopy(String src, String des) {
		BufferedReader br = null;
		PrintStream ps = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
			ps = new PrintStream(new FileOutputStream(des));
			String s = null;
			while ((s = br.readLine()) != null) {
				ps.println(s);
				ps.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (br != null)
					br.close();
				if (ps != null)
					ps.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    
    /**
     * 文件夹拷贝(文件内含有文件和文件夹) 
     *
     * @author yuxijia
     * @date 2017年3月23日 
     * @since 4.2.0
     *
     * @param src
     * @param des
     */
    public static void dirCopy(String src, String des) {  
        File file1=new File(src);  
        File[] fs=file1.listFiles();  
        File file2=new File(des);  
        if(!file2.exists()){  
            file2.mkdirs();  
        }  
        for (File f : fs) {  
            if(f.isFile()){  
                fileCopy(f.getPath(),des+ File.separator+f.getName()); //调用文件拷贝的方法  
            }else if(f.isDirectory()){  
            	dirCopy(f.getPath(),des+ File.separator+f.getName());  
            }  
        }  
    } 
}
