package org.vaadin.tunis.saif.xmlcontainer.dom;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.vaadin.tunis.saif.xmlcontainer.reflection.EntityParser;
import org.vaadin.tunis.saif.xmlcontainer.test.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {
	/**
	 * @param filePath
	 * @param classe
	 * @return list
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public static List<Object> domObjectsBinding(Class classe, String filePath)
			throws ParserConfigurationException, SAXException, IOException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(filePath));

		List<Object> objectList = new ArrayList();

		HashMap<String, String> entityFieldMap = EntityParser
				.getFieldsName(classe);

		NodeList nodeList = document.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			// We have encountered an <[object]> tag.
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				Object object = classe.newInstance();
				Iterator itr = entityFieldMap.entrySet().iterator();
				while (itr.hasNext()) {
					Map.Entry pairs = (Map.Entry) itr.next();
					Node item = ((Element) node).getElementsByTagName(
							pairs.getKey().toString()).item(0);
					EntityParser.invokeSetterMethod(object, pairs.getKey()
							.toString(), item.getFirstChild().getNodeValue());
				}
				objectList.add(object);
			}
		}
		return objectList;
	}
}
