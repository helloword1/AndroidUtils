package cxx.utils;


import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

public class ProcessDialogUtil {

	private static ProcessDialogUtil util = null;

	private static String TAG = "ProcessDialogUtil";

	public static ProgressDialog progressDialog;

	/**
	 * This isUtil.java class 获取实例
	 * 
	 * @return
	 * @return Util: 返回类型
	 */
	public static ProcessDialogUtil getUtil() {
		if (util == null) {
			util = new ProcessDialogUtil();
		}
		return util;
	}
	/**
	 * 显示一个消息
	 * 
	 * @param context
	 * @param msg
	 * @return void: 返回类型
	 */
	public void showText(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	/**
	 * 显示提示框 This isUtil.java class
	 * 
	 * @return void: 返回类型
	 */
	public static void showDialogMSG(Context context) {
		// 防止重复出现
		closeDialogMSG();
		progressDialog = new ProgressDialog(context);
		// LogDRC.d(TAG, "====>调用showDialogMSG()");
		progressDialog.setCancelable(false);
		progressDialog.setMessage("加载中...");
		progressDialog.show();
	}

	/**
	 * 关闭提示框 This isUtil.java class
	 * 
	 * @return void: 返回类型
	 */
	public static void closeDialogMSG() {
		// TODO Auto-generated method stub
		if (progressDialog != null) {
			progressDialog.dismiss();
			progressDialog = null;
		}
	}
}
