package com.yu.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * 二维码工具类
 *
 * @author derek 蔡海佳
 * @date 2016年12月20日 上午9:48:08
 * @since 3.8
 *
 */
public class QRCodeUtils {

	/**
	 * 创建二维码
	 *
	 * @author derek 蔡海佳
	 * @date 2016年12月20日 上午9:56:47
	 * @since 3.8
	 *
	 * @param content 二维码中的内容
	 * @param outputStream 二维码图片输出流
	 * @throws WriterException
	 * @throws IOException
	 */
	public static void createQRCode(String content, OutputStream outputStream) throws WriterException, IOException{
		createQRCode(content, outputStream, 600, 600);
	}
	
	/**
	 * 创建二维码
	 *
	 * @author derek 蔡海佳
	 * @date 2016年12月20日 上午9:57:47
	 * @since 3.8
	 *
	 * @param content 二维码中的内容
	 * @param outputStream 二维码图片输出流
	 * @param qrCodeWidth 二维码宽度
	 * @param qrCodeHeight 二维码高度
	 * @throws WriterException
	 * @throws IOException
	 */
	public static void createQRCode(String content, OutputStream outputStream, int qrCodeWidth, int qrCodeHeight) throws WriterException, IOException{
		String qrCodeFormat = "png";
        HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, qrCodeWidth, qrCodeHeight, hints);
        MatrixToImageWriter.writeToStream(bitMatrix, qrCodeFormat, outputStream);
	}
	
}
