package br.com.konorat.domain;

import java.math.BigDecimal;

public class Account {

    private Integer id;
    private BigDecimal balance;
    private LinkedListSimple<Transaction> trs;

    public Account(Integer id, BigDecimal balance,LinkedListSimple<Transaction> trs) {
        this.id = id;
        this.balance = balance;
        this.trs = trs;
    }

    public Account(Integer id) {
        this.id = id;
        this.balance = BigDecimal.valueOf(0);
        this.trs = new LinkedListSimple<Transaction>();

    }

    public Account() {
    }

    public LinkedListSimple<Transaction> getTrs() {
        return trs;
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

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void addTr(Transaction tr) {
        trs.insertFirst(tr);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", trs=" + //trs.printList() +
                '}';
    }
}
