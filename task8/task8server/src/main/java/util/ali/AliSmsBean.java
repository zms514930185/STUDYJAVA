package util.ali;



public class AliSmsBean {
    private String accessKeyId;
    private String accessKeySecret;
    private String signName;
    private String templateCode;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public String getSignName() {
        return signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }
}
