/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.likailee.rpc.client.service.UserService;

import javax.annotation.Resource;
import java.time.Instant;

/**
 * @author likailee.llk
 * @version MainController.java 2021/05/27 Thu 3:09 PM likai
 */
@RestController
public class MainController {

    @Resource
    private UserService userService;

    @GetMapping("client")
    public Object client() {
        String result = userService.getUserById(1L);
        return result;
    }
}
