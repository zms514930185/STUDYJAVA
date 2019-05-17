package pojo;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 6412031968583909091L;

    public User(Long id, String name, String qq, String job, Long createAt, Long updateAt, String daily, String flag, Long mobil, String email, String password) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.job = job;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.daily = daily;
        this.flag = flag;
        this.mobil = mobil;
        this.email = email;
        this.password = password;
    }

    public User(Long mobil, String password) {
        this.mobil = mobil;
        this.password = password;
    }

    public User() {
    }

    private Long id;

    private String name;

    private String qq;

    private String job;

    private Long createAt;

    private Long updateAt;

    private String daily;

    private String flag;

    private Long mobil;

    private String email;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily == null ? null : daily.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Long getMobil() {
        return mobil;
    }

    public void setMobil(Long mobil) {
        this.mobil = mobil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}