package Collections;

import java.util.*;

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

public class EnumSetStackVector {
    public static void main(String[] args) {
        new ExEnumSet().method(); System.out.println("---------------------");
        new ExVectorAndEnum().method(); System.out.println("---------------------");
        new ExHashtable().method(); System.out.println("---------------------");
        new ExStackV1().method(); System.out.println("---------------------");
        new ExStackV2().method(); System.out.println("---------------------");
    }
}
