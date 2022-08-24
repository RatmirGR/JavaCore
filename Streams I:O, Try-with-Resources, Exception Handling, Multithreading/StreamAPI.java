package Streams;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;

/* класс Stream*/
/* получение потока данных*/
class ExClass1{

    void method(){
        System.out.println("Создание и получения потока данных, а также обработка его некоторыми операциями");

        /* создание списочного массива типа Integer*/
        ArrayList<Integer> list = new ArrayList<>();
        list.add(47);
        list.add(11);
        list.add(25);
        list.add(52);
        list.add(34);

        /* вывести исходный список*/
        System.out.println("- исходный список: "+list);

        /* получение потока элементов списочного массива*/
        Stream<Integer> myStream = list.stream();

        /* получение минимального значения*/
        Optional<Integer> minVal = myStream.min(Integer::compare);
        if (minVal.isPresent()) System.out.println("- минимальное значение: "+minVal.get());

        /* необходимо сначала получить новый поток данных, поскольку предыдущий вызов метода min() стал
         * оконечный операцией, употребившей поток данных*/
        myStream = list.stream();

        /* получение максимального значения*/
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        if (maxVal.isPresent()) System.out.println("- максимальное значение: "+maxVal.get());

        /* получение отсортированного списка, вызвав метод sorted()*/
        Stream<Integer> sortedStream = list.stream().sorted();
        System.out.print("- отсортированный список:");
        sortedStream.forEach((n) -> System.out.print(" "+n));

        /* получение нечетных целочисленных значений, вызвав метод filter()*/
        Stream<Integer> oddVal = list.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.print("\n- нечетные целочисленные значения:");
        oddVal.forEach((n) -> System.out.print(" "+n));

        /* получение четных целочисленных значений. вызвав метод filter()*/
        oddVal = list.stream().sorted().filter((n) -> (n % 2) == 0);
        System.out.print("\n- четные целочисленные значения:");
        oddVal.forEach((n) -> System.out.print(" "+n));

        /* получение нечетных целочисленных значений больше 34. Обратите внимание на
        * конвейеризацию обеих операций фильтрации*/
        oddVal = list.stream().filter((n) -> (n % 2) == 1).filter((n) -> (n > 34));
        System.out.print("\n- нечетные целочисленные значения больше 34:");
        oddVal.forEach((n) -> System.out.print(" "+n));

        /* получение четных целочисленных значений больше 34. Обратите внимание на
         * конвейеризацию обеих операций фильтрации*/
        oddVal = list.stream().filter((n) -> (n % 2) == 0).filter((n) -> (n > 34));
        System.out.print("\n- четные целочисленные значения больше 34:");
        oddVal.forEach((n) -> System.out.print(" "+n));

    }
}

/*---------------------------------------------------------------------*/

/* операция сведения - последовательное выполнение*/
class ExClass2{

    void method(){
        System.out.println("Операция сведения - метод reduce() - последовательное выполнение");

        /* создание списка объектов типа Integer*/
        ArrayList<Integer> arrayList = new ArrayList<>();

        /* заполнение списка объектов типа Integer*/
        arrayList.add(34);
        arrayList.add(52);
        arrayList.add(47);

        /* первый способ получения результата перемножения целочисленных элементов списка arrayList
        * с помощью метода reduce()*/
        /* в связи с тем, что поток содержит объекты типа Integer, они автоматически распаковываются перед
        * операцией умножения и снова упаковываются перед возвратом результата*/
        /* оба перемножаемых значения представляют текущий результат и следующий элемент в потоке данных*/
        /* конечный результат возвращается в виде объекта типа Optional*/
        Optional<Integer> productOb = arrayList.stream().reduce((a, b) -> a * b);

        /* выводимое значение получается в результате вызова метода get() для возвращающего объекта*/
        System.out.println("- произведение в виде объекта типа Optional: "+productOb.get());

        /* второй способ получения результата перемножения целочисленных элементов списка arrayList
        * с помощью метода reduce()*/
        /* при вызове метода reduce(), значение идентичности указывается явным образом: для операции
        * умножения оно равно 1*/
        /* результат возвращается в виде объекта типа Integer (т.е. тип которого соответствует типу
        * элемента из потока данных*/
        int product = arrayList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("- произведение в виде значения типа int: "+product);

        int evenProduct = arrayList.stream().reduce(1, (a, b) -> {if (b % 2 == 0) return a * b; else return a;});
        System.out.println("- произведение в виде значения типа int: "+evenProduct);
    }
}

/*---------------------------------------------------------------------*/

/* операция сведения - параллельное выполнение*/
class ExClass3{

