package br.com.konorat;

import br.com.konorat.services.CSVReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        CSVReader csv = new CSVReader("c:\\ws-java\\extrato_contas\\testes\\cem.txt");
        csv.getText();


    }
}
