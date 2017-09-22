package cxx.utils;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * TimeUtils
 * 
 * @author ning
 */
public class TimeUtils {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE    = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_FORMAT_DATE_CN = new SimpleDateFormat("yyyy年MM月dd日");
	private final static SimpleDateFormat DISPLAY_FORMAT	 = new SimpleDateFormat("MM/dd HH:mm");
	public static final SimpleDateFormat DATE_FORMAT_TIME	 = new SimpleDateFormat("HH:mm");
	
	 public static final SimpleDateFormat DEFAULT_DATE_FORMAT_Style1 = new SimpleDateFormat("yyyyMMddHHmmss");
	

    /**
     * long time to string
     * 
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     * 
     * @param timeInMillis
     * @return
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }
    
    /**
     * get current time in milliseconds
     * 
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     * 
     * @return
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * get current time in milliseconds
     * 
     * @return
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }
    
    /**
     * 返回 20140707的格式
     * 
     * @return
     */
    public static String getYyyymmddFormat() {
    	String date = DATE_FORMAT_DATE.format(System.currentTimeMillis()).replaceAll("-", "");
    	return date;
    }
    
	
    /**
     * 返回 20140707090909的格式
     * 
     * @return
     */
    public static String getYyyymmddHHmmssFormat() {
    	String date = DEFAULT_DATE_FORMAT.format(System.currentTimeMillis())
    			.replaceAll("[-:\\s]", "");
    	return date;
    }
    
	@SuppressWarnings("deprecation")
	public static String friendlyTime(Date time) {
		if (time == null) {
			return "Unknown";
		}
		String ftime = "";
		Calendar cal = Calendar.getInstance();

		// 判断是否是同一天
		String curDate = DATE_FORMAT_DATE.format(cal.getTime());
		String paramDate = DATE_FORMAT_DATE.format(time);
		if (curDate.equals(paramDate)) {
			int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
			if (hour == 0) {
				ftime = Math.max((cal.getTimeInMillis()
						- time.getTime()) / 60000, 1)+ "分钟前";
			} else {
				ftime = hour + "小时前";
			}
				
			return ftime;
		}

		long lt = time.getTime() / 86400000;
		long ct = cal.getTimeInMillis() / 86400000;
		int days = (int) (ct - lt);
		String minutes = time.getMinutes() >= 10 ?
				time.getMinutes() + "" : "0" + time.getMinutes();
		if (days == 0) {
			int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
			if (hour == 0) {
				ftime = Math.max((cal.getTimeInMillis()
						- time.getTime()) / 60000, 1)+ "分钟前";
			} else {
				ftime = hour + "小时前";
			}
				
		} else if (days == 1) {
			ftime = MessageFormat.format("昨天{0}:{1}", time.getHours(),
					minutes);
		} else if (days == 2) {
			ftime = MessageFormat.format("前天{0}:{1}", time.getHours(),
					minutes);
		} else if (days > 2) {
			ftime = DATE_FORMAT_DATE_CN.format(time);
		}
		return ftime;
	}
	
	public static long getMillSecondByDate(String dateStr) {
		if (dateStr.contains(".")) {
			dateStr = dateStr.substring(0, dateStr.indexOf('.'));
		}
		
		try {
			Date date = DEFAULT_DATE_FORMAT.parse(dateStr);
			return date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis();
	}
}
