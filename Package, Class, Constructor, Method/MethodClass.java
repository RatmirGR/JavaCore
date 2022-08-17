package Method;

public class MethodClass {

    /* 1) передача данных, с примитивным типом параметра*/

    void exampleMethod1(){
        int x = 7;
        System.out.println(x);
        MethodClass.setPrimitiveValue(x);
        System.out.println(x);
    }

    static void setPrimitiveValue(int a){
        a = 5;
    }

    /*---------------------------------------------------------------------*/

    /* 2) передача данных, со ссылочным типом параметра*/

    void exampleMethod2(){
        int[] x = {7};
        System.out.println(x[0]);
        MethodClass.setReferenceValue(x);
        System.out.println(x[0]);
    }

    static void setReferenceValue(int[] a){
        a[0] = 5;
    }

    /*---------------------------------------------------------------------*/

    /* 3) передача аргумента в виде объекта */

    void exampleMethod3(){
        ExClass1 exClass1 = new ExClass1();
        exClass1.myMeth();

        ExClass2 exClass2 = new ExClass2();
        /* в качестве аргумента передается объект*/
        exClass2.myMeth(exClass1);
    }

    class ExClass1 {
        void myMeth() {
            System.out.println("ExClass1");
        }
    }
    class ExClass2{
        void myMeth(Object ob){
            System.out.println("ExClass2 "+ob.getClass());
        }

    }

    /*---------------------------------------------------------------------*/

    /* 4) перегрузка метода*/

    /* перегрузка метода - это процесс, при котором система использует тип и/или количество аргументов
    * метода для определения нужного варианта. Перегружаемый метод должен иметь одно имя, но разный тип
    * параметров и/или количество этих параметров*/

    void exampleMethod4(){
        method(5);
        method(5.0);
        method(3, 5);
        method(3.0, 5);
    }

    /* если нужного типа аргумента нет, то система пытается найти подходящий тип.
     * Если находит, то, в таком случае, происходит автоматическое преобразование типа аргумента
     * к подходящему типу параметра. Тип int преобразуется к типу double и выбирается
     * соответствующий метод*/
    void method(double a){ //сюда передается аргумент, преобразованный из типа int к типу double
        System.out.println(a);
    }
    void method(int a, int b){}
    void method(double a, int b){}

    /*---------------------------------------------------------------------*/

    /* 5) переопределение метода*/

    void exampleMethod5(){
        Parent parent = new Parent();
        parent.method();

        Child1 child = new Child1();
        child.method();
    }

    class Parent{
        void method(){
            System.out.println("Parent method");
        }
    }
    class Child1 extends Parent {
        @Override
        void method() {
            System.out.println("Child method");
        }
    }

    /*---------------------------------------------------------------------*/

    /* 6) абстрактный метод*/

    void exampleMethod6(){
        // AClass aClass = new AClass(); // ошибка, нельзя создать объект абстрактного класса
        Child2 child = new Child2();
        child.method(); // вызов метода суперкласса
        child.aMethod(); // вызов реализованного абстрактного класса
    }

    abstract class AClass{
        void method(){
            System.out.println("AClass method");
        }
        /* абстрактный метод*/
        abstract void aMethod();
    }

    class Child2 extends AClass {
        @Override
        void aMethod(){
            System.out.println("Child2 aMethod");
        }
    }

    /*---------------------------------------------------------------------*/

    /* 7) статический метод*/

    void exampleMethod7(){
        StClass sClass = new StClass();
        sClass.method();

        /* статический метод привязан к классу, а не к объекту. Следовательно, статический метод
        * может быть вызван до создания объекта.*/
        /* вызов статического метода через класс*/
        StClass.sMethod();

        /* Также статический метод может быть вызван через объект, т.к. на момент создания объекта
        * этот метод уже существует*/
        /* вызов статического метода через объект*/
        sClass.sMethod();
    }

    class StClass{
        void method(){
            System.out.println("SClass method");
        }

        /* статический метод*/
        static void sMethod(){
            System.out.println("SClass sMethod");
        }
    }

    /*---------------------------------------------------------------------*/

    /* 8) содержание метода*/

    void exampleMethod8(){
        int a = 3;
        {
            int b = 0;
        }
        class SubClass{
            void method(){
                System.out.println("SubClass method");
            }
        }
        new SubClass().method();
    }

    /*---------------------------------------------------------------------*/

    /* 9) метод с аргументами переменной длины*/

    void exampleMethod9(){
        VClass vClass = new VClass();
        vClass.method1(1, 2, 3, 4);
        vClass.method2("Text", 2 ,3 ,4);
    }

    class VClass{
        void method1(int ... c){
            System.out.println("VClass method1");
        }
        void method2(String a, int ... c){
            System.out.println("VClass method2");
        }
    }

    /*---------------------------------------------------------------------*/

    /* 10) перегрузка метода с аргументами переменной длины*/

    void exampleMethod10(){
        OClass oClass = new OClass();
        oClass.method1(5);
        oClass.method1("Text", 5);
        oClass.method1(true,"Text", 5);

        // oClass.method2(); // возникает неопределенность, вызвать int ... c или boolean ... c?

        //oClass.method3(5); // возникает неопределенность
        //oClass.method3(1, 2, 3, 4, 5); // возникает неопределенность
    }

    class OClass{
        void method1(int ... c){
            System.out.println("OClass method1 ... c");
        }
        void method1(String a, int ... c){
            System.out.println("OClass method1 a, ... c");
        }
        void method1(boolean a, String b, int ... c){
            System.out.println("OClass method1 a, b, ... c");
        }

        /* возникает неопределенность, если не передать аргумент,
         * т.к. неизвестно какой тип метода вызывать*/
        void method2(int ... c){}
        void method2(boolean ... c){}

