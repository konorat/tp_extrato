package br.com.konorat.services;

import br.com.konorat.domain.LinkedListTr;

public class Report {

    private LinkedListTr tr;

    public Report(LinkedListTr tr) {
        this.tr = tr;
    }

    public LinkedListTr getTr() {
        return tr;
    }

    public void setTr(LinkedListTr tr) {
        this.tr = tr;
    }

    @Override
    public String toString() {
        return "Report{" +
                "tr=" + tr +
                '}';
    }

    public String generateReport() {
        return  "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "";
    }
}
