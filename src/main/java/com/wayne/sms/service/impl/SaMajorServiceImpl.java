package com.wayne.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.CollegeMapper;
import com.wayne.sms.dao.MajorMapper;
import com.wayne.sms.dao.SaMajorMapper;
import com.wayne.sms.dao.StdMajorMapper;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.*;
import com.wayne.sms.service.SaMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.certpath.CertId;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-04-01 16:38
 * @Description: ${Description}
 */
@Service
public class SaMajorServiceImpl implements SaMajorService {
    @Autowired
    private SaMajorMapper saMajorMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private StdMajorMapper stdMajorMapper;

    @Override
    public PageInfo<SaMajor> list(Tablepar tablepar, String name, String grade, String courseName,String cid, String mid, String order) {
        SaMajorExample testExample=new SaMajorExample();
        if (order==null||"ID".equals(order)){
            testExample.setOrderByClause("id ASC");
        }else if ("total ASC".equals(order)){
            testExample.setOrderByClause("avg_total_score ASC");
        }else if("total DESC".equals(order)){
            testExample.setOrderByClause("avg_total_score DESC");
        }else if ("std ASC".equals(order)){
            testExample.setOrderByClause("std_score ASC");
        }else if ("std DESC".equals(order)){
            testExample.setOrderByClause("std_score DESC");
        }

        if(name!=null&&!"".equals(name)){
            testExample.createCriteria().andMajorLike("%"+name+"%");
        }

        if (grade!=null && courseName!=null && mid!=null && cid!= null){
            if (!"0".equals(mid)){
                Major major = majorMapper.selectByMajorId(Integer.parseInt(mid));
                testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andMajorEqualTo(major.getMajorName());
            }else {
                College college = collegeMapper.selectByCollegeId(Integer.parseInt(cid));
                testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andCollegeEqualTo(college.getCollegeName());
            }
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<SaMajor> list= saMajorMapper.selectByExample(testExample);

        PageInfo<SaMajor> pageInfo = new PageInfo<SaMajor>(list);
        return  pageInfo;
    }

    @Override
    public SaMajor selectByPrimaryKey(String id) {
        Integer id1 = Integer.valueOf(id);
        return saMajorMapper.selectByPrimaryKey(id1);
    }

    @Override
    public void clearTable() {
        saMajorMapper.truncateSaMajor();
    }

    @Override
    public int updateSaMajor(List<SaMajor> saMajors) {
        return saMajorMapper.insertIntoSaMajor(saMajors);
    }

    @Override
    public int refreshStdMajor() {
        //service层
        //1.对专业总评标准分表 清空
        stdMajorMapper.clearTable();
        //2.在专业成绩分析表中查询出 List<StdMajor>
        List<StdMajor> stdMajors = saMajorMapper.selectAsStdMajor();
        //3.将 List<StdMajor>保存到原有的专业总评标准分表中
        int i = stdMajorMapper.insertIntoStdMajor(stdMajors);
        //4.将 StdMajor表中的标准分更新到SaMajor中
        int i1 = saMajorMapper.updateStdScore();
        return i1;
    }

    @Override
    public List<SaMajor> findByMajorId(String courseName, String cid, String mid, String grade) {
        SaMajorExample testExample = new SaMajorExample();
//        SaMajor saMajor = saMajorMapper.selectByPrimaryKey(Integer.parseInt(mid));
        Major major = majorMapper.selectByMajorId(Integer.parseInt(mid));

        testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andMajorEqualTo(major.getMajorName());
        return saMajorMapper.selectByExample(testExample);
    }

    @Override
    public List<SaMajor> selectByCourseAndGradeAndCid(String grade, String courseName, String cid) {
        SaMajorExample saMajorExample = new SaMajorExample();
        College college = collegeMapper.selectByCollegeId(Integer.parseInt(cid));
        saMajorExample.createCriteria().andCollegeEqualTo(college.getCollegeName()).andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade));
        return saMajorMapper.selectByExample(saMajorExample);
    }

    @Override
    public SaMajor selectByCourseAndGradeAndMajorName(String grade, String courseName, String majorName) {
        SaMajorExample saMajorExample = new SaMajorExample();
        saMajorExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andMajorEqualTo(majorName);
        List<SaMajor> saMajors = saMajorMapper.selectByExample(saMajorExample);
        return saMajors.get(0);
    }
}
