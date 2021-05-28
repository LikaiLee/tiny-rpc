/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.service;

import site.likailee.rpc.client.annotation.RemoteClass;

import static site.likailee.rpc.client.common.Constants.SERVER_SERVICE;

/**
 * @author likailee.llk
 * @version UserService.java 2021/05/27 Thu 3:29 PM likai
 */
@RemoteClass(SERVER_SERVICE + "UserService")
public interface UserService {
    /**
     * get user by id
     *
     * @param id id
     * @return user string
     */
    String getUserById(Long id);
}
