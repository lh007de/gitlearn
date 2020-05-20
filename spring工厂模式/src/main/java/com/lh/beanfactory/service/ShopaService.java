package com.lh.beanfactory.service;

import com.lh.beanfactory.factory.ServiceBeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ShopaService
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/19 14:01
 * @Version: 1.0
 **/
@Service
public class ShopaService implements IBaseService, InitializingBean {
    @Override
    public Double computePrice(String type, String num) {
        System.out.println("计算服务启动中,计算a平台价格");
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ServiceBeanFactory.register("shopaService", this);
    }
}
