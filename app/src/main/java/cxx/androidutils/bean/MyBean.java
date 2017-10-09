package cxx.androidutils.bean;

/**
 * Created by LJN on 2017/9/28.
 */

public class MyBean {
    private String name;
    private int age;
    private String iconurl;
    private  boolean isShowIcon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public boolean isShowIcon() {
        return isShowIcon;
    }

    public void setShowIcon(boolean showIcon) {
        isShowIcon = showIcon;
    }

    public MyBean(String name, int age, String iconurl, boolean isShowIcon) {
        this.name = name;
        this.age = age;
        this.iconurl = iconurl;
        this.isShowIcon = isShowIcon;
    }
}
