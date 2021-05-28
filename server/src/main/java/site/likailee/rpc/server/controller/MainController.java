/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.likailee.rpc.server.common.RpcRequest;

/**
 * @author likailee.llk
 * @version MainController.java 2021/05/28 Fri 12:48 PM likai
 */
@RestController
public class MainController {

    @RequestMapping("/")
    public String main(RpcRequest request) {
        return request.toString();
    }
}

