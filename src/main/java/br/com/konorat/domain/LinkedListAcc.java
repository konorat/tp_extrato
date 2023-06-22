package br.com.konorat.domain;

public class LinkedListAcc {

    private static class Node {
        public Node next;
        public Account acc;

        public Node(Account acc) {
            acc = this.acc;
            next = null;
        }
    }

        private Node first;

        public void LinkedList() {

            first = null;
        }



        public boolean isEmpty(){
            return first == null;
        }

        public boolean search( Account acc){
            for(Node node = first; node != null; node = node.next)
                if (acc == node.acc) return true; //econtrou o elemento
                return false;                     // não encontrou o elemento

        }

        public void insertFirst(Account acc){ //insere no início da lista
            Node newNode = new Node(acc);
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
                str+= " "+ node.acc;
            return str + "\n";
        }

    }
