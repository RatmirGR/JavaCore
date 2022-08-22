package Annotations;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 1) создание аннотации*/
@interface Annotation1{
    int annMethod1();
    String annMethod2();
}

/* 1a) аннотирование класса*/
@Annotation1(annMethod1 = 25, annMethod2 = "Text Class")
class ExClass1{
    /* аннотирование поля*/
    @Annotation1(annMethod1 = 34, annMethod2 = "Text Field")
    String str = "Text";

    /* аннотирование конструктора*/
    @Annotation1(annMethod1 = 43, annMethod2 = "Text Constructor")
    ExClass1(){} //конструктор что-то делает

    /* аннотирование метода*/
    @Annotation1(annMethod1 = 52, annMethod2 = "Text Method")
    void method(){} //метод что-то делает
}

/*---------------------------------------------------------------------*/

/* 2) создания правила для аннотации*/

/* аннотация Retention задает время жизни аннотации. RetentionPolicy является
* (enum) перечислением*/

/* - RetentionPolicy.CLASS - указывает на то, что аннотации должны быть записаны компилятором
* в файл класса, но не должны сохраняться виртуальной машиной во время выполнения*/

/* - RetentionPolicy.RUNTIME - указывает на то, что аннотации должны быть записаны компилятором
* в файл класса и сохранены виртуальной машиной во время выполнения, чтобы их можно было читать рефлексивно*/

/* - RetentionPolicy.SOURCE - указывает на то, что аннотации должны быть отброшены компилятором*/

@Retention(RetentionPolicy.RUNTIME)
@interface Annotation2{
    String annMethod();
}

class ExClass2 {
    /* аннотирование метода*/
    @Annotation2(annMethod = "ExClass2: Method")
    public void method(){} //метод что-то делает
}

/*---------------------------------------------------------------------*/

/* 3) получения аннотации*/

/* создания правила для аннотации*/
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation3{
    String annMethod();
}
/* аннотирование класса*/
@Annotation3(annMethod = "Class")
class ExClass3a{
    /* аннотирование поля*/
    @Annotation3(annMethod = "Field")
    public String str = "Text";

    /* аннотирование конструктора*/
    @Annotation3(annMethod = "Constructor")
    public ExClass3a(){} //конструктор что-то делает

    /* аннотирование метода*/
    @Annotation3(annMethod = "Method")
    public void method1(){} //метод что-то делает
}
class ExClass3 {
    void method() {
        try{
            /* использования рефлексии*/
            ExClass3a exClass = new ExClass3a();
            Class<?> c = exClass.getClass();

            /* получение аннотации класса*/
            Annotation3 mClass = c.getAnnotation(Annotation3.class);
            System.out.println("ExClass3 Class: " + mClass.annMethod());

            /* получение аннотации поля*/
            Field f = c.getField("str");
            Annotation3 mField = f.getAnnotation(Annotation3.class);
            System.out.println("ExClass3 Field: " + mField.annMethod());

            /* получение аннотации конструктора*/
            Constructor con = c.getConstructor();
            Annotation3 mConstructor = (Annotation3) con.getAnnotation(Annotation3.class);
            System.out.println("ExClass3 Constructor: " + mConstructor.annMethod());

            /* получение аннотации метода*/
            Method m = c.getMethod("method1");
            Annotation3 mMethod = m.getAnnotation(Annotation3.class);
            System.out.println("ExClass3 Method: " + mMethod.annMethod());
        }catch(Exception e){e.printStackTrace();}
    }
}

/*---------------------------------------------------------------------*/

/* 4) получения аннотации метода, у которого есть параметры*/

/* создания правила для аннотации*/
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation4{
    String annMethod();
}
class ExClass4a {
    /* аннотирование метода с параметрами*/
    @Annotation4(annMethod = "ExClass4a: Text")
    public void method1(String str, int num){} //метод что-то делает
}
class ExClass4 {
    void method() {
        try{
            /* использования рефлексии*/
            ExClass4a exClass = new ExClass4a();
            Class<?> c = exClass.getClass();

            /* методу getMethod, кроме имени метода для которого необходимо создать объект, передаются два аргумента,
             * представляющие объект соответствующего типа (это String и int)*/
            Method m = c.getMethod("method1", String.class, int.class);

            /* получения аннотации*/
            Annotation4 anno = m.getAnnotation(Annotation4.class);
            System.out.println(anno.annMethod());
        }catch(NoSuchMethodException e){e.printStackTrace();}
    }
}

