package com.wdkl.zy.dao;

import com.wdkl.zy.pojo.Account;

import java.util.List;

public interface AccountDao {

    // 添加
    int addAccount(Account account);

    // 更新
    int updateAccount(Account account);

    // 删除
    int deleteAccount(Integer id);

    // 通过id查用户
    Account findById(Integer id);

    // 查询所有用户
    List<Account> findAll();


}
