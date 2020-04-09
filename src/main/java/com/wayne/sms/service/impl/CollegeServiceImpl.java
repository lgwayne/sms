package com.wayne.sms.service.impl;

import com.wayne.sms.dao.CollegeMapper;
import com.wayne.sms.pojo.College;
import com.wayne.sms.pojo.CollegeExample;
import com.wayne.sms.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-03-27 11:23
 * @Description: ${Description}
 */

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> selectByExample(CollegeExample example) {
        return collegeMapper.selectByExample(example);
    }
}
