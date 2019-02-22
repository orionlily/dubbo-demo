package com.deepexi.user.service.impl;

import com.deepexi.user.domain.vo.UcUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/2/21
 */
public interface UcUserService {


    /**
     * 查询分页
     * @param pageNum
     * @param pageSize
     * @param username
     * @param usernumber
     * @param nickname
     * @param email
     * @return
     */
    PageInfo<UcUser> getUcUserList(Integer pageNum, Integer pageSize, String username,String usernumber,String nickname,String email);

    /**
     * 根据id查询UcUser
     * @param id
     * @return
     */
    UcUser getUcUserById(String id);


    /**
     * 根据id删除UcUser
     * @param ids
     * @return
     */
    Integer deleteUcUserByIds(List<String> ids);

    /**
     * 根据id修改UcUser
     * @param ucUser
     * @return
     */
    Integer updateUcUserById(UcUser ucUser);

    /**
     * 增加UcUser
     * @param ucUser
     */
    Integer addUcUser(UcUser ucUser);

}
