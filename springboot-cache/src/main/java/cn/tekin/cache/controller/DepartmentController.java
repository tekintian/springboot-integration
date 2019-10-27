package cn.tekin.cache.controller;

import cn.tekin.cache.service.DepartmentService;
import cn.tekin.cache.bean.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-20 21:54
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department deptInfo(@PathVariable("id") Integer id) {
        Department dept = departmentService.getDept(id);
        return dept;
    }
}
