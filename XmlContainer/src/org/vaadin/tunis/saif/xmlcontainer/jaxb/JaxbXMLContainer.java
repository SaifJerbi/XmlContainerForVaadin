package org.vaadin.tunis.saif.xmlcontainer.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.vaadin.tunis.saif.xmlcontainer.XMLContainer;

import com.vaadin.data.util.BeanItemContainer;

public class JaxbXMLContainer<T> extends BeanItemContainer<T> implements
		XMLContainer {

	public JaxbXMLContainer(Class<? super T> classe, String filePath)
			throws JAXBException, FileNotFoundException {
		super(classe);
		addAllObjectToContainer(new FileInputStream(new File(filePath)), classe);
	}

	public JaxbXMLContainer(Class<? super T> classe, File file)
			throws JAXBException, FileNotFoundException {
		super(classe);
		addAllObjectToContainer(new FileInputStream(file), classe);
	}

	public JaxbXMLContainer(Class<? super T> classe,
			FileInputStream fileInputStream) throws JAXBException,
			FileNotFoundException {
		super(classe);
		addAllObjectToContainer(fileInputStream, classe);
	}

	private void addAllObjectToContainer(InputStream inputStream, Class classe)
			throws JAXBException, FileNotFoundException {
		List allObject = JaxBParser.jaxbObjectsBinding(classe, inputStream);
		addAll(allObject);
	}
}
