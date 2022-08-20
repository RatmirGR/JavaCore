package Construct.projects;

public class Constructs {

    /* 1) объявление конструктора*/

    void exampleMethod1(){

        class Example {

            /*конструктор по умолчанию создается компилятором,
            * в случае если явно не указан конкретный конструктор*/

            /*конструктор без параметров*/
            Example() {
                System.out.println("Constructor Example()");
            }

            /*конструктор с параметрами*/
            Example(int a, String str) {
                System.out.printf("Constructor Example(int %d, String %s\n", a, str);
            }

        }

        new Example();
        new Example(3, "Text");
    }

    /*---------------------------------------------------------------------*/

    /* 2) перегрузка конструктора*/

    void exampleMethod2(){

        class Example {

            Example(){
                System.out.println("Constructor Example()");
            }
            Example(int a){
                System.out.printf("Constructor Example(int %d)\n", a);
            }
            Example(int a, String str) {
                System.out.printf("Constructor Example(int %d, String %s\n", a, str);
            }

        }

        new Example();
        new Example(3);
        new Example(3, "Text");
    }

    /*---------------------------------------------------------------------*/

    /* 3) передача ссылочной переменной параметру конструктора*/

    void exampleMethod3(){

        class Example1{
            Example1(){
                System.out.println("Constructor Example1()");
            }
        }

        class Example2{
            Example2(Example1 ex){
                System.out.printf("Constructor Example2(Example1 %s)\n", ex);
            }
        }

        class Example {
            Example2 example2 = new Example2(new Example1());
        }

        new Example();
    }

    /*---------------------------------------------------------------------*/

    /* 4) конструктор и this*/

    void exampleMethod4(){

        class Example{

            Example(int a){
                System.out.printf("Constructor Example(int %d)\n", a);
            }

            Example(int a, int b){
                this(a); //обращение к своему конструктору с подходящей сигнатурой
                System.out.printf("Constructor Example(int %d, int %d)\n", a, b);
            }
        }

        new Example(3,5);
    }

    /*---------------------------------------------------------------------*/

    /* 5) конструктор и super*/

    void exampleMethod5(){

        class Parent{
            Parent(int a, int b){
                System.out.printf("Constructor Parent(int %d, int %d)\n", a, b);
            }
        }

        class Child extends Parent{

            Child(int a, int b, int c){
                super(a, b);
                System.out.printf("Constructor Child(int %d, int %d, int %d)\n", a, b, c);
            }
        }

        new Child(3, 5, 8);
    }

    /*---------------------------------------------------------------------*/


    /* 6) порядок выполнения конструкторов*/

    void exampleMethod6(){

        class Parent {

            /* если конструктор суперкласса объявлен неявно или явно, но без параметров,
             * то использование оператора super необязательно*/
            //Parent(){}

            /* если конструктор принимает значений, то
             * и оператор super также должен принимать значения*/
            Parent(int a, int b){
                System.out.printf("Constructor Parent(int %d, int %d)\n", a, b);
            }
        }

        class Child extends Parent{
            Child(int a, int b, int c){
                super(a, b);
                System.out.printf("Constructor Child(int %d, int %d, int %d)\n", a, b, c);
            }
        }

        new Child(3, 5, 8);
    }

    /*---------------------------------------------------------------------*/

    /* 7) порядок выполнения конструкторов при наследовании*/

    void exampleMethod7(){

        /* сначало вызывается конструктор класса Parent*/
        class Parent{
            Parent(){
                System.out.println("Parent");
            }
        }

        /* затем вызывается конструктор класса Child1*/
        class Child1 extends Parent{
            Child1(){System.out.println("Child1");}
        }

        /* затем вызывается конструктор класса Child2*/
        class Child2 extends Child1{
            Child2(){System.out.println("Child2");}
        }

       new Child2();
    }

    /*---------------------------------------------------------------------*/

    /* 8) доступ конструктора*/

    void exampleMethod8(){

        class Example{

            Example(int a){} // пакетный доступ
            public Example(double b){} // публичный доступ
            protected Example(char c){} // защищенный доступ
            private Example(String s){} // приватный доступ
        }

        new Example(5);
        new Example(3.0);
        new Example('a');
        new Example("Text");
    }


    public static void main(String[] args) {
        Constructs construct = new Constructs();
        construct.exampleMethod1();
        construct.exampleMethod2();
        construct.exampleMethod3();
        construct.exampleMethod4();
        construct.exampleMethod5();
        construct.exampleMethod6();
        construct.exampleMethod7();
        construct.exampleMethod8();
    }
}
