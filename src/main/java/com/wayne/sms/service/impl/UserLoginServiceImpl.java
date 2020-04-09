package com.wayne.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayne.sms.dao.UserloginMapper;
import com.wayne.sms.model.Tablepar;
import com.wayne.sms.pojo.Userlogin;
import com.wayne.sms.pojo.UserloginExample;
import com.wayne.sms.service.UserLoginService;
import com.wayne.sms.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.service.impl
 * @Author: lgwayne
 * @CreateTime: 2020-03-16 14:32
 * @Description: ${Description}
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserloginMapper userloginMapper;

    @Override
    public Userlogin findByUserId(Long user_id) {
        return userloginMapper.selectByPrimaryKey(user_id);
    }

    @Override
    public PageInfo<Userlogin> list(Tablepar tablepar, String name) {
        UserloginExample testExample=new UserloginExample();
        testExample.setOrderByClause("user_id ASC");
        if(name!=null&&!"".equals(name)){
            testExample.createCriteria().andUserNameLike("%"+name+"%");
        }

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<Userlogin> list= userloginMapper.selectByExample(testExample);
        for (int i = 0; i <list.size(); i++) {
            String role_name=list.get(i).getRole()==1?"管理员":list.get(i).getRole()==2?"教师":"学生";
            list.get(i).setRoleName(role_name);
        }
        PageInfo<Userlogin> pageInfo = new PageInfo<Userlogin>(list);
        return  pageInfo;
    }

    @Override
    public int insertSelective(Userlogin userlogin) {
        return userloginMapper.insertSelective(userlogin);
    }

    @Override
    public int checkNameUnique(Userlogin userlogin) {
        UserloginExample example=new UserloginExample();
        example.createCriteria().andUserNameEqualTo(userlogin.getUserName());
        List<Userlogin> list=userloginMapper.selectByExample(example);
        return list.size();
    }

    @Override
    public Userlogin selectByPrimaryKey(@RequestParam("id") String id) {
        Long id1 = Long.valueOf(id);
        return userloginMapper.selectByPrimaryKey(id1);
    }

    @Override
    public int updateByPrimaryKeySelective(Userlogin record) {
        return userloginMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String ids) {
        Long[] integers = Convert.toLongArray(",", ids);
        List<Long> stringB = Arrays.asList(integers);
        UserloginExample example=new UserloginExample();
        example.createCriteria().andUserIdIn(stringB);
        return userloginMapper.deleteByExample(example);
    }
}
