package com.lh.beanfactory;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @ClassName: ChainStyleEntity
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/20 8:48
 * @Version: 1.0
 **/
@Getter
@Setter
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
public class ChainStyleEntity {
    @NonNull
    private String name;
    private String level;

    @Override
    public String toString() {
        return "name: " + this.name + "age: "+ this.level;
    }
}
