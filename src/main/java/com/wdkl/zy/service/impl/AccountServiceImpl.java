package com.wdkl.zy.service.impl;

import com.wdkl.zy.pojo.Account;
import com.wdkl.zy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加账户
    @Override
    public int addAccount(Account account) {

        // 定义SQL
        String sql = "insert into account1(username, password, age) value(?, ?, ?)";
        // 定义数组来存放SQL语句中的参数
        Object[] obj = new Object[] {
                account.getUsername(),
                account.getPassword(),
                account.getAge()
        };
        // 执行添加操作，返回受SQL语句影响的条数
        int num = this.jdbcTemplate.update(sql, obj);
        return num;
    }

    @Override
    public int updateAccount(Account account) {

        // 定义SQL
        String sql = "update account1 set password = ? , age = ? where username = ?";
        // 定义数组来存放SQL语句中的参数
        Object[] obj = new Object[] {
                account.getPassword(),
                account.getAge(),
                account.getUsername(),
        };
        // 执行添加操作，返回受SQL语句影响的条数
        int num = this.jdbcTemplate.update(sql, obj);
        return num;
    }

    @Override
    public int deleteAccount(Integer id) {

        // 定义SQL
        String sql = "delete from account1 where id = ?";

        // 执行添加操作，返回受SQL语句影响的条数
        int num = this.jdbcTemplate.update(sql, id);
        return num;
    }

    @Override
    public Account findById(Integer id) {

        String sql = "SELECT * FROM account1 where id = ?";

        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        System.out.println(rowMapper);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }


    //查询所有账户信息
    @Override
    public List<Account> findAll() {
        // 定义SQL
        String sql = "select * from account1";
        // 创建一个新的BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //执行静态查询的sql，通过RowMapper返回结果
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}

