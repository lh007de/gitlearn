package com.lh.redis.dto;

import lombok.Data;

/**
 * @ClassName: SetReqDto
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/29 14:04
 * @Version: 1.0
 **/
@Data
public class SetReqDto {
    private String key;
    private Object value;
    private Long expireTime;
}
