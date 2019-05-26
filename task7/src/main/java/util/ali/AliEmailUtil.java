package util.ali;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AliEmailUtil {
    Logger logger = Logger.getLogger(AliSmsUtil.class);
    @Autowired
    private AliEmailBean aliEmailBean;

    public boolean sendEmail(String email,String htmlBody) throws ClientException {
        logger.info(aliEmailBean.getFromAlias());
        logger.info(aliEmailBean.getSubject());
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliEmailBean.getAccessKeyId(), aliEmailBean.getAccessKeySecret());
        //使用https加密连接
        //profile.getHttpClientConfig().setProtocolType(com.aliyuncs.http.ProtocolType.HTTPS);
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();

            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            //控制台创建的发信地址
            request.setAccountName(aliEmailBean.getAccountName());
            //发信人昵称
            request.setFromAlias(aliEmailBean.getFromAlias());
            request.setAddressType(1);
            //控制台创建的标签
            request.setTagName(aliEmailBean.getTagName());
            request.setReplyToAddress(true);
            //目标地址
            request.setToAddress(email);
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2");
            request.setSubject(aliEmailBean.getSubject());
            request.setHtmlBody(htmlBody);
//        try {
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            return true;

    }

}
