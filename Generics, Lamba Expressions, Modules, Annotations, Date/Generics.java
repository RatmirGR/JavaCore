package Generics;

/* Создание обобщенного класса*/
class Generic1<T>{
    private T ob;

    Generic1(T obj){
        ob = obj;
    }

    T getMethod(){return ob;}

    void printMethod(){
        System.out.println("Generic1<T> "+ob.getClass().getSimpleName()+": "+getMethod());
    }
}

class ExClass1 {

    void method(){
        //автоупаковка значения 34 из типа int в объект типа Integer
        Generic1<Integer> genericOne = new Generic1<Integer>(34);
        //можно также задать тип явно: new MyClass<Integer>(new Integer(34)),
        // но это необязательно;

        Generic1<String> genericTwo = new Generic1<String>("Text");

        genericOne.printMethod();
        genericTwo.printMethod();

        System.out.println("--------");

        /* альтернативный способ создания объекта*/
        genericOne = new Generic1<>(34);
        genericTwo = new Generic1<>("Text");

        /* автораспаковка из типа Integer в тип int*/
        int a = genericOne.getMethod();

        System.out.println("ExGeneric1: Auto: "+a);
        //можно также записать так: int a = genericOne.getMethod().intValue();

        System.out.println("--------");

        /* обобщения не работают с примитивными типами*/
        //Generic1<int> genericError = new Generic1<>(34); //ошибка

        /* вместо этого используются оболочки типов*/
        Generic1<Integer> genericThree = new Generic1<>(34);

        // они автораспаковываются в соответствующий тип
        System.out.println("ExGeneric1: "+genericThree.getMethod());

        System.out.println("--------");

        /* обобщения различаются по аргументам типа*/
        // две ссылочных переменных могут ссылаться друг на друга,
        // т.к. у них одинаковый параметр типа - Integer
        Generic1<Integer> genericFour = new Generic1<>(34);
        Generic1<Integer> genericFive = new Generic1<>(22);
        genericFour = genericFive;
        System.out.println("ExGeneric1: "+genericFour.getMethod());

        /* в этом случае, ссылочные переменные не могут ссылаться друг на друга,
        * т.к. объекты имеют разный тип*/
        Generic1<Integer> genericInt = new Generic1<>(34);
        Generic1<Double> genericDouble = new Generic1<>(34.0);
        Generic1<Byte> genericByte = new Generic1<Byte>((byte) 34);

        //genericInt = genericDouble; //ошибка, различаются параметры типов
        //genericInt = genericByte; //ошибка, различаются параметры типов
    }
}

/* необобщенный класс*/
class NotGeneric{
    Object obj;

    NotGeneric(Object ob){
        obj = ob;
    }

    Object getMethod(){
        return obj;
    }
}

class ExClass2{

    void method(){
        NotGeneric notGenericOne = new NotGeneric(34);
        int a = (Integer) notGenericOne.getMethod();
        System.out.println("MyClassM2: "+a);

        System.out.println("--------");

        NotGeneric notGenericTwo = new NotGeneric("Text");
        String str = (String) notGenericTwo.getMethod();
        System.out.println("MyClassM2: "+str);

        notGenericOne = notGenericTwo;

        //ошибка возникает во время выполнения
        //int b = (Integer) notGenericOne.getMethod();
        //System.out.println(b);
    }
}

/* создание обобщенного класса с двумя параметрами типа*/
class Generic3<T, V>{
    T a;
    V b;

    Generic3(T ob, V obj){
        a = ob;
        b = obj;
    }

    T getMethodV(){
        return a;
    }
    V getMethodT(){
        return b;
    }
}

class ExClass3{

    void method(){
        Generic3<Integer, String> mc = new Generic3<>(34, "Text");
        // альтернативный вариант
        // MyClass3<Integer, String> mc = new MyClass3<Integer, String>(34, "Text");

        System.out.println("MyClassM3: "+mc.getMethodT());

        System.out.println("--------");

        System.out.println("MyClassM3: "+mc.getMethodV());
    }
}

/* ограниченный тип в обобщенном классе - суперкласс*/
class Generic4<T extends Number>{
    private T ob;

    Generic4(T obj){
        ob = obj;
    }

    T getMethod(){
        return ob;
    }
}

class ExClass4{

