package Variable;

/* Примитивные типы*/
public class PrimitiveTypes {
    public static void main(String[] args) {
        System.out.println("Примитивные типы - 8 типов");

        /* целочисленные типы*/
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4;

        System.out.println("- целочисленные типы - 4 типа");
        System.out.println("byte: "+b);
        System.out.println("short: "+s);
        System.out.println("int: "+i);
        System.out.println("long: "+l);
        System.out.println("--------------------");

        /* вещественные типы*/
        float f = (float)34.0;
        double d = 47.0;

        System.out.println("- вещественные типы - 2 типа");
        System.out.println("float: "+f);
        System.out.println("double: "+d);
        System.out.println("--------------------");

        /* логический тип*/
        boolean boolTrue = true;
        boolean boolFalse = false;

        System.out.println("- логический тип - 1 тип");
        System.out.println("boolean true: "+boolTrue);
        System.out.println("boolean false: "+boolFalse);
        System.out.println("--------------------");

        /* символьный тип*/
        char c = 'a';
        char ch = 94;

        System.out.println("- символьный типы - 1 тип");
        System.out.println("char: "+c);
        System.out.println("char: "+ch);
    }
}
