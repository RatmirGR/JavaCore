package Collections;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/*пример использования класса PriorityQueue*/
class ExPriorityQueue{

    void method(){
        System.out.println("Использование класса PriorityQueue");

        /* создание очереди по приоритетам*/
        PriorityQueue<String> priorQueue = new PriorityQueue<>();

        /* введение элементов в очередь по приоритетам */
        priorQueue.add("C");
        priorQueue.add("A");
        priorQueue.add("D");
        priorQueue.add("B");

        /* вывод содержимого очереди по приоритетам */
        System.out.println("- очереди по приоритетам priorQueue: "+ priorQueue);
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса ArrayDeque*/
class ExArrayDeque{

    void method(){
        System.out.println("Использование класса ArrayDeque");

        /* создание двусторонней очереди*/
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        /* введение элементов в двустороннюю очередь*/
        arrayDeque.push("C");
        arrayDeque.push("A");
        arrayDeque.push("D");
        arrayDeque.push("B");

        /* вывод содержимого двусторонней очереди*/
        System.out.println("- содержимое двусторонней очереди arrayDeque: "+ arrayDeque);

        /* пример извлечения из стека*/
        System.out.print("- вывод содержимого, используя методы peek() и pop(): ");

        while(arrayDeque.peek() != null){
            System.out.print(arrayDeque.pop()+" ");
        }
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

public class QueueDeque {
    public static void main(String[] args) {
        new ExPriorityQueue().method(); System.out.println("---------------------");
        new ExArrayDeque().method(); System.out.println("---------------------");

    }
}
