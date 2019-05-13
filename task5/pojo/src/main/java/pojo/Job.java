package pojo;

public class Job {
    private Long id;

    private String direction;

    private String job;

    private String description;

    private String introduction;

    private Integer threshold;

    private Integer difficult;

    private Integer growth;

    private Integer demands;

    private String payone;

    private String paysec;

    private String paythr;

    private String image;

    private Long createAt;

    private Long updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getDemands() {
        return demands;
    }

    public void setDemands(Integer demands) {
        this.demands = demands;
    }

    public String getPayone() {
        return payone;
    }

    public void setPayone(String payone) {
        this.payone = payone == null ? null : payone.trim();
    }

    public String getPaysec() {
        return paysec;
    }

    public void setPaysec(String paysec) {
        this.paysec = paysec == null ? null : paysec.trim();
    }

    public String getPaythr() {
        return paythr;
    }

    public void setPaythr(String paythr) {
        this.paythr = paythr == null ? null : paythr.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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
}