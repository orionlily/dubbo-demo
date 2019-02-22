package com.deepexi.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deepexi.user.domain.vo.UcUser;
import com.deepexi.user.mapper.UcUserMapper;
import com.deepexi.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/2/21
 */
@Component
@Service(version = "${demo.service.version}")
public class UcUserServiceImpl implements  UcUserService{

    @Autowired
    private UcUserMapper ucUserMapper;

    @Override
    public PageInfo<UcUser> getUcUserList(Integer pageNum, Integer pageSize,String username,String usernumber,String nickname,String email) {

        //设置分页
        PageHelper.startPage(pageNum,pageSize);

        QueryWrapper<UcUser> queryWrapper = new QueryWrapper<>();
        if (StringUtil.isNotEmpty(email)){
            queryWrapper.like("email",email);
        }
        if (StringUtil.isNotEmpty(nickname)){
            queryWrapper.like("nickname",nickname);
        }
        if (StringUtil.isNotEmpty(username)){
            queryWrapper.like("username",username);
        }
        if (StringUtil.isNotEmpty(usernumber)){
            queryWrapper.like("usernumber",usernumber);
        }

        List<UcUser> ucUsers = ucUserMapper.selectList(queryWrapper);

        return new PageInfo<>(ucUsers);
    }

    @Override
    public UcUser getUcUserById(String id) {
        return ucUserMapper.selectById(id);
    }

    @Override
    public Integer deleteUcUserByIds(List<String> ids) {
        return ucUserMapper.deleteBatchIds(ids);
    }

    @Override
    public Integer updateUcUserById(UcUser ucUser) {
        return ucUserMapper.updateById(ucUser);
    }

    @Override
    public Integer addUcUser(UcUser ucUser) {
        return ucUserMapper.insert(ucUser);
    }
}
