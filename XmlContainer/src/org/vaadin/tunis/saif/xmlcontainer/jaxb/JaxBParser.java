package org.vaadin.tunis.saif.xmlcontainer.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


public class JaxBParser {
	
	public static List<Object> jaxbObjectsBinding(Class classe, InputStream inputStream)
			throws JAXBException, FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance(Wrapper.class, classe);
		// Unmarshal
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		List objects = unmarshal(unmarshaller, classe, inputStream);
		return objects;
	}

	private static <T> List<T> unmarshal(Unmarshaller unmarshaller,
			Class<T> clazz, InputStream inputStream) throws JAXBException {
		StreamSource xml = new StreamSource(inputStream);
		Wrapper<T> wrapper = (Wrapper<T>) unmarshaller.unmarshal(xml,
				Wrapper.class).getValue();
		return wrapper.getItems();
	}

}
