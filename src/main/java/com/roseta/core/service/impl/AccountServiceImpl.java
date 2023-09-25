package com.roseta.core.service.impl;

import com.roseta.core.dto.AccountDTO;
import com.roseta.core.entity.Accounts;
import com.roseta.core.repository.AccountRepository;
import com.roseta.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void addAccount(Accounts account) {
        accountRepository.save(account);
    }

    @Override
    public List<Accounts> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Accounts getAccount(Integer id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid account id" + id));
    }

    @Override
    public void updateAccount(Integer id, Accounts accounts) {
        // check if the user is exist
        accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id"));
        accounts.setId(id);
        accountRepository.save(accounts);
    }

    @Override
    public void deleteAccount(Integer id) {
        Accounts accounts = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id"));
        accountRepository.delete(accounts);
    }

    @Override
    public void updateName(Integer id, AccountDTO accountDTO) {
        Accounts accounts = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id"));
        accounts.setName(accountDTO.getName());
        accountRepository.save(accounts);
    }


}
