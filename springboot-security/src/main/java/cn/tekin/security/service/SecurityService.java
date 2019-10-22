package cn.tekin.security.service;

import cn.tekin.security.entity.User;
import cn.tekin.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 为认证用户服务 加载用户特定数据类
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-22 20:27
 */
public class SecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("");
        }

        return user;
    }
}
