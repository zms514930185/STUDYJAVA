package pojo;

public class Student {
    private String stuName;
    private String qq;
    private String job;
    private Long createAt;
    private Long updateAt;
    private String dailyUrl;
    private String flag;
    private Integer id;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getDailyUrl() {
        return dailyUrl;
    }

    public void setDailyUrl(String dailyUrl) {
        this.dailyUrl = dailyUrl;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", qq='" + qq + '\'' +
                ", job='" + job + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", dailyUrl='" + dailyUrl + '\'' +
                ", flag='" + flag + '\'' +
                ", id=" + id +
                '}';
    }
}
