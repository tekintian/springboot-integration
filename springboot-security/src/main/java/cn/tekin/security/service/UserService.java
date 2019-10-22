package cn.tekin.security.service;

import cn.tekin.security.entity.User;
import org.springframework.data.domain.Page;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-22 20:21
 */
public interface UserService {
    //保存用户
    void save(User user);
    //对用户数据进行分页
    Page<User> PageByUser(Integer page, Integer size);
}
