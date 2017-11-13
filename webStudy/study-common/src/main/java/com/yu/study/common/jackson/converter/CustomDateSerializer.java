package com.yu.study.common.jackson.converter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.yu.util.DateUtil;

/**对属性或get方法设置该注解 可解决界面上json字符中不同格式的日期字符映射到实体(responsebody)的问题  
 * ef: @JsonSerialize(using=CustomDateSerializer.UNDERLINE_DF_DateSerializer.class)
 * 默认在mappingJacksonHttpMessageConverter配置全局的解析器为yyyy-MM-dd HH:mm:ss
 * 
 * 不使用，应使用@JsonFormat 注解 ,例如:@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
 * @author xijia
 *
 */

public class CustomDateSerializer{
	
	public class DERLINE_DF_DateSerializer extends JsonSerializer<Date>
	{
	    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)throws IOException, JsonProcessingException
	    {
	        SimpleDateFormat format =DateUtil.DERLINE_DF.get();
	        String formattedDate = format.format(date);
	        gen.writeString(formattedDate);
	    }
	}
	
	public class DERLINE_TIME_DF_DateSerializer extends JsonSerializer<Date>
	{
	    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)throws IOException, JsonProcessingException
	    {
	        SimpleDateFormat format =DateUtil.DERLINE_TIME_DF.get();
	        String formattedDate = format.format(date);
	        gen.writeString(formattedDate);
	    }
	}
	
	public class LONG_DERLINE_DF_DateSerializer extends JsonSerializer<Date>
	{
	    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)throws IOException, JsonProcessingException
	    {
	        SimpleDateFormat format =DateUtil.LONG_DERLINE_DF.get();
	        String formattedDate = format.format(date);
	        gen.writeString(formattedDate);
	    }
	}
	
	public class SORT_DERLINE_DF_DateSerializer extends JsonSerializer<Date>
	{
	    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)throws IOException, JsonProcessingException
	    {
	        SimpleDateFormat format =DateUtil.SORT_DERLINE_DF.get();
	        String formattedDate = format.format(date);
	        gen.writeString(formattedDate);
	    }
	}
	
	public class SORT_DERLINE_TIME_DateSerializer1 extends JsonSerializer<Date>
	{
	    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)throws IOException, JsonProcessingException
	    {
	        SimpleDateFormat format =DateUtil.SORT_DERLINE_TIME.get();
	        String formattedDate = format.format(date);
	        gen.writeString(formattedDate);
	    }
	}
	
	public class UNDERLINE_DF_DateSerializer extends JsonSerializer<Date>
	{
	    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)throws IOException, JsonProcessingException
	    {
	        SimpleDateFormat format =DateUtil.UNDERLINE_DF.get();
	        String formattedDate = format.format(date);
	        gen.writeString(formattedDate);
	    }
	}
}


