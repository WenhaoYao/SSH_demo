package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ReflectUtil {
	
	/**
	 * 
	 * @Title: getEntityValue
	 * @Description: 得到一个实体类对象的属性值数组
	 * @param object
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @return: Object[]
	 */
	public static Object[] getEntityValue(Object object) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Field[] fields = object.getClass().getDeclaredFields();
		Object[] objects = new Object[fields.length];
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
			String type = fields[i].getGenericType().toString();
			if (type.equals("class java.lang.String")) {
				Method m = object.getClass().getMethod("get" + name);
				String value = (String) m.invoke(object);
				if (value != null) {

					objects[i] = value;
				}
			}
			if (type.equals("class java.lang.Integer")) {
				Method m = object.getClass().getMethod("get" + name);
				Integer value = (Integer) m.invoke(object);
				if (value != null) {
					objects[i] = value;
				}
			}
			if (type.equals("class java.lang.Short")) {
				Method m = object.getClass().getMethod("get" + name);
				Short value = (Short) m.invoke(object);
				if (value != null) {
					objects[i] = value;
				}
			}
			if (type.equals("class java.lang.Double")) {
				Method m = object.getClass().getMethod("get" + name);
				Double value = (Double) m.invoke(object);
				if (value != null) {
					objects[i] = value;
				}
			}
			if (type.equals("class java.lang.Boolean")) {
				Method m = object.getClass().getMethod("get" + name);
				Boolean value = (Boolean) m.invoke(object);
				if (value != null) {
					objects[i] = value;
				}
			}
			if (type.equals("class java.util.Date")) {
				Method m = object.getClass().getMethod("get" + name);
				Date value = (Date) m.invoke(object);
				if (value != null) {
					objects[i] = value.toString();
				}
			}
		}

		return objects;
	}
}
