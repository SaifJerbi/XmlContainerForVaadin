package org.vaadin.tunis.saif.xmlcontainer;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class XMLParser {

	public static List<Object> getAllElements(Class classe, String filePath)
			throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Wrapper.class, classe);
		// Unmarshal
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		List objects = unmarshal(unmarshaller, classe, filePath);
		return objects;

	}

	private static <T> List<T> unmarshal(Unmarshaller unmarshaller,
			Class<T> clazz, String filePath) throws JAXBException {
		StreamSource xml = new StreamSource(filePath);
		Wrapper<T> wrapper = (Wrapper<T>) unmarshaller.unmarshal(xml,
				Wrapper.class).getValue();
		return wrapper.getItems();
	}

}
