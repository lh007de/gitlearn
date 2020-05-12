package com.lh.jwt.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: UserToken
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 15:07
 * @Version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserToken implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户登录账户
     */
    private String userNo;

    /**
     * 用户中文名
     */
    private String userName;
}