    void method(){
        Generic4<Integer> generic = new Generic4<>(34);
        System.out.println("Generic4: " + generic.getMethod().intValue());
    }
}

/* ограниченный тип в обобщенном классе - собственный класс*/
class GenericLimit{
    void printMethod(){
        System.out.println("GenericLimit");
    }
}

class Generic5<T extends GenericLimit>{
    private T ob;

    Generic5(T obj){ob = obj;}

    T getMethod(){return ob;}
}

class ExClass5{

    void method(){
        Generic5<GenericLimit> generic = new Generic5<GenericLimit>(new GenericLimit());
        generic.getMethod().printMethod();
    }
}

/* ограниченный тип в обобщенном классе - собственный интерфейс*/
interface Interface6{
    void interfaceMethod();
}

class ExClass6a implements Interface6{
    @Override
    public void interfaceMethod() {
        System.out.println("ExClass6a");
    }
}

class Generic6<T extends Interface6>{
    private T ob;

    Generic6(T obj){
        ob = obj;
    }

    T getMethod(){
        return ob;
    }
}

class ExClass6{

    void method(){
        Generic6<ExClass6a> generic = new Generic6<ExClass6a>(new ExClass6a());
        generic.getMethod().interfaceMethod();
    }
}

/* ограниченный тип в обобщенном классе - собственный класс и интерфейс*/
interface Interface7{
    int interfaceMethod(int a);
}

class SuperClass7 implements Interface7{
    @Override
    public int interfaceMethod(int a) {
        return a + 1;
    }
}

class SubClass7 extends SuperClass7{
    void setMethod(int a){
        System.out.println("SubClass7 = "+interfaceMethod(a) / 2);
    }
}

/* обобщенный класс ограничен сверху суперклассом и интерфейсом,
* т.е. можно использовать подклассы, которые наследуются от суперкласса
* и реализуют интерфейс, либо суперкласс, который сам реализует интерфейс*/
class Generic7a<T extends SuperClass7 & Interface7>{
    private T ob;

    Generic7a(T obj){
        ob = obj;
    }

    T getMethod(){
        return ob;
    }
}

// в качестве ограничителя также можно использовать параметр,
// тип V должен быть совместим с типом T, или же быть его подклассом
class Generic7b<T, V extends T>{
    Generic7b(T ob1, V ob2){ ob1 = ob2;} // можно ссылаться друг на друга
}

class ExClass7{

    void method(){
        Generic7a<SubClass7> generic = new Generic7a<SubClass7>(new SubClass7());
        generic.getMethod().setMethod(7);
    }
}

/* использования метасимвола (метасимвольный аргумент или шаблон аргумента) в обобщенном классе*/
class Generic8<T extends Number>{
    private T ob;

    Generic8(T obj){
        ob = obj;
    }

    private T getMethod(){
        return ob ;
    }

    /* метод с типом T параметра может принимать
     * в качестве аргумента только объект, относящийся к тому же типу,
     * что и вызывающий объект, т.е. если тип вызывающего объекта Integer,
     * то и тип передаваемого объета тоже должен быть Integer. Использования
     * даже типов относящиеся к классу Number также приведет к ошибке*/
    boolean setMethod(T obf){
        if (getMethod() == obf){
            return true;
        }
        return false;
    }

    /* метод с обобщенным типом параметра может принимать
    * в качестве аргумента только объект, относящийся к тому же типу,
    * что и вызывающий объект, т.е. если тип вызывающего объекта Integer,
    * то и тип передаваемого объекта тоже должен быть Integer. Использования
    * даже типов относящиеся к классу Number также приведет к ошибке*/
    boolean isMethod1(Generic8<T> ob){
        if (getMethod().intValue() == ob.getMethod().intValue()) return true;
        return false;
    }

    /* метод с метасимвольным аргументом ? позволяет исправить данную ситуацию*/
    boolean isMethod2(Generic8<?> ob){
        if (getMethod().intValue() == ob.getMethod().intValue()) return true;
        return false;
    }
}

class ExClass8{

    void method(){
        System.out.println("MyClassM8: "+new Generic8<Integer>(34).setMethod(34));
        //System.out.println(new MyClass8<Integer>(34).myMeth8a(34.0)); //ошибка

        System.out.println("MyClassM8: "+new Generic8<Integer>(34).isMethod1(new Generic8<Integer>(34)));
        //System.out.println(new MyClass8<Integer>(34).myMeth8b(new MyClass8<Double>(34.0))); //ошибка

        System.out.println("MyClassM8: "+new Generic8<Integer>(34).isMethod2(new Generic8<Integer>(34)));
        System.out.println("MyClassM8: "+new Generic8<Integer>(34).isMethod2(new Generic8<Double>(34.0))); //разрешено
    }
}

