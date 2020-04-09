package com.wayne.sms.service;

import com.github.pagehelper.PageInfo;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.SaMajor;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-04-01 16:37
 * @Description: ${Description}
 */
public interface SaMajorService {


    PageInfo<SaMajor> list(Tablepar tablepar, String searchText, String grade, String courseName, String cid,String mid, String order);

    SaMajor selectByPrimaryKey(String id);

    void clearTable();

    int updateSaMajor(List<SaMajor> saMajors);

    int refreshStdMajor();

    List<SaMajor> findByMajorId(String courseName, String cid, String mid, String grade);

    List<SaMajor> selectByCourseAndGradeAndCid(String grade, String courseName, String cid);

    SaMajor selectByCourseAndGradeAndMajorName(String grade, String courseName, String majorName);

}
