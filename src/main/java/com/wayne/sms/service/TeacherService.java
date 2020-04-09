package com.wayne.sms.service;

import com.github.pagehelper.PageInfo;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.Teacher;
import com.wayne.sms.pojo.Userlogin;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-03-28 23:50
 * @Description: ${Description}
 */
public interface TeacherService {

    Teacher findByTeacherId(Long user_id);

    PageInfo<Teacher> list(Tablepar tablepar, String name);

    public int insertSelective(Teacher teacher);

    int checkNameUnique(Teacher teacher);

    Teacher selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Teacher record);

    int deleteByPrimaryKey(String ids);
}
