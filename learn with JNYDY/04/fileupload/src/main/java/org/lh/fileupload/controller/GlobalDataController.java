package org.lh.fileupload.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * @ClassName: GlobalDataController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 15:17
 * @Version: 1.0
 **/
@RestController
public class GlobalDataController {

    @GetMapping("/getdata")
    public String getGlobalData(Model model){
        Map<String, Object> stringObjectMap = model.asMap();
        Set<String> keys = stringObjectMap.keySet();
        for (String key : keys) {
            System.out.println(key + ":" +stringObjectMap.get(key));
        }
        return "hello";
    }
}
