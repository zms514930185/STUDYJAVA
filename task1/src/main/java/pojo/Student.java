package pojo;

import java.sql.Timestamp;

public class Student {
    private Integer id;
    private String sName;
    private String qq;
    private String job;
    private Long createAt;
    private Long updateAt;

    @Override
    public String toString() {
        return "Student{" +
                "编号:" + id +
                ", 姓名:'" + sName + '\'' +
                ", QQ:'" + qq + '\'' +
                ", job:'" + job + '\'' +
                ", createAt:" + createAt +
                ", updateAt:" + updateAt +
                '}';
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getQq(String qq) {
        return this.qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getJob(String job) {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getCreateAt(Long at) {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt(Long aLong) {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}
