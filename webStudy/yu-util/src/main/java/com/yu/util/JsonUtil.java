package com.yu.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson Json序列化工具类
 * 
 * @author 张超
 * @date 2015年5月28日 上午8:48:19
 * @since 2.2
 *
 */
public class JsonUtil {
	
	private final static Log log = LogFactory.getLog(JsonUtil.class);

	private static final ThreadLocal<SimpleDateFormat> TL_DATEF_LOCAL = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss");
		};
	};
	private static final ThreadLocal<SimpleDateFormat> RTIS_DATE_LOCAL = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		};
	};

	/**
	 * Json字符转对象
	 * 
	 * @param json
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T jsonToObj(String json, TypeReference<T> ref, SimpleDateFormat simpleDateFormat)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(simpleDateFormat);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return mapper.readValue(json, ref);
	}

	/**
	 * 对象转Json字符串
	 * 
	 * @param obj
	 * @throws JsonProcessingException
	 */
	public static <T> String objToJson(T obj, SimpleDateFormat simpleDateFormat) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(simpleDateFormat);
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.writeValueAsString(obj);
	}

	/**
	 * Json字符转对象 
	 * rtis日期 格式 2015-01-15 00:00:00
	 * @param json
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T rtisJson2Obj(String json, TypeReference<T> ref) throws JsonParseException, JsonMappingException,
			IOException {
		return jsonToObj(json,ref,RTIS_DATE_LOCAL.get());
	}

	/**
	 * 对象转Json字符串 
	 * rtis日期 格式 2015-01-15 00:00:00
	 * @param obj
	 * @throws JsonProcessingException
	 */
	public static <T> String rtisObj2Json(T obj) throws JsonProcessingException {

		return objToJson(obj,RTIS_DATE_LOCAL.get());
	}
	
	/**
	 * Json字符转对象
	 * 
	 * @param json
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T json2Obj(String json, TypeReference<T> ref) throws JsonParseException, JsonMappingException,
			IOException {
		return jsonToObj(json,ref,TL_DATEF_LOCAL.get());
	}

	/**
	 * 对象转Json字符串
	 * 
	 * @param obj
	 * @throws JsonProcessingException
	 */
	public static <T> String obj2Json(T obj) throws JsonProcessingException {

		return objToJson(obj,TL_DATEF_LOCAL.get());
	}


	/**
	 * JSON字符串转实体类（不支持泛型嵌套泛型）
	 * 
	 * @param content
	 * @param valueType
	 */
	public static <T> T json2obj(String content, Class<T> valueType) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(TL_DATEF_LOCAL.get());
		try {
			return mapper.readValue(content, valueType);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		
		return null;
	}

	private static <T> TypeReference<T> assembleType(T valueType) {
		return new TypeReference<T>() {
		};
	}
	
	
	
}
