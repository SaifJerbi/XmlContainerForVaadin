package org.vaadin.tunis.saif.xmlcontainer;

import java.util.List;

import javax.xml.bind.JAXBException;

import com.vaadin.data.util.IndexedContainer;

public class IndexedXMLContainer extends IndexedContainer implements
		XMLContainer {

	public IndexedXMLContainer(String filePath, Class classe)
			throws JAXBException {

		
			addAllObjectToContainer(filePath, classe);
		
	}

	private void addAllObjectToContainer(String filePath, Class classe)
			throws JAXBException {
		List allObject = XMLParser.getAllElements(classe, filePath);
		
		for(Object object : allObject){
			addItem(object);
		}
	}
}
