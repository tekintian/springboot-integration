package cn.tekin.cache.service;


import cn.tekin.cache.bean.Department;
import cn.tekin.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-20 21:51
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDept(Integer id) {
        System.out.println("部门" + id + "查询");
        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }
}
