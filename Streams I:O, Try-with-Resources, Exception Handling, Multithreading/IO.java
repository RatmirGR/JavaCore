package Streams;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/* использование метода list(), для получения списка файлов находящихся в указанном каталоге*/
class ExClass1{

    void method(){
        System.out.println("Использование метода list(), для получения списка файлов находящихся в указанном каталоге");

        File file = new File("d:\\pg\\file");
        for (String s : file.list()) System.out.println(s);
    }
}

/*---------------------------------------------------------------------*/

/* пример использование метода list() класса File*/
class ExClass2{

    void method(){
        System.out.println("Использование метода list() класса File");

        String dirname = "d:\\pg\\file";
        File file1 = new File(dirname);

        if (file1.isDirectory()){
            System.out.println("- каталог: "+file1.getName());
            String[] arrNameFile = file1.list();

            for (int i = 0; i < arrNameFile.length; i++) {
                File file2 = new File(dirname+"\\"+arrNameFile[i]);
                if (file2.isDirectory()) System.out.println(arrNameFile[i]+" является каталогом");
                else System.out.println(arrNameFile[i]+" является файлом");
            }
        }else{
            System.out.println(dirname+" не является каталогом");
        }
    }
}

/*---------------------------------------------------------------------*/

/* пример использования нескольких методов класса File*/
class ExClass3{

    void method(){
        System.out.println("Пример использования нескольких методов класса File");

        File file = new File("d:\\pg\\test2\\file.txt");

        /* получение имени файла*/
        System.out.println("- имя файла: "+file.getName());

        /* получение пути к файлу*/
        System.out.println("- path: "+file.getPath());

        /* получение родительского каталога*/
        System.out.println("- родительский каталог: "+file.getParent());

        /* получение абсолютного пути*/
        System.out.println("- абсолютный путь: "+file.getAbsolutePath());

        /* проверка, является ли файла каталогом*/
        System.out.println(file.isDirectory()? "- является каталого":"- не является каталогом");

        /* проверка, является ли файл файлом*/
        System.out.println(file.isFile()? "- является файлом" : "- не является файлом");

        /* проверка, можно ли читать файл*/
        System.out.println(file.canRead()? "- можно читать файл" : "- нельзя читать файл");

        /* проверка, можно ли записывать файл*/
        System.out.println(file.canWrite()? "- можно записывать файл" : "- нельзя записывать файл");

        /* проверка, существует ли файл*/
        System.out.println(file.exists() ? "- файл существует" : "- файл не существует");

        /* получение последнего изменения файла*/
        System.out.println("- последнее изменение: "+file.lastModified()/1000/60/60/24/365);
        System.out.println("- размер файла: "+file.length()+" байт");

        /* получение размера файла*/
        /* проверка является ли файл абсолютным*/
        System.out.println(file.isAbsolute()? "- имеет абсолютный путь" : "- не имеет абсолютный путь");

        /* получение true, если файл переименован и false, если нет*/
        //System.out.println((file.renameTo(new File("file1.txt"))? "- переименован" : "- не переименован"));;
        file.setLastModified(1999999999999999999l);
    }
}

/*---------------------------------------------------------------------*/

/* пример использование метода accept() класса FilenameFilter*/
/* класс MySClass2s реализует интерфейс FilenameFilter*/
class Filter implements FilenameFilter{
    private String ext;
    Filter(String ext){
        this.ext = ext;
    }
    /* реализация метода*/
    public boolean accept(File dir, String name){
        return name.endsWith(ext);
    }
}
class ExClass4{

    void method(){
        System.out.println("Использование метода accept() класса FilenameFilter");

        String dirname = "d:\\pg\\file";
        File file = new File(dirname);

        FilenameFilter only = new Filter(".txt");
        String[] arrNameFile = file.list(only);

        System.out.println("- вывести только файлы с расширением .txt: ");
        for (int i = 0; i < arrNameFile.length; i++) {
            System.out.println(i+" "+arrNameFile[i]);
        }
    }
}

/*---------------------------------------------------------------------*/

/* пример использование метода listFiles() класса FileFilter*/
class ExClass5{

    void method(){
        System.out.println("Использование метода listFiles() класса FileFilter");

        File file = new File("d:\\pg\\test2");

        System.out.println("- вывести все файлы из каталога:");
        File[] f = file.listFiles();

        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i]);
        }

        System.out.println("- вывести только файлы с расширением .txt: ");
        FilenameFilter only = new Filter(".txt");

        f = file.listFiles(only);

        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i]);
        }
    }
}

/*---------------------------------------------------------------------*/

/* пример использования методов mkdir() и mkdirs() класса File для создания каталогов*/

class ExClass6{

