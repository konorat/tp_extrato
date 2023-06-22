package br.com.konorat.services;

import br.com.konorat.domain.LinkedListSimple;
import br.com.konorat.domain.LinkedListTr;
import br.com.konorat.domain.Transaction;
import org.w3c.dom.Node;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class CSVReader {

    private String path;

    public CSVReader(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LinkedListSimple<Transaction> getText() {

        File file = new File(getPath());
        Scanner in = null;
        String final1 = "";

        LinkedListSimple<Transaction> lls = new LinkedListSimple<>();

        try {
            in = new Scanner(file);
            while (in.hasNextLine()) {
                String line = in.nextLine();

                String[] arrayLine = new String[3];
                arrayLine = line.split(",");

                Transaction tr = new Transaction(arrayLine[0], arrayLine[1], new BigDecimal(arrayLine[2]));
                    //System.out.print(tr + "csv");
                lls.insertFirst(tr);
                //System.out.println(trs.printList());


                //A PARTIR DAQUI ORIENTAR A OBJETO

            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            in.close();

        }
        return lls;
    }
}
