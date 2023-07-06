package edu.miu.CS425EasyBank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String accountNumber;
    @NotBlank
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String accountType;
    @Column(nullable = false)
    private double balance;
    @Column(nullable = false)
    private LocalDate lastTransactionDate;
    @Column(nullable = true)
    private LocalTime lastTransactionTime;


}
