package setup;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;

public class Util {

	
	
	/**
	 * Created by olaskierbiszewska on 31.01.16.
	 */
	

	    public Util() {
	    }

	    public static String stringNoUserInDb() {
	        return "{\"message\":\"noUser\"}";
	    }

	    public static String stringInvalidPassword() { return "{\"message\":\"invalidPassword\"}";}

	    public static String stringInvalidNameOrPassword() { return "{\"message\":\"invalidNameOrPassword\"}";}

	    public static String stringNickNotAvailable() {
	        return "{\"message\":\"userNameNotAvailable\"}";
	    }

	    public static String stringUserLoggedWithToken() {
	        return "{\"message\":\"logged\", \"token\":\"";
	    }

	    public static String stringRegistrationSucceedWithToken() {
	        return "{\"message\":\"registered\", \"token\":\"";
	    }

	    public static String stringRegistrationFailed() {
	        return "{\"message\":\"registrationFailed\"";
	    }

	    
	
	
	public static Object getField(Object obj, String fieldName) {
		try {
			Field field = FieldUtils.getField(obj.getClass(), fieldName, true);
			return field.get(obj);
		} catch (Exception e) {
			throw new RuntimeException("cannot get handlebars", e);
		}
	}

}