package util.ali;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component
public class AliOssUtil {

    @Autowired
    AliOssBean aliOssBean;
    public String upLoad(MultipartFile file) throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = aliOssBean.getAccessKeyId();
        String accessKeySecret = aliOssBean.getAccessKeySecret();

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        //重新命名文件
        //方法1
//        String[] fileNames=file.getOriginalFilename().split("\\.");
//        String fileName=fileNames[0]+"_"+System.currentTimeMillis()+"."+fileNames[1];

        //方法2
        String prefix=file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf("."))+"_"+System.currentTimeMillis();
        String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName=prefix+suffix;

        // 上传字符串。
        byte[] bytes= file.getBytes();
        ossClient.putObject(aliOssBean.getBucketName(), fileName, new ByteArrayInputStream(bytes));

        // 上传文件流。
//        InputStream inputStream = new File(file);
//        ossClient.putObject("banengr", fileName, inputStream);

        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
//        ossClient.putObject("banengr", "234", new File("/Users/chen/Desktop/234.png"));


        // 关闭OSSClient。
        ossClient.shutdown();


        //返回文件路径
        String picPath="https://banengr.oss-cn-hangzhou.aliyuncs.com/"+fileName;
        return picPath;

    }


}