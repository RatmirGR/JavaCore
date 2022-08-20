public class Wrappers {

    /* 1) оболочки типов*/

    void exampleMethod1(){
        /* класс Byte*/
        Byte by = new Byte((byte)25); // число
        Byte by1 = new Byte("25"); // число в стрковом виде
        System.out.println("класс Byte - метод byteValue() возвращает символ: "+by1.byteValue());

        /* класс Short*/
        Short sh = new Short((short) 34); // число
        Short sh1 = new Short("34"); // число в стрковом виде
        System.out.println("класс Short - метод shortValue() возвращает символ: "+sh1.shortValue());

        /* класс Integer*/
        Integer in = new Integer(47); // число
        Integer in1 = new Integer("47"); // число в стрковом виде
        System.out.println("класс Integer - метод intValue() возвращает символ: "+in1.intValue());

        /* класс Long*/
        Long lo = new Long(52); // число
        Long lo1 = new Long("52"); // число в стрковом виде
        System.out.println("класс Long- метод longValue() возвращает символ: "+lo1.longValue());

        /* класс Float*/
        Float fl = new Float(34.0); // число
        Float fl1 = new Float("34.0"); // число в стрковом виде
        System.out.println("класс Float - метод floatValue() возвращает символ: "+fl1.floatValue());

        /* класс Double*/
        Double db = new Double(47.0); // число
        Double db1 = new Double("47.0"); // число в стрковом виде
        System.out.println("класс Double - метод doubleValue() возвращает символ: "+db1.doubleValue());

        /* класс Character*/
        Character ch = new Character('a');
        System.out.println("класс Character - метод charValue() возвращает символ: "+ch.charValue());

        /* класс Boolean*/
        Boolean bool = new Boolean(true);
        Boolean bool1 = new Boolean("true"); // true - в верхнем или нижнем регистре, тогда метод вернет true
        System.out.println("класс Boolean - метод booleanValue() возвращает символ: "+bool1.booleanValue());
        System.out.println("----------");
    }

    /*---------------------------------------------------------------------*/

    /* 2) автоупаковка и автораспаковка*/

    void exampleMethod2(){
        Integer ing = 34; //автоупаковка
        int n = ing; //автораспаковка
        System.out.println("автоупаковка и автораспаковка: "+n);
    }

    /*---------------------------------------------------------------------*/

    /* 3) автоупаковка и автораспаковка в методе*/

    void exampleMethod3(){
        /* передача методу ссылки на объект класса-оболочки*/
        int a = getInteger(47); // присвоение ссылки на объект переменной примитивного типа.
        System.out.println("автоупаковка и автораспаковка в методе: "+a);
    }

    Integer getInteger(Integer v){
        return v;
    }

    /*---------------------------------------------------------------------*/

    /* 4) автоупаковка и автораспаковка в выражениях*/

    void exampleMethod4(){
        Integer iOb = 52; // автоупаковка
        ++iOb; // значение автораспаковывается, увеличивается на 1, а затем снова автоупаковывается

        /* значение автораспаковывается, складывается, затем делиться, а результат снова автоупаковывается и
         * ссылка на объект оболочки присваивается переменной с соответствующим типом оболочки*/
        iOb = (iOb + iOb)/3;

        /* значение автораспаковывается, складывается, затем делиться, и результат уже не автоупаковывается, а
         * просто присваивается переменной с соответствующим примитивным типом*/
        int res = (iOb + iOb)/3;
        System.out.println("автоупаковка и автораспаковка в выражениях: "+res);

        /* автоупаковка и автораспаковка разных числовых типов*/
        Integer intOb = 34;
        Double dbOb = 47.0;

        /* автораспаковка и продвижение к нужному типу*/
        Byte bOb = (byte)(intOb + dbOb);
        System.out.println("автоупаковка и автораспаковка разных числовых типов: "+bOb);
    }

    /*---------------------------------------------------------------------*/

    /* 5) автоупаковка и оператор switch*/

    void exampleMethod5(){
        Integer i = 52;

        switch (i){
            case 34: System.out.println("34"); break;
            case 47: System.out.println("47"); break;
            case 52: System.out.println("оператор switch: "+i); break;
            default: System.out.println("default");
        }
    }

    /*---------------------------------------------------------------------*/

    /* 6) автоупаковка и автораспаковка символьного и логического типов, а также в цикле while*/

    void exampleMethod6(){
        Character chr = 'a';
        char ch1 = ++chr; // автораспаковка объекта типа Character
        System.out.println("автоупаковка символьного типа - операция инкремент: "+ch1);

        Boolean bl = true;
        if (bl){} // автораспаковка объекта типа Boolean
        System.out.println("автораспаковка логического типа - условный оператор if: "+bl);
        /* объект типа Boolean, так же как и примитивный тип boolean, может участвовать во всех видах циклов
         * и логических выражениях*/

        /* автоупаковка, автораспаковка и цикл while*/
        while (bl){
            bl = false;
            System.out.println("автоупаковка, автораспаковка и цикл while: "+bl);
        }
    }

    /*---------------------------------------------------------------------*/

    /* 7) автоупаковка и автораспаковка предотвращают появление ошибок*/

    void exampleMethod7(){

        Integer iErr = 1000;
        int resInt = iErr.byteValue();
        System.out.println("втоупаковка и автораспаковка предотвращают появление ошибок");
        System.out.println("ошибка - iErr.byteValue() возвращает не значение 1000, а значение: "+resInt);
        System.out.print("автораспаковка предотвращает подобную ошибку: ");
        resInt = iErr;
        System.out.println(resInt);
    }

    public static void main(String[] args) {
        Wrappers wrappers = new Wrappers();
        wrappers.exampleMethod1();
        wrappers.exampleMethod2();
        wrappers.exampleMethod3();
        wrappers.exampleMethod4();
        wrappers.exampleMethod5();
        wrappers.exampleMethod6();
        wrappers.exampleMethod7();
    }
}
