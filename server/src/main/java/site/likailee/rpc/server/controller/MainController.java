/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author likailee.llk
 * @version MainController.java 2021/05/28 Fri 12:48 PM likai
 */
@RestController
public class MainController {

    @RequestMapping("/")
    public String main() {
        return "rpc server main";
    }
}

