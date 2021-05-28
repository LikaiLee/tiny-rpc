/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.rpc;

import com.alibaba.fastjson.JSON;
import site.likailee.rpc.client.annotation.RemoteClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author likailee.llk
 * @version ServiceProxy.java 2021/05/27 Thu 4:59 PM likai
 */
public class ServiceProxy<T> implements InvocationHandler {

    /**
     * 根据方法上的注解调用远程方法
     *
     * @param proxy  代理对象
     * @param method 被调用的方法
     * @param args   方法参数
     * @return 远程方法的返回结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RemoteClass remoteClass = method.getDeclaringClass().getAnnotation(RemoteClass.class);
        List<String> argTypeList = new ArrayList<>();
        if (Objects.nonNull(args)) {
            for (Object arg : args) {
                argTypeList.add(arg.getClass().getName());
            }
        }
        String argTypes = JSON.toJSONString(argTypeList);
        String argValues = JSON.toJSONString(args);
        System.out.println(argTypes);
        System.out.println(argValues);
        return null;
    }
}
