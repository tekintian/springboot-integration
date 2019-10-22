package cn.tekin.security.service;

import cn.tekin.security.entity.User;
import cn.tekin.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-22 20:24
 */
@Service
public class UserServiceImpl implements UserService {
     @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Page<User> PageByUser(Integer page, Integer size) {


    // springboot 1.5.x版本方法
        Pageable pageable = new PageRequest(page,size, Sort.Direction.ASC, "id");


        //新版本 Spring Boot 2.x JPA分页 PageRequest.of代替过时的PageRequest方法
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        Pageable pageable = PageRequest.of(0, 10, sort);
        return userRepository.findAll(pageable);
    }
}
