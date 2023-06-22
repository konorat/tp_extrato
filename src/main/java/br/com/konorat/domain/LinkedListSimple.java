package br.com.konorat.domain;

public class LinkedListSimple<T> {



    private static class Node<T> {
        public T dado;
        public Node<T> next;

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getDado() {
            return dado;
        }

        public void setTr(T dado) {
            this.dado = dado;
        }

        public  Node(T dado) {
            this.dado = dado;
            this.next = null;
        }
    }

        private Node first;

        public LinkedListSimple() {
            first = null;
        }

        public boolean isEmpty(){
            return first == null;
        }

        public boolean search(T dado){
            for(Node node = first; node != null; node = node.next)
                if (dado == node.dado) return true; //econtrou o elemento
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
            for (Node<T> node = first; node != null; node = node.next)
                str+= " "+ node.dado.toString() + "\n";
            return str + "\n";
        }

    }