/* ограниченный метасимвол*/
class SuperClass{
    void method1(){
    System.out.println("SuperClass");
    }
}

class SubClass1 extends SuperClass{
    void method1(){
        System.out.println("SubClass1");
    }
}

class SubClass2 extends SubClass1{
    void method2(){
        System.out.println("SubClass2");
    }
}

class SubClass3 extends SubClass2{
    void method3(){
        System.out.println("SubClass2");
    }
}

class Generic9<T>{
    private T ob;

    Generic9(T obj){ob = obj;}

    /* ограниченный сверху метасимвол*/
    static void method1(Generic9<? extends SubClass1> obj1){
        obj1.ob.method1();
    }

    /* ограниченный снизу метасимвол*/
    static void method2(Generic9<? super SubClass2> obj1){
        System.out.println(obj1.ob.getClass().getSimpleName());
    }
}
class ExClass9{

    void method(){
        SuperClass exClass1 = new SuperClass();
        SubClass1 exClass2 = new SubClass1();
        SubClass2 exClass3 = new SubClass2();
        SubClass3 exClass4 = new SubClass3();

        Generic9<SuperClass> generic1 = new Generic9<>(exClass1);
        Generic9<SubClass1> generic2 = new Generic9<>(exClass2);
        Generic9<SubClass2> generic3 = new Generic9<>(exClass3);
        Generic9<SubClass3> generic4 = new Generic9<>(exClass4);

        /* объект является суперклассом для SubClass1, но не входит в верхнюю границу*/
        //Generic9.method1(generic1); //ошибка SuperClass

        /* метод имеет метасимвол ограниченный сверху классом SubClass1,
        * поэтому метод может принимать только его подклассы, либо его самого*/
        Generic9.method1(generic2); //ExClass9b
        Generic9.method1(generic3); //ExClass9c
        Generic9.method1(generic4); //ExClass9d

        System.out.println("--------");

        /* метод имеет метасимвол ограниченный снизу классом SubClass2,
         * поэтому метод может принимать только суперклассы, либо его самого*/
        Generic9.method2(generic1); //ExClass9a
        Generic9.method2(generic2); //ExClass9b
        Generic9.method2(generic3); //ExClass9c

        /* объект наследуется от класса SubClass2, но не входит в нижнюю границу*/
        //Generic9.method2(generic4); //ошибка SubClass3
    }
}

/* пример использования ограниченного метасимвола*/
class Two{
    private int x,y;

    Two(int a, int b){
        x = a; y = b;
    }

    int getX(){return x;}

    int getY(){return y;}
}

class Three extends Two{
    private int z;

    Three(int a, int b, int c){
        super(a, b); z = c;
    }

    int getZ(){return z;}
}

class Four extends Three{
    private int t;

    Four(int a, int b, int c, int d){
        super(a, b, c); t = d;
    }

    int getT(){return t;}
}

class Generic10<T extends Two>{
    private T[] ob;

    Generic10(T[] obj){ob = obj;}

    T[] getMethod(){ return ob;}
}

class ExClass10a{
    void method1(Generic10<?> ob){
        System.out.print("Two:   ");
        for (int i = 0; i < ob.getMethod().length; i++) {
            System.out.print(ob.getMethod()[i].getX()+":"+ob.getMethod()[i].getY()+" ");
        }
        System.out.println();
    }

    void method2(Generic10<? extends Three> ob){
        System.out.print("Three: ");
        for (int i = 0; i < ob.getMethod().length; i++) {
            System.out.print(ob.getMethod()[i].getX()+":"+ob.getMethod()[i].getY() +":" +ob.getMethod()[i].getZ()+" ");
        }
        System.out.println();
    }

    void method3(Generic10<? extends Four> ob){
        System.out.print("Four:  ");
        for (int i = 0; i < ob.getMethod().length; i++) {
            System.out.print(ob.getMethod()[i].getX()+":"+ob.getMethod()[i].getY()
                    +":" +ob.getMethod()[i].getZ()+":"+ob.getMethod()[i].getT()+" ");
        }
        System.out.println();
    }

