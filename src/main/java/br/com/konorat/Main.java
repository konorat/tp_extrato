package br.com.konorat;

import br.com.konorat.domain.*;
import br.com.konorat.services.CSVReader;
import br.com.konorat.services.Report;

import java.lang.reflect.AccessibleObject;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        CSVReader csv = new CSVReader("c:\\ws-java\\extrato_contas\\testes\\cem.txt");
        //LinkedListTr trs = csv.getText();
        //System.out.println(trs.printList());

        LinkedListSimple<Transaction> lls = new LinkedListSimple<>();
        lls = csv.getText();
        System.out.println(lls.printList());

        LinkedListSimple<Account> accs = new LinkedListSimple<>();


        // Report repo = new Report(lls);
        //System.out.println(repo.toString());



    }
}
