package test;

import api.baidu.detect.Detect;
import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.URLDecoder;

public class Test {
    public static void main(String[] args) {
        try {
            String url = Test.class.getClassLoader().getResource("").getFile();
            url = URLDecoder.decode(url, "utf-8");

            System.out.println(url);

//            String img = FileUtil.readFileAsString(url+ "img/13_4k.jpg");

//            System.out.println(img);


            byte[] data = null;
            // 读取图片字节数组
            try {
                InputStream in = new FileInputStream(url+ "img/zhangsan.jpg");
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            String base64 = encoder.encode(data);// 返回Base64编码过的字节数组字符串


            String result = Detect.faceDetect(base64);
            System.out.println(result);

            JSONObject json = JSONObject.parseObject(result);
            JSONObject list = json.getJSONObject("result").getJSONArray("face_list").getJSONObject(0);


            System.out.println(list.get("age"));
            System.out.println(list.get("beauty"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