/*---------------------------------------------------------------------*/

/* 5) получения всех аннотаций*/

/* создания правила для аннотации*/
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation5{
    String description();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation5a{
    int count();
}

/* аннотирование класса*/
@Annotation5(description = "ExClass5: Text")
@Annotation5a(count = 34)
class ExClass5a {
    /* аннотирование метода*/
    @Annotation5(description = "method1: Text")
    @Annotation5a(count = 47)
    public void method1(){} //метод что-то делает
}
class ExClass5 {
    void method() {
        try{
            ExClass5a mc = new ExClass5a();
            /* создание массива аннотаций с помощью рефлексии, для класса ExClass5a*/
            Annotation[] arrAnn = mc.getClass().getAnnotations();

            /* получение всех аннотаций класса*/
            for (Annotation a : arrAnn) System.out.println(a);

            System.out.println("----------");

            /* создание массива аннотаций с помощью рефлексии, для метода method1*/
            Method m = mc.getClass().getMethod("method1");
            arrAnn = m.getAnnotations();

            /* получение всех аннотаций метода*/
            for (Annotation a : arrAnn) System.out.println(a);
        }catch(NoSuchMethodException e){e.printStackTrace();}
    }
}

/*---------------------------------------------------------------------*/

/* методы интерфейса AnnotatedElement*/
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation6{
    String str();
}

@Annotation6(str = "Annotation6")
class ExClass6a{
    void annMethod(){}
}
class ExClass6{
    void method(){
        try {
            //Annotation anno = new ExClass6a().getClass().getAnnotation(Annotation6.class); //пример

            ExClass6a exClass = new ExClass6a();
            Class<?> c = exClass.getClass();
            Annotation[] arrAnn;
            Annotation6 ann;

            /* применение метода getAnnotation*/
            ann = c.getAnnotation(Annotation6.class);
            System.out.println("ExClass6a getAnnotation: "+ann);
            System.out.println("----------");

            /* применение метода getAnnotations*/
            arrAnn = c.getAnnotations();
            for (Annotation a : arrAnn) System.out.println("ExClass6a getAnnotations: " + a);
            System.out.println("----------");

            /* применение метода getDeclaredAnnotations*/
            arrAnn = c.getDeclaredAnnotations();
            for (Annotation a : arrAnn) System.out.println("ExClass6a getDeclaredAnnotations: " + arrAnn);
            System.out.println("----------");

            /* применение метода isAnnotationPresent*/
            boolean val = c.isAnnotationPresent(Annotation6.class);
            System.out.println("ExClass6a isAnnotationPresent: " + val);
            System.out.println("----------");

            /* применение метода getDeclaredAnnotation*/
            ann = c.getDeclaredAnnotation(Annotation6.class);
            System.out.println("ExClass6a getDeclaredAnnotation: " + ann);
            System.out.println("----------");

            /* применение метода getAnnotationsByType*/
            arrAnn = c.getAnnotationsByType(Annotation6.class);
            System.out.println("ExClass6a getAnnotationsByType: " + arrAnn);
            System.out.println("----------");

            /* применение метода getDeclaredAnnotationsByType*/
            arrAnn = c.getDeclaredAnnotationsByType(Annotation6.class);
            System.out.println("ExClass6a getDeclaredAnnotationsByType: " + arrAnn);
        }catch (Exception e){}
    }
}

/*---------------------------------------------------------------------*/

/* применение значений по умолчанию*/
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation7{
    String str() default "ExClass7a";
    int num() default 34;
}
class ExClass7a{
    /* еще раз инициализировать элементы аннотации необязательно*/
    @Annotation7()
    /* но ничто не мешает это сделать явно*/
    //@Annotation7(str = "Text")
    //@Annotation7(num = 47)
    //@Annotation7(str = "Other text", num = 52)
    public void method1(){}
}
class ExClass7{
    void method(){
        try {
            Annotation7 anno = new ExClass7a().getClass().getMethod("method1").getAnnotation(Annotation7.class);
            System.out.println("ExClass7: "+anno.str()+" "+anno.num());
        }catch (Exception e){}
    }
}

/*---------------------------------------------------------------------*/

/* применение аннотации-маркера*/
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation8{}

/* аннотирование класса маркером*/
@Annotation8
class ExClass8a{
    void method1(){}
}
class ExClass8{
    void method(){
        Class<?> c = new ExClass8a().getClass();
        if (c.isAnnotationPresent(Annotation8.class)){
            System.out.println("ExClass8");
        }
        new ExClass8a().method1();
    }
}

/*---------------------------------------------------------------------*/

/* применение одноэлементной аннотации*/
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation9a{
    int value(); //здесь должен быть указан метод с именем value
}
/* применение одноэлементной аннотации вместе с другими элементами*/
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation9b{
    int value(); //здесь должен быть указан метод с именем value
    String str() default "Text"; //вместе с методом value, допускается использования методов по умолчанию
}
/* аннотирование класса*/
@Annotation9a(34)
class ExClass9a{
    void method1(){}
}
class ExClass9{
    void method(){
        Annotation9a ann = new ExClass9a().getClass().getAnnotation(Annotation9a.class);
        System.out.println("ExClass9a: "+ann.value());
    }
}

/*---------------------------------------------------------------------*/

/* встроенные аннотации*/
/* аннотация Retention*/
/* она предназначена для аннотирования других аннотаций и определяет правило удержания*/
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation10{}

/*---------------------------------------------------------------------*/

/* аннотация-маркер Documented*/
/* она предназначена для аннотирования других аннотаций и сообщает инструментальному средству разработки
 * о необходимости задокументировать аннотацию*/
@Documented
@interface Annotation11{}

/*---------------------------------------------------------------------*/

/* аннотация-маркер Inherited*/
/* она предназначена для аннотирования других аннотаций и разрешает обращаться к конкретной аннотации
 * в суперклассе, при отсутствии данной аннотации в подклассе. Без обозначения Inherited это приведет к ошибке*/
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation12{String str();}

/* аннотирование суперкласса аннотацией Annotation12*/
@Annotation12(str = "class")
class SuperClass12{
    /* аннотирование метода суперкласса аннотацией Annotation12*/
    @Annotation12(str = "method")
    public void method1(){}
}
class SubClass12 extends SuperClass12{} // в подклассе отсутствует аннотация Annotation12

class ExClass12{
    void method(){
        try {
            Annotation12 ann;
            /* здесь идет обращение к подклассу SubClass12 с целью получения аннотации Annotation12. Это не
             * приводит к ошибке, т.к. аннотация помечена @Inherited, что позволяет сделать пересылку запроса к
             * суперклассу, в поисках необходимой аннотации*/
            ann = new SubClass12().getClass().getAnnotation(Annotation12.class);
            System.out.println("SubClass12: "+ann.str());

            Method m = new SubClass12().getClass().getMethod("method1");
            ann = m.getAnnotation(Annotation12.class);
            System.out.println("SubClass12: " + ann.str());
        }catch (Exception e){}
    }
}

/*---------------------------------------------------------------------*/

/* аннотация Target*/
/* она предназначена для аннотирования других аннотаций и определяет тип элемента, для которого может быть
 * использована аннотация*/
@Target(ElementType.FIELD) //или @Target({ElementType.FIELD, ElementType.METHOD})
/*Константы из перечисления ElementType:
- PACKAGE (пакет)
- ANNOTATION_TYPE (другая аннотация)
- TYPE (класс, интерфейс, перечисление)
- FIELD (поле)
- CONSTRUCTOR (конструктор)
- METHOD (метод)
- PARAMETER (параметр)
- TYPE_PARAMETER (параметр типа)
- TYPE_USE (использования типа)
- LOCAL_VARIABLE (локальная переменная)*/
@interface Annotation13{int str();}

class ExClass13{
    @Annotation13(str = 34)
    int sum = 34;

    //@Annotation13(str = 34) //ошибка, этот элемент нельзя аннотировать
    void method(){}
}

/*---------------------------------------------------------------------*/

/* аннотация-маркер Override*/
/* данная аннотация предназначена для аннотирования переопределенных методов подкласса, т.е. тех методов,
 * которые ранее были объявлены в суперклассе. Без данной аннотации, может возникнуть ошибка. Он же дает
 * гарантию, что метод будет именно переопределен, а не перегружен*/
/* суперкласс*/
class SuperClass14{
    /* объявление метода суперкласса*/
    void method(){}
}
class SubClass14 extends SuperClass14{
    /* переопределение метода суперкласса*/
    @Override
    void method(){}
}

/*---------------------------------------------------------------------*/

/* аннотация-маркер Deprecated*/
/* данная аннотация предназначена для аннотирования объявлений любых допустимых элементов и указывает на то,
 * что это объявление устарело, и ее необходимо заменить на более новую форму*/
class ExClass15{
    @Deprecated
    void method(){} //старая форма, ее необходимо заменить на void ExClass14(int a)
}

/*---------------------------------------------------------------------*/

/* аннотация-маркер SafeVarargs*/
/* данная аннотация в основном предназначена для аннотирования конструкторов и завершенных или статических методов,
 * использующих переменное количество аргументов, и указывает на отсутствие небезопасных действий, связанных
 * с параметром переменной длины. Ее задача заключается в предотвращении возникновений непроверяемых предупреждений
 * в коде, который в основном является безопасным, за счет использования обобщенных типов аргументов переменной длины.*/
class ExClass16{
    @SafeVarargs
    ExClass16(int...a){} //конструктор
    @SafeVarargs
    final void method1(int... a){} //завершенный метод
    @SafeVarargs
    static void method2(String... str){} //статический метод
    //@SafeVarargs
    //void method3(int... a){} //ошибка, метод не является завершенным или статическим
    //@SafeVarargs
    //static void method4(){} //ошибка, метод не имеет параметра переменной длины
}

/*---------------------------------------------------------------------*/

/* аннотация-маркер FunctionalInterface*/
/* данная аннотация предназначена для аннотирования интерфейсов и указывает на то, что данный интерфейс
 * является функциональным (т.е. содержит только один абстрактный метод). Если аннотированный интерфейс
 * не будет являться функциональным, то возникнет ошибка. Данная аннотация несет только информационный
 * характер*/
@FunctionalInterface
interface Annotation17{
    void annMethod();
    //int annMethod1(); //возникнет ошибка, т.к. интерфейс уже не будет функциональным
}


/*---------------------------------------------------------------------*/

/* аннотация SuppressWarnings*/
/* данная аннотация предназначена для аннотирования объявлений любых допустимых элементов и подавляет одно или
 * несколько предупреждений, которые могут быть выданы компилятором. Предупреждения, которые следует подавить,
 * указываются по имени в строковой форме*/
class Annotation18{
    @SuppressWarnings(value = "type")
    void method(){}
}

/*---------------------------------------------------------------------*/

/* типовая аннотация*/
/* Для аннотирования типов данных, аннотация Annotation18 должна быть аннотирована @Target(ElementType.TYPE_USE)*/
@Target(ElementType.TYPE_USE)
@interface Annotation19{}

class ExClass19{
    /* аннотирование исключения*/
    void method1() throws @Annotation19() Exception{}

    /* аннотирование типа объекта по ссылке this*/
    /* здесь в качестве первого параметра метода указывается ссылка this с типом класса, в котором объявлен метод*/
    void method2(@Annotation19 ExClass19 this, int a){}
}

/*---------------------------------------------------------------------*/

/* пример применения типовой аннотации, аннотации для поля и метода, а также аннотации для параметра типа*/
/* типовая аннотация*/
@Target(ElementType.TYPE_USE)
@interface AnnoType{}

/* аннотация объявления поля*/
@Target(ElementType.FIELD)
@interface AnnoField{}

/* аннотация объявления метода*/
@Target(ElementType.METHOD)
@interface AnnoMethod{}

/* аннотация объявления параметра типа*/
@Target({ElementType.TYPE_PARAMETER})
@interface AnnoTypeParam{}

class SuperClass20{}

/* типовое аннотирование наследования*/
class SubClass20 extends @AnnoType SuperClass20{
    /* типовое аннотирование типа поля - String*/
    @AnnoType String str;

    /* аннотирование объявления поля - num*/
    @AnnoField int num;

    /* типовое аннотирование типа элемента массива*/
    @AnnoType Integer[] arr;

    /* типовое аннотирование уровня доступа к массиву*/
    String @AnnoType [] @AnnoType [] arr1;

    /* типовое аннотирование конструктора*/
    public @AnnoType SubClass20(){}

    /* типовое аннотирование типа, возвращаемого методом - int*/
    @AnnoType int method1(){
        // метод что-то делает
        return 34;
    }

    /* аннотирование объявление метода myMethod11b*/
    @AnnoMethod void method2(){
        // метод что-то делает
    }

    /* типовое аннотирование ссылки this на объект(получатель)*/
    void method3(@AnnoType SubClass20 this, String str){}

    class GenericClass<T>{
        /* типовое аннотирование ссылки this на объект(получатель)*/
        void myGMeth(@AnnoType GenericClass<T> this, int a){}
    }

    /* типовое аннотирование параметра типа*/
    <@AnnoType T> void method4(T ob){}

    /* аннотирование параметра типа*/
    <@AnnoTypeParam T> void method5(T ob){}

    /* типовое аннотирование исключения*/
    void method6() throws @AnnoType Exception{}

    void method7(){
        /* типовое аннотирование аргумента типа*/
        GenericClass<@AnnoType Integer> genericClass1 = new GenericClass<>();

        /* типовое аннотирование оператора new*/
        GenericClass<Integer> genericClass2 = new @AnnoType GenericClass<>();

        SubClass20 mc3 = new SubClass20();
        /* типовое аннотирование приведения типа*/
        SuperClass20 mc4 = (@AnnoType SubClass20) mc3;
    }
}

/*---------------------------------------------------------------------*/

/* повторяющиеся аннотации*/
/* объявление аннотации Annotation20, которая будет использована несколько раз для одного и того же элемента,
 * т.е. является повторяющейся аннотацией*/
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ExInterface21.class)
@interface Annotation21{
    String str();
}
/* объявление контейнера для повторяющейся аннотации*/
@Retention(RetentionPolicy.RUNTIME)
@interface ExInterface21{
    /* объявление массива с типом аннотации Annotation21, причем массив должен называться value()*/
    Annotation21[] value();
}
class ExClass21a{
    /* аннотирование метода повторяющейся аннотацией*/
    @Annotation21(str = "Text1")
    @Annotation21(str = "Text2")
    public void method(){
        // метод что-то делает
    }
}
class ExClass21{
    void method(){
        try{
            ExClass21a mc = new ExClass21a();
            Class<?> c = mc.getClass();
            Annotation ann = c.getMethod("method").getAnnotation(ExInterface21.class);
            System.out.println("ExClass21a: "+ ann);
            System.out.println("----------");
            /* здесь использован специальный метод, который возвращает повторяющуюся аннотацию по отдельности*/
            Annotation[] ann1 = c.getMethod("method").getAnnotationsByType(ExInterface21.class);
            for (Annotation a : ann1) System.out.println("ExClass21a: "+a);
            System.out.println("----------");
            /* здесь использован специальный метод, который возвращает повторяющуюся аннотацию по отдельности*/
            Annotation[] ann2 = c.getMethod("method").getDeclaredAnnotationsByType(ExInterface21.class);
            for (Annotation a : ann2) System.out.println("ExClass21a: "+a);
        }catch (Exception e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования аннотации*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ExInterface22{
    public int id();
    public String desc() default "no description";
}
class ExClass22a{
    @ExInterface22(id = 1, desc = "description1") void method1(){}
    @ExInterface22(id = 2) void method2(){}
    @ExInterface22(id = 3, desc = "description2") void method3(){}
}
class ExClass22b{
    void method1(List<Integer> list, Class<?> cl){
        for (Method m : cl.getDeclaredMethods()){
            ExInterface22 mc = m.getAnnotation(ExInterface22.class);
            if (mc != null) {
                System.out.println("id: "+mc.id()+", and desc: "+mc.desc());
                list.remove(new Integer(mc.id()));
            }
        }
        for (int i : list) System.out.println("Warning text: "+i);
    }
}
class ExClass22{
    void method(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4);
        new ExClass22b().method1(list, ExClass22a.class);
    }
}


public class Annotations {
    public static void main(String[] args) {
        new ExClass1().method();
        new ExClass2().method();
        new ExClass3().method();
        new ExClass4().method();
        new ExClass5().method();
        new ExClass6().method();
        new ExClass7().method();
        new ExClass8().method();
        new ExClass9().method();
        new ExClass12().method();
        new ExClass13().method();
        new ExClass15().method();
        new ExClass21().method();
        new ExClass22().method();

    }
}
