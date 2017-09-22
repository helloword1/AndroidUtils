package cxx.utils;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * is null or its length is 0 or it is made by space
	 * 
	 * <pre>
	 * isBlank(null) = true;
	 * isBlank(&quot;&quot;) = true;
	 * isBlank(&quot;  &quot;) = true;
	 * isBlank(&quot;a&quot;) = false;
	 * isBlank(&quot;a &quot;) = false;
	 * isBlank(&quot; a&quot;) = false;
	 * isBlank(&quot;a b&quot;) = false;
	 * </pre>
	 * 
	 * @param str
	 * @return if string is null or its size is 0 or it is made by space, return
	 *         true, else return false.
	 */
	public static boolean isBlank(String str) {
		return (str == null || str.trim().length() == 0);
	}

	/**
	 * Returns true if the string is null or 0-length.
	 * 
	 * @param str
	 *            the string to be examined
	 * @return true if str is null or zero length
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.length() == 0);
	}

	/**
	 * 在字符串后面增加空白符，主要用于手机号码的分割
	 * 
	 * @param str
	 *            如:"138 0013 8000"
	 * @return 返回:"13800138000"
	 */
	public static String removeBlank(String str) {
		String tempStr = str.replace(" ", "");
		return tempStr;
	}

	public static int trulyLength(String content) {
		int length = 0;
		String chinese = "[\\u4e00-\\u9fa5]";
		for (int i = 0; i < content.length(); i++) {
			String temp = content.substring(i, i + 1);
			if (temp.matches(chinese)) {
				length += 2;
			} else {
				length += 1;
			}
		}
		return length;
	}

	/**
	 * encoded in utf-8
	 * 
	 * <pre>
	 * utf8Encode(null)        =   null
	 * utf8Encode("")          =   "";
	 * utf8Encode("aa")        =   "aa";
	 * utf8Encode("鍟婂晩鍟婂晩")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
	 * </pre>
	 * 
	 * @param str
	 * @return
	 * @throws java.io.UnsupportedEncodingException
	 *             if an error occurs
	 */
	public static String utf8Encode(String str) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(
						"UnsupportedEncodingException occurred. ", e);
			}
		}
		return str;
	}

	/**
	 * 判断是不是一个合法的手机号码
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isPhone(String mobiles) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[0-9])|(17[0-9])|(18[0-9])|14[0-9])\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.find();
	}
	/**
	 * 判断是不是一个合法的固话号码
	 * 
	 * @param tel
	 * @return
	 */
	public static boolean isTel(String tel) {
		Pattern p = Pattern
				.compile("^(010|02\\d|0[3-9]\\d{2})?\\d{6,8}$");
		Matcher m = p.matcher(tel);
		return m.find();
	}

	/**
	 * 判断是不是一个合法的手机银行号码,测试用以后要删掉
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobilePhone(String mobiles) {
		Pattern p = Pattern
				.compile("^((11[0-9])|12[0-9]|(13[0-9])|(15[0-9])|(17[0-9])|(18[0-9])|14[0-9])\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.find();
	}

	private final static Pattern emailer = Pattern
			.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

	/**
	 * 判断是不是一个合法的电子邮件地址
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (email == null || email.trim().length() == 0)
			return false;
		return emailer.matcher(email).matches();
	}

	/**
	 * 判断是否为建行账号
	 * 
	 * @param accountNo
	 * @return
	 */
	public static boolean isAccountNo(String accountNo) {
		if (isWholeDigit(accountNo)
				&& (16 == accountNo.length() || 19 == accountNo.length() || 20 == accountNo
						.length())) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是不是一个合法的身份证号
	 * 
	 * @param IdNumber
	 * @return
	 */
	public static boolean isIdNumber(String IdNumber) {
		boolean m = IdNumber
				.matches("(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)");
		return m;
	}

	/**
	 * 是否内容全为数字
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isWholeDigit(String text) {
		boolean isWholeDigit = true;
		for (int i = 0; i < text.length(); i++) {
			boolean isDigit = Character.isDigit(text.charAt(i));
			if (!isDigit) {
				isWholeDigit = false;
				break;
			}
		}
		return isWholeDigit;
	}

	/**
	 * 把身份证号的中间替换成*
	 * 
	 * @param idNumber
	 *            传入的身份证号:"441702198808084321"
	 * @return 返回"4417****4321"
	 */
	public static String replaceIdNumberMiddle2Asterisk(String idNumber) {
		char[] idNumberCharArray = idNumber.toCharArray();
		int startIndex = 4, endIndex = idNumberCharArray.length - 4;
		for (int i = startIndex; i < endIndex; i++) {
			idNumberCharArray[i] = '*';
		}
		return new String(idNumberCharArray);
	}

	/**
	 * 把email的中间替换成*，保留用户名前两位和最后一位
	 * 
	 * @param email
	 *            传入的email:"abcdef@com.ccb.shop.com"
	 * @return 返回"ab***f@com.ccb.shop.com"
	 */
	public static String replaceEmailMiddle2Asterisk(String email) {
		char[] emailCharArray = email.toCharArray();
		int place = email.indexOf("@");

		// @前面的邮箱用户名大于2个才去加上*号，否则不加
		if (place > 2) {
			int startIndex = 2, endIndex = place - 1;
			for (int i = startIndex; i < endIndex; i++) {
				emailCharArray[i] = '*';
			}
		}
		return new String(emailCharArray);
	}

	/**
	 * 把userName的中间替换成***，保留用户名前两位和最后两位
	 * 
	 * @param userName
	 *            传入的userName:"abcdefghi"
	 * @return 返回"ab***hi"
	 */
	public static String replaceUserNameMiddle2Asterisk(String userName) {
		int length = userName.length();

		if (length < 4) {
			return userName;
		}

		String result = userName.substring(0, 2) + "***"
				+ userName.substring(length - 2, length);
		return result;
	}

	/**
	 * 把手机号的中间替换成*
	 * 
	 * @param phoneNumber
	 *            传入的手机号:"18664548654"
	 * @return 返回"186****8654"
	 */
	public static String replacePhoneMiddle2Asterisk(String phoneNumber) {
		char[] phoneCharArray = phoneNumber.toCharArray();
		int startIndex = 3, endIndex = startIndex + 4;
		for (int i = startIndex; i < endIndex; i++) {
			phoneCharArray[i] = '*';
		}
		return new String(phoneCharArray);
	}

	/**
	 * 把建行账号的中间替换成*
	 * 
	 * @param AccountNo
	 *            传入建行账号：6227003328888881070
	 * @return 6227003328*****1070
	 */
	public static String replaceAccountNoMiddle2Asterisk(String accountNo) {
		char[] accountNoCharArray = accountNo.toCharArray();
		int startIndex = 10, endIndex = accountNoCharArray.length - 4;
		for (int i = startIndex; i < endIndex; i++) {
			accountNoCharArray[i] = '*';
		}
		return new String(accountNoCharArray);
	}

	public static boolean isHaveValue(String input) {
		if (isEmpty(input)) {
			return false;
		}
		if (input.equalsIgnoreCase("null"))
			return false;
		else
			return true;
	}

	/**
	 * 获取对应的值
	 * 
	 * @param key
	 * @param json
	 * @return
	 */
	public static String getValue(String key, JSONObject json) {
		if (json == null)
			return null;
		if (json.isNull(key))
			return null;
		try {
			return json.getString(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 字符串转整数
	 * 
	 * @param str
	 * @param defValue
	 * @return
	 */
	public static int toInt(String str, int defValue) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
		}
		return defValue;
	}

	/**
	 * 对象转整数
	 * 
	 * @param obj
	 * @return 转换异常返回 0
	 */
	public static int toInt(Object obj) {
		if (obj == null)
			return 0;
		return toInt(obj.toString(), 0);
	}

	/**
	 * 判断密码最少6，有字母或数字组成
	 * 
	 * @param str
	 * @return 跟
	 */
	public static String stringFilter(String str) {
		// 只允许字母和数字
		String regEx = "^[A-Za-z0-9]{6,16}$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * 获取拼音的首字母（大写）
	 * 
	 * @param pinyin
	 * @return
	 */
	public static String getFirstLetter(final String pinyin) {
		if (TextUtils.isEmpty(pinyin))
			return "定位";
		String c = pinyin.substring(0, 1);
		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		if (pattern.matcher(c).matches()) {
			return c.toUpperCase();
		} else if ("0".equals(c)) {
			return "定位";
		} else if ("1".equals(c)) {
			return "热门";
		}
		return "定位";
	}

	/**
	 * 获取拼音的首字母（大写）
	 * 
	 * @param pinyin
	 * @return
	 */
	public static String getFirstLetterCard(final String pinyin) {
		if (TextUtils.isEmpty(pinyin))
			return "";
		String c = pinyin.substring(0, 1);
		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		if (pattern.matcher(c).matches()) {
			return c.toUpperCase();
		} else {
			return "#";
		}

	}

	/**
	 * 获取拼音的首字母（大写）
	 * 
	 * @param pinyin
	 * @return
	 */
	public static String getCardFirstLetter(final String pinyin) {
		if (TextUtils.isEmpty(pinyin))
			return "↑";
		String c = pinyin.substring(0, 1);
		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		if (pattern.matcher(c).matches()) {
			return c.toUpperCase();
		}
		return "↑";
	}

	/**
	 * 判断是否是合法手机号
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isPassWord(String pw) {
		// Pattern p = Pattern
		// .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(18[1,0-1]))\\d{8}$");
		Pattern p = Pattern.compile("^([A-Za-z]|[0-9])+$");
		Matcher m = p.matcher(pw);
		return m.matches();
	}

	/**
	 * 判断是否是合法手机号
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isUrl(String url) {
		Pattern pattern = Pattern
				.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)"
						+ "(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
		Matcher m = pattern.matcher(url);
		return m.matches();
	}
}
