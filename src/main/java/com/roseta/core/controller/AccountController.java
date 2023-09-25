package com.roseta.core.controller;


import com.roseta.core.dto.AccountDTO;
import com.roseta.core.entity.Accounts;
import com.roseta.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public String addAccount(@RequestBody Accounts account) {
        accountService.addAccount(account);
        return "success add";
    }

    @GetMapping
    public List<Accounts> getAccounts() {
        return  accountService.getAccounts();
    }

    @GetMapping("/get")
    public Accounts getAccount(@RequestParam Integer id) {
        return accountService.getAccount(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateAccount(@PathVariable Integer id, @RequestBody Accounts accounts) {
        accountService.updateAccount(id, accounts);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Void> deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccount(id);
        return  ResponseEntity.noContent().build();
    }

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Integer id, @RequestBody AccountDTO accountDTO) {
        accountService.updateName(id, accountDTO);
        return  ResponseEntity.noContent().build();
    }
}
