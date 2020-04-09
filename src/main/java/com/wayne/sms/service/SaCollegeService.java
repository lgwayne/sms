package com.wayne.sms.service;

import com.github.pagehelper.PageInfo;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.SaCollege;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-04-01 14:05
 * @Description: ${Description}
 */
public interface SaCollegeService {

    PageInfo<SaCollege> list(Tablepar tablepar, String searchText,String grade,String courseName,String cid,String order);

    int insertSelective(SaCollege saCollege);

//    int deleteByPrimaryKey(String ids);

    int checkNameUnique(SaCollege saCollege);

    SaCollege selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SaCollege record);

    void clearTable();

    int updateSaCollege(List<SaCollege> saColleges);

    List<SaCollege> findByCollegeId(String courseName, String cid, String grade);

    List<SaCollege> selectAll();

    List<SaCollege> selectSaCollegeByCourseAndGrade(String courseName, String grade);

    SaCollege selectByCourseAndGradeAndCollegeName(String grade, String courseName, String collegeName);


}