    void method(){
        System.out.println("Использование методов mkdir() и mkdirs() класса File для создания каталогов");

        /* метод mkdir может создать каталог, только если путь к нему известен*/
        boolean r = new File("d:\\pg\\test2\\mypack3").mkdir();

        System.out.println(r ? "- каталог создан" : "- каталог не создан");
        /* метод mkdirs может создать катало, даже если путь к нему неизвестен*/

        r = new File("d:\\pg\\test2\\mypack2\\st\\sts").mkdirs();
        System.out.println(r ? "- каталог создан" : "- каталог не создан");
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса FileInputStream*/
class ExClass7{

    void method(){
        System.out.print("Использование класса FileInputStream");

        int size;
        String mpath = "d:/pg/test2/file.txt";
        try(FileInputStream fis = new FileInputStream(mpath)){

            System.out.println("- общее количество доступных байтов: "+(size = fis.available()));
            int n = size/4;

            System.out.println("- первые "+n+" байтов, прочитанных из файла по очереди методом read()");
            for (int i = 0; i < n; i++) System.out.print((char)fis.read());
            System.out.println("\n- все еще доступно: "+fis.available());

            System.out.println("- чтение следующих "+n+" байтов по очереди методом read(arr[]), т.е. запись в массив");
            byte[] arr = new byte[n];

            if (fis.read(arr) != n) System.err.println("- нельзя прочитать "+n+" байтов");
            System.out.println(new String(arr, 0, n));
            System.out.println("- все еще доступно: "+ (size = fis.available()));

            System.out.println("- пропустить половину оставшихся байтов методом skip()");
            fis.skip(size/2);
            System.out.println("- все еще доступно: "+fis.available());

            System.out.println("- чтение "+(n/2)+" байтов, размещаемых в конце массива");
            if (fis.read(arr, n/2, n/2) != n/2) System.err.println("- нельзя прочитать "+n+" байтов");
            System.out.println(new String(arr, 0, arr.length));
            System.out.println("- все еще доступно: "+fis.available());
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

class ExClass8{

    void method(){
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        try(BufferedReader br1 = new BufferedReader(new FileReader("d:/pg/test2/file1.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("d:/pg/test2/file2.txt"))){

            StringBuilder sb = new StringBuilder();

            while (br1.ready()){
                int c = br1.read();
                if (c != 32) {
                    sb.append((char)c);
                }else{
                    list1.add(sb.toString());
                    sb = new StringBuilder();
                }
            }

            list1.add(sb.toString());

            sb = new StringBuilder();

            while (br2.ready()){
                int c = br2.read();
                if (c != 32) {
                    sb.append((char)c);
                }else{
                    list2.add(sb.toString());
                    sb = new StringBuilder();
                }
            }

            list2.add(sb.toString());

        }catch(IOException e){}

        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();

        for(String s : list1) if(isNumber(s)) list3.add(Integer.parseInt(s));
        for(String t : list2) if(isNumber(t)) list4.add(Integer.parseInt(t));

        System.out.println(list3);
        System.out.println(list4);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("d:/pg/test2/file3.txt"))){

            int i = 0;

            if (list3.size() < list4.size()){

                int s = list4.size() - list3.size();
                for (;i < list3.size(); i++) {
                    bw.write(String.valueOf(list3.get(i)+list4.get(i)));
                    bw.write(' ');
                }

                s += i;

                for (; i < s; i++) {
                    bw.write(String.valueOf(list4.get(i)));
                }
            }else {

                int s = list3.size() - list4.size();
                for (;i < list4.size(); i++) {
                    bw.write(String.valueOf(list4.get(i)+list3.get(i)));
                    bw.write(' ');
                }
                s += i;
                for (; i < s; i++) {
                    bw.write(String.valueOf(list3.get(i)));
                }
            }
        }catch(IOException e){}

    }

    private boolean isNumber(String str){
        try{
            int a = Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса FileOutputStream*/
class ExClass9{

    void method(){
        System.out.print("Использование класса FileOutputStream");

        String str = "My text is very good, but I’m not author";

        byte[] arr = str.getBytes();

        try(FileOutputStream fos1 = new FileOutputStream("d:/pg/test2/file1.txt");
        FileOutputStream fos2 = new FileOutputStream("d:/pg/test2/file2.txt");
        FileOutputStream fos3 = new FileOutputStream("d:/pg/test2/file3.txt")){

            /* запись данных в первый файл*/
            for (int i = 0; i < arr.length; i+=2) {
                fos1.write(arr[i]);
            }
            /* запись данных во второй файл*/
            fos2.write(arr);

            /* запись данных в третий файл*/
            fos3.write(arr, arr.length-arr.length/4, arr.length/4);
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса ByteArrayInputStream*/
class ExClass10{

    void method(){
        System.out.print("Использование класса ByteArrayInputStream");

        String str = "my text is very good";
        byte[] arr = str.getBytes();
        ByteArrayInputStream bais1 = new ByteArrayInputStream(arr);
        ByteArrayInputStream bais2 = new ByteArrayInputStream(arr, 0, 3);
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса ByteArrayInputStream - метод reset()*/
class ExClass11{

    void method(){
        System.out.println("Использование класса ByteArrayInputStream - метод reset()");

        String str = "my text is very good";

        byte[] arr = str.getBytes();

        ByteArrayInputStream bais = new ByteArrayInputStream(arr);

        for (int i = 0; i < 2; i++) {

            int c;

            /* чтение из потока типа ByteArrayInputStream*/
            System.out.print("- ");
            while ((c = bais.read()) != -1){
                if (i == 0) System.out.print((char)c);
                else System.out.print(Character.toUpperCase((char)c));
            }

            System.out.println();

            /* метод reset() возвращает поток в исходное состояние, в нашем случае - это начало массива*/
            bais.reset();
        }
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса ByteArrayOutputStream*/
class ExClass12{

    void method(){
        System.out.println("Использование класса ByteArrayOutputStream");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        String str = "- my text is very good";
        byte[] arr = str.getBytes();

        try{
            /* запись массива в поток типа ByteArrayOutputStream*/
            baos.write(arr);
        }catch(IOException e){return;}

        System.out.println("- буфер в виде символьной строки");
        /* вывод текста в потоке в виде символьной строки*/
        System.out.println("- "+baos.toString());

        System.out.println("- в массив");

        /* запись текста из потока в массив*/
        byte[] b = baos.toByteArray();

        /* вывод текста из массива*/
        System.out.print("- ");
        for (int i = 0; i < b.length; i++) {
            System.out.print((char)b[i]);
        }

        System.out.println("\n- в поток вывода типа OutputStream()");
        /* использование оператора try с ресурсами для управления потоком ввода-вывода данных в файл*/
        try(FileOutputStream fos = new FileOutputStream("d:/pg/test2/file.txt")){
            /* запись данных в файл*/
            baos.writeTo(fos);
        }catch(IOException e){return;}

        System.out.println("- установка в исходное состояние");
        /* метод reset() возвращает в исходное состояние, т.е. поток вновь становится пустым*/
        baos.reset();

        /* запись в поток*/
        for (int i = 0; i < 3; i++) baos.write('X');
        System.out.println("- "+baos.toString());
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса BufferedInputStream*/
class ExClass13{

    void method(){
        System.out.println("Использование класса BufferedInputStream");
        /* исходный текст*/
        String str = "- my text is very good&copy;, and &copy isn't copyright";

        /* преобразование текста в массив байтов*/
        byte[] arr = str.getBytes();

        /* передача ссылки на массив объекту типа ByteArrayInputStream*/
        /* теперь он имеет доступ к тексту внутри массива*/
        ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        int c;
        boolean marked = false;

        /* использование оператора try с ресурсами для управления файлами*/
        /* передача ссылки на поток типа ByteArrayInputStream потоку типа BufferedInputStream*/
        /* теперь он имеет доступ к тексту внутри массива*/
        try(BufferedInputStream buf = new BufferedInputStream(bais)){
            while((c = buf.read()) != -1){
                switch (c){
                    /* если символ = &, то если переменная marked = не false, то присвоить ему true,
                    * далее вызвать метод mark(), с помощью которого сохраняется метка для чтения следующих 32 байт,
                    * т.е метка устанавливается на текущую позицию (в нашем случае на позицию после символа "&") и
                    * стирает все что после нее, при этом сохраняя у себя копию стертого текста,
                    * если будет вызван метод reset(), то он вернет текст обратно,
                    * а иначе присвоить переменной marked false*/
                    case '&':
                        if (!marked){
                            marked = true;
                            buf.mark(32);
                        }else marked = false;
                        break;
                    /* если символ = ;, то если переменная marked = true, то присвоить ему false,
                    * далее с позиции метки, установленной методом mark() вывести символ авторского право, до символа
                    * ";", а иначе просто вывести текущий символ*/
                    case ';':
                        if (marked){
                            marked = false;
                            System.out.print("(c)");
                        }else System.out.print((char)c);
                        break;
                    /* если символ = пробелу, то если переменная marked = true, то присвоить ему false,
                    * далее вызвать метод reset(), вернув поток на позицию метки и вывести символ "&"
                    * а иначе просто вывести текущий символ*/
                    case ' ':
                        if (marked){
                            marked = false;
                            buf.reset();
                            System.out.print("&");
                        }else System.out.print((char)c);
                        break;
                    /* по умолчанию, если переменная marked не false, то просто выводится символы*/
                    default:
                        if(!marked) System.out.print((char)c);
                }
            }
            System.out.println();
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса PushbackInputStream*/
class ExClass14{

    void method(){
        System.out.println("Использование класса PushbackInputStream");

        int c;
        String str = "if(a == b) a = 0;";
        byte[] arr = str.getBytes();

        ByteArrayInputStream bais = new ByteArrayInputStream(arr);

        try(PushbackInputStream pbis = new PushbackInputStream(bais)){
            while ((c = pbis.read()) != -1){
                switch (c){
                    case '=':
                        if ((c = pbis.read()) == '='){
                            System.out.print(".eq.");
                        }else{
                            System.out.print("<-");
                            pbis.unread(c);
                        }break;
                    default: System.out.print((char)c);break;
                }
            }
        }catch(IOException e){}

        System.out.println();

    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса SequenceInputStream*/
class Enumeration1 implements Enumeration<FileInputStream>{

    private Enumeration<String>f;

    Enumeration1(Vector<String>files){
        f = files.elements();
    }

    public boolean hasMoreElements(){
        return f.hasMoreElements();
    }

    public FileInputStream nextElement(){
        try{
            return new FileInputStream(f.nextElement().toString());
        }catch(Exception e){
            return null;
        }
    }
}

class ExClass15{

    void method(){
        System.out.println("Использование класса SequenceInputStream");

        int c, a = 0;

        /* создание объекта типа Vector и добавление в него трех элементов - имена файлов, которые следует прочитать*/
        Vector<String> files = new Vector<>();
        files.addElement("d:/pg/test2/file1.txt");
        files.addElement("d:/pg/test2/file2.txt");
        files.addElement("d:/pg/test2/file3.txt");

        /* создание объекта типа MySClass12s, который служит оболочкой для объекта типа Vector.
        * Он возвращает не имена файлов, а созданные потоки типа FileInputStream, открытых по этим именам*/
        Enumeration1 mc = new Enumeration1(files);

        /* создание потока типа SequenceInputStream, которому передается объект типа MySClass12s. Он читает все
        * переданные файлы по очереди и закрывает каждый прочитанный поток*/
        try(InputStream is = new SequenceInputStream(mc)){
            while ((c = is.read()) != -1){
                if(a == 20){a = -22; System.out.println();}
                System.out.print((char)c);
                a++;
            }
            System.out.println();
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса PrintStream*/
class ExClass16{

    void method(){
        System.out.print("Использование класса PrintStream");
        System.out.println("- вывести некоторые числовые значения в разных форматах");
        System.out.printf("- разные целочисленные форматы: %d %(d %+d %05d\n", 3, -3, 3, 3);
        System.out.printf("- формат чисел с плавающей точкой по умолчанию: %f\n", 1234567.123);
        System.out.printf("- формат чисел с плавающей точкой, разделяемых запятыми: %,f\n", 1234567.123);
        System.out.printf("- формат отрицательных чисел с плавающей точкой по умолчанию: %,f\n", -1234567.123);
        System.out.printf("- другой формат отрицательных чисел с плавающей точкой: (%,f)\n", 1234567.123);
        System.out.printf("- выравнивание положительных и отрицательных числовых значений:\n");
        System.out.printf("% ,.2f\n% ,.2f\n", 1234567.123, -1234567.123);
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* пример использования классов DataOutputStream и DataInputStream*/
class ExClass17{

    void method(){
        System.out.println("Использование классов DataOutputStream и DataInputStream");

        /* вывести данные в файл - примитивные типы преобразуются в последовательность байтов и записываются
        * в указанный файл*/
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("d:/pg/test2/file.txt"))) {
            dos.writeDouble(98.6);
            dos.writeInt(1000);
            dos.writeBoolean(true);
        }catch (FileNotFoundException e){return;
        }catch(IOException e){}

        /* ввести данные из файла - последовательность байтов преобразуются в примитивные типы и присваиваются
        * соответствующим переменным*/
        try(DataInputStream dis = new DataInputStream(new FileInputStream("d:/pg/test2/file.txt"))){
            double d = dis.readDouble();
            int i = dis.readInt();
            boolean b = dis.readBoolean();
            /* вывести полученные значения*/
            System.out.println("получаемые значения: "+d+" "+i+" "+b);
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса FileReader*/
class ExClass18{

    void method(){
        System.out.println("Использование класса FileReader");
        try(FileReader fr = new FileReader("d:/pg/test2/file.txt")){
            int c;
            while ((c = fr.read()) != -1) System.out.print((char)c);
        }catch(IOException e){}
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса FileWriter*/
class ExClass19{

    void method(){
        System.out.println("Использование класса FileWriter");

        String str = "my text is very good";

        char[] arr = new char[str.length()];

        str.getChars(0, str.length(), arr, 0);

        try(FileWriter f1 = new FileWriter("d:/pg/test2/file1.txt");
            FileWriter f2 = new FileWriter("d:/pg/test2/file2.txt");
            FileWriter f3 = new FileWriter("d:/pg/test2/file3.txt")){
            /* вывести символы в первый файл*/
            for (int i = 0; i < str.length(); i+=2) {
                f1.write(arr[i]);
            }
            /* вывести символы во второй файл*/
            f2.write(arr);

            /* вывести символы в третий файл*/
            f3.write(arr, arr.length-arr.length/4, arr.length/4);
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса CharArrayReader*/
class ExClass20 {

    void method() {
        System.out.println("Использование класса CharArrayReader");

        String str = "my text is very good";
        int len = str.length();
        char[] arr = new char[len];
        str.getChars(0, len, arr, 0);

        /* объект типа CharArrayReader содержит все символы*/
        try (CharArrayReader car = new CharArrayReader(arr)) {
            int c = 0;
            while ((c = car.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {}

        /* объект типа CharArrayReader содержит только первые пять символов*/
        try (CharArrayReader car = new CharArrayReader(arr, 0, 5)) {
            int c = 0;
            while ((c = car.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса CharArrayWriter*/
class ExClass21 {

    void method() {
        System.out.println("Использование класса CharArrayWriter");

        CharArrayWriter caw = new CharArrayWriter();
        String str = "my text is very good";
        char[] arr = new char[str.length()];

        /* заполнение массива arr символами строки str*/
        str.getChars(0, str.length(), arr, 0);

        /* запись массива arr в буфер типа CharArrayWriter*/
        try {
            caw.write(arr);
        }catch(IOException e){return;}

        /* вывод буфера типа CharArrayWriter в виде символьной строки */
        System.out.println("- буфер в виде символьной строки: "+caw.toString());

        /* вывод буфера типа CharArrayWriter в массив*/
        System.out.println("- в массив:");
        char[] c = caw.toCharArray();

        System.out.print("- ");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        /* запись буфера типа CharArrayWriter в поток вывода типа FileWriter*/
        /* использование оператора try с ресурсами для управления потоком ввода-вывода в файл*/
        try(FileWriter fw = new FileWriter("d:/pg/test2/s1.txt")){
            caw.writeTo(fw);
        }catch(IOException e){}

        System.out.println("\n- установка в исходное состояние");
        /* установка в исходное состояние*/
        caw.reset();

        System.out.print("- ");
        for (int i = 0; i < 3; i++) caw.write('X');

        System.out.println(caw.toString());
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса BufferedReader*/
class ExClass22{

    void method(){
        System.out.println("Использование класса BufferedReader");

        String str = "my text is &copy; very &copy good";

        char[] arr = new char[str.length()];

        str.getChars(0, str.length(), arr, 0);

        CharArrayReader car = new CharArrayReader(arr);

        int c;
        boolean marked = false;

        try(BufferedReader br = new BufferedReader(car)){
            while((c = br.read()) != -1){
                switch(c){
                    case '&':
                        if(!marked){
                            br.mark(32);
                            marked = true;
                        }else marked = false; break;
                    case ';':
                        if(marked){
                            System.out.print("(c) - copyright,");
                            marked = false;
                        }else System.out.print((char)c); break;
                    case ' ':
                        if(marked){
                            br.reset();
                            marked = false;
                            System.out.println(" & - not copyright");
                        }else System.out.print((char)c); break;
                    default:
                        if(!marked) System.out.print((char)c); break;
                }
            }
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса PushbackReader*/
class ExClass23{

    void method(){
        System.out.println("Использование класса PushbackReader");

        String str = "if(a == b) a = 0;\n";

        char[] arr = new char[str.length()];

        str.getChars(0, str.length(), arr, 0);

        CharArrayReader car = new CharArrayReader(arr);

        int c;

        try(PushbackReader pbr = new PushbackReader(car)){
            while ((c = pbr.read()) != -1){
                switch (c){
                    case '=':
                        if ((c = pbr.read()) == '=') System.out.print(".eq.");
                        else{
                            System.out.print("<-");
                            pbr.unread(c);
                        }
                        break;
                    default: System.out.print((char)c);
                }
            }
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования класса Console*/
class ExClass24{

    void method(){
        System.out.println("Использование класса Console");

        /* получение ссылки на консоль*/
        Console con = System.console();

        /* проверка, если консоль недоступна, то выйти из программы*/
        if (con == null) return;

        /* чтение строки и ее вывод*/
        String str = con.readLine("- введите строку: ");
        con.printf("- выводимая строка: %s\n", str);
    }
}

/*---------------------------------------------------------------------*/

/* пример использования сериализации и десериализации*/
class SerializeClass implements Serializable{
    private String name;
    private int age;
    private double temp;
    public SerializeClass(String s, int i, double d){
        name = s; age = i; temp = d;
    }
    public String toString(){
        return "name = "+name+"; age = "+age+"; temp = "+temp;
    }
}

class ExClass25{

    void method(){
        System.out.println("Использование сериализации и десериализации");

        /* произведение сериализации объекта*/
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/pg/test2/file"))){
            SerializeClass mc1 = new SerializeClass("dog", 11, 34.8);

            System.out.println("mc1: "+mc1);

            oos.writeObject(mc1);
        }catch(IOException e){}

        /* произведение десериализации объекта*/
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/pg/test2/file"))) {
            SerializeClass mc2 = (SerializeClass) ois.readObject();

            System.out.println("mc2: "+mc2);

        }catch (ClassNotFoundException e){
        }catch(IOException e){System.exit(0);}
    }
}

/*---------------------------------------------------------------------*/

/* использование класса BufferedReader для чтения символов с консоли*/
class ExClass26{

    void method(){
        System.out.println("Использование класса BufferedReader для чтения символов с консоли");

        char c;

        /* создание потока ввода типа BufferedReader, используя стандартный поток ввода System.in*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            do {
                /* использование метода read() для чтения символов*/
                c = (char) br.read();
                System.out.print(c);
            } while (c != 'q');
        }catch (IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* использование класса BufferedReader для чтения символьных строк с консоли*/
class ExClass27{

    void method(){
        System.out.println("Использование класса BufferedReader для чтения символьных строк с консоли");

        String str;

        /* создание потока ввода типа BufferedReader, используя стандартный поток ввода System.in*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            do{
                /* использования метода readLine() для чтения символьных строк*/
                str = br.readLine();
                System.out.println(str);
            }while(!str.equals("stop"));
        }catch(Exception e){}
    }
}

/*---------------------------------------------------------------------*/

/* использование класса BufferedReader для чтения символьных строк с консоли и записи в массив*/
class ExClass28{

    void method(){
        System.out.println("Использование класса BufferedReader для чтения символьных строк с консоли и записи в массив");

        String[] arr = new String[5];
        int i = -1;

        /* создание потока ввода типа BufferedReader, используя стандартный поток ввода System.in*/
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("введите строки текста, ‘стоп’ – для выхода");
        try{
            do{
                i++;
                /* использования метода readLine() для чтения символьных строк*/
                arr[i] =  br.readLine();
            }while(i < arr.length-1 && !arr[i].equals("stop"));
        }catch(IOException e){}
        for(i = 0; i < arr.length; i++){
            if (arr[i].equals("stop")) break;
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

/*---------------------------------------------------------------------*/

/* использование класса System и метода write() для вывода данных на консоль*/
class ExClass29{

    void method(){
        System.out.println("Использование класса System и метода write() для вывода данных на консоль");

        int b = 'A';
        /* метод write() применяется для вывода на экран буквы "A" с последующим переводом строки*/
        System.out.write(b);
        System.out.write('\n');
    }
}

/*---------------------------------------------------------------------*/

/* использование класса PrintWriter для вывода данных на консоль*/
class ExClass30{

    void method(){
        System.out.println("Использование класса PrintWriter для вывода данных на консоль");

        /* создание объекта типа PrintWriter*/
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("My text");
        int b = 7;
        pw.println(b);
        double d = 4.7;
        pw.println(d);
    }
}

/*---------------------------------------------------------------------*/

/* использование класса FileInputStream - чтение из файла*/
class ExClass31{

    void method(){
        System.out.println("Использование класса FileInputStream - чтение с файла");

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        FileInputStream fin;
        int i;

        try{
            String name = br.readLine();
            if (name == null) return;
            /* создание объекта типа FileInputStream и открытие указанного файла*/
            fin = new FileInputStream(name);
            System.out.println("open file");
            long time = System.currentTimeMillis();
            System.out.println("reading file");
            do{
                /* чтение из файла*/
                i = fin.read();
                if (!(i == -1))System.out.print((char)i);
            }while(i != -1);
            time = System.currentTimeMillis() - time;
            System.out.println(time/1000);
            fin.close();
            System.out.println("\nclose file");
        }catch(FileNotFoundException e){
            System.out.println("error open file");
        }catch (IOException e){
            System.out.println("error read of file or close file");
        }
    }
}

/*---------------------------------------------------------------------*/

/* использование класса FileInputStream - чтение из файла - закрытие файла - finally*/
class ExClass32{

    void method(){
        System.out.println("Использование класса FileInputStream - чтение из файла - закрытие файла - finally");

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        FileInputStream fin = null;
        int i;

        try{
            String name = br.readLine();
            if (name == null) return;
            /* создание объекта типа FileInputStream - открытие файла*/
            System.out.println("open file");
            fin = new FileInputStream(name);
            /* чтение из файла*/
            System.out.println("reading file");
            do{
                i = fin.read();
                if(i != -1) System.out.print((char)i);
            }while(i != -1);
            System.out.println();
        }catch(IOException e){

        }finally {
            try{
                /* закрытие потока - файла*/
                if (fin != null) fin.close();
                System.out.println("close file");
            }catch(IOException e){}
        }
    }
}

/*---------------------------------------------------------------------*/

/* другой пример закрытия файла*/
class ExClass33{

    void method(){
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        FileInputStream fis = null;

        try{
            /* открытие файла*/
            System.out.println("open file");
            String name = br.readLine();
            if (name == null) return;
            fis = new FileInputStream(name);
            int i;
            /* чтение файла*/
            System.out.println("reading file");
            do{
                i = fis.read();
                if (i != -1) System.out.print((char)i);
            }while(i != -1);
            System.out.println();
        }catch (IOException e){
            // класс исключения FileNotFoundException является произовдным от класса исключения IOException,
            // поэтому указывать его необязательно*/
            System.out.println(e);
        }finally {
            try{
                /* если файл был удачно открыт, то он не будет ссылаться на null, соответственно его можно
                 * закрыть - закрытие файла*/
                if (fis != null) fis.close();
                System.out.println("close file");
            }catch(IOException e){}
        }
    }
}

/*---------------------------------------------------------------------*/

/* вариант обработки ошибки ввода имени файла*/
class ExClass34{
    String name;

    void method(){
        System.out.println("Вариант обработки ошибки ввода имени файла");

        boolean flag = true;
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        FileInputStream fis = null; int i = 0;

        exPoint:do{
            try {
                System.out.println("введите имя файла:");
                name = br.readLine();
                fis = new FileInputStream("d:\\pg\\test2\\"+name);
                System.out.println("открытие файла");
                flag = false;
                System.out.println("чтение файла");
                do{
                    i = fis.read();
                    if (i != -1) System.out.print((char)i);
                }while(i != -1);
                System.out.println();
            }catch (IOException e){
                continue exPoint;
            }finally {
                if (fis != null) {
                    try {
                        fis.close();
                        System.out.println("закрытие файла");
                    } catch (IOException e) {}
                }
            }
        }while (flag);
    }
}

/*---------------------------------------------------------------------*/

/* использование класса FileOutputStream - запись в файл*/
class ExClass35{

    void method(){
        System.out.println("Использование класса FileOutputStream - запись в файл");

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int i = 0;

        try{
            /* получение имени исходного файла*/
            System.out.println("введите имя исходного файла:");
            String name1 = br.readLine();

            System.out.println("введите имя целевого файла:");
            /* получение имени целевого файла*/
            String name2 = br.readLine();

            /* проверка, указаны ли имена файлов*/
            if (name1 == null || name2 == null) return;

            /* создание объектов - открытие файлов*/
            System.out.println("открытие первого файла");
            fis = new FileInputStream("d:\\pg\\test2\\"+name1+".txt");

            System.out.println("открытие второго файла");
            fos = new FileOutputStream("d:\\pg\\test2\\"+name2+".txt");
            System.out.println("чтение из одного файла и запись в другой файл");
            do{
                /* чтение из одного файла*/
                i = fis.read();

                /* запись в другой файл*/
                if(i != -1) fos.write(i);
            }while(i != -1);
        }catch(IOException e){
            System.out.println("ошибка");
        }finally {
            try{
                /* закрытие файла, но только если объект fis не null*/
                if (fis != null) fis.close();
                System.out.println("закрытие первого файла");
            }catch(IOException e){
                System.out.println("ошибка-1");
            }
            try{
                /* закрытие файла, но только если объект fos не null*/
                if (fos != null) fos.close();
                System.out.println("закрытие второго файла");
            }catch(IOException e){}
        }
    }
}

/*---------------------------------------------------------------------*/

/* пример чтения и записи файла - с использованием классов FileReader и FileWriter*/
class ExClass36{

    void method(){
        System.out.println("Пример чтения и записи файла - с использованием классов FileReader и FileWriter");

        FileReader fr = null; FileWriter fw = null; int i = 0;
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        try{
            System.out.println("введите имя первого файла");
            fr = new FileReader("d:\\pg\\test2\\"+br.readLine()+".txt");

            System.out.println("введите имя второго файла");
            fw = new FileWriter("d:\\pg\\test2\\"+br.readLine()+".txt");

            System.out.println("открытие файлов");
            System.out.println("чтение и запись файлов");
            long t = System.currentTimeMillis();

            do{
                i = fr.read();
                if (i != -1){
                    System.out.print((char)i);
                    fw.write(i);
                }
            }while(i != -1);
            System.out.println("\n"+(System.currentTimeMillis() - t)/1000+" сек");
        }catch(IOException e){ System.out.println("ошибка");
        }finally {
            try{
                if (fr != null && fw != null){
                    fr.close();
                    fw.close();
                    System.out.println("закрытие файлов");
                }
            }catch(IOException e){System.out.println("ошибка-1");}
        }
    }
}

/*---------------------------------------------------------------------*/

/* использование оператора try с ресурсами*/
class ExClass37{

    void method(){
        System.out.println("Использование оператора try с ресурсами");

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String name = null; int i = 0;

        try {
            System.out.println("введите имя файла:");
            name = br.readLine();
            if (name == null) return;
        }catch (IOException e){}

        /* создание объекта типа FileInputStream*/
        /* оператор try с ресурсами применяется сначала для открытия,
         * а затем для автоматического закрытия файла по завершении блока этого оператора*/
        try (FileInputStream fis = new FileInputStream("d:\\pg\\test2\\"+name+".txt")){
            System.out.println("открытие файла");
            System.out.println("чтение файла");
            do{
                i = fis.read();
                i = getRusTranslate(i);
                if (i != -1) System.out.print((char)i);
            }while(i != -1);
            System.out.println("\nзакрытие файла");
        }catch (IOException e){}
    }

    private int getRusTranslate(int a){
        if(a >= 224 && a <= 255) return a + 848;
        return a;
    }
}

/*---------------------------------------------------------------------*/

/* использования оператора try с ресурсами для создания нескольких потоков ввода-вывода*/
class ExClass38{

    void method(){
        System.out.println("Использования оператора try с ресурсами для создания нескольких потоков ввода-вывода");

        int i = 0;
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String name = null, name1 = null;

        try {
            System.out.println("введите имя первого файла");
            name = getNamePath(br.readLine());
            System.out.println("введите имя второго файла");
            name1 = getNamePath(br.readLine());
            if (name == null || name1 == null) return;
        }catch (IOException e){}

        /* создание двух объектов - открытие и управления двумя ресурсами (файлами)*/
        try(FileInputStream fis = new FileInputStream(name); FileOutputStream fos = new FileOutputStream(name1)){
            System.out.println("открытие двух файлов");
            do{
                /* чтение и запись файла*/
                i = fis.read();
                if (i != -1) fos.write(i);
            }while(i != -1);
        }catch(IOException e){}
        System.out.println("закрытие файлов");
    }

    private String getNamePath(String name){
        return "d:\\pg\\test2\\"+name+".txt";
    }
}

/*---------------------------------------------------------------------*/

public class IO {

    public static void main(String[] args) {
        new ExClass1().method(); System.out.println("----------------------");
        new ExClass2().method(); System.out.println("----------------------");
        new ExClass3().method(); System.out.println("----------------------");
        new ExClass4().method(); System.out.println("----------------------");
        new ExClass5().method(); System.out.println("----------------------");
        new ExClass6().method(); System.out.println("----------------------");
        new ExClass7().method(); System.out.println("----------------------");
        new ExClass8().method(); System.out.println("----------------------");
        new ExClass9().method(); System.out.println("----------------------");
        new ExClass10().method(); System.out.println("----------------------");
        new ExClass11().method(); System.out.println("----------------------");
        new ExClass12().method(); System.out.println("----------------------");
        new ExClass13().method(); System.out.println("----------------------");
        new ExClass14().method(); System.out.println("----------------------");
        new ExClass15().method(); System.out.println("----------------------");
        new ExClass16().method(); System.out.println("----------------------");
        new ExClass17().method(); System.out.println("----------------------");
        new ExClass18().method(); System.out.println("----------------------");
        new ExClass19().method(); System.out.println("----------------------");
        new ExClass20().method(); System.out.println("----------------------");
        new ExClass21().method(); System.out.println("----------------------");
        new ExClass22().method(); System.out.println("----------------------");
        new ExClass23().method(); System.out.println("----------------------");
        new ExClass24().method(); System.out.println("----------------------");
        new ExClass25().method(); System.out.println("----------------------");
        new ExClass26().method(); System.out.println("----------------------");
        new ExClass27().method(); System.out.println("----------------------");
        new ExClass28().method(); System.out.println("----------------------");
        new ExClass29().method(); System.out.println("----------------------");
        new ExClass30().method(); System.out.println("----------------------");
        new ExClass31().method(); System.out.println("----------------------");
        new ExClass32().method(); System.out.println("----------------------");
        new ExClass33().method(); System.out.println("----------------------");
        new ExClass34().method(); System.out.println("----------------------");
        new ExClass35().method(); System.out.println("----------------------");
        new ExClass36().method(); System.out.println("----------------------");
        new ExClass37().method(); System.out.println("----------------------");
        new ExClass38().method(); System.out.println("----------------------");
    }
}
