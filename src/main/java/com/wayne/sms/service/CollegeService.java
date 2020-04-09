package com.wayne.sms.service;

import com.wayne.sms.pojo.College;
import com.wayne.sms.pojo.CollegeExample;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-03-27 10:45
 * @Description: ${Description}
 */
public interface CollegeService {

    public List<College> selectByExample(CollegeExample example);


}
