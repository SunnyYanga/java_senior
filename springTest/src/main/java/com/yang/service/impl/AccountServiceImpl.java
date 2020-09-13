package com.yang.service.impl;

import com.yang.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author yg
 * @date 2020/4/25 12:12
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("保存");
    }

    public void updateAccount(int i) {
        System.out.println("更新" + i);
    }

    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }
}
