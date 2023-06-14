package br.com.konorat.services;

import java.io.File;
import java.io.IOException;
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

    public String getText() {

        File file = new File(getPath());
        Scanner in = null;
        try {
            in = new Scanner(file);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            in.close();
        }




        return null;
    }
}
