package org.lh.exception.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @ClassName: MyErrorAttributeError
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 16:15
 * @Version: 1.0
 **/
@Component
public class MyErrorAttributeError  extends DefaultErrorAttributes {

    // 重写了获取异常方法
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("myerror", "自定义异常");
        return errorAttributes;
    }
}
