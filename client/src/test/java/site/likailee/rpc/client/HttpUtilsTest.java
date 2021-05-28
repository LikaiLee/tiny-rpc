/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import site.likailee.rpc.client.common.RpcRequest;
import site.likailee.rpc.client.util.HttpUtils;

import static site.likailee.rpc.client.common.Constants.RPC_INFO.SERVER_SERVICE;

/**
 * @author likailee.llk
 * @version HttpUtilsTest.java 2021/05/28 Fri 12:42 PM likai
 */
public class HttpUtilsTest {

    @Test
    public void should_send_post_request() {
        RpcRequest request = new RpcRequest(SERVER_SERVICE + "UserService",
                "getUserById",
                "[java.lang.Long]",
                "[1]");
        String result = HttpUtils.callRemoteService(request);
        Assertions.assertEquals("RpcRequest{clazz='site.likailee.rpc.server.service.UserService', methodName='getUserById', argTypes='[java.lang.Long]', argValues='[1]'}", result);
    }
}
