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

    public String getIdconta() {
        return idconta;
    }

    public void setIdconta(String idconta) {
        this.idconta = idconta;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
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
