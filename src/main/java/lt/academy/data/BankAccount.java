package lt.academy.data;

import java.math.BigDecimal;

public class BankAccount {
    String bankAccountNumber;
    String bank;
    String userId;
    BigDecimal balance;


    public BankAccount() {
    }

    public BankAccount(String bankAccountNumber, String bank, String userId, BigDecimal balance) {
        this.bankAccountNumber = bankAccountNumber;
        this.bank = bank;
        this.userId = userId;
        this.balance = balance;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}