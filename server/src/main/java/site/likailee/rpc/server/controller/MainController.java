/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.server.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.likailee.rpc.server.common.BeanFactory;
import site.likailee.rpc.server.common.RpcRequest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author likailee.llk
 * @version MainController.java 2021/05/28 Fri 12:48 PM likai
 */
@RestController
public class MainController {

    @RequestMapping("/")
    public Object main(RpcRequest request) {
        try {
            // service class
            Class<?> clazz = Class.forName(request.getClazz());
            // 获取参数的 class
            List<String> classNameList = JSON.parseArray(request.getArgTypes(), String.class);
            List<Class<?>> argClassList = new ArrayList<>();
            for (String className : classNameList) {
                argClassList.add(Class.forName(className));
            }
            // 将参数值转为方法需要的类型
            List<String> argValueStrList = JSON.parseArray(request.getArgValues(), String.class);
            List<Object> argValueList = new ArrayList<>();
            for (int i = 0; i < argClassList.size(); i++) {
                argValueList.add(JSON.parseObject(argValueStrList.get(i), argClassList.get(i)));
            }
            // 获取需要调用的方法
            System.out.println(argClassList);
            Method method = clazz.getMethod(request.getMethodName(), argClassList.toArray(new Class<?>[0]));
            Object[] args = argValueList.toArray(new Object[0]);
            // 获取 bean
            Object bean = BeanFactory.getBeanByClass(clazz);
            return method.invoke(bean, args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return String.format("class %s not found.", request.getClazz());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return String.format("method %s not found.", request.getMethodName());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return String.format("failed to invoke method %s with args %s.", request.getMethodName(), request.getArgValues());
        }
    }
}

