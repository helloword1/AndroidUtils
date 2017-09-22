package cxx.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class SharedPreferencesUtils {

	public static final String WIDTH = "width";
	public static final String HEIGHT = "height";

    private static final String PREFERENCE_NAME = "YQC_BUSINESS_CARDS";

    public static SharedPreferencesUtils instance;
    public SharedPreferences sharedPreferences;

    private SharedPreferencesUtils(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Single instance.
     */
    public static SharedPreferencesUtils getInstance(Context context) {
        if(instance == null) {
            instance = new SharedPreferencesUtils(context);
        }
        return instance;
    }

    public void putValue(String key, Object value) {
        Editor editor = sharedPreferences.edit();
        if (value == null || value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if(value instanceof Integer) {
            editor.putInt(key, (Integer)value);
        }else if(value instanceof Long){
        	editor.putLong(key, (Long)value);
        }
        editor.commit();
    }

    public <T extends Object> Object getValue(String key, Class<T> cls, Boolean bl) {
        if (cls.equals(String.class)) {
        	String returnValue = sharedPreferences.getString(key, "");
        	return returnValue;
        } else if (cls.equals(Boolean.class)) {
            return sharedPreferences.getBoolean(key, bl);
        } else if (cls.equals(Integer.class)) {
            return sharedPreferences.getInt(key, 0);
        }else if(cls.equals(Long.class)){
        	return sharedPreferences.getLong(key, 0);
        }
        return null;
    }

    public String getStringValue(String key) {
        String value = (String) getValue(key, String.class,null);
        return value;
    } public void cleanValue(String key) {
        Editor editor = sharedPreferences.edit();
        editor.remove("KEY");
        editor.commit();
    }
    
    public int getWidth() {
    	return (Integer) getValue(WIDTH, Integer.class,null);
    }
    
    public int getHeight() {
    	return (Integer) getValue(HEIGHT, Integer.class,null);
    }
    
    /**
     * 清除配置文件
     * 
     * @author
     * @since 2016/02/01
     */
	public void clearPreferences() {
		if (sharedPreferences != null) {
			Editor editor = sharedPreferences.edit();
			editor.clear();  
			editor.commit();
		}
	}
	
	/**
     * 清除手势密码配置信息
     * 
     */
	public void clearGesturePreferences() {
		if (sharedPreferences != null) {
		
		}
	}

}
