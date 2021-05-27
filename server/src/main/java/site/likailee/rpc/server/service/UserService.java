/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.server.service;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author likailee.llk
 * @version UserService.java 2021/05/27 Thu 3:30 PM likai
 */
public class UserService {

    String getUserById(Long id) {
        Map<String, Object> user = new HashMap<>(4);
        user.put("id", id);
        user.put("name", "likailee");
        user.put("email", "likailee.cn@gmail.com");
        return JSON.toJSONString(user);
    }
}
