package Exceptions;

import java.util.Random;
import java.util.Scanner;

/* Обработка исключений*/
class Exceptions1{

    /* ручное генерирование исключения - throw*/
    void generateException(){
        //throw new Exception();
    }

    void method(){
        System.out.println("- Обработчик исключений - try/catch");

        /* обработчик исключений - try/catch*/
        try{
            //throw new ArrayStoreException(); // - это исключение не отлавливается
            int a = 4 / 0; // - это исключение отлавливается
            // тут проверяется возможное исключение
        }catch (ArithmeticException e){
            // тут перехватывается и обрабатывается возникшее исключение
            /* важно отметить, что исключение перехватится и обработается только в том случае,
            * если его тип указан в параметре catch*/
        }
    }
}

/* пример работы обработчика исключения*/
class Exceptions2{

    void method(){
        System.out.println("- Пример 2 работы обработчика исключения");

        int a;
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            try {
                a = r.nextInt(10);
                a = 32 / a;
            }catch (ArithmeticException e){
                System.out.println("- деление на ноль: "+i+" шаг");
            }
        }
    }
}

/* использования нескольких операторов catch*/
class Exceptions3{

    void method(){
        System.out.println("- Использования нескольких операторов catch");

        /* если возможно появление нескольких исключений, то, в таком случае, применяют несколько операторов catch*/
        try{
            int a = new Random().nextInt(5);
            int b = 34 / a; // возможно деление на ноль
            int[] c = {b};
            c[11] = 52; // ошибка, индекс за пределами массива
        }catch(ArithmeticException e){
            System.out.println("- перехват и обработка деления на ноль");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("- перехват и обработка индекса за пределами массива");
        }
        // код после всего блока try/catch
    }
}

/* вложенный блок try/catch*/
class Exceptions4{

    void method(){
        System.out.println("- Вложенный блок try/catch");

        /* внешний блок try/catch*/
        try{
            int a = new Random().nextInt(5);
            int b = 34 / a;
            /* вложенный блок try/catch*/
            try{
                if (a == 4) b = 47 / (a - a);
                if (a == 3){
                    int[] c = {a};
                    c[a] = a * a;
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("- исключение: "+e);
            }
        }catch (ArithmeticException e){
            System.out.println("- исключение: "+e);
        }
    }
}

/* пример вложенного блока*/
class Exceptions5{

    void method1(){
        System.out.println("- Пример вложенного блока - вызов проверяемого метода");

        /* вложенный блок try/catch*/
        try{
            int b = new Random().nextInt(3);
            int a = 52 / b;
            int[] c = {a, b};
            System.out.println("- значение индекса: "+c[b]+", а результат деления: "+a);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("- вложенный блок try/catch: "+e);
        }
    }
    void method(){
        /* внешний блок try/catch*/
        try{
            method1();
        }catch (ArithmeticException e){
            System.out.println("- внешний блок try/catch: "+e);
        }
    }
}

/* пример использования оператора throw*/
class Exceptions6{

    void method1(){
        System.out.println("Пример использования оператора throw");

        try{
            /* генерируется исключение*/
            System.out.println("- генерируется исключение с помощью оператора throw");
            throw new ArithmeticException("пример вывода сообщения");
        }catch(ArithmeticException e){
            /* вновь генерируется это исключение*/
            System.out.println("- тут оно отлавливается и вновь генерируется оператором throw e");
            throw e;
        }
    }
    void method(){
        try{
            method1();
        }catch(ArithmeticException e){
            // здесь оно вновь обрабатывается
            System.out.println("- здесь оно вновь отлавливается и обрабатывается: "+e);
        }
    }
}

/* оператор throws*/
class Exceptions7{

    /* если метод может сгенерировать любой тип исключения (кроме классов Error, RuntimeException и их подклассов),
    * то при его объявлении необходимо вессти оператор throws с указанием одного или нескольких соответствующих
    * типов исключений*/
    void method1() throws IllegalAccessException{
        throw new IllegalAccessException();
    }

    void method(){
        System.out.println("Использование оператора throws");

        /* метод, в котором вызывается myMethod5a должен, либо поместить вызов в блок try/catch, либо также при
        * объявлении ввести оператор throws с соответствующими типами исключений*/
        try {
            method1();
        }catch (IllegalAccessException e){
            System.out.println("Передача методу println метода getMessage(): "+e.getMessage());
            System.out.println("Передача методу println просто объекта: "+e);
        }
    }
}

/* оператор finally*/
class Exceptions8{

    void methodV1(){
        try {
            // тут нет ошибки
        }finally {
            System.out.println("- код все равно выполнится - без ошибки");
        }
    }
    void methodV2(){
        try {
            return;
        }finally {
            System.out.println("- код все равно выполнится = использовние оператора return");
        }
    }
    void methodV3(){
        /* блок try-catch-finally*/
        try{
            throw new ArithmeticException();
        }catch (ArithmeticException e){
        }finally {
            System.out.println("- код все равно выполнится - блок try-catch-finally");
        }
    }
    void methodV4(){
        /* блок try-finally*/
        try{
            throw new ArrayIndexOutOfBoundsException();
        }finally {
            System.out.println("- код все равно выполнится - генерирование исключения");
        }
    }
    void method(){
        System.out.println("Оператора finally");

        try {
            methodV1();
            methodV2();
            methodV3();
            methodV4();
        }catch (ArrayIndexOutOfBoundsException e){}
    }
}

/* создание собственного класса исключения*/
class Exceptions9a extends Exception{
    Exceptions9a(){
        System.out.println("какое-то описание по умолчанию");
    }
    Exceptions9a(String desc){
        super(desc);
    }

