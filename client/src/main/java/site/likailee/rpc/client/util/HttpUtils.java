/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author likailee.llk
 * @version HttpUtils.java 2021/05/28 Fri 12:31 PM likai
 */
public class HttpUtils {
    public static final int STATUS_OK = 200;

    public static String callRemoteService(String clazz, String methodName, String argTypes, String argValues) {
        return "";
    }

    public static String sendPost(String url, List<NameValuePair> nameValuePairList) {
        CloseableHttpResponse response = null;
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(url);
            StringEntity entity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
            post.setEntity(entity);
            response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == STATUS_OK) {
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(response)) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
