package com.roseta.core.service;

import com.roseta.core.dto.AccountDTO;
import com.roseta.core.entity.Accounts;

import java.util.List;

public interface AccountService {
    void addAccount(Accounts account);

    List<Accounts> getAccounts();

    Accounts getAccount(Integer id);

    void updateAccount(Integer id, Accounts accounts);

    void deleteAccount(Integer id);

    void updateName(Integer id, AccountDTO accountDTO);
}
