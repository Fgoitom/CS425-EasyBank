package edu.miu.CS425EasyBank.repository;


import edu.miu.CS425EasyBank.model.Account;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAccountByLastTransactionDateGreaterThanEqual(LocalDate month, Sort sort);
    List<Account> findAccountByLastTransactionDateLessThanEqual(LocalDate month);
    Double findAllByBalance(double balance);


}
