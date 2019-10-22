package cn.tekin.security.repository;

import cn.tekin.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-22 20:18
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRolename(String name);
}
