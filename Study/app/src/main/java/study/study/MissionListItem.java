package study.study;

/**
 * Created by sungju on 2017-07-24.
 */

public class MissionListItem {
    private String name;
    private String phone;
    private int age;
    private int resId;

    public MissionListItem(String name, String phone, int age, int resId) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
