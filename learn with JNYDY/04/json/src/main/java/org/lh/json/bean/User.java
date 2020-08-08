package org.lh.json.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 10:14
 * @Version: 1.0
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String address;

    private LocalDateTime dateTime;
}
