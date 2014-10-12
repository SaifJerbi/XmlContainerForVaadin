package org.vaadin.tunis.saif.xmlcontainer.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.vaadin.tunis.saif.xmlcontainer.XMLContainer;
import org.xml.sax.SAXException;

import com.vaadin.data.util.BeanItemContainer;

public class DomXMLContainer<T> extends BeanItemContainer<T> implements
		XMLContainer {

	
	/**
	 * @param classe
	 * @param filePath
	 * @throws JAXBException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public DomXMLContainer(Class<? super T> classe, String filePath)
			throws JAXBException, IllegalAccessException,
			InvocationTargetException, InstantiationException,
			ParserConfigurationException, SAXException, IOException {

		super(classe);
		File file = new File(filePath);
		InputStream inputStream = new FileInputStream(file);
		addAllObjectToContainer(inputStream, classe);
	}
	
	
	/**
	 * @param classe
	 * @param file
	 * @throws JAXBException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public DomXMLContainer(Class<? super T> classe, File file)
			throws JAXBException, IllegalAccessException,
			InvocationTargetException, InstantiationException,
			ParserConfigurationException, SAXException, IOException {

		super(classe);
		InputStream inputStream = new FileInputStream(file);
		addAllObjectToContainer(inputStream, classe);
	}
	
	/**
	 * @param classe
	 * @param fileInputStream
	 * @throws JAXBException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public DomXMLContainer(Class<? super T> classe, FileInputStream fileInputStream)
			throws JAXBException, IllegalAccessException,
			InvocationTargetException, InstantiationException,
			ParserConfigurationException, SAXException, IOException {

		super(classe);
		InputStream inputStream = fileInputStream;
		addAllObjectToContainer(inputStream, classe);
	}
	
	/**
	 * @param classe
	 * @param inputStream
	 * @throws JAXBException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public DomXMLContainer(Class<? super T> classe, InputStream inputStream)
			throws JAXBException, IllegalAccessException,
			InvocationTargetException, InstantiationException,
			ParserConfigurationException, SAXException, IOException {

		super(classe);
		addAllObjectToContainer(inputStream, classe);
	}

	private void addAllObjectToContainer(InputStream inputStream, Class classe)
			throws JAXBException, IllegalAccessException,
			InvocationTargetException, InstantiationException,
			ParserConfigurationException, SAXException, IOException {

		List allObject = DomParser.domObjectsBinding(classe, inputStream);

		addAll(allObject);
	}
}