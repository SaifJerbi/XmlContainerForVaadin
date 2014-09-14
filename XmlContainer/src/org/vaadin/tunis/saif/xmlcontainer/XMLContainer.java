package org.vaadin.tunis.saif.xmlcontainer;

import javax.xml.bind.JAXBException;

import com.vaadin.data.Container;

public interface XMLContainer extends Container.Indexed, Container.Sortable,
		Container.Filterable, Container.SimpleFilterable {

	public static class Factory {

		/**
		 * Creates a new instance of JsonContainer for the given JSON string.
		 * 
		 * @throws IllegalArgumentException
		 *             if the given JSON string cannot be parsed.
		 * @param json
		 *            JSON data for populating the container.
		 * @return new JsonContainer instance populated with the given data.
		 * 
		 */
		public static XMLContainer newInstance(String filePath, Class classe) {

			try {
				return new IndexedXMLContainer(classe, filePath, classe);
			} catch (JAXBException e) {
				throw new IllegalArgumentException(
						"Cannot parse the given XML file");
			}
		}
	}
}
