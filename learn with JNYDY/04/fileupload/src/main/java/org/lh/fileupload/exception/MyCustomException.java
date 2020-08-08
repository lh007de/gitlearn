package org.lh.fileupload.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * @ClassName: MyCustomException
 * @Description: 自定义捕获异常处理
 * @author: LH
 * @Date: 2020/7/14 14:55
 * @Version: 1.0
 **/
@ControllerAdvice
public class MyCustomException {
/*
*   @ControllerAdvice 应用场景1：自定义捕获异常处理
* */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void myException(MaxUploadSizeExceededException e){

    }
}
