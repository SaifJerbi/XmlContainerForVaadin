package org.vaadin.tunis.saif.xmlcontainer.dom;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.vaadin.tunis.saif.xmlcontainer.XMLContainer;
import org.xml.sax.SAXException;

import com.vaadin.data.util.BeanItemContainer;

public class DomXMLContainer<T> extends BeanItemContainer<T> implements
		XMLContainer {

	public DomXMLContainer(Class<? super T> classe, String filePath) throws JAXBException, IllegalAccessException, InvocationTargetException, InstantiationException, ParserConfigurationException, SAXException, IOException {

		super(classe);

		addAllObjectToContainer(filePath, classe);
	}

	private void addAllObjectToContainer(String filePath, Class classe)
			throws JAXBException, IllegalAccessException, InvocationTargetException, InstantiationException, ParserConfigurationException, SAXException, IOException {
		List allObject = DomParser.domObjectsBinding(classe, filePath);

		addAll(allObject);
	}
}