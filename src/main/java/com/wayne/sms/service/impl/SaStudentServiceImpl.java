package com.wayne.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.SaStudentMapper;
import com.wayne.sms.dao.StdStudentMapper;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.SaStudent;
import com.wayne.sms.pojo.SaStudentExample;
import com.wayne.sms.pojo.StdStudent;
import com.wayne.sms.service.SaStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-04-02 00:25
 * @Description: ${Description}
 */
@Service
public class SaStudentServiceImpl implements SaStudentService {

    @Autowired
    private SaStudentMapper saStudentMapper;

    @Autowired
    private StdStudentMapper stdStudentMapper;

    @Override
    public PageInfo<SaStudent> list(Tablepar tablepar, String name, String grade, String courseName, String mid, String clid, String order) {
        SaStudentExample testExample=new SaStudentExample();
        testExample.setOrderByClause("id ASC");
        if(name!=null&&!"".equals(name)){
            testExample.createCriteria().andStuNameLike("%"+name+"%");
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<SaStudent> list= saStudentMapper.selectByExample(testExample);
        PageInfo<SaStudent> pageInfo = new PageInfo<SaStudent>(list);
        return  pageInfo;
    }

    @Override
    public SaStudent selectByPrimaryKey(String id) {
        Integer id1 = Integer.valueOf(id);
        return saStudentMapper.selectByPrimaryKey(id1);
    }

    @Override
    public void clearTable() {
        saStudentMapper.truncateTable();
    }

    @Override
    public int updateSaStudent(List<SaStudent> saStudents) {
        return saStudentMapper.insertIntoSaStudents(saStudents);
    }

    @Override
    public int updateStdStudent() {
        stdStudentMapper.clearTable();
        List<StdStudent> stdStudents=saStudentMapper.selectAsStdStudents();
        int i = stdStudentMapper.insertIntoStdStudent(stdStudents);
        int i1 = saStudentMapper.updateStdScore();
        return i1;
    }

    @Override
    public SaStudent selectByStuId(long i) {
        SaStudentExample saStudentExample = new SaStudentExample();
        saStudentExample.createCriteria().andStuIdEqualTo(i);
        List<SaStudent> saStudents = saStudentMapper.selectByExample(saStudentExample);
        return saStudents.get(0);
    }
}
