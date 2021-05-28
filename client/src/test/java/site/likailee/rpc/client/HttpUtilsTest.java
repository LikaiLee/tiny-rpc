/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import site.likailee.rpc.client.common.Constants;
import site.likailee.rpc.client.util.HttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author likailee.llk
 * @version HttpUtilsTest.java 2021/05/28 Fri 12:42 PM likai
 */
public class HttpUtilsTest {

    @Test
    public void should_send_post_request() {
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        nameValuePairList.add(new BasicNameValuePair("methodName", "hello"));
        String result = HttpUtils.sendPost(Constants.SERVER_BASE_URL, nameValuePairList);
        Assertions.assertEquals(result, "rpc server main");
    }
}
