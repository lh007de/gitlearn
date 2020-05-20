package com.lh.beanfactory;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/19 16:26
 * @Version: 1.0
 **/
@Data
@Builder
public class User {
    @NonNull
    private String name;
    @NonNull
    private String age;
}