    void method(){
        System.out.println("Операция сведения - метод reduce() - параллельное выполнение");

        /* создание списка объектов типа Double*/
        ArrayList<Double> myList = new ArrayList<>();

        /* заполнение списка объектов типа Double*/
        myList.add(34.0);
        myList.add(52.0);
        myList.add(47.0);

        /* применение объединяющего варианта метода reduce()*/
        double productDb = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
        System.out.println("- произведение квадратных корней: " + productDb);
    }
}

/*---------------------------------------------------------------------*/

/* операция отображения - последовательное выполнение*/
class PhoneBook{
    private final String name;
    private final String phone;
    private final String email;

    PhoneBook(String n, String p, String e){
        name = n; phone = p; email = e;
    }

    String getName(){ return name;}
    String getPhone(){ return phone;}
    String getEmail(){ return email;}
}

class NamePhone1{
    private final String name;
    private final String phone;

    NamePhone1(String n, String p){
        name = n; phone = p;
    }

    String getName(){ return name;}
    String getPhone(){ return phone;}
}

class ExClass4{

    void method(){
        System.out.println("Операция отображения - метод map() - последовательное выполнение");

        /* создание списка объектов типа PhoneBook (список имен, номеров телефонов и адресов электронной почты*/
        ArrayList<PhoneBook> arrayList = new ArrayList<>();

        /* заполнение списка объектов типа PhoneBook */
        arrayList.add(new PhoneBook("dog", "phone1", "email1"));
        arrayList.add(new PhoneBook("cat", "phone2", "email2"));
        arrayList.add(new PhoneBook("pig", "phone3", "email3"));

        /* вывести на консоль исходные элементы списка arrayList*/
        System.out.println("- исходные элементы из списка myList:");
        arrayList.forEach((a) -> {System.out.println("- "+a.getName()+" - "+a.getPhone()+" - "+a.getEmail());});

        System.out.println();

        /* отобразить на новый поток данных только имена и номера телефонов*/
        Stream<NamePhone1> namePhoneStream;
        namePhoneStream = arrayList.stream().map((a) -> new NamePhone1(a.getName(), a.getPhone()));

        /* вывести на консоль элементы из потока namePhoneStream*/
        System.out.println("- элементы из потока namePhoneStream:");
        namePhoneStream.forEach((a) -> {System.out.println("- "+a.getName()+" - "+a.getPhone());});

        /* объединение нескольких операций (в нашем случае, это filter() и map())*/
        namePhoneStream = arrayList.stream().filter((a) ->
                a.getName().equals("cat")).map((a) -> new NamePhone1(a.getName(), a.getPhone()));

        /* вывести на консоль элементы из потока namePhoneStream*/
        System.out.println("- элементы, которые совпадают с именем \"cat\" из потока namePhone:");
        namePhoneStream.forEach((a) -> {System.out.println("- "+a.getName()+" - "+a.getPhone());});
    }
}

/*---------------------------------------------------------------------*/

/* применение потока данных примитивного типа*/
class ExClass5{