    void method4(Generic10<? super Four> ob){
        System.out.print("Four:  ");
        for (int i = 0; i < ob.getMethod().length; i++) {
            System.out.print(ob.getMethod()[i].getX()+":"+ob.getMethod()[i].getY()
                    +":" +ob.getMethod()[i].getClass().getSimpleName()+" ");
        }
        System.out.println();
    }
}

class ExClass10{

    void method(){
        Two[] arrTwo = new Two[]{
                new Two(237,209),
                new Two(254,128)
        };
        Generic10<Two> genericTwo = new Generic10<Two>(arrTwo);
        new ExClass10a().method1(genericTwo);

        Three[] arrThree = new Three[]{
                new Three(17,43, 21),
                new Three(20,19,32)
        };
        Generic10<Three> genericThree = new Generic10<Three>(arrThree);
        new ExClass10a().method2(genericThree);

        Four[] arrFour = new Four[]{
                new Four(4, 1, 8, 7),
                new Four(0, 5, 3, 2)
        };

        Generic10<Four> genericFour = new Generic10<Four>(arrFour);
        new ExClass10a().method3(genericFour);

        Generic10<Three> genericFour2 = new Generic10<Three>(arrFour);
        new ExClass10a().method4(genericFour2);
    }
}

/* обобщенный метод в обычном классе*/
interface SuperClass11{
    int method1();
}

class SubClass11a implements SuperClass11{
    private int a;

    SubClass11a(int b){a = b;}

    public int method1(){return a;}
}

class SubClass11b implements SuperClass11{
    private int a;

    SubClass11b(int b){a = b;}

    public int method1(){return a;}
}

class SubClass11c{ //не является подклассом SuperClass11
    private int a;

    SubClass11c(int b){a = b;}

    public int method1(){return a;}
}

class Generic11{
    /* Тип T наследуется от класса SuperClass11, тип V наследуется от типа T, это значит, что тип V должен
    * совпадать с типом T или же быть его подклассом, а тип T, в свою очередь, должен совпадать с типом
    * SuperClass11 или же быть его подклассом, следовательно, тип T и V могут принимать совместимые типы*/
    <T extends SuperClass11, V extends T> boolean isMethod(T a, V b){ // объявления обобщенного метода
        if (a.method1() == b.method1()) return true;
        else return false;
    }
}
class ExClass11{
    void method() {
        boolean d =  new Generic11().isMethod(new SubClass11a(34), new SubClass11b(34));
        System.out.println("ExClass11: "+d);

        /* тут происходит попытка передать объект типа MyClass10c, который не является подклассом MyClass10*/
        //boolean e =  new Generic12().method2(new SubClass11c(34), new SubClass11c(34)); //ошибка, не совместимый тип
        //System.out.println("ExClass12: "+d);
    }
}

/* переопределение обобщенного метода в обобщенном классе*/
class Generic12<T>{
    protected T ob;

    T printMethod(){
        System.out.println("Generic12");
        return ob;
    }
}

class SubClass12<T> extends Generic12<T>{
    /* переопределение обобщенного метода*/
    @Override
    T printMethod(){
        System.out.println("SubClass12");
        return ob;
    }
}

class ExClass12{
    void method(){
        new SubClass12<>().printMethod();
    }
}

/* переопределение обобщенного метода в необобщенном классе*/
class NotGeneric13{
    <T> void printMethod(){
        System.out.println("NotGeneric13");
    }
}

class SubClass13 extends NotGeneric13{
    /* переопределение обобщенного метода*/
    @Override
    <T> void printMethod(){
        System.out.println("SubClass13");
    }
}

class ExClass13{
    void method(){
        new SubClass13().printMethod();
    }
}

/* неявное создание мостового метода*/
class Generic14<T>{
    protected T ob;

    T bridgeMethod(){
        return ob;
    }
}

class SubClass14 extends Generic14<Integer>{
    //перегрузка метода bridgeMethod суперкласса
    Integer bridgeMethod(){
        return ob;
    }
}

class ExClass14{
    /* неявное появление мостового метода*/
    void method(){
        System.out.println("ExClass14: "+new SubClass14().bridgeMethod());
    }
}

/* обобщенный конструктор*/
class Generic15{
    private double b;

