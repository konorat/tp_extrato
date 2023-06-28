package br.com.konorat.domain;

import java.math.BigDecimal;
import java.util.Objects;

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

    private Node first;

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
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
        //return search(dado) != null;
      for (Node node = first; node != null; node = node.next)
            if (dado == node.dado) return true; //econtrou o elemento
       return false;                     // não encontrou o elemento

    }

    private Node<T> search(T dado) {
        Node<T> aux = first;
        while(aux != null && aux.dado.equals(dado)) {
            aux = aux.next;
        }
        return aux;
    }

    public Node<Account> searchById(Integer id) {
        for (Node<Account> node = first; node != null; node = node.next){
            if(node.dado.getId().equals(id)){
                return node;
            }
        }
        return null;
/*        Node<Account> aux = first;
        while(aux != null && Objects.equals(aux.dado.getId(), acc.getId())) {
            aux = aux.next;
        }
        return aux;*/

    }

    public void insertFirst(T dado) {
        Node newNode = new Node(dado);
        newNode.next = first; //novoNo -> inicio antigo
        first = newNode;      // inicio -> novoNo
    }


    public void removeFirst() { //elimina o primiro item da lista
        first = first.next; // elimina o elemento e reposiciona o início
    }

/*    public String printList() {
        if (isEmpty()) return "Lista vazia\n"; //teste de lista vazia
        String str = " ";
        int i = 0;
        for (Node<T> node = first; node != null; node = node.next){
            i++;
            System.out.println(i);
            str += " " + node.dado.toString() + "\n";
        }
        return str + "\n";
    }*/

    public String printList() {
        if (isEmpty()) return "Lista vazia\n"; //teste de lista vazia

        StringBuilder builder = new StringBuilder();

        BigDecimal saldoTemp = new BigDecimal(0);

        for (Node<Account> node = first; node != null; node = node.next){


        builder.append("Número da Conta: " + node.dado.getId() + "\n");
        builder.append("-------------------------------------" + "\n");
        builder.append("Detalhes das Transações: " + "\n");
        builder.append("-------------------------------------" + "\n");
        builder.append("Tipo         | Valor  | Saldo     " + "\n");
        builder.append("-------------------------------------" + "\n");

        for(Node<Transaction> nodeTr = node.dado.getTrs().getFirst(); nodeTr != null; nodeTr = nodeTr.next) {
            switch(nodeTr.dado.getOperation()){
                case "1":
                    saldoTemp = saldoTemp.subtract(nodeTr.dado.getValue());
                    builder.append("Saque        | " + nodeTr.dado.getValue() + "    | " + saldoTemp + "\n");
                break;

                case "2":
                    saldoTemp = saldoTemp.add(nodeTr.dado.getValue());
                    builder.append("Deposito     | " + nodeTr.dado.getValue() + "    | " + saldoTemp + "\n");
                break;

                case "4":
                    saldoTemp = saldoTemp.subtract(nodeTr.dado.getValue());
                    builder.append("Pagamento    | " + nodeTr.dado.getValue() + "    | " + saldoTemp + "\n");

            }
        }

        saldoTemp = new BigDecimal(0);

        builder.append("-------------------------------------" + "\n");
        builder.append("Saldo Atual: " + node.dado.getBalance() + "\n");
        builder.append("\n");

        }

        return builder.toString();
    }



}
