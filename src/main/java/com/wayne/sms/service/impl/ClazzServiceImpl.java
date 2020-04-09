package com.wayne.sms.service.impl;

import com.wayne.sms.dao.ClazzMapper;
import com.wayne.sms.pojo.Clazz;
import com.wayne.sms.pojo.ClazzExample;
import com.wayne.sms.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-03-27 11:26
 * @Description: ${Description}
 */

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public List<Clazz> selectByExample(ClazzExample example) {
        return  clazzMapper.selectByExample(example);
    }
}
