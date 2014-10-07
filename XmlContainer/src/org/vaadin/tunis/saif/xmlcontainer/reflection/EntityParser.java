package org.vaadin.tunis.saif.xmlcontainer.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.vaadin.tunis.saif.xmlcontainer.test.Employee;

public class EntityParser {
	public static HashMap<String, String> getFieldsName(Class cls) {
		HashMap<String, String> mapOfField = new HashMap<String, String>();
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			mapOfField.put(field.getName(), field.getGenericType().toString());
		}
		return mapOfField;
	}

	public static void invokeSetterMethod(Object entity, String fieldName,Object value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		getSetterMethod(entity.getClass(), fieldName).invoke(entity, value);
	}

	public static Method getSetterMethod(Class cls, String fieldName) {
		Method[] methods = cls.getDeclaredMethods();
		int i = 0;
		do {
			if (methods[i].getName().equalsIgnoreCase("set" + fieldName)) {
				return methods[i];
			}
			i++;
		} while (i < methods.length);
		return null;
	}

	public static void main(String[] args) {
		HashMap<String, String> ss = getFieldsName(Employee.class);

		Iterator itr = ss.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry pairs = (Map.Entry) itr.next();
			System.out.println(pairs.getKey() + " " + pairs.getValue());
		}

	}
}
