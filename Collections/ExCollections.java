package Collections;

/* импортирование пакета*/
import java.io.*;
import java.util.*;

/* пример использования класса ArrayList*/
class ExArrayList1{

    void method(){
        System.out.println("Использование класса ArrayList*/");
        /* создание списочного массива*/
        ArrayList<String> list = new ArrayList<>();

        System.out.println("- начальный размер списочного массива: "+list.size());

        /* введение элементов в списочный массив*/
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add(1, "A2");

        System.out.println("- размер списочного массива list после ввода элементов: "+ list.size());

        /* вывод списочного массива*/
        System.out.println("- содержимое списочного массива list: "+ list);

        /* удаление элементов из списочного массива*/
        list.remove("C");
        list.remove(1);

        System.out.println("- размер списочного массива list после удаления элементов: "+ list.size());

        /* вывод содержимого массива list*/
        System.out.println("- содержимое списочного массива: " + list);
    }
}

/*---------------------------------------------------------------------*/

/* пример преобразования списочного массива типа ArrayList в обычной массив*/
class ExArrayList2{

    void method(){
        System.out.println("Преобразование списочного массива типа ArrayList в обычной массив");

        /* создание списочного массива*/
        ArrayList<Integer> list = new ArrayList<>();

        /* введение элементов в списочный массив*/
        list.add(1);
        list.add(2);
        list.add(3);

        /* вывод содержимого списочного массива*/
        System.out.println("содержимое списочного массива: "+list);

        /* получение обычного массива*/
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);

        /* вывод содержимого получившегося массива*/
        System.out.print("содержимое массива: ");

        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса LinkedList*/
class ExLinkedList{

    void method(){
        System.out.println("Использование класса LinkedList");

        /* создание связного списка*/
        LinkedList<String> linkLIst = new LinkedList<>();

        /* введение элементов в связный список*/
        linkLIst.add("B");
        linkLIst.add("C");
        linkLIst.add("D");
        linkLIst.add("E");
        linkLIst.addFirst("A");
        linkLIst.addLast("F");
        linkLIst.add(1, "A2");

        /* вывод содержимого связного списка*/
        System.out.println("- содержимое связного списка linkLIst: "+ linkLIst);

        /* удаление элементов из связного списка*/
        linkLIst.remove("C");
        linkLIst.remove(2);
        linkLIst.removeFirst();
        linkLIst.removeLast();

        /* вывод содержимого связного списка*/
        System.out.println("- содержимое связного списка linkLIst: "+ linkLIst);

        /* получение и присвоение значения*/
        String val = linkLIst.get(2);
        linkLIst.set(2, val+ " изменено");

        /* вывод содержимого связного списка*/
        System.out.println("- содержимое связного списка linkLIst: "+ linkLIst);
    }
}

/*---------------------------------------------------------------------*/

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

/* пример использования класса EnumSet*/
enum Numbers{
    ONE, TWO, THREE
}
class ExEnumSet{

    void method(){
        System.out.println("Использование класса EnumSet");

        /* создание множества с ключами перечислимого типа используя фабричный метод с добавлением элементов*/
        EnumSet<Numbers> enumSet = EnumSet.of(Numbers.ONE, Numbers.THREE, Numbers.TWO);

        /* вывод содержимого множества с ключами перечислимого типа */
        System.out.println("вывод содержимого множества с ключами перечислимого типа: "+enumSet);
    }
}

/*---------------------------------------------------------------------*/

/* пример использования интерфейсов Iterator и ListIterator*/
class ExListIterator{

