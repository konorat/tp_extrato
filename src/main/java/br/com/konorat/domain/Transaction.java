package br.com.konorat.domain;


import java.math.BigDecimal;

public class Transaction {

    String idconta;
    String operation;
    BigDecimal value;

    public Transaction(String idconta, String operation, BigDecimal value) {
        this.idconta = idconta;
        this.operation = operation;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idconta=" + idconta +
                ", operation=" + operation +
                ", value=" + value +
                '}';
    }
}
