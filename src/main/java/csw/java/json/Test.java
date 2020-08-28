package csw.java.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 作用:
 *
 * @author chensw
 * @since 2020/7/16
 */
public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        Demo demo = new Demo("sojson",4,"https://www.sojson.com");
        ObjectMapper mapper = new ObjectMapper();
        //普通输出
        System.out.println(mapper.writeValueAsString(demo));
        //格式化/美化/优雅的输出
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(demo));
    }
}
