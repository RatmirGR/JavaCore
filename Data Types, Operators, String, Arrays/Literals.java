/* Литералы*/
public class Literals {
    public static void main(String[] args) {
        System.out.println("Литералы");

        System.out.println("1) Целочисленные литералы:");

        System.out.println("- двоичное основание");
        int a = 0b111; // или 0B1010 = 7
        System.out.println(a);
        System.out.println("--------------------");

        System.out.println("- восьмеричное основание");
        int b = 07; // 07 = 7
        //int c = 08; // ошибка, т.к. значение выходит за пределы восьмеричного основания
        long max8 = 0777777777777777777777L;
        System.out.println(b);
        System.out.println(max8);
        System.out.println("--------------------");

        System.out.println("- десятичное основание");
        int d = 7;
        long max10 = 9223372036854775807L;
        System.out.println(d);
        System.out.println(max10);
        System.out.println("--------------------");

        System.out.println("- шестнадцатеричное основание");
        int e = 0x00f; // 0x00f = 15
        long max16 = 0x7fffffffffffffffL;
        System.out.println(e);
        System.out.println(max16);
        System.out.println("--------------------");

        System.out.println("использования знака _ (подчеркивания)");
        int f = 0b1010_1100_1010_1101; // 44205
        System.out.println(f);

        System.out.println("2) Литералы с плавающей точкой - по умолчанию double:");

        double g = 34.0;
        double h = 47.0;
        System.out.println(g);
        System.out.println(h);

        System.out.println("научная (экспоненциальная) форма - E степень числа 10, на которое необходимо умножить число");
        double i = 4.8E7;
        double j = 2.E+31;
        double k = 5.0E-10;

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println("--------------------");

        System.out.println("литералы с плавающией точкой - float");
        float l = 1.092f; // или 1.092F
        System.out.println(l);
        System.out.println("--------------------");

        System.out.println("-  шестнадцатеричное основание - P степень числа 2, на которое необходимо умножить число");
        double m = 0x2.4P0;
        System.out.println(m);
        System.out.println("--------------------");

        System.out.println("использования знака _ (подчеркивания)");
        double n = 123_456_789.123_456;
        System.out.println(n);
        System.out.println("--------------------");

        System.out.println("логические литералы");
        boolean o = true;
        boolean p = false;
        boolean q = 3 > 4;
        if (o) q = o;
        System.out.println(o);
        System.out.println(p);
        System.out.println(q);
        System.out.println("--------------------");

        System.out.println("символьные литералы");
        char r = 'a'; // непосредсвенный ввод символа
        char s = '\t'; // с использованием управляющих последовательностей
        char t = '\147'; // восьмеричная форма ввода
        char u = '\u0074'; // шестнадцатеричная форма ввода
        System.out.println(r);
        System.out.println(s +" = \\t");
        System.out.println(t);
        System.out.println(u);
        System.out.println("--------------------");

        System.out.println("строковые литералы");
        String v = "my text"; // непосредсвенный ввод символа
        String w = "my \n new text1"; // с использованием управляющих последовательностей
        String x = "my \"new\" text2"; // с использованием управляющих последовательностей
        System.out.println(v);
        System.out.println(w);
        System.out.println(x);
    }
}
