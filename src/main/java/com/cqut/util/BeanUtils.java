package com.cqut.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

	
public class BeanUtils {
	    
	    /**
	     * 检查是否为null
	     * @param bean
	     * @return
	     */
	    public static boolean checkFieldValueNull(Object bean) {
	        boolean result = true;
	        if (bean == null) {
	            return true;
	        }
	        Class<?> cls = bean.getClass();
	        Method[] methods = cls.getDeclaredMethods();
	        Field[] fields = cls.getDeclaredFields();
	        for (Field field : fields) {
	            try {
	                String fieldGetName = parGetName(field.getName());
	                if (!checkGetMet(methods, fieldGetName)) {
	                    continue;
	                }
	                Method fieldGetMet = cls.getMethod(fieldGetName, new Class[]{});
	                Object fieldVal = fieldGetMet.invoke(bean, new Object[]{});
	                if (fieldVal != null) {
	                    if ("".equals(fieldVal)) {
	                        result = true;
	                    } else {
	                        result = false;
	                    }
	                }
	            } catch (Exception e) {
	                continue;
	            }
	        }
	        return result;
	    }


	    /**
	     * 拼接某属性的 get方法
	     *
	     * @param fieldName
	     * @return String
	     */
	    public static String parGetName(String fieldName) {
	        if (null == fieldName || "".equals(fieldName)) {
	            return null;
	        }
	        int startIndex = 0;
	        if (fieldName.charAt(0) == '_')
	            startIndex = 1;
	        return "get"
	                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
	                + fieldName.substring(startIndex + 1);
	    }

	    /**
	     * 判断是否存在某属性的 get方法
	     *
	     * @param methods
	     * @param fieldGetMet
	     * @return boolean
	     */
	    public static boolean checkGetMet(Method[] methods, String fieldGetMet) {
	        for (Method met : methods) {
	            if (fieldGetMet.equals(met.getName())) {
	                return true;
	            }
	        }
	        return false;
	    }
	   
		/**
		 * 对象转换为map，null转换为""
		 * @param obj
		 * @param isNul;是否剔除null和""属性,true剔除；false不剔除转换为空字符串
		 * @return
		 */
		public static Map<String, Object> convertObjToMap(Object obj,boolean isNull) {
			Map<String, Object> reMap = new HashMap<String, Object>();
			if (obj == null)
				return null;
			Field[] fields = obj.getClass().getDeclaredFields();
			try {
				for (int i = 0; i < fields.length; i++) {
					try {
						Field f = obj.getClass().getDeclaredField(
								fields[i].getName());
						f.setAccessible(true);
						Object o = f.get(obj);
						
						if (o instanceof Date) {
							o = DateFactory.formatDateTime((Date) o);
						}
						if(isNull==true){
							if(o!=null){
								reMap.put(fields[i].getName(), o);
							}
						}
						else{
							if (o == null) {
								o = "";
						    }
							reMap.put(fields[i].getName(), o);
						}
							
						
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			return reMap;
		}
		
	}