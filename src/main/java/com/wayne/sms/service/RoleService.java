package com.wayne.sms.service;

import com.wayne.sms.pojo.Role;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-03-16 14:35
 * @Description: ${Description}
 */
public interface RoleService {

        Role findbyId(Integer id);
}
