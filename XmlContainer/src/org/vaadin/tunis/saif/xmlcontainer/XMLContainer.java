package org.vaadin.tunis.saif.xmlcontainer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.vaadin.tunis.saif.xmlcontainer.dom.DomXMLContainer;
import org.vaadin.tunis.saif.xmlcontainer.jaxb.JaxbXMLContainer;
import org.xml.sax.SAXException;

import com.vaadin.data.Container;

public interface XMLContainer extends Container.Indexed, Container.Sortable,
		Container.Filterable, Container.SimpleFilterable {

	public static class Factory {

		/**
		 * Creates a new instance of XMLContainer for the given XML file. This
		 * parser uses the JaxB specification
		 * 
		 * @throws IllegalArgumentException
		 *             if the given XML file cannot be parsed.
		 * @param filePath
		 *            XML File Path.
		 * @param classe
		 *            object Class type which will be unmarshalled from the XML
		 *            file
		 * 
		 * @return new XMLContainer instance which contains a collection of
		 *         classe Beans from the given file.
		 * 
		 */
		public static XMLContainer newInstanceForJaxb(String filePath,
				Class classe) {

			try {
				return new JaxbXMLContainer(classe, filePath);
			} catch (JAXBException e) {
				throw new IllegalArgumentException(
						"Cannot parse the given XML file");
			}
		}

		/**
		 * Creates a new instance of XMLContainer for the given XML file. This
		 * parser uses the Dom parser
		 * 
		 * @throws IllegalArgumentException
		 *             if the given XML file cannot be parsed.
		 * @param filePath
		 *            XML File Path.
		 * @param classe
		 *            object Class type which will be binded from the XML
		 *            file
		 * 
		 * @return new XMLContainer instance which contains a collection of
		 *         classe Beans from the given file.
		 * 
		 */
		public static XMLContainer newInstanceForDom(String filePath,
				Class classe) {

			try {
				return new DomXMLContainer(classe, filePath);
			} catch (JAXBException e) {
				throw new IllegalArgumentException(
						"Cannot parse the given XML file");
			} catch (IllegalAccessException e) {
				throw new IllegalAccessError(e.getMessage());
			} catch (InvocationTargetException e) {
				throw new IllegalAccessError(e.getMessage());
			} catch (InstantiationException e) {
				throw new IllegalAccessError(e.getMessage());
			} catch (ParserConfigurationException e) {
				throw new IllegalAccessError(e.getMessage());
			} catch (SAXException e) {
				throw new IllegalAccessError(e.getMessage());
			} catch (IOException e) {
				throw new IllegalAccessError(e.getMessage());
			}
		}
	}
}
