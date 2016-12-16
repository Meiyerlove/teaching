package james;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.util.EntityUtils;


public class TxdataHttpKit {

	public static void main(String[] args) throws Exception {
		queryCustomer();
	}

	private static void queryCustomer() throws Exception {

		String posturl = "http://test.wesufe.cn/weixin/notify?title=11&content=11";
		DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());
		HttpPost post = new HttpPost(posturl);
		HttpResponse response = client.execute(post);
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
	}
}
