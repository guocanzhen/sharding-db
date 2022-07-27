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
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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

    @Autowired
    private IUserService iUserService;

    @ResponseBody
    @PostMapping("/add")
    public BaseResult add(@RequestBody List<User> list) {
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
