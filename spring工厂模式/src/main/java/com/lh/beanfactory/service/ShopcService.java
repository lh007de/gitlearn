package com.lh.beanfactory.service;

import com.lh.beanfactory.factory.ServiceBeanFactory;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ShopcService
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/19 14:21
 * @Version: 1.0
 **/
@Service
public class ShopcService implements IBaseService, InitializingBean {
    @Override
    public Double computePrice(String type, String num) {
        System.out.println("计算服务启动中,计算c平台价格");
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ServiceBeanFactory.register("shopcService", this);
    }
}
