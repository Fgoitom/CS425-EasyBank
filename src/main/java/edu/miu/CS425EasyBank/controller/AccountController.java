package edu.miu.CS425EasyBank.controller;

import edu.miu.CS425EasyBank.model.Account;
import edu.miu.CS425EasyBank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    public final AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllDormantAccount(){
        return new ResponseEntity<>(accountService.getAllDormantAccounts(), HttpStatus.OK);
    }

    @GetMapping("/active")
        public ResponseEntity<?> getActiveAccount(){
        return new ResponseEntity<>(accountService.activeAccounts(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.saveAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/totalBalance")
    public ResponseEntity<Double> getTotalBalance(){
        return new ResponseEntity<>(accountService.getAccountBalance(), HttpStatus.OK);
    }
}
