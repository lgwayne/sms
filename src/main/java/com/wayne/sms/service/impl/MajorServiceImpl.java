package com.wayne.sms.service.impl;

import com.wayne.sms.dao.MajorMapper;
import com.wayne.sms.pojo.Major;
import com.wayne.sms.pojo.MajorExample;
import com.wayne.sms.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-03-27 11:24
 * @Description: ${Description}
 */

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public List<Major> selectByExample(MajorExample example) {
        return majorMapper.selectByExample(example);
    }
}
