package cn.tekin.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色实体类
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-22 20:13
 */

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private long id;

    private String rolename;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}

