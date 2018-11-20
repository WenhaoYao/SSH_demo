package entity;

import java.io.Serializable;

/**
 * @author yaowenhao
 * @Title: Univercity
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/19 17:23
 */
public class Univercity implements Serializable {

    private static final long serialVersionUID = -6849794470754667710L;

    private Integer id;
    private String sex;
    private String univercity;
    private String start_time;
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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public Integer getjValue() {
        return jValue;
    }

    public void setjValue(Integer jValue) {
        this.jValue = jValue;
    }

    @Override
    public String toString() {
        return "Univercity{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", univercity='" + univercity + '\'' +
                ", start_time=" + start_time +
                ", jValue=" + jValue +
                '}';
    }
}
