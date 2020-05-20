package com.lh.beanfactory;

public interface DTOConvert<S,T> {
    T convert(S s);
}
