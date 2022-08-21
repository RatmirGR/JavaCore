package Object;

public class Objects {

    /* 1) использование метода clone(), определенного в классе Object*/

    /* пример 1 - вызов метода clone() из другого метода*/
    void exampleMethod1a(){

        class ExClass implements Cloneable{
            int a;
            double b;

            /* в этом методе вызывается метод clone() из класса Object*/
            ExClass cloneObject(){
                try{
                    /* вызвать метод clone() из класса Object*/
                    return (ExClass) super.clone();
                }catch(CloneNotSupportedException e){
                    System.out.println("- клонирование невозможно");
                    return this;
                }
            }
        }

        System.out.println("Использование метода clone(), определенного в классе Object - Пример 1");

        ExClass ob1 = new ExClass();
        ob1.a = 34;
        ob1.b = 47.3;

        ExClass ob2 = ob1.cloneObject(); // клонирование объекта exClass

        System.out.println("- ob1: " + ob1.a + " " + ob1.b);
        System.out.println("- ob2: " + ob2.a + " " + ob2.b);
    }

    /* пример 2 - переопределение метода clone()*/

    void exampleMethod1b() {

        class ExClass implements Cloneable {
            int a;
            double b;

            /* метод clone() переопределяется как public*/
            public Object clone() {
                try {
                    /* вызов метода clone() из класса Object()*/
                    return super.clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println("клонирование невозможно");
                    return this;
                }
            }
        }

        System.out.println("Использование метода clone(), определенного в классе Object - пример 2");

        ExClass ob1 = new ExClass();
        ob1.a = 34;
        ob1.b = 47.3;

        /* здесь метод clone() вызывается непосредственно*/
        ExClass ob2 = (ExClass) ob1.clone(); // клонирование объекта ob1

        System.out.println("- ob1: " + ob1.a + " " + ob1.b);
        System.out.println("- ob2: " + ob2.a + " " + ob2.b);
    }

    /*---------------------------------------------------------------------*/

    /* 2) использование метода equals и hashCode*/

    /* для правильной работы методов equals и hashCode, их необходимо переопределить*/

    void exampleMethod2(){

        class User{
            private String name;

            User(String name){
                this.name = name;
            }

            void setName(String name){
                this.name = name;
            }

            String getName(){
                return name;
            }

            /* переопределение метода equals класса Object*/
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return name.equals(user.name);
            }

            /* переопределение метода hashCode класса Object*/
            @Override
            public int hashCode() {
                return java.util.Objects.hash(name);
            }
        }

        User user1 = new User("Tom");
        User user2 = new User("Tom");
        User user3 = user1;

        /* оператор равно сравнивает только ссылки*/
        System.out.println("user1 == user2: " + (user1 == user2));
        System.out.println("user1 == user3: " + (user1 == user3));

        /* оператор equals сравнивает содержимое объектов*/
        System.out.println("user1.equals(user2): " + (user1.equals(user2)));
        System.out.println("user1.equals(user3): " + (user1.equals(user3)));

        /* оператор hashCode возвращает числовое значение фиксированной длины*/
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
    }

    /*---------------------------------------------------------------------*/

    /* 3) использование метода toString*/

    /* метод toString(), возвращающий символьную строку описывающую объект*/

    void exampleMethod3(){

        class User{
            private String name;

            User(String name){
                this.name = name;
            }

            void setName(String name){
                this.name = name;
            }

            String getName(){
                return name;
            }

            /* переопределение метода toString класса Object*/
            @Override
            public String toString() {
                return "User{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }

        User user = new User("Tom");
        System.out.println(user);
    }

    /*---------------------------------------------------------------------*/

    /* 4) использование метода finalize*/

    /* метод finalize() нужен для того, чтобы выполнить высвобождения ресурсов
    * (например: закрытие потоков), перед удалением объектов, которые эти ресурсы занимают.
    * Примечание: начиная с Java 9 данный метод не рекомендуется к использованию*/

    void exampleMethod4(){

        class User{
            private String name;

            User(String name){
                this.name = name;
            }

            void setName(String name){
                this.name = name;
            }

            String getName(){
                return name;
            }

            @Override
            protected void finalize(){
                System.out.println("Тут высвобождаются ресурсы");
            }
        }

        User user = new User("Tim");
        user = null;

        /* метод gc дает возможность запросить сборку мусора, но JVM сама решает выполнять ли запрос*/
        System.gc();
    }

    /*---------------------------------------------------------------------*/

    /* 5) использование метода wait и notify*/

    /* методы wait(), wait(long timeout) и wait(long timeout, int nanos) используются
    * для освобождения монитора и перевода вызывающего потока в состояние ожидания до тех пор,
    * пока другой поток не вызовет метод notify() или не истечет указанное время*/

    /* метод notify() используется для продолжения работы потока, у которого ранее был вызван
    * метод wait()*/

    /* метод notifyAll() используется для продолжения работы всех потоков, у которых ранее был вызван
     * метод wait()*/

    /* Примечание: Все эти методы вызываются только из синхронизированного блока или метода*/

    void exampleMethod5(){

        class Store{
            private boolean flag = false;

            public synchronized void set(){
                while (flag){
                    try{
                        wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                flag = true;
                System.out.println("Consumer set 1");
                notify();
            }

            public synchronized void get(){
                while (!flag){
                    try{
                        wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                flag = false;
                System.out.println("Producer get 1");
                notify();
            }
        }

        class Producer implements Runnable{
            final Store store;

            Producer(Store store){
                this.store = store;
            }

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    store.set();
                }
            }
        }

        class Consumer implements Runnable{
            final Store store;

            Consumer(Store store){
                this.store = store;
            }

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    store.get();
                }
            }
        }

        Store store = new Store();
        new Thread(new Producer(store)).start();
        new Thread(new Consumer(store)).start();
    }

    /*---------------------------------------------------------------------*/

    /* 6) использование метода getClass*/

    /* метод getClass предоставляет характеристики того класса, экземпляром которого является объект.
    *   Он предоставляет следующую информацию:
    *   - является ли класс интерфейсом, массивом или примитивным типом;
    *   - каков супер класс объекта;
    *   - каково имя класса;
    *   - какие в нем конструкторы, поля, методы и вложенные классы.

    * В классе Сlass нет конструкторов. Экземпляр этого класса создается исполняющей системой Java
    * во время загрузки класса и предоставляется методом getClass() класса Object*/

    void exampleMethod6(){

        class User{
            private String name;
            private int age;

            User(String name, int age){
                this.name = name;
                this.age = age;
            }

            String getName(){
                return name;
            }
        }

        User user = new User("Tom", 34);
        System.out.println(user.getName());

        Class<?> cl = user.getClass();
        System.out.println(cl.getSimpleName());
    }

    public static void main(String[] args) {
        Objects objects = new Objects();
        objects.exampleMethod1a();
       objects.exampleMethod1b();
        objects.exampleMethod2();
        objects.exampleMethod3();
        objects.exampleMethod4();
        objects.exampleMethod5();
        objects.exampleMethod6();

        /* Object и массивы*/
        Object[] arrInt = new Integer[4];
        Object[] arrString = new String[4];
        Object[] arrOb = new Object[4];
    }
}
