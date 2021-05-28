/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import site.likailee.rpc.client.common.Constants;
import site.likailee.rpc.client.common.RpcRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author likailee.llk
 * @version HttpUtils.java 2021/05/28 Fri 12:31 PM likai
 */
public class HttpUtils {
    public static final int STATUS_OK = 200;

    public static String callRemoteService(RpcRequest request) {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair(Constants.REQUEST_PARAMS.CLAZZ, request.getClazz()));
        params.add(new BasicNameValuePair(Constants.REQUEST_PARAMS.METHOD_NAME, request.getMethodName()));
        params.add(new BasicNameValuePair(Constants.REQUEST_PARAMS.ARG_TYPES, request.getArgTypes()));
        params.add(new BasicNameValuePair(Constants.REQUEST_PARAMS.ARG_VALUES, request.getArgValues()));
        String result = sendPost(Constants.RPC_INFO.SERVER_BASE_URL, params);
        return result;
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
