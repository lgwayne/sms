package com.wayne.sms.service;

import com.wayne.sms.pojo.Clazz;
import com.wayne.sms.pojo.ClazzExample;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service
 * @Author: lgwayne
 * @CreateTime: 2020-03-27 11:25
 * @Description: ${Description}
 */
public interface ClazzService {

    public List<Clazz> selectByExample(ClazzExample example);
}
