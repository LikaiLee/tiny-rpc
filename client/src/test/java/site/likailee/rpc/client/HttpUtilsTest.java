/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import site.likailee.rpc.client.common.Result;
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
                "[\"java.lang.Long\"]",
                "[100]");
        Result result = HttpUtils.callRemoteService(request);
        Assertions.assertEquals("Result{success=true, message='success', resultType='java.lang.String', result='\"{\\\"name\\\":\\\"likailee\\\",\\\"email\\\":\\\"likailee.cn@gmail.com\\\",\\\"id\\\":100}\"'}", result.toString());
    }
}
