package com.lh.aop.controller;

import com.lh.aop.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/22 12:14
 * @Version: 1.0
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "测试 ", notes = "测试接口")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "获取成功" ),
            @ApiResponse(code = 400, message = "参数错误")})
    @RequestMapping(value = "/add",
            method = RequestMethod.GET)
    public ResponseEntity<Void> manualStart() {
        userService.add(3, 1);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
