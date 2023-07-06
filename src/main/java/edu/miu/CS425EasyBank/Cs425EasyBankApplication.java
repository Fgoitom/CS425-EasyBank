package edu.miu.CS425EasyBank;

import edu.miu.CS425EasyBank.model.Account;
import edu.miu.CS425EasyBank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;



@SpringBootApplication
@RequiredArgsConstructor
public class Cs425EasyBankApplication implements CommandLineRunner {

	public final AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(Cs425EasyBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Account ac1001 = new Account(
				null,"CK1089"," United Metals Inc", "checking",
				105945.50, LocalDate.of(2023,06,13),
				LocalTime.of(10,05,00));


				accountService.saveAccount(ac1001);

		Account ac1002 = new Account(
				null,"SV1104"," AgroFeeds Corporation", "saving",
				197750.00, LocalDate.of(2023,05,21),
				LocalTime.of(14,15,00));
		accountService.saveAccount(ac1002);
		Account ac1003 = new Account(
				null,"SV2307"," DeLawro and Co., LLC", "saving",
				842000.75, LocalDate.of(2023,05,20),
				LocalTime.of(07,00,00));
	accountService.saveAccount(ac1003);
		Account ac1004 = new Account(
				null,"CK4133"," Bolingo Ventures", "checking",
				7450000, LocalDate.of(2022,11,16),
				null);

		accountService.saveAccount(ac1004);



	}

}