    void method(){
        System.out.println("Применение потока данных примитивного типа");

        /* создание списка объектов типа Double*/
        ArrayList<Double> arrayList = new ArrayList<>();

        /* заполнение списка объектов типа Double*/
        arrayList.add(34.0);
        arrayList.add(52.0);
        arrayList.add(47.0);

        System.out.println("- исходные значения из списка arrayList");
        arrayList.stream().forEach((a) -> { System.out.print(a+" ");});

        System.out.println();

        /* отображение максимально допустимого предела каждого значения из списка arrayList на поток данных типа IntStream*/
        IntStream ob = arrayList.stream().mapToInt((a) -> (int) Math.ceil(a));

        System.out.println("- максимально допустимые пределы значений из списка arrayList: ");
        ob.forEach((a) -> {System.out.print(a+" ");});

        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* накопление*/
/* получение коллекции из потока данных*/
class NamePhoneEmail{
    private final String name;
    private final String phone;
    private final String email;

    NamePhoneEmail(String n, String p, String e){
        name = n; phone = p; email = e;
    }

    String getName(){ return name;}
    String getPhone(){ return phone;}
    String getEmail(){ return email;}
}

class NamePhone2{
    private String name, phone;

    NamePhone2(String n, String p){
        name = n; phone = p;
    }

    String getName(){ return name;}
    String getPhone(){ return phone;}
}

class ExClass6{

    void method(){
        System.out.println("Получение коллекции из потока данных - накопление");

        /* создание списка объектов типа NamePhoneEmail (список имен, номеров телефонов и адресов электронной почты*/
        ArrayList<NamePhoneEmail> arrayList = new ArrayList<>();

        /* заполнение списка объектов типа NamePhoneEmail */
        arrayList.add(new NamePhoneEmail("dog", "phone1", "email1"));
        arrayList.add(new NamePhoneEmail("cat", "phone2", "email2"));
        arrayList.add(new NamePhoneEmail("pig", "phone3", "email3"));

        /* выведение на консоль исходных элементов списка arrayList*/
        System.out.println("исходные элементы из списка myList:");
        arrayList.stream().forEach((a) -> {System.out.println(a.getName()+" "+a.getPhone()+" "+a.getEmail());});

        /* отображение только имен и номеров телефонов на новый поток данных*/
        Stream<NamePhone2> namePhoneStream = arrayList.stream().map((a) -> new NamePhone2(a.getName(), a.getPhone()));

        /*вызов метода collect(), который составляет список типа List из имен и номеров телефонов*/
        List<NamePhone2> namePhoneList = namePhoneStream.collect(Collectors.toList());

        System.out.println("имена и номера телефонов в списке типа List:");
        for (NamePhone2 e : namePhoneList) System.out.println("- "+e.getName()+" - "+e.getPhone());

        /* получение другого отображения имен и номеров телефонов*/
        namePhoneStream = arrayList.stream().map((a) -> new NamePhone2(a.getName(), a.getPhone()));

        /* создание множества типа Set, вызвав метод collect()*/
        Set<NamePhone2> mSet = namePhoneStream.collect(Collectors.toSet());

        System.out.println("имена и номера телефонов в множестве типа Set:");
        for (NamePhone2 e : mSet) System.out.println("- "+e.getName()+" - "+e.getPhone());
    }
}

/*---------------------------------------------------------------------*/

/* итераторы в потоке данных*/
class ExClass7{

    void method(){
        System.out.println("Итераторы в потоке данных");

        /* создание списка символьных строк*/
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("text1");
        arrayList.add("text2");
        arrayList.add("text3");

        /* получение потока данных для списочного массива*/
        Stream<String> arrayListStream = arrayList.stream();

        /* получение итератора для потока данных*/
        Iterator<String> itr = arrayListStream.iterator();

        /* перебор элементов в потоке данных*/
        while (itr.hasNext()) System.out.println(itr.next());
    }
}

/*---------------------------------------------------------------------*/

/* сплитераторы в потоке данных*/
class ExClass8{

    void method(){
        System.out.println("Сплитераторы в потоке данных");

        /* создание списка символьных строк*/
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("text1");
        arrayList.add("text2");
        arrayList.add("text3");

        /* получение потока данных для списочного массива*/
        Stream<String> arrayListStream = arrayList.stream();

        /* получение сплитератора для потока данных*/
        Spliterator<String> split = arrayListStream.spliterator();

        /* перебор элементов в потоке данных*/
        while (split.tryAdvance((n) -> System.out.println(n)));
    }
}

/*---------------------------------------------------------------------*/

class ExClass9{

    void method() {
        System.out.println("Сплитераторы в потоке данных - метод trySplit() - разделение сплитератора на две части");

        /* создание списка символьных строк*/
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("text1");
        arrayList.add("text2");
        arrayList.add("text3");

        /* получение потока данных для списочного массива*/
        Stream<String> arrayListStream = arrayList.stream();

        /* получение сплитератора для потока данных*/
        Spliterator<String> split = arrayListStream.spliterator();

        /* разделение сплитератора split на две части*/
        Spliterator<String> split2 = split.trySplit();

        /* получение результата из нового сплитератора*/
        if (split2 != null){
            System.out.println("результат, выводимый итератором split:");
            split2.forEachRemaining((n) -> System.out.println(n));
        }

        /* получение результата из старого сплитератора*/
        System.out.println("результат, выводимый итератором split:");
        split.forEachRemaining((n) -> System.out.println(n));
    }
}

/*---------------------------------------------------------------------*/

public class StreamAPI {
    public static void main(String[] args) {
        new ExClass1().method(); System.out.println("----------------------");
        new ExClass2().method(); System.out.println("----------------------");
        new ExClass3().method(); System.out.println("----------------------");
        new ExClass4().method(); System.out.println("----------------------");
        new ExClass5().method(); System.out.println("----------------------");
        new ExClass6().method(); System.out.println("----------------------");
        new ExClass7().method(); System.out.println("----------------------");
        new ExClass8().method(); System.out.println("----------------------");
        new ExClass9().method(); System.out.println("----------------------");
    }
}
