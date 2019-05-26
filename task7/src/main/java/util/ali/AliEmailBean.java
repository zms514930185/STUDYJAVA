package util.ali;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


public class AliEmailBean {
    private String accessKeyId;
    private String accessKeySecret;
    private String accountName;
    private String fromAlias;
    private String tagName;
    private String subject;
    private String htmlBody;

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setFromAlias(String fromAlias) {
        this.fromAlias = fromAlias;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getFromAlias() {
        return fromAlias;
    }

    public String getTagName() {
        return tagName;
    }

    public String getSubject() {
        return subject;
    }

    public String getHtmlBody() {
        return htmlBody;
    }
}
