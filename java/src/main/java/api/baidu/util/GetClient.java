package api.baidu.util;

import test.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class GetClient {
    public static Properties getProperties(){
        Properties properties = null;
        try {
            String url = Test.class.getClassLoader().getResource("key.properties").getFile();
            url = URLDecoder.decode(url, "utf-8");

            properties = new Properties();
            // 使用InPutStream流读取properties文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
            properties.load(bufferedReader);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }

}
