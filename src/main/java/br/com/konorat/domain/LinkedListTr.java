package br.com.konorat.domain;

public class LinkedListTr {



    private static class Node {
        public Node next;
        public Transaction tr;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Transaction getTr() {
            return tr;
        }

        public void setTr(Transaction tr) {
            this.tr = tr;
        }

        public  Node(Transaction tr) {
            this.tr = tr;
            this.next = null;
        }
    }



        private Node first;

        public LinkedListTr() {
            first = null;
        }

        public boolean isEmpty(){
            return first == null;
        }

        public boolean search(Transaction tr){
            for(Node node = first; node != null; node = node.next)
                if (tr == node.tr) return true; //econtrou o elemento
                return false;                     // não encontrou o elemento

        }

    public void insertFirst(Transaction tr) {
        Node newNode = new Node(tr);
        newNode.next = first; //novoNo -> inicio antigo
        first = newNode;      // inicio -> novoNo
    }



        public void removeFirst(){ //elimina o primiro item da lista
            first = first.next; // elimina o elemento e reposiciona o início
        }

        public String printList(){
            if(isEmpty()) return "Lista vazia\n"; //teste de lista vazia
            String str = "Lista Encadeada: ";
            for (Node node = first; node != null; node = node.next)
                str+= " "+ node.tr.toString() + "\n";
            return str + "\n";
        }

    }
