package com.lh.beanfactory;

import com.lh.beanfactory.factory.ServiceBeanFactory;
import com.lh.beanfactory.service.IBaseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeanfactoryApplication.class)

class BeanfactoryApplicationTests {
//    @Autowired
//    ServiceBeanFactory serviceBeanFactory;

    @Test
    void contextLoads() {
        IBaseService shopaService = ServiceBeanFactory.getServiceByType("shopcService");
        shopaService.computePrice("111", "222");
    }

    @Test
    void beanPropertyCopy(){
        User lh = User.builder().age("18").build();
        UserInfo userInfo = new UserInfo();
/*        userInfo.setName(lh.getName());
        userInfo.setAge(lh.getAge());*/
        BeanUtils.copyProperties(lh, userInfo);
        System.out.println(userInfo);
    }

    @Test
    void beanChainTest(){
        // 使用lombok 链式调用
//        ChainStyleEntity chainStyleEntity = new ChainStyleEntity().setLevel("123").setName("test");
//        System.out.println(chainStyleEntity);

        ChainStyleEntity chainStyleEntity = ChainStyleEntity.of("TEST").setLevel("high");
        System.out.println(chainStyleEntity);
    }

}
