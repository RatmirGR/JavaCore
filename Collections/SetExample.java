package Collections;

import java.util.*;

/* пример использования класса HashSet*/
class ExHashSet{

    void method(){
        System.out.println("Использование класса HashSet");

        /* создание хеш-множества*/
        HashSet<String> hashSet = new HashSet<>();

        /* введение элементов в хеш-множество*/
        hashSet.add("Art");
        hashSet.add("Big");
        hashSet.add("Cat");
        hashSet.add("Dog");
        hashSet.add("Big"); // попытка повторного введение элемента

        /* вывод содержимого хеш-множества*/
        System.out.println("- содержимое хеш-множества hashSet: "+ hashSet);
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса LinkedHashSet*/
class ExLinkedHashSet{

    void method(){
        System.out.println("Использование класса LinkedHashSet");

        /* создание отсортированного хеш-множества*/
        LinkedHashSet<String> linkHashSet = new LinkedHashSet<>();

        /* введение элементов в хеш-множество*/
        linkHashSet.add("A");
        linkHashSet.add("B");
        linkHashSet.add("D");
        linkHashSet.add("C");
        linkHashSet.add("B"); // попытка повторного введение элемента

        /* вывод содержимого отсортированного хеш-множества*/
        System.out.println("- содержимое хеш-множества linkHashSet: "+ linkHashSet);
    }
}

/*---------------------------------------------------------------------*/

/*пример использования класса TreeSet*/
class ExTreeSet{

    void method(){
        System.out.println("Использование класса TreeSet");

        /* создание древовидного множества*/
        TreeSet<String> treeSet = new TreeSet<>();

        /* введение элементов в древовидное множество*/
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("D");
        treeSet.add("B");
        treeSet.add("E");
        treeSet.add("B"); // попытка повторного введение элемента

        /* вывод содержимого древовидного множества*/
        System.out.println("- содержимое древовидного множества treeSet: "+ treeSet);

        /* получение диапазона значений с помощью метода subSet(), определенного в интерфейсе*/
        System.out.println(treeSet.subSet("B", "E"));
    }
}

/*---------------------------------------------------------------------*/

/* пример использования специального компаратора*/
/* компаратор для сравнения символьных строк в обратном порядке*/
class ExComparator1 implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        /* выполнить сравнение в естественном порядке*/
        // return o1.compareTo(o2);
        /* выполнить сравнение в обратном порядке*/
        return o2.compareTo(o1);
        /* переопределять метод equals не требуется*/
    }
}

class ExComparator{

    void method(){
        System.out.println("Использование специального компаратора");

        /* создание древовидного множества типа TreeSet*/
        TreeSet<String> treeSet = new TreeSet<>(new ExComparator1());

        /* введение элементов в древовидное множество*/
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("D");
        treeSet.add("C");
        treeSet.add("E");

        /* выведение элементов из древовидного множества*/
        for(String el : treeSet) System.out.print(el + " ");
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* переделанный вариант 2*/
/* пример использования лямбда-выражения для реализации компаратора типа Comparator<String>*/
class ExComparatorV2{

    void method(){

        System.out.println("Использование лямбда-выражения для реализации компаратора типа Comparator<String>");

        /* создание компаратора*/
        Comparator<String> comp = (a, b) -> a.compareTo(b);
        /* аналогичный вариант создание компаратора*/
        //Comparator<String> comp = String::compareTo;

        /* создание древовидного множества типа TreeSet*/
        /* передача компаратора с обратным упорядочением конструктору класса TreeSet через лямбда-выражение*/
        TreeSet<String> treeSet = new TreeSet<>(comp);

        /* введение элементов в древовидное множество*/
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("D");
        treeSet.add("C");
        treeSet.add("E");

        /* выведение элементов из древовидного множества*/
        System.out.println("- ");
        for(String el : treeSet) System.out.print(el + " ");
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* переделанный вариант 3*/
/* пример использования лямбда-выражения для создания компаратора с обратным упорядочением*/
class ExComparatorV3{

    void method(){
        System.out.println("Использование лямбда-выражения для создания компаратора с обратным упорядочением");

        /* создание древовидного множества типа TreeSet*/
        /* передача компаратора с обратным упорядочением древовидному множеству типа TreeSet*/
        TreeSet<String> treeSet = new TreeSet<>((a, b) -> b.compareTo(a));

        /* введение элементов в древовидное множество*/
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("D");
        treeSet.add("C");
        treeSet.add("E");

        /* выведение элементов из древовидного множества*/
        System.out.println("- ");
        for(String el : treeSet) System.out.print(el + " ");
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

public class SetExample {
    public static void main(String[] args) {
        new ExHashSet().method(); System.out.println("---------------------");
        new ExLinkedHashSet().method(); System.out.println("---------------------");
        new ExTreeSet().method(); System.out.println("---------------------");
        new ExComparator().method(); System.out.println("---------------------");
        new ExComparatorV2().method(); System.out.println("---------------------");
        new ExComparatorV3().method(); System.out.println("---------------------");
    }
}
