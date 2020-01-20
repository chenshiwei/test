package csw.java.other;

import com.alibaba.fastjson.JSON;

public class Test2 {
    public static void main(String[] args) {
        String s = "{\"CODE\":5}";
        System.out.println(JSON.parseObject(s));
        System.out.println(JSON.parseObject(JSON.toJSONString(s)));
    }


}
