package com.lh.jwt.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenUtilTest {

    @Test
    void createToken() {
        String lhtest = JwtTokenUtil.createToken("lhtest");
        System.out.println(lhtest);
    }

    @Test
    void verifyToken() {
    }
}