    /* переопределение метода toString()*/
    //public String toString(){
    //  return "тут другой стиль вывода текста";
    //}
}

class Exceptions9{
    void methodV1() throws Exceptions9a{
        throw new Exceptions9a();
    }
    void methodV2() throws Exceptions9a{
        throw new Exceptions9a("текст описания собственного исключения");
    }
    void method(){
        System.out.println("Создание собственного класса исключения");

        try {
            if (new Random().nextInt(2) == 1) {
                methodV1();
            }else {
                methodV2();
            }
        }catch (Exceptions9a e){
            System.out.println("- исключение: "+e);
        }
    }
}

/* цепочки исключений*/
class Exceptions10{

    void method1(){
        NullPointerException e = new NullPointerException("верхний уровень");
        e.initCause(new ArithmeticException("причина"));
        throw e;
    }

    void method(){
        System.out.println("Цепочки исключений");

        try {
            method1();
        }catch (NullPointerException e){
            /* вывод исключения верхнего уровня*/
            System.out.println("- вывод исключения верхнего уровня: "+e);

            /* вывод исключения, ставшее причиной для исключения верхнего уровня*/
            System.out.println("- вывод исключения, ставшее причиной для исключения верхнего уровня: "+e.getCause());
        }
    }
}

/* пример цепочки исключения*/
class Exceptions11{
    private final String[] pets = {"cat", "dog"};
    private boolean flag;
    private Throwable throwable;

    private int method1(){
        System.out.print("введите число: ");
        int res;

        try {
            Scanner scanner = new Scanner(System.in);
            res = Integer.parseInt(scanner.next());
        }catch (NumberFormatException e){
            throwable = e;
            res = 0;
        }
        return res;
    }

    private int method2(){
        int res;

        try{
            res = (34 / method1()) % 2;
        }catch (ArithmeticException e){
            e.initCause(throwable);
            if(e.getCause() != null){
                flag = true;
                System.out.println("-1 первопричина: "+e.getCause());
            }
            throwable = e;
            res = 0;
        }
        return res;
    }

    private int method3(){
        int res;

        try{
            res = (34 / method2()) % 2;
        }catch (ArithmeticException e){
            e.initCause(throwable);

            if(e.getCause() != null){
                if (flag) {
                    System.out.println("-2 причина: " + e.getCause());
                }else{
                    flag = true;
                    System.out.println("-2 первопричина: "+e.getCause());
                }
            }
            throwable = e;
            res = 2;
        }
        return res;
    }

    void method(){
        System.out.println("Пример использования цепочки исключения");

        try {
            int a = method3();
            String str = pets[a];
            System.out.println("результат: " + str);
        }catch (ArrayIndexOutOfBoundsException e){
            e.initCause(throwable);

            if(e.getCause() != null){
                if (flag) {
                    System.out.println("-3 причина: " + e.getCause());
                }else{
                    flag = true;
                    System.out.println("-3 первопричина: "+e.getCause());
                }
            }
            System.out.println("-4 причина: "+e);
        }
    }
}

/* многократный перехват*/
class Exceptions12{

    void method(){
        System.out.println("Многократный перехват");

        try{
            int a = 34 / new Random().nextInt(2);
            int[] arr = {1};
            arr[1] = 47;
        }catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
            // e = new ArithmeticException(); // ошибка, переменная e неявно считается завершенной (final)
            System.out.println("- исключение: "+e);
        }catch (ClassCastException e){
            e = new ClassCastException(); // разрешено
        }
    }
}

/* окончательное повторное генерирование исключений*/
class Exceptions13{

    void method(){
        System.out.println("Окончательное повторное генерирование исключений");

        try{
            throw new NoSuchFieldException();
        }catch (ArithmeticException e){
            e = new ArithmeticException();
        }catch (final NoSuchFieldException e){
            System.out.println("- исключение: "+e);
        }
    }
}
public class Exceptions {
    public static void main(String[] args) {
        new Exceptions1().method(); System.out.println("-------------------");
        new Exceptions2().method(); System.out.println("-------------------");
        new Exceptions3().method(); System.out.println("-------------------");
        new Exceptions4().method(); System.out.println("-------------------");
        new Exceptions5().method(); System.out.println("-------------------");
        new Exceptions6().method(); System.out.println("-------------------");
        new Exceptions7().method(); System.out.println("-------------------");
        new Exceptions8().method(); System.out.println("-------------------");
        new Exceptions9().method(); System.out.println("-------------------");
        new Exceptions10().method(); System.out.println("-------------------");
        new Exceptions11().method(); System.out.println("-------------------");
        new Exceptions12().method(); System.out.println("-------------------");
        new Exceptions13().method(); System.out.println("-------------------");
    }
}
