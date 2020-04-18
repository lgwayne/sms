package com.wayne.sms.service;

import com.github.pagehelper.PageInfo;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.SaStudent;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-04-02 00:25
 * @Description: ${Description}
 */
public interface SaStudentService {
    PageInfo<SaStudent> list(Tablepar tablepar, String searchText, String grade, String courseName, String mid, String clid, String order);

    SaStudent selectByPrimaryKey(String id);

    void clearTable();

    int updateSaStudent(List<SaStudent> saStudents);

    int updateStdStudent();

    SaStudent selectByStuId(long i);

    PageInfo<SaStudent> listByTeacher(Tablepar tablepar, String searchText, String tid, String grade, String courseName, String clid, String order);

}
