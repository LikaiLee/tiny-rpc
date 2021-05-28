/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.rpc;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author likailee.llk
 * @version ServiceFactory.java 2021/05/27 Thu 4:39 PM likai
 */
public class ServiceFactory<T> implements FactoryBean<T> {

    private Class<T> interfaceType;

    public ServiceFactory(Class<T> interfaceType) {
        this.interfaceType = interfaceType;
    }

    @Override
    public T getObject() throws Exception {
        // 方法代理
        InvocationHandler handler = new ServiceProxy<>();
        // 生成代理对象
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class[]{interfaceType}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceType;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
