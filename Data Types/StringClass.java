import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class StringClass {

    /* 1) пример 1 создания и заполнения экземпляра класса String*/

    void exampleMethod1(){
        System.out.println("Использование класса String - пример 1");

        /* создание экземпляра класса String, не содержащий символы*/
        java.lang.String s = new java.lang.String();
        if (s.isEmpty()){
            System.out.println("- экземпляр пуст");
        }else{
            System.out.println(s);
        }

        System.out.println("-------------------------");

        char[] ch = {'a', 'b', 'c'};

        /* создание объекта типа String, содержащий элементы из массива ch*/
        s = new java.lang.String(ch);
        System.out.println(s);

        System.out.println("-------------------------");

        char[] ch1 = {'a', 'b', 'c', 'd', 'e', 'f'};

        /* создание объекта типа String, содержащий элементы из массива ch1 в указанном диапазоне*/
        s = new java.lang.String(ch1, 2, 3); //выбираются 3 элемента, с 2-ой позиции, т.е. cde
        System.out.println(s);

        System.out.println("-------------------------");

        char[] ch2 = {'a', 'b', 'c', 'd'};

        /* создание объекта типа String, содержащий элементы из массива ch2*/
        s = new java.lang.String(ch2);
        java.lang.String s2 = new java.lang.String(s); // объект s2 будет содержать те же значения, что и объект s
        System.out.println(s+" и "+s2);

        System.out.println("-------------------------");

        byte[] bt = {97, 98, 99, 100, 101, 102};

        /* создание объекта типа String, содержащий элементы из массива bt*/
        s = new java.lang.String(bt);
        s2 = new java.lang.String(bt, 2, 3); //выбираются 3 элемента, с 2-ой позиции, т.е. cde
        System.out.println(s+" и "+s2);

        System.out.println("-------------------------");

        StringBuffer stringBuffer = new StringBuffer("my text");

        /* создание объекта типа String из объекта типа StringBuffer*/
        s = new java.lang.String(stringBuffer);
        System.out.println(s);

        System.out.println("-------------------------");

        StringBuilder stringBuilder = new StringBuilder("my text");

        /* создание объекта типа String из объекта типа StringBuilder*/
        s = new java.lang.String(stringBuilder);
        System.out.println(s);
    }

    /*---------------------------------------------------------------------*/

    /* 2) пример 2 создания и заполнения экземпляра класса String*/

    void exampleMethod2(){
        System.out.println("Использование класса String - пример 2");

        /* создание объекта класса String с помощью оператора new*/
        java.lang.String s = new java.lang.String("abc");

        /* создание объекта класса String с помощью строкового литерала*/
        s = "abc";
        System.out.println(s);

        System.out.println("-------------------------");

        /* вызов метода класса String во время создания его объекта с помощью строкового литерала*/
        s = "abc".toUpperCase();
        System.out.println(s);

        System.out.println("-------------------------");

        /* непосредственный вызов метода для символьной строки "abc"*/
        System.out.println("abc".length());

        System.out.println("-------------------------");

        /* сцепление символьных строк*/
        java.lang.String s1 = "my ";
        java.lang.String s2 = " text";
        java.lang.String s3 = s1 + "super" + s2;
        System.out.println(s3);

        System.out.println("-------------------------");

        /* сцепление длинной строки*/
        s = "это очень длинная строка, "
                + "которую можно было бы "
                + "перенести на новую строку. "
                + "Но благодаря сцеплению "
                + "этого удается избежать.";
        System.out.println(s);

        System.out.println("-------------------------");

        /* сцепление с другими типами данных*/
        int a = 30; // тип int
        s2 = " text";
        s3 =  a+ " super" + s2;
        System.out.println(s3);

        System.out.println("-------------------------");

        /* неожиданные результаты при сцеплении разных типов данных*/
        s = "four: "+ 2 + 2; // four: 22, вместо four: 4
        System.out.println(s);

        System.out.println("-------------------------");

        /* получение нужного результата*/
        s = "four: "+ (2 + 2); // four: 4
        System.out.println("- "+s);
    }

    /*---------------------------------------------------------------------*/

    /* 3) использование метода toString()*/

    void exampleMethod3(){
        ClassToString classToString = new ClassToString(); // создание объекта типа ClassToString
        java.lang.String s = "- объект mc типа MyClass3: "+ classToString; // сцепление символьной строки с объектом
        System.out.println(classToString);
        System.out.println(s); // преобразование объекта типа ClassToString в символьную строку при выводе на консоль
    }

    class ClassToString{
        private int a = 34, b = 47, c = 52;
        public java.lang.String toString(){
            return "размеры: "+a+" на "+b+" на "+c;
        }
    }

    /*---------------------------------------------------------------------*/

    /* 4) использования методов charAt(), getChars(), getBytes(), toCharArray()*/

    void exampleMethod4(){
        System.out.println("Использование методов charAt(), getChars(), getBytes(), toCharArray()");

        System.out.println("- метод charAt():");

        /* использование метода charAt() для извлечения символа из строки по указанному индексу*/
        char ch = "abc".charAt(1); // извлечение символа b
        System.out.println(ch);

        //ch = "abc".charAt(-1); // возникает исключение, т.к. такого индекса не существует
        //ch = "abc".charAt(3); // возникает исключение, т.к. такого индекса не существует
        //System.out.println(ch);

        System.out.println("-------------------------");

        System.out.println("- метод getChars():");

        /* использование метода getChars() для извлечения нескольких символов сразу из строки по указанному индексу
         * и копирование их в массив байтов*/
        String s = "my text is very good";
        int start = 3, end = 7;
        char[] ch1 = new char[end - start]; // создание массива типа char с размером 3
        s.getChars(start, end, ch1, 0); // вызов метода getChars() - (3, 7, массив, 0 индекс массива)

        for(int i = 0; i < ch1.length; i++){
            System.out.print(ch1[i]);
        }
        System.out.println("\n-------------------------");

        System.out.println("- метод getBytes():");

        /* использование метода getBytes() для извлечения нескольких символов сразу из строки и копирование их
         * в массив байтов. Перед копированием полученных символов, данный метод их преобразует в байты, используя
         * кодировку по умолчанию или указанную явно*/

        /* использование метода getBytes(), использующий кодировку ASCII*/
        try {
            for (int i = 0; i < s.length(); i++){
                System.out.print((char)s.getBytes("ASCII")[i]);
            }
        }catch (UnsupportedEncodingException e){}

        System.out.println("\n-------------------------");

        /* использование метода getBytes(), использующий кодировку по умолчанию*/
        for (int i = 0; i < s.length(); i++){
            System.out.print((char)s.getBytes()[i]);
        }

        System.out.println("\n-------------------------");

        /* использование метода getBytes(), использующий кодировку UTF-16*/
        Charset chs = StandardCharsets.UTF_16;
        for (int i = 0; i < s.length(); i++){
            System.out.print((char)s.getBytes(chs)[i]);
        }

        System.out.println("\n-------------------------");

        System.out.println("- метод toCharArray():");

        char[] ch2 = s.toCharArray(); // метод преобразует строку в массив символов
        System.out.print(" - ");
        for (int i = 0; i < ch2.length; i++) {
            System.out.print(ch2[i]);
        }
        System.out.println();
    }

    /*---------------------------------------------------------------------*/

    /* 5) использования методов equals(), equalsIgnoreCase(), regionMatches(). startsWith(), endsWith()*/

    void exampleMethod5(){

        System.out.println("Использование методов equals(), equalsIgnoreCase(), regionMatches(), startsWith(), endsWith()");

        System.out.println("- методы equals() и equalsIgnoreCase():");
        String s1 = "my text";
        String s2 = "my text";
        String s3 = "my super text";
        String s4 = "MY TEXT";

        /* сравнение символьной строки s1 с символьными строками s2, s3 и s4 – метод equals()*/
        System.out.println(s1+" равно "+s2+": " +s1.equals(s2));
        System.out.println(s1+" равно "+s3+": " +s1.equals(s3));
        System.out.println(s1+" равно "+s4+": " +s1.equals(s4));

        /* сравнение символьной строки s1 с символьной строкой s4 – метод equalsIgnoreCase()*/
        System.out.println(s1+" равно без учета регистра "+s4+": " +s1.equalsIgnoreCase(s2));

        System.out.println("- метод regionMatches():");
        s1 = "my text";
        s2 = "my super text";
        s3 = "MY SUPER TEXT";

        /* сравнение подстроки s1 с подстрокой s2 – метод regionMatches()*/
        System.out.println(s1.regionMatches(0, s2, 0, 3));
        System.out.println(s1.regionMatches(3, s2, 9, 4));

        /* сравнение подстроки s1 с подстрокой s3 – метод regionMatches() без игнорирования регистра*/
        System.out.println(s1.regionMatches(3, s3, 9, 4));

        /* сравнение подстроки s1 с подстрокой s3 – метод regionMatches() с игнорированием регистра*/
        System.out.println(s1.regionMatches(true,3, s3, 9, 4));

        s1 = "my text is very good text";

        /* сравнение двух подстрок одной и той же строки s1 – метод regionMatches()*/
        System.out.println(s1.regionMatches(3, s1, 21, 4));

        System.out.println("методы startsWith() и endsWith():");

        /* проверка наличия указанной подстроки в начале строки – метод startsWith()*/
        System.out.println("my text".startsWith("my"));

        /* проверка наличия указанной подстроки в конце строки – метод endsWith()*/
        System.out.println("my text".endsWith("text"));
    }

    /*---------------------------------------------------------------------*/

    /* 6) сравнение метода equals и операции == (сравнение на равенство)*/

    void exampleMethod6(){

        System.out.println("Сравнение метода equals и операции == (сравнение на равенство)");

        String s1 = "my text";
        String s2 = new String(s1);
        System.out.println(s1+" равно "+s2+": "+s1.equals(s2));
        System.out.println(s1+" равно "+s2+": "+(s1 == s2));

        s1 = "my text";
        s2 = s1;
        System.out.println(s1+" равно "+s2+": "+s1.equals(s2));
        System.out.println(s1+" равно "+s2+": "+(s1 == s2));
    }

    /*---------------------------------------------------------------------*/

    /* 7) использование метода compareTo()*/

    void exampleMethod7(){
        System.out.println("Использование метода compareTo()");

        /* метод compareTo() определен в интерфейсе Comparable<T>*/

        String[] arr = {"text", "is", "My", "good", "very"};
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j].compareTo(arr[i]) < 0){
                    String s = arr[i];
                    arr[i] = arr[j];
                    arr[j] = s;
                }
            }
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /*---------------------------------------------------------------------*/

    /* 8) использования методов indexOf() и lastIndexOf()*/

    void exampleMethod8(){
        System.out.println("Использования методов indexOf() и lastIndexOf()");

        /* метод indexOf() и lastIndexOf() находят первое и последнее вхождение символа или подстроки соответственно*/

        String s = "my text is very good text, it's cool";
        System.out.println(s);
        System.out.println("indexOf(t) = " + s.indexOf('t'));
        System.out.println("lastIndexOf(t) = " + s.lastIndexOf('t'));
        System.out.println("indexOf(text) = " + s.indexOf("text"));
        System.out.println("lastIndexOf(text) = " + s.lastIndexOf("text"));
        System.out.println("indexOf(t, 3) = " + s.indexOf('t', 3));
        System.out.println("lastIndexOf(t, 23) = " + s.lastIndexOf('t', 23));
        System.out.println("indexOf(text, 3) = " + s.indexOf("text", 3));
        System.out.println("lastIndexOf(text, 23) = " + s.lastIndexOf("text", 23));
    }

    /*---------------------------------------------------------------------*/

    /* 9) использования методов substring(), concat(), replace()*/

    void exampleMethod9(){
        System.out.println("Использования методов substring(), concat(), replace()");

        String s = "my text is very good text";
        String sr = " text";
        String sb = " context";
        String res = " ";
        int i;
        System.out.println("метод substring():");

        /* метод substring() извлекает подстроку из символьной строки*/

        do{
            System.out.println(s);
            i = s.indexOf(sr);
            if(i != -1){
                res = s.substring(0, i);
                res += sb;
                res += s.substring(i + sr.length());
                s = res;
            }
        }while(i != -1);

        System.out.println("метод concat():");

        /* метод concat() соединяет две строки */

        String s1 = "my ";
        String s2 = s1.concat("text");
        System.out.println(s2);

        /* аналогичный вариант*/
        s1 = "my ";
        s2 = s1 + "text";
        System.out.println(s2);

        System.out.println("метод replace():");

        /* заменяет все вхождения одного символа в исходной строке на другой символ*/

        s1 = "my text".replace('t', 'k');
        System.out.println(s1);

        /* заменяет все вхождения одного слова в исходной строке на другое слово*/

        s2 = "my text".replace("text", "word");
        System.out.println(s2);
    }

    /*---------------------------------------------------------------------*/

    /* 10) использование метода trim()*/

    void exampleMethod10(){
        System.out.println("Использование метода trim()");

        /* метод trim() удаляет все начальные и конечные пробелы*/

        /* создание буферизованного потока чтения данных, используя поток ввода System.in*/
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String str;
            System.out.println("- введите имя: ('stop' – для завершения)");
            do{
                System.out.print("- ");
                str = br.readLine();
                str = str.trim(); // удаление пробелов
                if(str.equals("Tom")){
                    System.out.println("- cat "+str);
                }else if(str.equals("Sam")){
                    System.out.println("- dog "+str);
                }else if(str.equals("Scott")){
                    System.out.println("- pig "+str);
                }else{
                    System.out.println("- not animal");
                }
            }while(!str.equals("stop"));
        }catch(IOException e){}
    }

    /*---------------------------------------------------------------------*/

    /* 11) использование метода valueOf()*/

    void exampleMethod11(){
        System.out.println("Использование метода valueOf()");

        String s1 = String.valueOf(3.0);
        System.out.println(s1);
        String s2 = String.valueOf(5);
        System.out.println(s2);
        String s3 = String.valueOf("text");
        System.out.println(s3);
        String s4 = String.valueOf(new StringClass());
        System.out.println(s4);
        char[] ch = {'a', 'b', 'c', 'd'};
        String s5 = String.valueOf(ch);
        System.out.println(s5);

        char[] ch1 = {'a', 'b', 'c', 'd', 'e', 'f'};
        s5 = String.valueOf(ch1, 2, 3);
        System.out.println(s5);
    }

    /*---------------------------------------------------------------------*/

    /* 12) использования методов toLowerCase() и toUpperCase()*/

    void exampleMethod12(){
        System.out.println("Использования методов toLowerCase() и toUpperCase()");

        String s1 = "MY TEXT IS VERY GOOD".toLowerCase();
        System.out.println("toLowerCase() "+s1);
        String s2 = "my text is 5".toUpperCase();
        System.out.println("toUpperCase() "+s2);
    }

    /*---------------------------------------------------------------------*/

    /* 13) использование метода join()*/

    void exampleMethod13(){
        System.out.println("Использование метода join()");

        String res = String.join(" ", "my", "text", "is", "very", "good");
        System.out.println(res);
        res = String.join(", ", "a", "b", "c", "d", "e");

        String[] arr = {"one", "two", "three", "four", "five"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        res = String.join(", -> ", list);
        System.out.println(res);
    }

    /*---------------------------------------------------------------------*/

    /* 14) использование класса StringBuffer - length(), setLength(), capacity(), ensureCapacity()*/

    /* Класс StringBuffer является потокобезопасной изменяемой строкой, а его методы являются синхронизированными.
     * Он используется в тех случаях когда речь идет о многопоточных программах*/

    void exampleMethod14(){
        System.out.println("Использование класса StringBuffer - length(), setLength(), capacity(), ensureCapacity()");

        StringBuffer sbuf = new StringBuffer("my text");
        System.out.println(sbuf);
        System.out.println("метод length() - размер: "+sbuf.length()); // получение размера
        sbuf.setLength(4); // установка размера
        System.out.println("метод seLength() - новый размер: "+sbuf.length());


        sbuf = new StringBuffer(7); // установка объема
        System.out.println("метод capacity() - объем: "+sbuf.capacity()); // получение объема
        sbuf.ensureCapacity(8); // установка объема методов ensureCapacity()
        System.out.println("метод ensureCapacity() - новый объем: "+sbuf.capacity());

        CharSequence cs = "my text";
        sbuf = new StringBuffer(cs);
        System.out.println(sbuf);
    }

    /*---------------------------------------------------------------------*/

    /* 15) использование класса StringBuffer - charAt(), setCharAt(), append(), insert(), reverse()*/

    void exampleMethod15(){

        System.out.println("Использование класса StringBuffer - charAt(), setCharAt(), append(), insert(), reverse()");

        StringBuffer sbuf = new StringBuffer("my text");
        System.out.println("символ: "+sbuf.charAt(4)); // получение символа
        sbuf.setCharAt(4, 'a'); // установка символа
        System.out.println("метод setCharAt() - "+sbuf);
        sbuf.setLength(sbuf.length()-1);
        System.out.println(sbuf);

        sbuf = new StringBuffer("my text is very good");
        char[] ch = new char[4];
        sbuf.getChars(3, 7, ch, 0);
        System.out.print("метод getChars() - ");
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }

        System.out.println("-------------------------");

        class StringTest{
            public String toString(){
                return "StringTest()";
            }
        }

        sbuf = new StringBuffer("my text");
        System.out.println(sbuf);
        sbuf.append("3").append(4).append(new StringTest()); // добавление строкового представления любого типа
        System.out.println("метод append() - "+sbuf);

        sbuf = new StringBuffer("my text");
        System.out.println(sbuf);
        sbuf.insert(3, "super ");
        sbuf.insert(13, 47);
        sbuf.insert(15, new StringTest());
        System.out.println("метод insert() - "+sbuf);

        sbuf = new StringBuffer("my text");
        sbuf.reverse();
        System.out.println("метод reverse() - "+sbuf);
    }

    /*---------------------------------------------------------------------*/

    /* 16) использование класса StringBuffer - delete(), deleteCharAt(), replace(), substring()*/

    void exampleMethod16(){
        System.out.println("/* использование класса StringBuffer - delete(), deleteCharAt(), replace(), substring()");

        StringBuffer sbuf = new StringBuffer("my text");
        System.out.println(sbuf);
        sbuf.delete(4, 7);
        System.out.println("метод delete() - "+sbuf);

        sbuf = new StringBuffer("my text");
        System.out.println(sbuf);
        sbuf.deleteCharAt(1);
        System.out.println("метод deleteCharAt() - "+sbuf);

        sbuf = new StringBuffer("my text");
        System.out.println("- "+sbuf);
        sbuf.replace(3,7, "word");
        System.out.println("метод replace() - "+sbuf);

        sbuf = new StringBuffer("my text");
        System.out.println(sbuf);
        System.out.println("метод1 substring() - "+sbuf.substring(1));
        System.out.println("метод2 substring() - "+sbuf.substring(3,7));
    }

    /*---------------------------------------------------------------------*/

    /* 17) использование класса StringBuffer - indexOf() и lastIndexOf()*/

    void exampleMethod17(){
        System.out.println("Использование класса StringBuffer - indexOf() и lastIndexOf()");

        StringBuffer sbuf = new StringBuffer("my text is text");
        int i;
        i = sbuf.indexOf("text");
        System.out.println("метод indexOf() - индекс первого вхождения: "+i);

        i = sbuf.lastIndexOf("text");
        System.out.println("метод lastIndexOf() - индекс последнего вхождения: "+i);
    }

    public static void main(StringClass[] args) {
        StringClass stringClass = new StringClass();
        stringClass.exampleMethod1();
        stringClass.exampleMethod2();
        stringClass.exampleMethod3();
        stringClass.exampleMethod4();
        stringClass.exampleMethod5();
        stringClass.exampleMethod6();
        stringClass.exampleMethod7();
        stringClass.exampleMethod8();
        stringClass.exampleMethod9();
        stringClass.exampleMethod10();
        stringClass.exampleMethod11();
        stringClass.exampleMethod12();
        stringClass.exampleMethod13();
        stringClass.exampleMethod14();
        stringClass.exampleMethod15();
        stringClass.exampleMethod16();
        stringClass.exampleMethod17();
    }
}
