/**
 * https://likailee.site
 * CopyRight (c) 2021
 */
package site.likailee.rpc.client.rpc;

import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import site.likailee.rpc.client.annotation.RemoteClass;

import java.util.Set;

import static site.likailee.rpc.client.common.Constants.RPC_INFO.CLIENT_SERVICE;

/**
 * @author likailee.llk
 * @version ServiceBeanDefinitionRegistry.java 2021/05/27 Thu 3:59 PM likai
 */
@Component
public class ServiceBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        Reflections reflections = new Reflections(CLIENT_SERVICE);
        // 获取带有注解 @RemoteClass 的接口
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(RemoteClass.class);
        classSet.stream().filter(Class::isInterface).forEach(c -> registerBean(beanDefinitionRegistry, c));
    }

    private void registerBean(BeanDefinitionRegistry registry, Class<?> clazz) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        // 构造函数参数为 clazz
        definition.getConstructorArgumentValues().addGenericArgumentValue(clazz);
        // 根据 class 类生成代理对象
        definition.setBeanClass(ServiceFactory.class);
        definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        // 注入 Bean 容器
        registry.registerBeanDefinition(clazz.getSimpleName(), definition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
