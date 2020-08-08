package org.lh.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName: MyCommandLineRunner
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/17 15:10
 * @Version: 1.0
 **/
@Component
@Order(98)
public class MyCommandLineRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner1" + Arrays.toString(args));
    }
}
