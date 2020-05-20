package com.lh.beanfactory;

import org.springframework.beans.BeanUtils;

/**
 * @ClassName: UserInputDTOConvert
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/19 16:44
 * @Version: 1.0
 **/
public class UserInputDTOConvert implements DTOConvert<User,UserInfo> {
    @Override
    public UserInfo convert(User user) {
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(user,userInfo);
            return userInfo;
    }

}