    <T extends Number>Generic15(T a){ // обобщенный конструктор
        b = a.doubleValue() * a.doubleValue();
    }

    double getMethod(){return b;}
}

class ExClass15{
    void method(){
        System.out.println("ExClass15: "+new Generic15(34).getMethod());
    }
}

/* обобщенный интерфейс*/
interface Interface16<T extends Number>{
    boolean interfaceMethod(T ob);
}

/* класс реализующий обобщенный интерфейс должен также быть обобщенным, причем,
* если обобщенный интерфейс имеет ограниченный тип, то и обобщенный класс, также
* должен иметь соответствующий ограниченный тип*/
class Generic16<T extends Number> implements Interface16<T>{
    private T ob;

    Generic16(T obj1){ob = obj1;}

    /* реализация метода обобщенного интерфейса*/
    @Override
    public boolean interfaceMethod(T obj2) {
        if (ob.intValue() == obj2.intValue()) return true;
        else return false;
    }
}

class ExClass16{

    void method(){
        Generic16<Integer> mc12 = new Generic16<>(34);
        System.out.println("MyClassM12: "+mc12.interfaceMethod(34));
    }
}

/* пример 1 обобщенного интерфейса*/
interface GenericInterface17<T extends Comparable<T>>{
    T max();
    T min();
}
class Generic17<T extends Comparable<T>> implements GenericInterface17<T>{
    private T[] ob;

    Generic17(T[] obj){ob = obj;}

    @Override
    public T max() {
        T val = ob[0];
        for (int i = 1; i < ob.length; i++) {
            if (ob[i].compareTo(val) > 0){ val = ob[i];}
        }
        return val;
    }

    @Override
    public T min() {
        T val = ob[0];
        for (int i = 1; i < ob.length; i++) {
            if (ob[i].compareTo(val) < 0){ val = ob[i];}
        }
        return val;
    }
}

class ExClass17{

    void method(){
        Generic17<Integer> generic1 = new Generic17<>(new Integer[]{23,54,21,84,22,53});
        System.out.println("Min: "+generic1.min()+" | Max: "+generic1.max());

        Generic17<java.lang.String> generic2 = new Generic17<>(new java.lang.String[]{"ab", "fp", "qw"});
        System.out.println("Min: "+generic2.min()+" | Max: "+generic2.max());

        Generic17<Character> generic3 = new Generic17<>(new Character[]{'b', 'w', 'a', 'e'});
        System.out.println("Min: "+generic3.min()+" | Max: "+generic3.max());
    }
}

/* пример 2 обобщенного интерфейса*/
interface Interface18{
    String interfaceMethod();
}

class ImplClass implements Interface18{ // класс реализующий интерфейс Interface18
    @Override
    public String interfaceMethod(){
        return "ImplClass реализует интерфейс Interface18";
    }
}

class NotImplClass{ // класс не реализующий интерфейс Interface18
}

interface Generic18<T extends Interface18>{ // обобщенный интерфейс
    void method1(T ob);
}

class Generic18a<T extends Interface18> implements Generic18<T>{ // обобщенный класс
    @Override
    public void method1(T ob){
        System.out.println(ob.interfaceMethod());
    }
}

class ExClass18{

    void method(){
        /* ImplClass реализует интерфейс Interface18, поэтому может быть использован как тип
        * для параметра типа обобщенного класса MyGenClass, который в свою очередь реализует
        * обобщенный интерфейс Generic18. Этот интерфейс накладывает ограничения, в виде того,
        * что тип обобщенного класса, должен реализовывать интерфейс Interface18*/
        Generic18a<ImplClass> generic = new Generic18a<ImplClass>();
        generic.method1(new ImplClass());

        /* Этот класс не реализует интерфейс Interface18, поэтому его нельзя использовать как тип
        * для обобщенного класса Generic18a*/
        //Generic18a<NotImplClass> generic2 = new Generic18a<>(); //ошибка
        //generic2.method1(new NotImplClass());
    }
}

/* иерархия обобщенных классов - обобщенный суперкласс*/
class SuperGeneric19<T>{
    private T ob;

    SuperGeneric19(T obj){ ob = obj;}

    T getMethod(){return ob;}
}

/* первый вариант*/
class SubGenericV1<T> extends SuperGeneric19<T>{
    SubGenericV1(T obj1){
        super(obj1);
    }
}

