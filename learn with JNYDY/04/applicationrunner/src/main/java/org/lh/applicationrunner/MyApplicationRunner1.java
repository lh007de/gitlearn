package org.lh.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: MyApplicationRunner1
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/17 15:20
 * @Version: 1.0
 **/
@Component
@Order(99)
public class MyApplicationRunner1 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 获取启动时所有参数
        String[] sourceArgs = args.getSourceArgs();
        System.out.println("sourceArgs" + sourceArgs);
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("nonOptionArgs"+nonOptionArgs);


    }
}
