package com.util.objectOperations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * CompareUtil used to sort the objects on the basis of their property. it can
 * sort the objects using not only a single property but also multiple
 * properties.For example Person class has a property like
 * firstName,lastName,dateOfBirth and salary .
 * <p>
 * CompareUtil also works on getter methods
 * </p>
 * Usage : <code>
 * 		CompareUtil compareUtil=new CompareUtil();
 * 		compareUtil.setKey("salary");             //this is must
 * 		compareUtil.setSequenceOfKeys("dateOfBrith","firstName","lastName"); //this is optional
 * 		Collections.sort(personList,compareUtil);
 * </code> it will compare the list of person first on the basis of their salary
 * if salary is equal of two persons then dateOfBirth if dateOfBirth also equal
 * of two person then firstName if firstName also equal of two person then
 * lastName. we can also use it when objects are wrapped in the other object
 * Example Person class have the property like firstName,lastName,dateOfBirth
 * and salary. PersonUI class has the has a relationship with Person class
 * <code>
 * 		public class PersonUI{
 * 			private	Person person;
 * 			------------
 * 			------------
 * 			public PersonUI(Person person){
 * 				this.person=person;
 * 			}
 * 			------------
 * 			------------		
 * 		}
 * 
 * 		CompareUtil compareUtil=new CompareUtil();
 * 		compareUtil.setKey("person.salary");             //this is must
 * 		compareUtil.setSequenceOfKeys("dateOfBrith","firstName","lastName"); //this is optional
 * 		Collections.sort(personUIList,compareUtil); * 		
 * 
 * </code> it will compare the list of personUI first on the basis of salary of
 * person if salary is equal of two person then dateOfBirth if dateOfBirth also
 * equal of two person then firstName if firstName also equal of two person then
 * lastName.
 * 
 * 
 * @author <i>Sukhdeep Bangar</i>
 * 
 */

public class CompareUtil implements Comparator<Object> {

	private String key;
	private boolean isCaseSensitive;
	private boolean ascending;
	private String keyPath[];
	private String sequenceOfKeys[];

	/**
	 * 
	 */
	public CompareUtil() {

	}

	/**
	 * Initialize the data member
	 * 
	 * @param key
	 *            sorting key
	 * @param isNumber
	 * @param isCaseSensitive
	 */
	public CompareUtil(String key, boolean isCaseSensitive) {
		this.isCaseSensitive = isCaseSensitive;
		this.ascending = true;
		setKeyPath(key);
	}

	/**
	 * Initialize of key
	 * 
	 * @param key
	 *            sorting key.
	 */
	public CompareUtil(String key) {
		setKeyPath(key);
		this.ascending = true;
	}

	
	public int compare(Object o1, Object o2) {
		if (key == null)
			return 0;
		if (keyPath.length > 1) {
			Object old = null;
			for (int i = 0; i < keyPath.length - 1; i++) {
				old = o1;
				o1 = getValueForKey(keyPath[i], o1);
				o2 = getValueForKey(keyPath[i], o2);
				if (o1 == null || o2 == null)
					throw new RuntimeException(key + " and " + getGetterKey(key) + " key not found in " + old.getClass().getName());
			}
		}
		if (!ascending)
			return sequenceCompare(o2, o1);
		else
			return sequenceCompare(o1, o2);
	}

	/**
	 * 
	 * @param key
	 */
	private void setKeyPath(String key) {
		this.keyPath = key.split("[.]");
		if (keyPath.length > 0)
			this.key = keyPath[keyPath.length - 1];
		else
			this.key = key;
	}

	/**
	 * Compare the object on the base of keys sequence
	 * 
	 * @param o1
	 *            object1
	 * @param o2
	 *            object2
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private int sequenceCompare(Object o1, Object o2) {

		int result = compareObjects(o1, o2, key);
		if (result == 0 && sequenceOfKeys != null && sequenceOfKeys.length > 0) {
			for (int i = 0; i < sequenceOfKeys.length; i++) {
				result = compareObjects(o1, o2, sequenceOfKeys[i]);
				if (result != 0)
					return result;
			}
		}
		return result;
	}

	/**
	 * compare the non primitive type objects
	 * 
	 * @param field
	 *            field of object
	 * @param o1
	 *            object1
	 * @param o2
	 *            object2
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private int compareObjects(Object o1, Object o2, String key) {
		Object old = o1;
		o1 = getValueForKey(key, o1);
		o2 = getValueForKey(key, o2);
		if (o1 == null || o2 == null)
			throw new RuntimeException(key + " and " + getGetterKey(key) + " key not found in " + old.getClass().getName());
		Object value = null;
		if (!isCaseSensitive && o1.getClass().getName().equals(String.class.getName()))
			value = getValue("compareToIgnoreCase", o1, o2);
		else
			value = getValue("compareTo", o1, o2);
		if (value != null)
			return (Integer) value;
		return 0;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		String keyStr = "";
		for (String str : keyPath)
			keyStr += "." + str;
		return keyStr + "." + key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		setKeyPath(key);
	}

	/**
	 * @return the isCaseSensitive
	 */
	public boolean isCaseSensitive() {
		return isCaseSensitive;
	}

