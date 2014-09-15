package org.vaadin.tunis.saif.xmlcontainer;

import javax.xml.bind.JAXBException;

import com.vaadin.data.Container;

public interface XMLContainer extends Container.Indexed, Container.Sortable,
		Container.Filterable, Container.SimpleFilterable {

	public static class Factory {

		/**
		 * Creates a new instance of XMLContainer for the given XML file.
		 * 
		 * @throws IllegalArgumentException
		 *             if the given XML file cannot be parsed.
		 * @param filePath
		 *            XML File Path.
		 * @param classe
		 * 		      object Class type which will be unmarshalled from the XML file
		 * 
		 * @return new XMLContainer instance which contains a collection of classe Beans from the given file.
		 * 
		 */
		public static XMLContainer newInstance(String filePath, Class classe) {

			try {
				return new IndexedXMLContainer(classe, filePath);
			} catch (JAXBException e) {
				throw new IllegalArgumentException(
						"Cannot parse the given XML file");
			}
		}
	}
}
