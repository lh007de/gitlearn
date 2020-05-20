package com.lh.beanfactory.factory;

import com.lh.beanfactory.service.IBaseService;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ClassName: ServiceBeanFactory
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/19 14:24
 * @Version: 1.0
 **/
public class ServiceBeanFactory {
    private static Map<String, IBaseService> services = new ConcurrentHashMap<>();

    public static IBaseService getServiceByType(String type){
        return services.get(type);
    }

    // 工厂类注册方法，把不同服务方法保存到ConcurrentHashMap数据结构中，使用时直接从工厂获取
    // 下一步的关键是如何从spring bean 初始化对象后调用该方法
    // spring 提供了一个初始化后的接口InitializingBean，我们可以利用该接口进行注册服务
    // 这个接口为Bean提供了属性初始化后的处理方法,它只包括afterPropertiesSet方法，凡是继承该接口的类，在bean的属性初始化后都会执行该方法。
    public static void register(String serviceName,IBaseService shopService){
        Assert.notNull(serviceName,"serviceName can't be null");
        services.put(serviceName,shopService);
    }
}
