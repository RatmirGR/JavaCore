package Class.Projects;

public class Classes {

    /* 1) объявление класса*/

    void exampleMethod1(){

        class ExampleClass{

            /* нежелательно использовать публичные переменные*/
            public int a = 4; //недоступен для других пакетов

            /* принадлежат объекту */
            private int aValue = 1; // переменная класса
            private final int B_VALUE = 2; // завершенная переменная класса (Константа)

             /* принадлежат классу*/
            private static int cValue = 3; // статическая переменная класса
            private final static int D_VALUE = 4; // завершенная статическая переменная класса (Константа)

            {
                // блок класса
            }

            static {
                // статический блок класса
            }

            ExampleClass(){} // конструктор класса (без параметров)
            ExampleClass(int a){} // конструктор класса (с параметрами)

            /* принадлежат объекту */
            void method(){ // метод класса (без параметров)
                int e = 5; // локальная переменная
            }

            void method(int a){ // метод класса (с параметрами)
                int e = 6;
            }

            String method(String str, int a){ // возвращающий метод класса
                return str;
            }

            /* принадлежат классу*/
            static void method(int a, int b){}
            public static String method(int c, String str){ // возвращающий метод класса
                return str;
            }
        }
    }

    /*---------------------------------------------------------------------*/

    /* 2) вложенный класс (статический)*/

    void exampleMethod2(){

        class ExampleClass{

            int notAStaticVariable = 1;
            static int staticVariable = 2;
            void notAStaticMethod(){}
            static void staticMethod(){}

            /* вложенный класс (статический)*/
            static class StaticNestedClass{

                void method(){
                    /* обращаться к нестатическим элементам внешнего класса,
                    необходимо через объект*/
                    ExampleClass exampleClass = new ExampleClass();
                    exampleClass.notAStaticVariable = 4;
                    exampleClass.notAStaticMethod();

                    /* обращаться к статическим элементам внешнего класса
                    можно напрямую*/
                    staticVariable = 5;
                    staticMethod();

                    /* или через объект*/
                    ExampleClass exampleClass1 = new ExampleClass();
                    exampleClass1.staticVariable = 5;
                    exampleClass1.staticMethod();
                }
            }
        }

        /* создание объекта вложенного класса*/
        ExampleClass.StaticNestedClass staticClass = new ExampleClass.StaticNestedClass();
        staticClass.method();

        /* создание объекта внешнего класса*/
        ExampleClass exampleClass = new ExampleClass();
        exampleClass.notAStaticMethod();
    }

    /*---------------------------------------------------------------------*/

    /* 3) внутренний класс (нестатический)*/

    void exampleMethod3(){

        class ExampleClass {

            int notAStaticVariable = 1;
            static int staticVariable = 2;
            void notAStaticMethod() {}
            static void staticMethod() {}

            class InnerClass {

                void method() {
                /* обращаться к статическим и нестатическим элементам
                внешнего класса можно напрямую*/
                    notAStaticVariable = 4;
                    notAStaticMethod();
                    staticVariable = 4;
                    staticMethod();

                    /* или через объект*/
                    ExampleClass exampleClass = new ExampleClass();
                    exampleClass.notAStaticVariable = 4;
                    exampleClass.notAStaticMethod();
                    exampleClass.staticVariable = 4;
                    exampleClass.staticMethod();
                }
            }

            void createInnerObject(){
                InnerClass innerClass = new InnerClass();
                innerClass.method();
            }
        }

        /*создание объекта внутреннего класса*/
        ExampleClass exampleClass = new ExampleClass();
        exampleClass.createInnerObject();

        //ExampleClass.InnerClass staticClass = new ExampleClass().InnerClass(); // так нельзя создавать

        /* создание объекта внешнего класса*/
        ExampleClass exampleClass1 = new ExampleClass();
        exampleClass.notAStaticMethod();
    }

    /*---------------------------------------------------------------------*/

    /* 4) использование модификатора transient*/

    void exampleMethod4(){

        class ExampleClass{
            private int a;

            /* модификатор transient указывает на то, что поле не должно быть сериализовано*/
            private transient int b;

            ExampleClass(int a, int b){
                this.a = a;
                this.b = b;
            }

            public int getA(){
                return a;
            }
            public int getB(){
                return b;
            }
        }

        ExampleClass exampleClass1 = new ExampleClass(1, 2);
        ExampleClass exampleClass2 = new ExampleClass(2, 3);
        System.out.printf("%d, %d\n", exampleClass1.getA(), exampleClass1.getB());
        System.out.printf("%d, %d\n", exampleClass2.getA(), exampleClass2.getB());
    }

    /*---------------------------------------------------------------------*/

    /* 5) использование модификатора volatile*/

   void exampleMethod5() {

       class ExampleClass {

           class VClass{

               /* модификатор volatile указывает на то, что операции над этим полем являются атомарными (неделимыми).
                * Таким образом, результат записи значения в эту переменную одним потоком будет виден
                * всем другим потокам, которые используют ее для чтения*/
               private volatile int count = 0;

               void method(){
                   VClass vClass = new VClass();
                   ThreadClass1 threadClass1 = new ThreadClass1(vClass);
                   ThreadClass2 threadClass2 = new ThreadClass2(vClass);
                   threadClass1.start();
                   threadClass2.start();
               }
           }

           class ThreadClass1 extends Thread {

               VClass vClass;

               ThreadClass1(VClass vClass) {
                   this.vClass = vClass;
               }

               @Override
               public void run() {
                   while (vClass.count < 200){
                       System.out.printf("thread name: %s, count: %d\n", getName(), vClass.count);
                       vClass.count++;
                   }
               }
           }

           class ThreadClass2 extends Thread {

               VClass vClass;

               ThreadClass2(VClass vClass) {
                   this.vClass = vClass;
               }

               @Override
               public void run() {
                   while (vClass.count < 200){
                       System.out.printf("thread name: %s, count: %d\n", getName(), vClass.count);
                       vClass.count++;
                   }
               }
           }

           void startThread(){
               VClass vClass = new VClass();
               vClass.method();
           }
       }

       ExampleClass exampleClass = new ExampleClass();
       exampleClass.startThread();
   }

    /*---------------------------------------------------------------------*/

    /* 6) использование ключевого слова assert*/

    void exampleMethod6() {

        class ExampleClass {

            /* примечание: чтобы разрешить проверку утверждения во время выполнения, следует
            * указать параметр -ea в командной строке*/

            void method() {
                int n = 3;
                for (int i = 0; i < 10; i++) {
                    n--;
                  //  assert n > 0; // не подтвердится, если n == 0
                    System.out.println("n равно " + n);
                }
            }
        }

        ExampleClass exampleClass = new ExampleClass();
        exampleClass.method();
    }

    /*---------------------------------------------------------------------*/

    public static void main(String[] args) {
        Classes classes = new Classes();
        classes.exampleMethod1();
        classes.exampleMethod2();
        classes.exampleMethod3();
        classes.exampleMethod4();
        classes.exampleMethod5();
        classes.exampleMethod6();

        /*------------------------------------------------*/

        /* использование командной строки*/

        /* вывод всех аргументов командной строки*/
        for(int i = 0; i < args.length; i++) System.out.println("args["+i+"]: " + args[i]);
    }
}
