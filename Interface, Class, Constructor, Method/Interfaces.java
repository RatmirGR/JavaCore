package Interface;

/* 1) определение интерфейса*/

interface Interface1 {
    int MAX = 0; //константа
    void getMax(); //определение метода
}

/*---------------------------------------------------------------------*/

/* 2) вложенный интерфейс*/

interface Interface2 {
    int MAX = 7;

    public interface NestedInterface{
        int MAX = 0;
        void setMax();
    }

    void getMax();
}

class ExClass2a implements Interface2.NestedInterface{
    @Override
    public void setMax() {} // реализация метода вложенного интерфейса
}

class ExClass2b implements Interface2{
    @Override
    public void getMax() { // реализация метода внешнего интерфейса
    }
}

// Выполнение:
// Interface2.NestedInterface nestedInterface = new ExClass2a();
// Interface2 interface2 = new ExClass2b();

/*---------------------------------------------------------------------*/

/* 3) определение константы*/

interface Interface3{
    int MIX = 4; // константа (неявно public final static)
}
class ExClass3 implements Interface3{
    void method(){
        System.out.println(MIX);
    }
}

/*---------------------------------------------------------------------*/

/* 4) статический метод интерфейса*/

interface Interface4{
    static void staticMethod(){
        System.out.println("text");
    }
    int notOfStaticMethod();
}

/*---------------------------------------------------------------------*/

/* 5) наследование интерфейса*/

interface Interface5a{
    default void method(){
        System.out.println("Interface5a");
    }
}
interface Interface5b{
    default void method(){
        System.out.println("Interface5b");
    }
}
interface Interface5c extends Interface5a{
    default void method(){
        System.out.println("Interface5c");
    }
    void method2();
}

/*---------------------------------------------------------------------*/

/* 6) множественное наследование интерфейсов*/

interface Interface6a{}

interface Interface6b{}

interface MyInterface2 extends Interface6a, Interface6b{
}

/*---------------------------------------------------------------------*/

/* 7) множественная реализация интерфейса*/

interface Interface7{
    int method();
}

class ExClass7a implements Interface7{
    @Override
    public int method() {
        return 34;
    }
}
class ExClass7b implements Interface7{
    @Override
    public int method() {
        return 45;
    }
}

// Выполнение:
// Interface7[] interface7 = new Interface7[2];
// interface7[0] = new ExClass7a();
// interface7[1] = new ExClass7b();
// System.out.println(interface7[0].method());
// System.out.println(interface7[1].method());

/*---------------------------------------------------------------------*/

/* 8) реализация нескольких интерфейсов*/

interface Interface8a{
    void method();
}
interface Interface8b{
    void method();
}

class ExClass8 implements Interface8a, Interface8b{
    @Override
    public void method() {
        System.out.println("ExClass8 method");
    }
}

/*---------------------------------------------------------------------*/

/* 9) реализация нескольких интерфейсов и использование super*/

interface Interface9a{
    default void method1(){}
    void method2();
}

interface Interface9b extends Interface9a{
    @Override
    default void method2() {
        Interface9a.super.method1(); //вызов метода наследуемого интерфейса
    }
}
class ExClass9 implements Interface9b{
    public void methodClass(){
        Interface9b.super.method2(); //вызов метода реализуемого интерфейса
        System.out.println("ExClass9");
    }
}

// Выполнение:
// Interface9b interface9b = new ExClass9();
// interface9b.method2();

/*---------------------------------------------------------------------*/

/* 10) Пример реализации интерфейса*/

interface Interface10{
    void setMethod(int num);
    int getMethod();
}

class ExClass10 implements Interface10{
    private int[] arr;
    private int top;

    ExClass10(int size){
        arr = new int[size];
        top = -1;
    }
    @Override
    public void setMethod(int num) {
        int[] tmp;

        if (top == arr.length - 1){
            tmp = new int[num * 2];

            System.arraycopy(arr, 0, tmp, 0, arr.length);

            if (arr.length >= 10){
                System.out.println("done");
            }
            arr = tmp;
        }
        arr[++top] = num;
    }
    @Override
    public int getMethod() {
        if (top < 0){
            System.out.println("not done");
            return 0;
        }else{
            return arr[top--];
        }
    }
}

// Выполнение:
// Interface10 interface10 = new ExClass10(5);
// for (int i = 0; i < 10; i++) interface10.setMethod(i);
// for (int i = 0; i < 10; i++) interface10.getMethod();

/*---------------------------------------------------------------------*/

/* главный интерфейс файла должен быть с модификатором public и иметь такое же имя,
* что и имя файла*/
public interface Interfaces {
    /* все переменные интерфейса неявно являются public static final*/
    int num = 4;
    /* статическая переменная неявно являются public final*/
    static int num2 = 5;
    /* все методы интерфейса неявно являются public*/
    void method();
    /* модификатор default позволяет создавать реализованные методы*/
    default void defMethod(){}
    /* модификатор private позволяет создавать реализованные методы доступные только внутри
    * интерфейсе*/
    private void prMethod(){}
    /* модификатор static позволяет создавать реализованные методы, которые можно вызывать
    * через интерфейс*/
    static void stMethod(){}
}

