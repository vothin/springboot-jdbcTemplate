package com.wdkl.zy.controller;

import com.wdkl.zy.pojo.Account;
import com.wdkl.zy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 添加单条数据
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public int addUser(@RequestParam String username,
                       @RequestParam String password,
                       @RequestParam Integer age) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setAge(age);

        return accountService.addAccount(account);
    }


    // 修改单条数据
    @PostMapping("/updateAccount")
//    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    public int post(@RequestParam String username,
                    @RequestParam String password,
                    @RequestParam Integer age) {

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setAge(age);

        return accountService.updateAccount(account);
    }


    // 删除数据
    @PostMapping("/deleteAccount")
    public int post(@RequestParam Integer id) {
        return accountService.deleteAccount(id);
    }


    // 查询单条数据
    @GetMapping("/findById")
    public Account get(@RequestParam Integer id) {
        return accountService.findById(id);
    }

    // 查询全部数据
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Account> findAll(){
        List<Account> accountList = accountService.findAll();
        return accountList;
    }


}
