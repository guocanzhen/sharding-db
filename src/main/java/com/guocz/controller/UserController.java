package com.guocz.controller;


import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guocz.entity.User;
import com.guocz.param.UserParam;
import com.guocz.result.BaseResult;
import com.guocz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author springBoot-Learning
 * @since 2022-07-25
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static List<User> list = new ArrayList<>();

    static {
        list.add(new User(9L, "1", "3", "1", "1"));
        list.add(new User(10L, "2", "4", "2", "2"));
        list.add(new User(11L, "1", "5", "1", "1"));
        list.add(new User(12L, "1", "6", "1", "1"));
        list.add(new User(13L, "1", "7", "1", "1"));
        list.add(new User(14L, "1", "8", "1", "1"));
    }

    @Autowired
    private IUserService iUserService;

    @ResponseBody
    @GetMapping("/add")
    public BaseResult add() {
        iUserService.saveBatch(list);
        return BaseResult.success();
    }

    @ResponseBody
    @GetMapping("/list")
    public BaseResult list(@RequestBody UserParam userParam) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ObjectUtil.isNotEmpty(userParam.getId()), "id", userParam.getId());
        queryWrapper.eq(CharSequenceUtil.isNotBlank(userParam.getUserName()), "UserName", userParam.getUserName());
        return BaseResult.success(iUserService.list(queryWrapper));
    }

}
