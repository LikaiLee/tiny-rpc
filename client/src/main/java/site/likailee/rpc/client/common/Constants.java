/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.common;

/**
 * @author likailee.llk
 * @version Constants.java 2021/05/27 Thu 3:54 PM likai
 */
public class Constants {

    public static class RPC_INFO {
        /**
         * rpc service 所在的包名
         */
        public static final String SERVER_SERVICE = "site.likailee.rpc.server.service.";

        /**
         * 本地 service 所在的包名
         */
        public static final String CLIENT_SERVICE = "site.likailee.rpc.client.service.";

        /**
         * rpc 地址
         */
        public static final String SERVER_BASE_URL = "http://127.0.0.1:8090/";
    }


    /**
     * 标识接口信息
     */
    public static class REQUEST_PARAMS {
        public static final String CLAZZ = "clazz";
        public static final String METHOD_NAME = "methodName";
        public static final String ARG_TYPES = "argTypes";
        public static final String ARG_VALUES = "argValues";
    }

}
