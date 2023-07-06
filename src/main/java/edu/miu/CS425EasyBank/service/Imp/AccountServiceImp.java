package edu.miu.CS425EasyBank.service.Imp;

import edu.miu.CS425EasyBank.model.Account;
import edu.miu.CS425EasyBank.repository.AccountRepository;
import edu.miu.CS425EasyBank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

    public final AccountRepository accountRepository;
    @Override
    public List<Account> getAllDormantAccounts() {
        var allAccounts = accountRepository.findAll();
        var lastTransactionAMonthAGo= LocalDate.now().minusMonths(1);
        return allAccounts.stream().filter(account -> account.getLastTransactionDate().isBefore(lastTransactionAMonthAGo)).sorted(Comparator.comparing(Account::getCustomerName)).toList();
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> activeAccounts() {
        var allAccounts = accountRepository.findAll();
        var lastTransactionAMonthAGo= LocalDate.now().minusMonths(1);
        return allAccounts.stream().filter(account -> account.getLastTransactionDate().isEqual(lastTransactionAMonthAGo) || account.getLastTransactionDate().isAfter(lastTransactionAMonthAGo)).sorted(Comparator.comparing(Account::getCustomerName)).toList();


    }

    @Override
    public double getAccountBalance() {
        var allAccounts = accountRepository.findAll();
        var totalBalance = 0.0;
        return allAccounts.stream().mapToDouble(Account::getBalance).sum();
    }


}