/* второй вариант*/
/* обобщенный класс можно дополнять своими параметрами типа*/
class SubGenericV2<T, V> extends SuperGeneric19<T>{
    private V ob;

    SubGenericV2(T obj1, V obj2){
        super(obj1);
        ob = obj2;
    }

    V getMethod2(){return ob;}
}

class ExClass19{

    void method(){
        new SubGenericV1<>(34).getMethod();
        new SubGenericV2<>(34, "Text").getMethod2();
    }
}

/* иерархия обобщенных классов - обобщенный подкласс*/
class SuperGeneric20{ //необобщенный суперкласс
    private int a;

    SuperGeneric20(int b){
        a = b;
    }

    int getMethod(){
        return a;
    }
}

class Generic20<T> extends SuperGeneric20{ //обобщенный подкласс
    private T ob;

    Generic20(T obj, int c){
        super(c);
        ob = obj;
        System.out.println("Generic20: " + getMethod());
    }
}

class ExClass20{
    void method(){
        new Generic20<>("Text", 34);
    }
}

/* сравнения типов в иерархии обобщенных классов во время выполнения*/
class SuperGeneric21<T>{
    private T ob;

    SuperGeneric21(T obj){ob = obj;}
}

class Generic21<T> extends SuperGeneric21<T>{
    Generic21(T obj1){
        super(obj1);
    }
}

class ExClass21{

    void method(){
        SuperGeneric21<Integer> generic1 = new SuperGeneric21<>(34);
        SuperGeneric21<Integer> generic2 = new SuperGeneric21<>(47);
        SuperGeneric21<String> generic3 = new SuperGeneric21<>("Text");

        /* generic2 относится к типу класса SuperGeneric21*/
        if(generic2 instanceof SuperGeneric21){ System.out.println("generic2 instanceof SuperGeneric21 - true");}
        /* generic2 относится к типу класса SuperGeneric21*/
        if(generic2 instanceof SuperGeneric21){ System.out.println("generic2 instanceof SuperGeneric21 - true");}

        /* generic3 относится к типу класса SuperGeneric21*/
        if(generic3 instanceof SuperGeneric21){ System.out.println("generic3 instanceof SuperGeneric21 - true");}
        /* generic3 относится к типу класса SuperGeneric21*/
        if(generic3 instanceof SuperGeneric21){ System.out.println("generic3 instanceof SuperGeneric21 - true");}

        /* generic1 относится к типу класса SuperGeneric21*/
        if(generic1 instanceof SuperGeneric21){ System.out.println("generic1 instanceof SuperGeneric21 - true");}
        /* generic1 не относится к типу класса SuperGeneric21*/
        if(generic1 instanceof SuperGeneric21){ System.out.println("generic1 instanceof SuperGeneric21 - true");}

        /* попытка сравнить объект generic2 с конкретным типом обобщенного класса, а именно Generic21<Integer>*/
        /* ошибка возникает из-за того, что оператор instanceof проводит проверку во время выполнения, в то время
        * как все сведения о типе обобщенного класса удаляются еще во время компиляции, таким образом оператор
        * не сможет проверить, является ли объект экземпляром типа Generic21<Integer>, т.к. этого параметризованного
        * типа уже не будет*/
        //if(generic2 instanceof Generic21<Integer>){ System.out.println("generic1 instanceof Generic21 - true");} //ошибка
    }
}

/* базовый тип*/
class Generic22<T>{
    private T ob;

    Generic22(T obj){ob = obj;}

    T getMethod(){return ob;}
}

class ExClass22{
    void method(){
        /* передача аргумента типа, во время создания объекта*/
        /* при присвоении значений переменной, приведение типа происходит автоматически,
        * что в случае несоответствия типов приведет к ошибке во время компиляции, а не
        * во время выполнения*/
        int a = new Generic22<Integer>(34).getMethod();
        int b = new Generic22<>(47).getMethod();
        int c = new Generic22<Integer>(new Integer(34)).getMethod();

        /* создание объекта базового типа,*/
        /* параметр типа во время компиляции заменяется на тип Object, таким образом, при
        * присвоении значений переменной, приведения типа необходимо будет проводить в ручную,*/
        /* а это значит, что в случае несоответствия типов, ошибка не возникнет во время компиляции,
        а возникнет во время выполнения. Тем самым базовый тип нарушает типовую безопасность*/
        int d = (Integer) new Generic22(new Integer(34)).getMethod();
        System.out.println("ExClass22: "+d);

        //int e = (Integer) new Generic22(new Double(34.0)).getMethod(); //ошибка
        //System.out.println(e);
    }
}

