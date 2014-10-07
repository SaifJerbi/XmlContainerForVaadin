package org.vaadin.tunis.saif.xmlcontainer.jaxb;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.vaadin.tunis.saif.xmlcontainer.XMLContainer;

import com.vaadin.data.util.BeanItemContainer;

public class JaxbXMLContainer<T> extends BeanItemContainer<T> implements
		XMLContainer {

	public JaxbXMLContainer(Class<? super T> classe, String filePath) throws JAXBException {

		super(classe);

		addAllObjectToContainer(filePath, classe);
	}

	private void addAllObjectToContainer(String filePath, Class classe)
			throws JAXBException {
		List allObject = JaxBParser.jaxbObjectsBinding(classe, filePath);

		addAll(allObject);
	}
}
