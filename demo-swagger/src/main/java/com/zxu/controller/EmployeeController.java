package com.zxu.controller;

import com.zxu.domain.SwUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;


@Api(tags = "用户管理")
@RestController
public class EmployeeController {


    @ApiOperation("创建用户")
    @PostMapping("/users")
    public SwUser create (@RequestBody SwUser user) {
        return user;
    }

    @ApiOperation("用户详情")
    @GetMapping("/users/{id}")
    public SwUser findById (@PathVariable Long id) {
        return new SwUser("bbb", 21, "上海", "aaa@bbb.com");
    }

    @ApiOperation("用户列表")
    @GetMapping("/users")
    public List<SwUser> list (@ApiParam("查看第几页") @RequestParam int pageIndex,
                              @ApiParam("每页多少条") @RequestParam int pageSize) {
        List<SwUser> result = new ArrayList<>();
        result.add(new SwUser("aaa", 50, "北京", "aaa@ccc.com"));
        result.add(new SwUser("bbb", 21, "广州", "aaa@ddd.com"));
        return result;
    }

    @ApiIgnore
    @DeleteMapping("/users/{id}")
    public String deleteById (@PathVariable Long id) {
        return "delete user : " + id;
    }


}
