package edu.miu.CS425EasyBank.service;

import edu.miu.CS425EasyBank.model.Account;

import java.util.List;

public interface AccountService {

   public  List<Account> getAllDormantAccounts();
    public Account saveAccount(Account account);
     public List <Account> activeAccounts();

     public double getAccountBalance();



}
