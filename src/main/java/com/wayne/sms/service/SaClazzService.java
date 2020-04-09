package com.wayne.sms.service;

import com.github.pagehelper.PageInfo;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.SaClazz;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-04-01 23:13
 * @Description: ${Description}
 */
public interface SaClazzService {
    PageInfo<SaClazz> list(Tablepar tablepar, String searchText, String grade, String courseName, String mid, String clid, String order);

    SaClazz selectByPrimaryKey(String id);

    void clearTable();


    int updateSaClazz(List<SaClazz> saClazzes);

    int refreshStdClazz();

    List<SaClazz> findByClazzId(String courseName, String grade, String clid);


    List<SaClazz> selectByCourseAndGradeAndMid(String grade, String courseName, String mid);

    SaClazz selectByCourseAndGradeAndClazzName(String grade, String courseName, String clazzName);

}