        /* возникает неопределенность, если передать один или несколько аргументов,
         * т.к. неизвестно какой метод вызывать*/
        void method3(int ... c){}
        void method3(int a, int ... c){}
    }

    /*---------------------------------------------------------------------*/

    /* 11) завершенный метод */

    /* метод объявленный с модификатором final нельзя переопределить*/

    void exampleMethod11(){
        FClass fClass = new FClass();
        fClass.oMethod();

        /* вызов завершенного метода*/
        fClass.fMethod();
    }

    class FClass{
        void oMethod(){
            System.out.println("FClass method");
        }

        /* завершенный метод*/
        final void fMethod(){
            System.out.println("FClass fMethod");
        }
    }

    class OClass2 extends FClass {
        @Override
        void oMethod(){
            System.out.println("OClass2 oMethod");
        }

        //void fMethod(){} //нельзя переопределить
    }

    /*---------------------------------------------------------------------*/

    /* 12) возвращающий метод */

    void exampleMethod12(){
        RClass rClass = new RClass();
        rClass.method();
        int a = rClass.rMethod1();
        String str = rClass.rMethod2();
        RClass rClass2 = rClass.rMethod3();
        RClass rClass3 = rClass.rMethod4();

        new RClass2().rMethod1().method();
    }

    /* варианты возвращения значений*/
    class RClass{
        /* тип void не возвращает значения*/
        void method(){
            System.out.println("RClass method");
        }

        /* возвращение примитивного значения*/
        int rMethod1(){
            return 5;
        }

        /* возвращение ссылочного значения*/
        String rMethod2(){
            return "Text";
        }

        /* возвращение ссылочного значения*/
        RClass rMethod3(){
            return new RClass();
        }

        /* возвращение ссылочного значения*/
        RClass rMethod4(){
            return new RClass().rMethod3().rMethod3();
        }
    }

    class RClass1{
        void method(){
            System.out.println("RClass1 method");
        }
    }

    class RClass2{
        RClass1 rMethod1(){
            return new RClass1();
        }
    }

    /*---------------------------------------------------------------------*/

    /* 13) рекурсия*/

    void exampleMethod13(){
        Recursive recursive = new Recursive();
        recursive.recMethod(5);

        Iterative iterative = new Iterative();
        iterative.iterMethod(5);
    }

    // рекурсивный вариант
    class Recursive{
        int recMethod(int a){
            if (a == 1) return 1;
            else return recMethod(a - 1) * a;
        }
    }

    // итерационный вариант
    class Iterative {
        int iterMethod(int a) {
            int b = 1;
            if (a == 1) return 1;
            else {
                while (a > 1) {
                    b *= a;
                    a--;
                }
            }
            return b;
        }
    }

    /*---------------------------------------------------------------------*/

    /* 14 динамическая диспетчеризация методов*/

    void exampleMethod14(){
        DParent dParent;

        dParent = new DParent();
        dParent.method();

        dParent = new DChild1();
        dParent.method();

        dParent = new DChild2();
        dParent.method();

    }

    class DParent{
        void method(){
            System.out.println("DParent method");
        }
    }

    class DChild1 extends DParent{
        @Override
        void method(){
            System.out.println("DChild1 method");
        }
    }

    class DChild2 extends DParent{
        @Override
        void method(){
            System.out.println("DChild2 method");
        }
    }

    /*---------------------------------------------------------------------*/

    /* 15) синхронизированный метод*/

    void exampleMethod15(){
        SynClass synClass = new SynClass();

        ThreadClass thread1, thread2, thread3;

        thread1 = new ThreadClass(synClass, "Тут находится", false);
        thread2 = new ThreadClass(synClass, "не синхронизированный", false);
        thread3 = new ThreadClass(synClass, "метод!", false);

        try{
            thread1.t.join();
            thread2.t.join();
            thread3.t.join();
        }catch (Exception e){}

        System.out.println("--------------------");

        thread1 = new ThreadClass(synClass, "Тут находится", true);
        thread2 = new ThreadClass(synClass, "синхронизированный", true);
        thread3 = new ThreadClass(synClass, "метод!", true);

        try{
            thread1.t.join();
            thread2.t.join();
            thread3.t.join();
        }catch (Exception e){}
    }

    class ThreadClass implements Runnable{
        Thread t;
        String str;
        SynClass sClass;
        boolean flag;
        ThreadClass(SynClass sClass, String str, boolean flag){
            this.sClass = sClass;
            this.str = str;
            this.flag = flag;
            t = new Thread(this);
            t.start();
        }
        @Override
        public void run() {
            if (flag) sClass.synMethod(str);
            else sClass.method(str);
        }
    }

    class SynClass{
        void method(String str){
            System.out.print("["+str);

            try {
                Thread.sleep(1000);
            } catch (Exception e){}

            System.out.println("]");
        }

        synchronized void synMethod(String str){
            System.out.print("["+str);

            try {
                Thread.sleep(1000);
            } catch (Exception e){}

            System.out.println("]");
        }
    }


    /*---------------------------------------------------------------------*/

    public static void main(String[] args) {
        MethodClass cMethod = new MethodClass();
        cMethod.exampleMethod1();
        cMethod.exampleMethod2();
        cMethod.exampleMethod3();
        cMethod.exampleMethod4();
        cMethod.exampleMethod5();
        cMethod.exampleMethod6();
        cMethod.exampleMethod7();
        cMethod.exampleMethod8();
        cMethod.exampleMethod9();
        cMethod.exampleMethod10();
        cMethod.exampleMethod11();
        cMethod.exampleMethod12();
        cMethod.exampleMethod13();
        cMethod.exampleMethod14();
        cMethod.exampleMethod15();
    }
}
