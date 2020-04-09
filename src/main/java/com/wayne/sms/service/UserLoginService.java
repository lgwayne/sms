package com.wayne.sms.service;

import com.github.pagehelper.PageInfo;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.Userlogin;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-03-16 14:29
 * @Description: ${Description}
 */
public interface UserLoginService {

    Userlogin findByUserId(Long user_id);

    PageInfo<Userlogin> list(Tablepar tablepar, String name);

    public int insertSelective(Userlogin userlogin);

    int checkNameUnique(Userlogin userlogin);

    Userlogin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Userlogin record);

    int deleteByPrimaryKey(String ids);

}
