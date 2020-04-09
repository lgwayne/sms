package com.wayne.sms.service.impl;

import com.wayne.sms.dao.RoleMapper;
import com.wayne.sms.pojo.Role;
import com.wayne.sms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-03-16 14:36
 * @Description: ${Description}
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findbyId(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
