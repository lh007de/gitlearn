package org.lh.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyApplicationRunner1
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/17 15:20
 * @Version: 1.0
 **/
@Component
@Order(98)
public class MyApplicationRunner2 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
    }
}
