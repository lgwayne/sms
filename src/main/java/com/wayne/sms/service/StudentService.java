package com.wayne.sms.service;

import com.github.pagehelper.PageInfo;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.Student;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-03-26 15:04
 * @Description: ${Description}
 */

public interface StudentService {

    public  PageInfo<Student> list(Tablepar tablepar, String searchText);

    public PageInfo<Student> search(Tablepar tablepar,String cid,String mid,String clid,String grade);

    int insertSelective(Student student);

    int checkNameUnique(Student student);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int deleteByPrimaryKey(String ids);

}
