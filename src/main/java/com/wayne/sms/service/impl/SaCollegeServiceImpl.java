package com.wayne.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.CollegeMapper;
import com.wayne.sms.dao.SaCollegeMapper;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.College;
import com.wayne.sms.pojo.SaCollege;
import com.wayne.sms.pojo.SaCollegeExample;
import com.wayne.sms.service.SaCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-04-01 14:05
 * @Description: ${Description}
 */

@Service
public class SaCollegeServiceImpl implements SaCollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private  SaCollegeMapper saCollegeMapper;

    @Override
    public PageInfo<SaCollege> list(Tablepar tablepar,String name,String grade,String courseName,String cid,String order){
        SaCollegeExample testExample=new SaCollegeExample();
        if (order==null||"ID".equals(order)){
            testExample.setOrderByClause("id ASC");
        }else if ("ASC".equals(order)){
            testExample.setOrderByClause("avg_total_score ASC");
        }else if("DESC".equals(order)){
            testExample.setOrderByClause("avg_total_score DESC");
        }
        if(name!=null&&!"".equals(name)){
            testExample.createCriteria().andCollegeLike("%"+name+"%");
        }

        if (grade!=null && courseName!=null && cid!=null ){
            if (!"0".equals(cid)){
                College college = collegeMapper.selectByCollegeId(Integer.parseInt(cid));
                testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andCollegeEqualTo(college.getCollegeName());
            }else {
                testExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName);
            }
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<SaCollege> list= saCollegeMapper.selectByExample(testExample);
        PageInfo<SaCollege> pageInfo = new PageInfo<SaCollege>(list);
        return  pageInfo;
    }

    @Override
    public int insertSelective(SaCollege record) {
        record.setId(null);
        return saCollegeMapper.insertSelective(record);
    }

//    @Override
//    public int deleteByPrimaryKey(String ids) {
//        Integer[] integers = Convert.toIntArray(",", ids);
//        List<Integer> stringB = Arrays.asList(integers);
//        SaCollegeExample example=new SaCollegeExample();
//        example.createCriteria().andIdIn(stringB);
//        return saCollegeMapper.deleteByExample(example);
//    }

    @Override
    public int checkNameUnique(SaCollege saCollege) {
        SaCollegeExample example=new SaCollegeExample();
        example.createCriteria().andCollegeEqualTo(saCollege.getCollege());
        List<SaCollege> list=saCollegeMapper.selectByExample(example);
        return list.size();
    }

    @Override
    public SaCollege selectByPrimaryKey(String id) {
        Integer id1 = Integer.valueOf(id);
        return saCollegeMapper.selectByPrimaryKey(id1);
    }

    @Override
    public int updateByPrimaryKeySelective(SaCollege record) {
        return saCollegeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void clearTable() {
        saCollegeMapper.truncateSaCollege();
    }

    @Override
    public int updateSaCollege(List<SaCollege> saColleges) {
        return saCollegeMapper.insertIntoSaCollege(saColleges);
    }

    @Override
    public List<SaCollege> findByCollegeId(String courseName, String cid, String grade) {
        SaCollegeExample testExample = new SaCollegeExample();
        College college = collegeMapper.selectByCollegeId(Integer.parseInt(cid));
        testExample.createCriteria().andCourseNameEqualTo(courseName).andCollegeEqualTo(college.getCollegeName()).andGradeEqualTo(Integer.parseInt(grade));
        return  saCollegeMapper.selectByExample(testExample);
    }

    @Override
    public List<SaCollege> selectAll() {
        return saCollegeMapper.selectByExample(null);
    }

    @Override
    public List<SaCollege> selectSaCollegeByCourseAndGrade(String courseName, String grade) {
        SaCollegeExample example = new SaCollegeExample();
        example.createCriteria().andCourseNameEqualTo(courseName).andGradeEqualTo(Integer.parseInt(grade));
        return saCollegeMapper.selectByExample(example);
    }

    @Override
    public SaCollege selectByCourseAndGradeAndCollegeName(String grade, String courseName, String collegeName) {
        SaCollegeExample saCollegeExample = new SaCollegeExample();
        saCollegeExample.createCriteria().andGradeEqualTo(Integer.parseInt(grade)).andCourseNameEqualTo(courseName).andCollegeEqualTo(collegeName);
        return saCollegeMapper.selectByExample(saCollegeExample).get(0);
    }

}