/* неоднозначность и ограничения*/
class Generic23<T, V>{

    /* НЕОДНОЗНАЧНОСТЬ*/
    /* неоднозначность при перегрузке метода возникает из-за того, что компилятор не знает, будут ли переданы
    * в качестве аргумента типа разные типы. Кроме того, после компиляции параметры типов обоев методов заменяются
    * типом Object*/
    //void method1(T ob){}
    void method1(V ob){}

    /* ОГРАНИЧЕНИЯ*/
    /* 1) попытка создания обобщенного исключения и расширения класса Throwable*/
    //class MyException<T> extends Throwable{}

    /* 2) попытка создания объекта параметра типа*/
    class Generic23a<T>{
        Generic23a(){
            //T ob = new T(); //ошибка
        }
    }

    /* 3) аргумент типа передается при создании объекта, а т.к. статическая переменная или метод
    * могут быть вызваны без создания объекта, то компилятор не знает какой тип создавать*/

    /* попытка объявления статической переменной с параметром типа*/
    //static T ob; //ошибка

    /* попытка объявления статического метода с параметром типа*/
    //static T myMeth14a(){
    //  return ob;
    //}

    /*исключение составляет только статический метод, объявленный со своим паараметром типа*/
    static<T> void method2(T ob){}
    /* ----------*/

    /* 4) попытка создания массива с параметром типа*/
    //T[] obj2 = new T[5]; //ошибка, т.к. компилятору неизвестно какой тип необходимо создать

    T[] obj1; //допускается объявление ссылочной переменной с параметром типа

    void method3(T[] arr){
        obj1 = arr; //b) допускается присвоение ссылки на созданный массив
    }


    class Generic23b<T>{
        void setMethod(){}
    }

    void method4(){
        /* попытка создания массива с параметром конкретного типа*/
        //Generic23b<Integer>[] arr1 = new Generic23b<Integer>[3]; //ошибка

        /* но допускается создания массива с использованием метасимвола*/
        //Generic23b<?>[] arr2 = new Generic23b<?>[3];
    }
}

class ExClass23{

    void method(){
        Integer[] arr = new Integer[3];
        new Generic23<Integer, String>().method3(arr); //a) передача ссылки на созданный массив
    }
}

/* пример использования массива с метасимволом*/
class Generic24<T>{

    private T ob;

    Generic24(T obj){ob = obj;}

    T getMethod(){return ob;}
}

class ExClass24{

    void method(){
        Generic24<?>[] arr = new Generic24<?>[3];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Generic24<>(i);
        }

        for (Generic24<?> o : arr){ System.out.println("Generic24: "+o.getMethod());}
    }
}

public class Generics {
    public static void main(String[] args) {
        new ExClass1().method(); System.out.println("---------------------");
        new ExClass2().method(); System.out.println("---------------------");
        new ExClass3().method(); System.out.println("---------------------");
        new ExClass4().method(); System.out.println("---------------------");
        new ExClass5().method(); System.out.println("---------------------");
        new ExClass6().method(); System.out.println("---------------------");
        new ExClass7().method(); System.out.println("---------------------");
        new ExClass8().method(); System.out.println("---------------------");
        new ExClass9().method(); System.out.println("---------------------");
        new ExClass10().method(); System.out.println("---------------------");
        new ExClass11().method(); System.out.println("---------------------");
        new ExClass12().method(); System.out.println("---------------------");
        new ExClass13().method(); System.out.println("---------------------");
        new ExClass14().method(); System.out.println("---------------------");
        new ExClass15().method(); System.out.println("---------------------");
        new ExClass16().method(); System.out.println("---------------------");
        new ExClass17().method(); System.out.println("---------------------");
        new ExClass18().method(); System.out.println("---------------------");
        new ExClass19().method(); System.out.println("---------------------");
        new ExClass20().method(); System.out.println("---------------------");
        new ExClass21().method(); System.out.println("---------------------");
        new ExClass22().method(); System.out.println("---------------------");
        new ExClass23().method(); System.out.println("---------------------");
        new ExClass24().method(); System.out.println("---------------------");
    }
}
