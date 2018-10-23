package csw.java.other;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by chendong on 2016/12/30.
 * <p>
 * 模拟发送multipart/form-data
 */
public class HttpClientTest {

	public static void main(String[] args) throws IOException {

		final String token = "vjArtGa39toaRTvMPAOCvS/EkCyfbQfr22TIOZ1axbsHSbY50nSIiVjutVOxiSvZOX4a8kt9ANQ42rwuvj2jrLGOfjV/5P9Xo53Y3HQPfvE=";
		final String filePath = "E:/test.png";
//		final String url = "http://10.1.4.223:7480/web/frontApi/v1/heatMap/save";
		final String url = "http://localhost:7600/v1/heatMap/save";

		// 请求路径
		HttpPost post = new HttpPost(url);
		// 添加header头信息
		post.setHeader("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		post.setHeader("Host", "web.uyuntest.cn");
		post.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		post.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		post.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		post.setHeader("charset", "utf-8");
		post.setHeader("X-Requested-With", "XMLHttpRequest");
		post.setHeader("Referer", "https://web.uyuntest.cn/");
		post.setHeader("Cookie",
				"token=" + token + ";" + "userId=e0a67e986a594a61b3d1e523a0a39c77;tenantId=e0a67e986a594a61b3d1e523a0a39c77");

		@SuppressWarnings("deprecation")
    FormBodyPart part = FormBodyPartBuilder.create("pic", new FileBody(new File(filePath), "image/png", "utf-8"))
				.build();
		HttpEntity entity = MultipartEntityBuilder.create().addPart(part)
				.addTextBody("appId", "TJVnwGhfrgPJp7rzsapPlVB8MRaVkjgU").addTextBody("name", "test")
				.addTextBody("url", "http://*/kb/dashboard.action")
				.addTextBody("page", "http://www.uyunsoft.cn/kb/dashboard.action").build();
		post.setEntity(entity);
		HttpEntity entities = HttpClients.createDefault().execute(post).getEntity();

		if (entities != null) {
			System.out.println(EntityUtils.toString(entities));
		}
		// httpclient.getConnectionManager().shutdown();
	}
}
