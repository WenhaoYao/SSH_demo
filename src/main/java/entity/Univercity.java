package entity;

import java.time.Year;

/**
 * @author yaowenhao
 * @Title: Univercity
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/19 17:23
 */
public class Univercity {

    private Integer id;
    private String sex;
    private String univercity;
    private Year year;
    private Integer jValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Integer getjValue() {
        return jValue;
    }

    public void setjValue(Integer jValue) {
        this.jValue = jValue;
    }
}
