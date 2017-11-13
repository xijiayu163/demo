package com.yu.util;

//import java.io.File;
import java.util.HashMap;
import java.util.List;

//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathExpressionException;
//import javax.xml.xpath.XPathFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;







import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/**
 * 功能说明:xml 与对象间进行互转;
 * 
 * @author 王卫
 * @date 2015年7月20日 上午10:06:15
 * @since 2.3
 *
 * @param <T>
 */
public class XMLUtil {

	private XStream xstream = null;
	
	private void newXStream(){
		xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_"))){
			@Override
			protected MapperWrapper wrapMapper(MapperWrapper next) {
				return new MapperWrapper(next) {
		            @Override
		            public boolean shouldSerializeMember(Class definedIn, String fieldName) {
		                if (definedIn == Object.class) {
		                    return false;
		                }
		                return super.shouldSerializeMember(definedIn, fieldName);
		            }
		        };
			}
		};
	}
	
	public <T> XMLUtil(T t) {
		newXStream();
		xstream.processAnnotations(t.getClass());
	}
	
	public <T> XMLUtil(Class<T> clz) {
		newXStream();
		xstream.processAnnotations(clz);
	}

	public XMLUtil(List<Object> ts) {
		newXStream();
		for (Object t2 : ts) {
			xstream.processAnnotations(t2.getClass());
		}
	}

	/**
	 * 对象转xml
	 * 
	 * @param t
	 * @return
	 */
	public <T> String beanToXML(T t) {

		try {
			return xstream.toXML(t);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * xml转对象
	 * 
	 * @param xmlStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T XMLStringToBean(String xmlStr) {
		try {
			T fromXML = (T) xstream.fromXML(xmlStr);
			return fromXML;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * xml转map
	 * 
	 * @author ksh
	 * @date 2017年3月3日
	 * @since 3.9
	 *
	 * @param xmlStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> XMLStringToMap(String xmlStr) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Document doc = DocumentHelper.parseText(xmlStr);
			Element rootElt = doc.getRootElement();
			
			List<Element> elements = rootElt.elements();
			for(Element element:elements){
				map.put(element.getName(), element.getText());
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static void modifyXml(String xmlPath, String express, String newNodeValue) {
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		dbf.setIgnoringElementContentWhitespace(true);
//		try {
//			DocumentBuilder db = dbf.newDocumentBuilder();
//			File xmlFile = new File(xmlPath);
//			// System.out.println(xmlFile.createNewFile());
//			if (!xmlFile.exists()) {
//				throw new RuntimeException("[" + xmlPath + "] not is exist, please check!!");
//			}
//			if (!xmlFile.isFile()) {
//				throw new RuntimeException("[" + xmlPath + "] not is file, please check!!");
//			}
//			if (!xmlFile.canRead()) {
//				throw new RuntimeException("No read '" + xmlPath + "' permissions, please check!!");
//			}
//			if (!xmlFile.canWrite()) {
//				throw new RuntimeException("No write '" + xmlPath + "' permissions, please check!!");
//			}
//			Document xmldoc = db.parse(xmlPath);
//			Element root = xmldoc.getDocumentElement();
//			Element per = (Element) selectSingleNode(express, root);
//			per.setNodeValue(newNodeValue);
//			// per.getElementsByTagName("age").item(0).setTextContent("27");
//			// per.getElementsByTagName("key").item(0).setNodeValue(newNodeValue);
//			TransformerFactory factory = TransformerFactory.newInstance();
//			Transformer former = factory.newTransformer();
//			former.transform(new DOMSource(xmldoc), new StreamResult(new File(xmlPath)));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static Node selectSingleNode(String express, Element source) {
//		Node result = null;
//		XPathFactory xpathFactory = XPathFactory.newInstance();
//		XPath xpath = xpathFactory.newXPath();
//		try {
//			result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
//		} catch (XPathExpressionException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	public static void readXml(String xmlPath, String express) {
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		dbf.setIgnoringElementContentWhitespace(true);
//		try {
//			DocumentBuilder db = dbf.newDocumentBuilder();
//			Document doc = db.parse(xmlPath); // 使用dom解析xml文件
////			XPathFactory xpathFactory = XPathFactory.newInstance();
////			XPath xpath = xpathFactory.newXPath();
////			Node result = (Node) xpath.evaluate(express, doc, XPathConstants.NODE);
////			System.out.println(result.getNodeValue());
//			NodeList sonlist = doc.getElementsByTagName("string");
//			for (int i = 0; i < sonlist.getLength(); i++) // 循环处理对象
//			{
//				Element son = (Element) sonlist.item(i);
//
//				for (Node node = son.getFirstChild(); node != null; node = node.getNextSibling()) {
//					if (node.getNodeType() == Node.ELEMENT_NODE) {
//						String name = node.getNodeName();
//						String value = node.getFirstChild().getNodeValue();
//						System.out.println(name + " : " + value);
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
////		readXml("E:/son.xml", "/dict/array/dict/array/dict/string");
////		readXml("E:/patient-zc.xml", "/dict/array/dict/array/dict/string");
//		modifyXml("E:/patient-zc.xml", "/dict/array/dict/array/dict/string", "xxx-aaa-bbb");
//	}

}
