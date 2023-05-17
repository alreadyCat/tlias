package com.tlias;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UploadDemo {
  private static String secretId = "AKIDMXS7VcS1KL6ZlgKgmb9PO7Y7PRCgtpVu";
  private static String secretKey = "8zauwhCSRActtc4KJ1SbT4ORDhuqWv3u";
  private static String bucketName = "littlenine-1259672777";
  private static String regionStr = "ap-nanjing"; // 区域北京则  beijing

  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("C:\\Users\\cat\\Desktop\\Snipaste_2023-05-17_17-13-28.png");
    updateList(list);
  }

  public static List<String> updateList(List<String> list) {
    COSClient client = null;
    if (client != null) {
      client.shutdown();
    }
    COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
    Region region = new Region(regionStr);
    ClientConfig clientConfig = new ClientConfig(region);
    // 3 生成 cos 客户端。
    client = new COSClient(cred, clientConfig);

    List<String> fileUrlList = new ArrayList<>();
    try {
      for (String path : list) {
        // 指定要上传的文件
        File localFile = new File(path);
        // 指定要上传到的存储桶

        // 指定要上传到 COS 上对象键
        String key = localFile.getName();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        client.putObject(putObjectRequest);

        int index = path.lastIndexOf("\\");
        String originFileName = path.substring(index);
        String url = "https://" + bucketName + ".cos." + regionStr + ".myqcloud.com/" + originFileName;
        fileUrlList.add(url);

      }

    } catch (CosServiceException serverException) {
      serverException.printStackTrace();
    } catch (CosClientException clientException) {
      clientException.printStackTrace();
    }

    return fileUrlList;
  }

  @Test
  public void test(){
    String path = "D:\\e6cd27ff-0567-4092-b35d-51b37c039510.png";

    int index=  path.lastIndexOf("\\") + 1;
    String name = path.substring(index);
    System.out.println(name);
  }
}
