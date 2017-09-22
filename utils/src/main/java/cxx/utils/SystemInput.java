package cxx.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class SystemInput {
	
	
	
	public static void input(Context context){
		InputMethodManager inputMethodManager=(InputMethodManager)context. getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}

	public static boolean isActive(Context context){
		InputMethodManager imm = (InputMethodManager)context .getSystemService(Context.INPUT_METHOD_SERVICE);
		boolean isOpen=imm.isActive();
		return isOpen;
	}
	
	public static void openInput(Context context){
		InputMethodManager inputMethodManager=(InputMethodManager)context. getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
	}
	
	public static void closeInput(Context context){
		InputMethodManager inputMethodManager=(InputMethodManager)context. getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}
	
	//Òþ²ØÐéÄâ¼üÅÌ
    public static void hideKeyboard(View v)
    {
        InputMethodManager imm = (InputMethodManager) v.getContext( ).getSystemService( Context.INPUT_METHOD_SERVICE );
         if ( imm.isActive( ) ) {     
              imm.hideSoftInputFromWindow( v.getApplicationWindowToken( ) , 0 );   
            }    
    }
}