    void method(){
        System.out.println("Использование интерфейсов Iterator и ListIterator");

        /* создание списочного массива*/
        ArrayList<String> arrayList = new ArrayList<>();

        /* введение элементов в списочный массив*/
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");

        /* использование итератора для вывода содержимого списочного массива*/
        System.out.print("- исходное содержимое списочного массива arrayList: ");

        Iterator<String> itr = arrayList.iterator();
        while (itr.hasNext()) System.out.print(itr.next()+" ");
        System.out.println();

        /* видоизменение перебираемого объекта*/
        ListIterator<String> lItr = arrayList.listIterator();
        while (lItr.hasNext()) lItr.set(lItr.next()+"+");

        /* вывод измененного содержимого списочного массива*/
        System.out.print("- измененное содержимое списочного массива arrayList: ");
        itr = arrayList.iterator();
        while (itr.hasNext()) System.out.print(itr.next()+" ");
        System.out.println();

        /* отображение списка в обратном порядке*/
        System.out.print("- измененный в обратном порядке список arrayList: ");
        while (lItr.hasPrevious()) System.out.print(lItr.previous()+" ");
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* пример использования цикла for в стиле for each для перебора элементов коллекции*/
class ExArrayListForEach{

    void method(){
        System.out.println("Использование цикла for в стиле for each для перебора элементов коллекции");

        /* создание списочного массива*/
        ArrayList<Integer> arrayList = new ArrayList<>();

        /* введение элементов в списочный массив*/
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        /* организация цикла для вывода числовых значений*/
        System.out.print("- исходное содержимое списочного массива arrayList: ");
        for(int v : arrayList) System.out.print(v+" ");

        System.out.println();

        /* суммирование числовых значений в цикле for*/
        int sum = 1;
        for(int v : arrayList) sum *= v;

        System.out.println("- сумма числовых значений: "+sum);
    }
}

/*---------------------------------------------------------------------*/

/* пример использования интерфейса Spliterator*/
class ExSpliterator{

    void method(){
        System.out.println("Использование интерфейса Spliterator");

        /* создание списочного массива числовых значений типа double*/
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(1.0);
        arrayList.add(2.0);
        arrayList.add(3.0);
        arrayList.add(4.0);
        arrayList.add(5.0);

        /* вызов метода tryAdvance() для вывода содержимого списочного массива arrayList*/
        System.out.print("- вызов метода tryAdvance() для вывода содержимого списочного массива arrayList: ");
        Spliterator<Double> splitr = arrayList.spliterator();
        while (splitr.tryAdvance((n) -> System.out.print(n+" ")));

        System.out.println();

        /* создание нового списочного массива, содержащего квадратные корни числовых значений
         * из списочного массива arrayList*/
        splitr = arrayList.spliterator();
        ArrayList<Double> arrayList1 = new ArrayList<>();
        while (splitr.tryAdvance((n)->arrayList1.add(Math.sqrt(n))));

        /* вызов метода forEachRemaining() для вывода содержимого списочных массивов arrayList и arrayList1*/
        System.out.print("- вызов метод forEachRemaining() для вывода содержимого списочного массива arrayList: ");
        splitr = arrayList.spliterator();
        splitr.forEachRemaining((n)->System.out.print(n+" "));

        System.out.println();

        System.out.print("- вызов метода forEachRemaining() для вывода содержимого списочного массива arrayList1: ");
        splitr = arrayList1.spliterator();
        splitr.forEachRemaining((n)->System.out.print(n+" "));
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* создание класса, для использования его экземпляра в связном списке*/
class ExClass1{
    private final String name;
    private final int age;
    private final char gend;
    ExClass1(String n, int a, char g){
        name = n; age = a; gend = g;
    }

    public String toString(){
        return name+" - "+age+" - "+gend;
    }
}

class ExLinkedList1{

    void method(){
        System.out.println("Создание класса, для использования его экземпляра в связном списке");

        /* создание связного списка*/
        LinkedList<ExClass1> linkLIst = new LinkedList<>();

        /* введение элементов в связный список*/
        linkLIst.add(new ExClass1("name1", 31, 'm'));
        linkLIst.add(new ExClass1("name2", 32, 'w'));
        linkLIst.add(new ExClass1("name3", 34, 'w'));
        linkLIst.add(new ExClass1("name4", 35, 'm'));

        /* вывод содержимого связного списка*/
        for(ExClass1 mc : linkLIst) System.out.println("- "+mc);
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса HashMap*/
class ExHashMap{

    void method(){
        System.out.println("Использование класса HashMap");

        /* создание хеш-отображения*/
        HashMap<String, Double> hashMap = new HashMap<>();

        /* введение элементов в хеш-отображение*/
        hashMap.put("name1", new Double(34.0));
        hashMap.put("name2", new Double(11.0));
        hashMap.put("name3", new Double(25.0));
        hashMap.put("name4", new Double(-47.0));
        hashMap.put("name5", new Double(52.0));

        /* получение множество записей*/
        Set<Map.Entry<String, Double>> set = hashMap.entrySet();

        /* вывод множество записей*/
        for(Map.Entry<String, Double> m : set){
            System.out.print("- "+m.getKey()+" : ");
            System.out.println(m.getValue());
        }
        System.out.println();

        /* внесение суммы 100 на счет name1*/
        double balance = hashMap.get("name1");
        hashMap.put("name1", balance + 100);
        System.out.println("- новый остаток на счете name1: "+hashMap.get("name1"));
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса TreeMap*/
class ExTreeMap{

    void method(){
        System.out.println("Использование класса TreeMap");

        /* создание древовидного отображения*/
        TreeMap<String, Double> treeMap = new TreeMap<>();

        /* введение элементов в древовидное отображение*/
        treeMap.put("name1", new Double(34.0));
        treeMap.put("name2", new Double(11.0));
        treeMap.put("name3", new Double(25.0));
        treeMap.put("name4", new Double(-47.0));
        treeMap.put("name5", new Double(52.0));

        /* получение множество записей*/
        Set<Map.Entry<String, Double>> set = treeMap.entrySet();

        /* вывод множество записей*/
        for(Map.Entry<String, Double> m : set){
            System.out.print("- "+m.getKey()+" : ");
            System.out.println(m.getValue());
        }
        System.out.println();

        /* внесение суммы 100 на счет name1*/
        double balance = treeMap.get("name1");
        treeMap.put("name1", balance + 100);
        System.out.println("- новый остаток на счете name1: "+treeMap.get("name1"));
    }
}

/*---------------------------------------------------------------------*/

/* пример использования специального компаратора*/
/* компаратор для сравнения символьных строк в обратном порядке*/
class ExComparator1 implements Comparator<String>{
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

/* пример использования компаратора для сортировки счетов по фамилиям вкладчиков*/
/* сравнение последних слов в обеих символьных строках*/
class ExSortComparator implements Comparator<String>{

    public int compare(String a, String b){

        /* поиск индекса символа, с которого начинается фамилия*/
        int i = a.lastIndexOf(' ');
        int j = b.lastIndexOf(' ');
        int k = a.substring(i).compareTo(b.substring(j));

        /* если фамилии совпадают, то проверить имя и фамилию полностью*/
        if(k == 0) return a.compareTo(b);
        else return k;
    }
    /* переопределять метод equals не требуется*/
}

/* сокращенный вариант*/
class ExSortComparatorV2 implements Comparator<String>{

    public int compare(String a, String b){
        int k = 0;
        if((k = a.substring(a.lastIndexOf(' ')).compareTo(b.substring(b.lastIndexOf(' ')))) == 0)
            return a.compareTo(b);
        else return k;
    }
}

class ExComparator2{

    void method(){
        System.out.println("Использование компаратора для сортировки счетов по фамилиям вкладчиков");

        /* создание древовидного отображения*/
        TreeMap<String, Double> treeMap = new TreeMap<>(new ExSortComparatorV2());

        /* создание древовидного отображения и передача ему лямбда-выражения*/
        /*TreeMap<String, Double> treeMap = new TreeMap<>((a, b) -> {
            int k = 0;
            if((k = a.substring(a.lastIndexOf(' ')).compareTo(b.substring(b.lastIndexOf(' ')))) == 0)
                return a.compareTo(b);
            else return k;
        });*/

        /* введение элементов в древовидное отображение*/
        treeMap.put("name1 lastname1", new Double(34.0));
        treeMap.put("name2 lastname2", new Double(11.0));
        treeMap.put("name3 lastname3", new Double(25.0));
        treeMap.put("name4 lastname4", new Double(-47.0));
        treeMap.put("name5 lastname5", new Double(52.0));

        /* получение множество записей*/
        Set<Map.Entry<String, Double>> set = treeMap.entrySet();

        /* вывод множества записей*/
        for(Map.Entry<String, Double> m : set){
            System.out.print("- "+m.getKey()+" : ");
            System.out.println(m.getValue());
        }

        System.out.println();

        /* внесение суммы 100 на счет name2 lastname2*/
        double balance = treeMap.get("name2 lastname2");
        treeMap.put("name2 lastname2", balance + 100);
        System.out.println("- новый остаток на счете name2 lastname2: "+treeMap.get("name2 lastname2"));
    }
}

/*---------------------------------------------------------------------*/

/* пример использования метода thenComparing() для сортировки счетов вкладчиков сначала по фамилии, а затем по имени*/
/* компаратор, сравнивающий фамилии вкладчиков – первый компаратор*/
class SortDepositComp1 implements Comparator<String>{
    public int compare(String a, String b){
        /* поиск индекса символа, с которого начинается фамилия*/
        int i = a.lastIndexOf(' ');
        int j = b.lastIndexOf(' ');
        return a.substring(i).compareToIgnoreCase(b.substring(j));
    }
}

/* сортировка счета вкладчиков по Ф.И.О., если фамилии одинаковы – второй компаратор*/
class SortDepositComp2 implements Comparator<String>{
    public int compare(String a, String b){
        return a.compareToIgnoreCase(b);
    }
}

class ExThenComparing{

    void method(){
        System.out.println("Использование метода thenComparing()");
        /* использование метода thenComparing() для создания компаратора, сравнивающего сначала фамилии,
        а затем Ф.И.О. вкладчиков, если фамилии одинаковы*/

        Comparator<String> comp = new SortDepositComp1().thenComparing(new SortDepositComp2());
        /* создание древовидного отображения*/

        TreeMap<String, Double> treeMap = new TreeMap<>(comp);

        /* введение элементов в древовидное отображение*/
        treeMap.put("name1 lastname1", new Double(34.0));
        treeMap.put("name2 lastname2", new Double(11.0));
        treeMap.put("name3 lastname4", new Double(25.0));
        treeMap.put("name3 lastname3", new Double(-47.0));
        treeMap.put("name5 lastname5", new Double(52.0));

        /* получение множество записей*/
        Set<Map.Entry<String, Double>> set = treeMap.entrySet();
        /* вывод множества записей*/

        for(Map.Entry<String, Double> m : set){
            System.out.print("- "+m.getKey()+" : ");
            System.out.println(m.getValue());
        }

        System.out.println();

        /* внесение суммы 100 на счет name2 lastname2*/
        double balance = treeMap.get("name2 lastname2");
        treeMap.put("name2 lastname2", balance + 100);
        System.out.println("- новый остаток на счете name2 lastname2: "+treeMap.get("name2 lastname2"));
    }
}

/*---------------------------------------------------------------------*/

/* пример использования метода thenComparing() для сортировки счетов вкладчиков сначала по фамилии, а затем по имени,
 * используя лямбда-выражение*/
class ExComparatorLambda{

    void method(){
        System.out.println("Использование метода thenComparing() используя лямбда-выражение");

        Comparator<String> comp1 = (a, b) -> {
            return a.substring(a.lastIndexOf(' ')).compareToIgnoreCase(b.substring(b.lastIndexOf(' ')));
        };

        Comparator<String> comp2 = (a, b) -> {return a.compareToIgnoreCase(b);};
        Comparator<String> comp = comp1.thenComparing(comp2);

        /* создание древовидного отображения*/
        TreeMap<String, Double> treeMap = new TreeMap<>(comp);

        /* введение элементов в древовидное отображение*/
        treeMap.put("name1 lastname1", new Double(34.0));
        treeMap.put("name2 lastname2", new Double(11.0));
        treeMap.put("name3 lastname4", new Double(25.0));
        treeMap.put("name3 lastname3", new Double(-47.0));
        treeMap.put("name5 lastname5", new Double(52.0));

        /* получение множество записей*/
        Set<Map.Entry<String, Double>> set = treeMap.entrySet();

        /* вывод множества записей*/
        for(Map.Entry<String, Double> m : set){
            System.out.print("- "+m.getKey()+" : ");
            System.out.println(m.getValue());
        }
        System.out.println();

        /* внесение суммы 100 на счет name2 lastname2*/
        double balance = treeMap.get("name2 lastname2");
        treeMap.put("name2 lastname2", balance + 100);
        System.out.println("- новый остаток на счете name2 lastname2: "+treeMap.get("name2 lastname2"));
    }
}

/*---------------------------------------------------------------------*/

/* пример использования некоторых алгоритмов коллекций*/
class MultiCollectionAlgorithms{

    void method(){
        System.out.println("Использование некоторых алгоритмов коллекций");

        /* создание неинициализированного связного списка*/
        LinkedList<Integer> linkList = new LinkedList<>();
        linkList.add(-8);
        linkList.add(20);
        linkList.add(-20);
        linkList.add(8);

        System.out.print("- вывод списка в исходном порядке: ");
        for (int i : linkList) System.out.print(i+" ");

        System.out.println();

        /* создание компаратора с обратным упорядочением*/
        Comparator<Integer> comp = Collections.reverseOrder();

        /* отсортировка списка с помощью компаратора*/
        Collections.sort(linkList, comp);
        System.out.print("- список отсортирован в обратном порядке: ");
        for(int i : linkList) System.out.print(i + " ");

        System.out.println();

        /* перетасовка списка*/
        Collections.shuffle(linkList);
        System.out.print("- список перетасован: ");
        for(int i : linkList) System.out.print(i + " ");

        System.out.println();

        /* вывод минимального и максимального значения*/
        System.out.println("- вывод минимального и максимального значения:");
        System.out.println("- минимум: "+Collections.min(linkList));
        System.out.println("- максимум: "+Collections.max(linkList));
    }
}

/*---------------------------------------------------------------------*/

/* унаследованный классы и интерфейсы*/
/* пример использования класса Vector и интерфейса Enumeration*/
class ExVectorAndEnum {

    void method() {
        System.out.println("Использование класса Vector и интерфейса Enumeration");

        /* начальный размер вектора – 3, а инкремент - 2*/
        Vector<Integer> v = new Vector<Integer>(3, 2);
        System.out.println("- начальный размер вектора: "+v.size());
        System.out.println("- начальная емкость вектора: "+v.capacity());

        v.addElement(1);
        v.addElement(2);
        v.addElement(3);
        v.addElement(4);

        System.out.println("- емкость вектора после ввода четырех элементов: "+v.capacity());
        System.out.println("- первый элемент вектора: "+v.firstElement());
        System.out.println("- последний элемент вектора: "+v.lastElement());

        if (v.contains(3)) System.out.println("- вектор содержит 3");

        /* перечисление элементов вектора с помощью методов из интерфейса Enumeration*/
        Enumeration<Integer> vEnum1 = v.elements();

        System.out.print("- элементы вектора с помощью методов из интерфейса Enumeration:");
        while (vEnum1.hasMoreElements()) System.out.print(vEnum1.nextElement() + " ");

        System.out.println();

        /* перечисление элементов вектора с помощью итератора*/
        Iterator<Integer> vEnum2 = v.iterator();

        System.out.print("- элементы вектора с помощью итератора:");
        while (vEnum2.hasNext()) System.out.print(vEnum2.next() + " ");

        System.out.println();

        /* перечисление элементов вектора с помощью цикла for в стиле for each*/
        System.out.print("- элементы вектора с помощью цикла for в стиле for each:");
        for (int i : v) System.out.print(i + " ");
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса Stack*/
class ExStackV1{
    private static <E> void methodPush(Stack<E> stack, E a){
        stack.push(a);
        System.out.println(stack);
    }

    private static <E> void methodPop(Stack<E> stack){
        stack.pop();
        System.out.println(stack);
    }

    void method(){
        Stack<String> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        methodPush(stack1, "tom"); // стек строк
        methodPush(stack1, "tim"); // стек строк
        methodPop(stack1);

        methodPush(stack2, 1); // стек чисел
        methodPush(stack2, 2); // стек чисел
        methodPush(stack2, 3); // стек чисел
        methodPop(stack2);
    }
}

class ExStackV2{
    static void methodPush(Stack<Integer> stack, int a){
        stack.push(a);
        System.out.println("- push(" + a + ")");
        System.out.println("- стек: " + stack);
    }

    static void methodPop(Stack<Integer> stack){
        System.out.print("- pop -> ");
        Integer a = stack.pop();
        System.out.println(a);
        System.out.println("- стек: "+ stack);
    }

    void method(){
        System.out.println("Использование класса Stack");
        Stack<Integer> stack = new Stack<>();
        System.out.println("- стек: "+ stack);
        methodPush(stack, 34);
        methodPush(stack, 47);
        methodPush(stack, 52);
        methodPop(stack);
        methodPop(stack);
        methodPop(stack);

        try{
            methodPop(stack);
        }catch(EmptyStackException e){ System.out.println("стек пуст");}

        new ExStackV1().method();
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса Hashtable*/
class ExHashtable{

    void method(){
        System.out.println("Использование класса Hashtable");

        /* создание хеш-таблицы*/
        Hashtable<String, Double> hashtab = new Hashtable<>();

        /* введение элементов в хеш-таблицу*/
        hashtab.put("name1 lastname1", 34.0);
        hashtab.put("name2 lastname2", 11.0);
        hashtab.put("name3 lastname3", 25.0);
        hashtab.put("name4 lastname4", -47.0);
        hashtab.put("name5 lastname5", 52.0);

        System.out.println("- использование Enumeration");

        /* получение перечисления ключей из хеш-таблицы*/
        Enumeration<String> names = hashtab.keys();
        while(names.hasMoreElements()){
            String str = names.nextElement();
            System.out.println("- "+str + ": "+hashtab.get(str));
        }

        /* внесение суммы 100 на счет name2 lastname2*/
        double balance = hashtab.get("name2 lastname2");
        hashtab.put("name2 lastname2", balance + 100);
        System.out.println("- новый остаток на счете name2 lastname2: "+hashtab.get("name2 lastname2"));
        System.out.println();

        /* переделанный фрагмент*/
        System.out.println("- использование Iterator");

        /* получение представления всех ключей из хеш-таблицы в виде множества*/
        Set<String> set = hashtab.keySet();

        /* получение итератора*/
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()){
            String str = itr.next();
            System.out.println("- "+str + ": " + hashtab.get(str));
        }

        /* внесение суммы 100 на счет name2 lastname2*/
        balance = hashtab.get("name2 lastname2");
        hashtab.put("name2 lastname2", balance + 100);
        System.out.println("- новый остаток на счете name2 lastname2: "+hashtab.get("name2 lastname2"));
    }
}

/*---------------------------------------------------------------------*/

/* пример применения списка свойств в классе Properties*/
class ExProperties{

    void method(){
        System.out.println("Применение списка свойств в классе Properties");

        /* создание объекта типа Properties*/
        Properties prop = new Properties();
        prop.put("иллинойс", "спрингфилд");
        prop.put("миссури", "джефферсон-сити");
        prop.put("вашингтон", "олимпия");
        prop.put("калифорния", "сакраменто");
        prop.put("индиана", "индианаполис");

        /* получение множества ключей*/
        Set<?> set = prop.keySet();

        /* вывод всех штатов и их столицы*/
        for(Object name : set) System.out.println("- столица штата "+ name+" ("+prop.getProperty((String) name) + ")");

        /* найти штат, отсутствующий в списке, указав значение, выбираемое по умолчанию*/
        String str = prop.getProperty("флорида", "не найдена");
        System.out.println("- столица штата флорида "+str+".");
    }
}

/*---------------------------------------------------------------------*/

/* переделанный предыдущий пример, в котором используется список свойств по умолчанию*/
class ExPropertiesV2{

    void method(){
        System.out.println("Переделанный предыдущий пример, в котором используется список свойств по умолчанию");

        /* создание объекта типа Properties – в качестве списка по умолчанию*/
        Properties defprop = new Properties();
        defprop.put("флорида", "тэлесси");
        defprop.put("висконсин", "мэдисон");

        /* создание объекта типа Properties и передача ему списка по умолчанию*/
        Properties prop = new Properties(defprop);
        prop.put("иллинойс", "спрингфилд");
        prop.put("миссури", "джефферсон-сити");
        prop.put("вашингтон", "олимпия");
        prop.put("калифорния", "сакраменто");
        prop.put("индиана", "индианаполис");

        /* получение множества ключей*/
        Set<?> set = prop.keySet();

        /* вывод всех штатов и их столицы*/
        for(Object name : set) System.out.println("столица штата: "+ name+"  –  "+prop.getProperty((String) name));

        /* найти штат, отсутствующий в списке, указав значение, выбираемое по умолчанию*/
        String str = prop.getProperty("флорида", "не найдена");
        System.out.println("столица штата флорида: "+str);
    }
}

/*---------------------------------------------------------------------*/

/* пример использования методов store() и load()*/
class ExStoreAndLoad{

    void method(){
        /* создание объекта типа Properties*/
        Properties prop = new Properties();

        /* создание потока ввода*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        FileInputStream fis = null;
        boolean changed = false;
        try {
            /* попытка открыть файл base.dat*/
            fis = new FileInputStream("base.dat");

            /* если телефонная книга уже существует, загрузить существующие телефонные номера*/
            if (fis != null) {
                prop.load(fis);
                fis.close();
            }

            /* разрешение пользователю вводить новые имена и номера телефонов абонентов*/
            do {
                System.out.println("введите имя (‘exit’ для завершения): ");
                name = br.readLine();

                if (name.equals("exit")) continue;

                System.out.println("введите номер: ");
                number = br.readLine();
                prop.put(name, number);
                changed = true;
            } while (!name.equals("exit"));

            /* сохранение телефонной книги, если она изменилась*/
            if (changed) {
                FileOutputStream fos = new FileOutputStream("base.dat");
                prop.store(fos, "телефонная книга");
                fos.close();
            }

            /* поиск в телефонной книги по имени*/
            do {
                System.out.println("введите имя для поиска (‘exit’ для завершения): ");
                name = br.readLine();

                if (name.equals("exit")) continue;

                number = (String) prop.get(name);
                System.out.println(number);
            } while (!name.equals("exit"));
        }catch(FileNotFoundException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример2 использования методов store() и load() - try с ресурсами*/
class ExStoreAndLoadV2{

    void method(){
        Properties prop = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        boolean flag = false;

        try(FileInputStream fis = new FileInputStream("base.dat");
            FileOutputStream fos = new FileOutputStream("base.dat")){
            if (fis != null) prop.load(fis);

            do{
                System.out.print("input name: ");
                name = br.readLine();

                if (name.equals("exit")) continue;

                System.out.print("input number: ");
                number = br.readLine();
                prop.put(name, number);
                flag = true;
            }while(!name.equals("exit"));

            if (flag) prop.store(fos, "phonebook");

            do{
                System.out.print("find name: ");
                name = br.readLine();
                if (name.equals("exit")) continue;
                System.out.println(prop.getProperty(name, "not find"));
            }while(!name.equals("exit"));
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

public class ExCollections {

    public static void main(String[] args) {
        new ExArrayList1().method(); System.out.println("----------------------");
        new ExArrayList2().method(); System.out.println("----------------------");
        new ExLinkedList().method(); System.out.println("----------------------");
        new ExHashSet().method(); System.out.println("----------------------");
        new ExLinkedHashSet().method(); System.out.println("----------------------");
        new ExTreeSet().method(); System.out.println("----------------------");
        new ExPriorityQueue().method(); System.out.println("----------------------");
        new ExArrayDeque().method(); System.out.println("----------------------");
        new ExEnumSet().method(); System.out.println("----------------------");
        new ExListIterator().method(); System.out.println("----------------------");
        new ExArrayListForEach().method(); System.out.println("----------------------");
        new ExSpliterator().method(); System.out.println("----------------------");
        new ExLinkedList1().method(); System.out.println("----------------------");
        new ExHashMap().method(); System.out.println("----------------------");
        new ExTreeMap().method(); System.out.println("----------------------");
        new ExComparator().method(); System.out.println("----------------------");
        new ExComparatorV2().method(); System.out.println("----------------------");
        new ExComparatorV3().method(); System.out.println("----------------------");
        new ExComparator2().method(); System.out.println("----------------------");
        new ExThenComparing().method(); System.out.println("----------------------");
        new ExComparatorLambda().method(); System.out.println("----------------------");
        new MultiCollectionAlgorithms().method(); System.out.println("----------------------");
        new ExVectorAndEnum().method(); System.out.println("----------------------");
        new ExStackV2().method(); System.out.println("----------------------");
        new ExHashtable().method(); System.out.println("----------------------");
        new ExProperties().method(); System.out.println("----------------------");
        new ExPropertiesV2().method(); System.out.println("----------------------");
        new ExStoreAndLoad().method(); System.out.println("----------------------");
        new ExStoreAndLoadV2().method(); System.out.println("----------------------");

    }
}
