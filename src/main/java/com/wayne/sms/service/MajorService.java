package com.wayne.sms.service;

import com.wayne.sms.pojo.Major;
import com.wayne.sms.pojo.MajorExample;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-03-27 11:24
 * @Description: ${Description}
 */
public interface MajorService {

    public List<Major> selectByExample(MajorExample example);
}
