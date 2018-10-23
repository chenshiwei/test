package csw.java.http;

import java.util.HashMap;
import java.util.Map;

/**
 * 作用:
 *
 * @author chensw
 * @since 2018/9/7
 */
public class MainTest {
    public static void main(String[] args) {
        String getUrl = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";
        String postUrl = "http://gc.ditu.aliyun.com/geocoding";
        String param = "format=json&ip=218.4.255.255";
        String param1 = "a=苏州市";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("format", "json");
        map.put("ip", "218.4.255.255");
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("a", "苏州市");
        System.out.println("Get请求1:" + MyHttpRequest.sendGet(getUrl, param, "utf-8"));
        System.out.println("Get请求2:" + MyHttpRequest.sendGet(getUrl, map, "utf-8"));
        System.out.println("Post请求1:" + MyHttpRequest.sendPost(postUrl, param1, "utf-8"));
        System.out.println("Post请求2:" + MyHttpRequest.sendPost(postUrl, map, "utf-8"));
    }
}
