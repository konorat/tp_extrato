package br.com.konorat.domain;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;

public class LinkedListSimple<T> {

    public static class Node<T> {
        private T dado;
        private Node<T> next;

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getDado() {
            return dado;
        }

        public void setDado(T dado) {
            this.dado = dado;
        }

        public Node(T dado) {
            this.dado = dado;
            this.next = null;
        }
    }

    private Node<T> first;

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public LinkedListSimple() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Node<T> searcgObj(T dado) {
        return search(dado);
    }
    public boolean searchBol(T dado) {
      for (Node<T> node = first; node != null; node = node.next)
            if (dado == node.dado) return true;
       return false;                     

    }

    private Node<T> search(T dado) {
        Node<T> aux = first;
        while(aux != null && aux.dado.equals(dado)) {
            aux = aux.next;
        }
        return aux;
    }

    public Node<Account> searchById(Integer id) {
        for (Node<Account> node = (Node<Account>) first; node != null; node = node.next){
            if(node.dado.getId().equals(id)){
                return node;
            }
        }
        return null;
    }

    public void insertFirst(T dado) {
        Node newNode = new Node(dado);
        newNode.next = first;
        first = newNode;
    }


    public void removeFirst() {
        first = first.next;
    }

    public void printList() throws IOException {
        if (isEmpty()) return;
        
        OutputStream os = new FileOutputStream("relatorio.txt");
        Writer wr = new OutputStreamWriter(os);
        BufferedWriter br = new BufferedWriter(wr);

        BigDecimal saldoTemp = new BigDecimal(0);

        for (Node<Account> node = (Node<Account>) first; node != null; node = node.next){


        br.write("Número da Conta: " + node.dado.getId() + "\n");
        br.write("-------------------------------------" + "\n");
        br.write("Detalhes das Transações: " + "\n");
        br.write("-------------------------------------" + "\n");
        br.write("Tipo         | Valor  | Saldo     " + "\n");
        br.write("-------------------------------------" + "\n");

        for(Node<Transaction> nodeTr = node.dado.getTrs().getFirst(); nodeTr != null; nodeTr = nodeTr.next) {
            switch(nodeTr.dado.getOperation()){
                case "1":
                    saldoTemp = saldoTemp.subtract(nodeTr.dado.getValue());
                    br.write("Saque        | " + nodeTr.dado.getValue() + "    | " + saldoTemp + "\n");
                break;

                case "2":
                    saldoTemp = saldoTemp.add(nodeTr.dado.getValue());
                    br.write("Deposito     | " + nodeTr.dado.getValue() + "    | " + saldoTemp + "\n");
                break;

                case "4":
                    saldoTemp = saldoTemp.subtract(nodeTr.dado.getValue());
                    br.write("Pagamento    | " + nodeTr.dado.getValue() + "    | " + saldoTemp + "\n");

            }
        }

        saldoTemp = new BigDecimal(0);

        br.write("-------------------------------------" + "\n");
        br.write("Saldo Atual: " + node.dado.getBalance() + "\n");
        br.write("\n");
        }
        br.close();
    }
}
