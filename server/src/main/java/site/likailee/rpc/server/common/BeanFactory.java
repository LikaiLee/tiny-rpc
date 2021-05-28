/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.server.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author likailee.llk
 * @version BeanFactory.java 2021/05/28 Fri 2:18 PM likai
 */
public class BeanFactory {
    /**
     * 存放所有 Bean 实例
     */
    public static final Map<Class<?>, Object> BEANS = new ConcurrentHashMap<>(128);

    public static Object getBeanByClass(Class<?> clazz) {
        BEANS.computeIfAbsent(clazz, cls -> {
            try {
                return cls.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        });
        return BEANS.get(clazz);
    }
}
