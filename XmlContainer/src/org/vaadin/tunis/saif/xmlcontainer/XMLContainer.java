package org.vaadin.tunis.saif.xmlcontainer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
		 * @throws FileNotFoundException 
		 * 
		 */
		public static XMLContainer newInstanceForJaxb(String filePath,
				Class classe)  {

			try {
				return new JaxbXMLContainer(classe, filePath);
			} catch (JAXBException e) {
				throw new IllegalArgumentException(
						"Cannot parse the given XML file");
			}
			catch (FileNotFoundException e) {
				throw new IllegalArgumentException(
						"File not found");
			}
		}

		/**
		 * Creates a new instance of XMLContainer for the given XML file. This
		 * parser uses the JaxB specification
		 * 
		 * @throws IllegalArgumentException
		 *             if the given XML file cannot be parsed.
		 * @param file
		 *            XML File as java.io.File.
		 * @param classe
		 *            object Class type which will be unmarshalled from the XML
		 *            file
		 * 
		 * @return new XMLContainer instance which contains a collection of
		 *         classe Beans from the given file.
		 * @throws FileNotFoundException 
		 * 
		 */
		public static XMLContainer newInstanceForJaxb(File file,
				Class classe)  {

			try {
				return new JaxbXMLContainer(classe, file);
			} catch (JAXBException e) {
				throw new IllegalArgumentException(
						"Cannot parse the given XML file");
			}
			catch (FileNotFoundException e) {
				throw new IllegalArgumentException(
						"File not found");
			}
		}
		
		/**
		 * Creates a new instance of XMLContainer for the given XML file. This
		 * parser uses the JaxB specification
		 * 
		 * @throws IllegalArgumentException
		 *             if the given XML file cannot be parsed.
		 * @param file
		 *            XML File as java.io.File.
		 * @param classe
		 *            object Class type which will be unmarshalled from the XML
		 *            file
		 * 
		 * @return new XMLContainer instance which contains a collection of
		 *         classe Beans from the given file.
		 * @throws FileNotFoundException 
		 * 
		 */
		public static XMLContainer newInstanceForJaxb(FileInputStream fileInputStream,
				Class classe)  {

			try {
				return new JaxbXMLContainer(classe, fileInputStream);
			} catch (JAXBException e) {
				throw new IllegalArgumentException(
						"Cannot parse the given XML file");
			}
			catch (FileNotFoundException e) {
				throw new IllegalArgumentException(
						"File not found");
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
		
		/**
		 * Creates a new instance of XMLContainer for the given XML file. This
		 * parser uses the Dom parser
		 * 
		 * @throws IllegalArgumentException
		 *             if the given XML file cannot be parsed.
		 * @param file
		 *            XML File as java.io.File.
		 * @param classe
		 *            object Class type which will be binded from the XML
		 *            file
		 * 
		 * @return new XMLContainer instance which contains a collection of
		 *         classe Beans from the given file.
		 * 
		 */
		public static XMLContainer newInstanceForDom(File file,
				Class classe) {

			try {
				return new DomXMLContainer(classe, file);
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
		
		/**
		 * Creates a new instance of XMLContainer for the given XML file. This
		 * parser uses the Dom parser
		 * 
		 * @throws IllegalArgumentException
		 *             if the given XML file cannot be parsed.
		 * @param fileInputStream
		 *            XML FileInputStream.
		 * @param classe
		 *            object Class type which will be binded from the XML
		 *            file
		 * 
		 * @return new XMLContainer instance which contains a collection of
		 *         classe Beans from the given file.
		 * 
		 */
		public static XMLContainer newInstanceForDom(FileInputStream fileInputStream,
				Class classe) {

			try {
				return new DomXMLContainer(classe, fileInputStream);
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
		
		/**
		 * Creates a new instance of XMLContainer for the given XML file. This
		 * parser uses the Dom parser
		 * 
		 * @throws IllegalArgumentException
		 *             if the given XML file cannot be parsed.
		 * @param inputStream
		 *            XML inputStream.
		 * @param classe
		 *            object Class type which will be binded from the XML
		 *            file
		 * 
		 * @return new XMLContainer instance which contains a collection of
		 *         classe Beans from the given file.
		 * 
		 */
		public static XMLContainer newInstanceForDom(InputStream inputStream,
				Class classe) {

			try {
				return new DomXMLContainer(classe, inputStream);
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
