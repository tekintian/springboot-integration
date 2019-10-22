package cn.tekin.security;

import cn.tekin.security.entity.Role;
import cn.tekin.security.entity.User;
import cn.tekin.security.repository.RoleRepository;
import cn.tekin.security.repository.UserRepository;
import cn.tekin.security.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSecurityApplicationTests {


    @Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;
	 @Test
    public void contextLoads() {
    }
	@Test
	public void test1() {
		String pass = MD5Util.encode("a");
		User user = new User("a",pass);
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findByRolename("ROLE_ADMIN"));
		user.setRoles(roles);
		repository.save(user);
	}

}
