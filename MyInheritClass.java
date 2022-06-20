/* пример 1 - наследование*/
class A{
    int i = 1; // открытый элемент суперкласса
    private int t = 3; // закрытый элемент суперкласса
}
class B extends A{
    int j;
    int getSum(){
        j = i +2; // разрешено
        //j = t + 2; // запрещено, т.к. элемент t имеет закрытый тип
        return i + j;
    }
}
class MyInClass1{
    void myMeth(){
        System.out.println("- Пример 1 - наследование");
        A a = new A();
        B b = new B();
        System.out.println(b.getSum());
    }
}

/* пример 2 - наследование и переменная суперкласса*/
class Animal{
    String color;
    void run(){
        System.out.println("run animal");
    }
}
class Cat extends Animal{
    int speed;
    void setColorCat(){
        color = "Black";
        run();
    }
    void setSpeed(int s){
        speed = s;
        System.out.println(color+" : "+speed);
    }
}
class Dog extends Animal{
    int voice;
    void setColorDog(){
        color = "White";
        run();
    }
    void setVoice(int v){
        voice = v;
        System.out.println(color+" : "+voice);
    }
}
class MyInClass2{
    void myMeth(){
        System.out.println("- Пример 2 - наследование и переменная суперкласса");
        Animal a = new Animal();
        Cat c = new Cat();
        c.setColorCat();
        c.setSpeed(3);
        Dog d = new Dog();
        d.setColorDog();
        d.setVoice(4);
        /* Переменная из суперкласса может ссылаться на объект подкласса*/
        a = new Cat();
        a = new Dog();
    }
}

/* вызов конструктора суперкласса - super*/
class Animal1{
    private int speed;
    private int age;
    Animal1(){speed = -1; age = -1;}
    Animal1(Animal1 an){speed = an.speed; age = an.age;}
    Animal1(int s, int a){speed = s; age = a;}
    Animal1(int sum){speed = age = sum;}
    int getSpeed(){
        return speed;
    }
    int getAge(){
        return age;
    }
}
class Cat1 extends Animal1{
    private int voice;
    Cat1(Cat1 ob){super(ob); voice = ob.voice;}
    Cat1(int s, int a, int v){super(s, a); voice = v;}
    Cat1(){super(); voice = -1;}
    Cat1(int sum, int v){super(sum); voice = v;}
    int getVoice(){
        return voice;
    }
}
class MyInClass3{
    void myMeth(){
        System.out.println("- Вызов конструктора суперкласса");
        Cat1 c1 = new Cat1(); // по умолчанию
        Cat1 c2 = new Cat1(12, 4); // передача 2 аргументов
        Cat1 c3 = new Cat1(23, 34, 47); // передача 3 аргументов
        Cat1 c4 = new Cat1(c2); // передача объекта в качестве аргумента
        System.out.println(c1.getSpeed()+" : "+c1.getAge() + " : "+c1.getVoice());
        System.out.println(c2.getSpeed()+" : "+c2.getAge() + " : "+c2.getVoice());
        System.out.println(c3.getSpeed()+" : "+c3.getAge() + " : "+c3.getVoice());
        System.out.println(c4.getSpeed()+" : "+c4.getAge() + " : "+c4.getVoice());
    }
}

/* обращение к элементу суперкласса, скрываемому элементом подкласса - super*/
class A1{
    int i; // элемент класса A
}
class B1 extends A1{
    int i; // элемент класса B скрывает элемент класса A, т.к. имеют одинаковые имена
    B1(int a, int b){
        super.i = a; // элемент класса A
        i = b; // элемент класса B
    }
    void getI(){
        System.out.println(super.i+" : "+i);
    }
}
class MyInClass4{
    void myMeth(){
        System.out.println("- Обращение к элементу суперкласса, скрываемому элементом подкласса");
        A1 a = new A1();
        B1 b = new B1(34, 47);
        b.getI();
    }
}

/* динамическая диспетчеризация методов*/
class A2{
    void myMeth(){ System.out.println("A2"); }
}
class B2 extends A2{
    /* переопределение метода суперкласса*/
    void myMeth(){ System.out.println("B2"); }
}
class C2 extends A2{
    /* переопределение метода суперкласса*/
    void myMeth(){ System.out.println("C2"); }
}
class MyInClass5{
    void myMeth(){
        System.out.println("Динамическая диспетчеризация методов");
        A2 r;
        r = new A2();
        r.myMeth();
        r = new B2();
        r.myMeth();
        r = new C2();
        r.myMeth();

    }
}

/* предотвращение переопределения с помощью ключевого слова final*/
class A3{
    final void meth(){
        System.out.println("Это конечный метод");
    }
}
class B3 extends A3{
    //void meth(){} // ошибка, этот метод не может быть переопределен
}
class MyInClass6{
    void myMeth(){
        System.out.println("Предотвращение переопределения с помощью ключевого слова final");
        A3 a = new A3();
        B3 b = new B3();
    }
}

/* предотвращение наследования с помощью ключевого слова final*/
final class A4{}
/* ошибка, класс A не может иметь подклассы*/
class B4 /*extends A4*/{}
class MyInClass7{
    void myMeth(){
        System.out.println("Предотвращение наследования с помощью ключевого слова final");
        A4 a = new A4();
        B4 b = new B4();
    }
}


public class MyInheritClass {
    public static void main(String[] args) {
        new MyInClass1().myMeth();
        new MyInClass2().myMeth();
        new MyInClass3().myMeth();
        new MyInClass4().myMeth();
        new MyInClass5().myMeth();
        new MyInClass6().myMeth();
        new MyInClass7().myMeth();
    }
}
