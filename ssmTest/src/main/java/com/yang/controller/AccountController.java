package com.yang.controller;

import com.yang.domain.Account;
import com.yang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yg
 * @date 2020/4/30 9:11
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层查询所有账户信息");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("list", accounts);
        return "list";
    }

    @RequestMapping("/save")
    public String save(Account account) {
        System.out.println("表现层查询所有账户信息");
        accountService.saveAccount(account);

        return "list";
    }
}
