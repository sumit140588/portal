package in.garaaj.common.base.util;

import com.google.gson.Gson;

public class GaraajParser {

	public static String convertObjectToJSON(Object object){
		Gson gson=new Gson();
		String jsonString=gson.toJson(object);
		return jsonString;
	}
	public static Object convertJSONToObject(String jsonString,Class type){
		Gson gson=new Gson();
		Object o=gson.fromJson(jsonString,type);
		return o;
	}
		public static Object ConvertSourceObjectToType(Object object,Class type){
			Gson gson=new Gson();
			Object o=convertJSONToObject(convertObjectToJSON(object), type);
			return o;
		}
		
}
