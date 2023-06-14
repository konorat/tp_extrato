package br.com.konorat.domain;

import java.math.BigDecimal;

public class Account {

    private Integer id;
    private BigDecimal balance;

    public Account(Integer id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal    balance) {
        this.balance = balance;
    }
}
