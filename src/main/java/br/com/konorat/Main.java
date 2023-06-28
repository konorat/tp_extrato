package br.com.konorat;

import br.com.konorat.domain.*;
import br.com.konorat.services.CSVReader;
import br.com.konorat.services.Report;
import br.com.konorat.domain.LinkedListSimple;


import java.lang.reflect.AccessibleObject;
import java.math.BigDecimal;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static <T> void main(String[] args) {

        CSVReader csv = new CSVReader("c:\\ws-java\\extrato_contas\\testes\\teste.txt");

        LinkedListSimple<Transaction> lls = new LinkedListSimple<>();
        lls = csv.getText();

        LinkedListSimple<Account> accs = new LinkedListSimple<>();

        for (LinkedListSimple.Node<Transaction> node = lls.getFirst(); node != null; node = node.getNext()){
            Transaction tr = node.getDado();

            Integer idAcc =  Integer.parseInt(tr.getIdconta());
            String op = tr.getOperation();
            BigDecimal val = tr.getValue();

            LinkedListSimple.Node<Account> nAcc = accs.searchById(idAcc);

            BigDecimal newBalance = new BigDecimal(0);

            if(nAcc != null){
                switch (op) {
                    case "1", "4":
                        newBalance = nAcc.getDado().getBalance().subtract(val);
                        nAcc.getDado().setBalance(newBalance);
                        nAcc.getDado().addTr(tr);
                        break;
                    case "2":
                        newBalance = nAcc.getDado().getBalance().add(val);
                        nAcc.getDado().setBalance(newBalance);
                        nAcc.getDado().addTr(tr);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + op);
                }
            }else {
                Account acc = new Account(idAcc);
                switch (op) {
                    case "1", "4":
                        newBalance = acc.getBalance().subtract(val);
                        acc.setBalance(newBalance);
                        acc.addTr(tr);

                        accs.insertFirst(acc);
                        break;
                    case "2":
                        newBalance = acc.getBalance().add(val);
                        acc.setBalance(newBalance);
                        acc.addTr(tr);

                        accs.insertFirst(acc);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + op);
                }
            }
            newBalance = new BigDecimal(0);
        }
        System.out.println(accs.printList());
    }
}

