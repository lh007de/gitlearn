package org.lh.fileupload.bean;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GlobalData
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 15:08
 * @Version: 1.0
 **/
@ControllerAdvice
public class GlobalData {
    /*
    @ControllerAdvice 应用场景2：预设全局数据
    在所有的controller中都能访问设计的全局数据
    * */

    @ModelAttribute(value = "info")
    public Map<String,Object> myData(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "global name");
        map.put("address", "global address");
        return map;
    }

        /*
    @ControllerAdvice 应用场景3:请求参数预处理
    * */

    @InitBinder("a")
    public void initA(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");
    }

    @InitBinder("b")
    public void initB(WebDataBinder binder){
        binder.setFieldDefaultPrefix("b.");
    }


}
