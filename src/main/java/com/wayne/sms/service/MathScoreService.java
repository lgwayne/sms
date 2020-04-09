package com.wayne.sms.service;

import com.github.pagehelper.PageInfo;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.*;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-03-30 14:47
 * @Description: ${Description}
 */
public interface MathScoreService {


    PageInfo<MathScore> list(Tablepar tablepar, String searchText,String cid,String mid,String clid,String grade,String courseName,String scoreOder);

    int insertSelective(MathScore mathScore);

    int deleteByPrimaryKey(String ids);

    int checkNameUnique(MathScore mathScore);

    MathScore selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MathScore record);

    List<SaCollege> selectAsSaCollege();

    List<SaMajor> selectAsSaMajor();

    List<SaClazz> selectAsSaClazz();

    List<SaStudent> selectAsSaStudent();

}
