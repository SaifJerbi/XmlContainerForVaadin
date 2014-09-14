package org.vaadin.tunis.saif.xmlcontainer;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

public class XMLParser {
	/**
	 * @param args
	 */
//	static Logger log = Logger.getLogger(XMLParser.class.getName());
//	static String xmlLocation = "/home/jerbi/Desktop/adr.xml";

//	public static void main(String[] args) {
//		try {
//			List all = getAllElements(Address.class, xmlLocation);
//			for (int i = 0; i < all.size(); i++) {
//				System.out.println(((Address) (all.get(i))).getStreet());
//
//			}
//		} catch (JAXBException e) {
//			log.error("Error ", e);
//		}
//	}

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