	/**
	 * @param isCaseSensitive
	 *            the isCaseSensitive to set
	 */
	public void setCaseSensitive(boolean isCaseSensitive) {
		this.isCaseSensitive = isCaseSensitive;
	}

	/**
	 * @return the ascending
	 */
	public boolean isAscending() {
		return ascending;
	}

	/**
	 * @param ascending
	 *            the ascending to set
	 */
	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	/**
	 * @return the sequenceOfKeys
	 */
	public String[] getSequenceOfKeys() {
		return sequenceOfKeys;
	}

	/**
	 * Set the sequence of sorting on the basis of multiple key.
	 * 
	 * @param sequenceOfKeys
	 *            the sequenceOfKeys to set
	 */
	public void setSequenceOfKeys(String... sequenceOfKeys) {
		this.sequenceOfKeys = sequenceOfKeys;
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @return
	 */
	private Method getMethod(Object obj, String methodName, Object param) {
		try {
			if (obj == null || methodName == null)
				return null;
			if (param == null)
				try {
					return obj.getClass().getDeclaredMethod(methodName);
				} catch (Exception e) {
					return obj.getClass().getMethod(methodName);
				}

			else if (getField("TYPE", param) != null) {
				Field f = getField("TYPE", param);
				f.setAccessible(true);
				try {
					return obj.getClass().getDeclaredMethod(methodName, (Class) f.get(param));
				} catch (Exception e) {
					try {
						return obj.getClass().getMethod(methodName, (Class) f.get(param));
					} catch (Exception e1) {
					}
				}
			}
			if (param != null)
				try {
					return obj.getClass().getDeclaredMethod(methodName, param.getClass());
				} catch (Exception e) {
					return obj.getClass().getDeclaredMethod(methodName, param.getClass());
				}

		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 
	 * @param m
	 * @param obj
	 * @param param
	 * @return
	 */
	private Object invokMethod(Method m, Object obj, Object param) {
		try {
			if (m == null || obj == null)
				return null;
			m.setAccessible(true);
			if (param == null)
				return m.invoke(obj);
			return m.invoke(obj, param);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @param key
	 * @param obj
	 * @return
	 */
	private Object getValueForKey(String key, Object obj) {		
			Object value = invokMethod(getMethod(obj, getGetterKey(key), null), obj, null);			
			if(value==null)			
				value= getValue(key, obj, null);
			return value;		
	}

	/**
	 * 
	 * @param key
	 * @param obj
	 * @param param
	 * @return
	 */
	private Object getValue(String key, Object obj, Object param) {
		Object value = invokMethod(getMethod(obj, key, param), obj, param);
		if (value == null)
			return getFieldValue(getField(key, obj), obj);
		else
			return value;

	}

	/**
	 * Make the key as a getter
	 * <p>
	 * Example key is name the it will return getName
	 * </p>
	 * 
	 * @param key
	 * @return
	 */
	private String getGetterKey(String key) {
		if (key.length() == 1)
			return "get" + key.toUpperCase();
		else
			return "get" + key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
	}

	/**
	 * Return the Filed object of <code>obj</code> object it may be
	 * private,public or protected if field inherited from parent then it must
	 * be public else return null
	 * 
	 * @param key
	 * @param obj
	 * @return return the field
	 */
	private Field getField(String key, Object obj) {
		try {
			return obj.getClass().getDeclaredField(key);
		} catch (Exception e) {
			try {
				return obj.getClass().getField(key);
			} catch (Exception e1) {
				return null;
			}
		}
	}

	/**
	 * 
	 * @param field
	 *            Field of object
	 * @param obj
	 * @return the value of field
	 */
	private Object getFieldValue(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return field.get(obj);
		} catch (Exception e) {
			return null;
		}
	}
}
