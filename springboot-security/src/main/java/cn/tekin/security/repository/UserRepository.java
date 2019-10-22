package cn.tekin.security.repository;

import cn.tekin.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-22 20:20
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
