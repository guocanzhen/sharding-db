package com.guocz;

import com.guocz.entity.User;
import com.guocz.result.BaseResult;
import com.guocz.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guocz
 * @date 2022/7/27 9:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void add() {
        List<User> list = new ArrayList<>();
        list.add(new User(15L, "1", "3", "1", "1"));
        list.add(new User(16L, "2", "4", "2", "2"));
        list.add(new User(17L, "1", "5", "1", "1"));
        list.add(new User(18L, "1", "6", "1", "1"));
        list.add(new User(19L, "1", "7", "1", "1"));
        list.add(new User(20L, "1", "8", "1", "1"));

        boolean b = iUserService.saveBatch(list);

    }

    @Test
    public void list() {
        List<User> list = iUserService.list();
        System.out.println(list);
    }
}
