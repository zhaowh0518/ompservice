package omp.util;

import org.dom4j.DocumentException;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.DocumentHelper;

/*
 * process xml
 * */
public class XmlUtil {
	
	//read xml element
	public static Element getElement(String str) throws DocumentException {
		Document document = DocumentHelper.parseText(str);
		Element element = document.getRootElement();
		return element;
	}
}
