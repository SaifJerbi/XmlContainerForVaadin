package org.vaadin.tunis.saif.xmlcontainer;

import java.util.List;

import javax.xml.bind.JAXBException;

import com.vaadin.data.util.BeanItemContainer;

public class IndexedXMLContainer<T> extends BeanItemContainer<T> implements
		XMLContainer {

	public IndexedXMLContainer(Class<? super T> type, String filePath,
			Class classe) throws JAXBException {

		super(type);

		addAllObjectToContainer(filePath, classe);
	}

	private void addAllObjectToContainer(String filePath, Class classe)
			throws JAXBException {
		List allObject = XMLParser.getAllElements(classe, filePath);

		addAll(allObject);
	}
}
