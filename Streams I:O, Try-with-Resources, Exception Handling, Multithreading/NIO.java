package Streams;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

/* пример использования канала ввода-вывода для чтения файлов*/
class ExClass1{

    void method(){
        System.out.println("Использование канала ввода-вывода для чтения файлов");

        Path filepath = null;
        int count;

        /* сначала получение пути к файлу*/
        try{
            filepath = Paths.get("file.txt");
        }catch(InvalidPathException e){return;}

        /* затем получение канала к этому файлу в блоке оператора try с ресурсами*/
        try(SeekableByteChannel sbc = Files.newByteChannel(filepath)){

            /* выделение памяти под буфер*/
            ByteBuffer buf = ByteBuffer.allocate(128);
            System.out.print("- ");
            do{
                /* чтение данных из файла в буфер*/
                count = sbc.read(buf);

                /* прекращение чтения по достижении конца файла*/
                if (count != -1) {
                    buf.rewind();
                    /* чтение байтов данных из буфера и вывод их на экран как символы*/
                    for (int i = 0; i < count; i++) {
                        System.out.print((char)buf.get());
                    }
                }
            }while(count != -1);

            System.out.println();

        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования компактного способа открытия файла, чем в примере выше*/
class ExClass2{

    void method(){
        int count;

        /* канал открывается по пути, возвращаемому методом Paths.get() в виде объекта типа Path*/
        /* переменная filepath больше не нужна*/
        try(SeekableByteChannel sbc = Files.newByteChannel(Paths.get("file.txt"))) {

            /* выделение памяти под буфер*/
            ByteBuffer buf = ByteBuffer.allocate(128);
            System.out.print("- ");
            do {
                /* чтение данных из файла в буфер*/
                count = sbc.read(buf);

                /* прекращение чтения по достижении конца файла*/
                if (count != -1) {
                    /* подготовка буфера к чтению из него данных*/
                    buf.rewind();

                    /* чтение байтов данных из буфера и вывод их на экран как символы*/
                    for (int i = 0; i < count; i++) System.out.print((char) buf.get());
                }
            } while (count != -1);

            System.out.println();

        }catch (InvalidPathException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования отображения для чтения данных из файла*/
class ExClass3 {

    void method() {
        System.out.println("Использование отображения для чтения данных из файла");

        /* получение канала к файлу в блоке оператора try с ресурсами*/
        try(FileChannel fc = (FileChannel)Files.newByteChannel(Paths.get("file.txt"))) {
            /* получение размера файла*/
            long fSize = fc.size();

            /* отображение файла в буфер*/
            MappedByteBuffer buf = fc.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            System.out.print("- ");
            /* чтение байтов из буфера и вывод их на экран*/
            for (int i = 0; i < fSize; i++) System.out.print((char)buf.get());

            System.out.println();

        }catch (InvalidPathException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования канала ввода-вывода для записи файлов*/
class ExClass4{

    void method(){
        System.out.println("Использование канала ввода-вывода для записи файлов");

        /* получение канала к файлу в блоке оператора try с ресурсами - способ открытия (создание файла и его чтение)*/
        try(FileChannel fc = (FileChannel) Files.newByteChannel(Paths.get("file.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            /* создание буфера*/
            ByteBuffer buf = ByteBuffer.allocate(26);

            /* запись некоторого количества байтов в буфер*/
            for (int i = 0; i < 26; i++) {
                buf.put((byte) ('A' + i));
            }
            /* подготовка буфера к записи данных*/
            buf.rewind();

            /* запись данных из буфера в выходной файл*/
            fc.write(buf);

        }catch (InvalidPathException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования отображения для записи данных s файл*/
class ExClass5{

    void method(){
        System.out.println("Использование отображения для записи данных s файл");

        int size = 26;

        try(FileChannel fc = (FileChannel)Files.newByteChannel(Paths.get("file.txt"),
                StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE)){

            /* сопоставление файла с буфером*/
            /* буфер mbuf сопоставляется с файлом, поэтому изменения в буфере автоматически отражаются
            в основном файле*/
            MappedByteBuffer mbuf = fc.map(FileChannel.MapMode.READ_WRITE, 0 , size);

            /* запись заданного количества байт в буфер*/
            for (int i = 0; i < size; i++) {
                mbuf.put((byte) ('A' + i));
            }
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования копирования файла средствами ввода-вывода NIO*/
class ExClass6{

    void method(){
        System.out.println("Использование копирования файла средствами ввода-вывода NIO");

        String[] args = new String[2];
        args[0] = "file1.txt";
        args[1] = "file2.txt";

        /* проверка, введены ли два файла*/
        if(args.length != 2) return;
        /* получение адресов файлов*/
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);
        try{
            /* копирование файла*/
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования потокового ввода на основе системы NIO*/
class ExClass7{

    void method(){
        System.out.println("Использование потокового ввода на основе системы NIO");

        int i;

        /* открытие файла и получение связанного с ним потока вввода-вывода*/
        try(InputStream is = Files.newInputStream(Paths.get("file.txt"))) {
            System.out.print("- ");
            do {
                i = is.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);

            System.out.println();

        }catch (InvalidPathException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования потокового ввода на основе системы NIO с применением буферизации*/
class ExClass8{

    void method(){
        System.out.println("Использование потокового ввода на основе системы NIO с применением буферизации");

        int i;

        /* открытие файла и получение связанного с ним потока ввода-вывода с применением буферизации*/
        try(InputStream is = new BufferedInputStream(Files.newInputStream(Paths.get("file.txt")))) {
            System.out.print("- ");
            do {
                i = is.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);

            System.out.println();

        }catch (InvalidPathException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования потокового вывода на основе системы NIO с применением буферизации*/
class ExClass9{

    void method(){
        System.out.println("Использование потокового вывода на основе системы NIO с применением буферизации");

        /* открытие файла и получение связанного с ним потока вывода с применением буферизации*/
        try(OutputStream os = new BufferedOutputStream(Files.newOutputStream(Paths.get("file.txt")))){
            /* вывод в поток заданного количества байтов*/
            for (int i = 0; i < 26; i++) {
                os.write((char)('A' + i));
            }
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования некоторых методов из интерфейса Path и класса Files*/
class ExClass10{

    void method(){
        System.out.println("Использование некоторых методов из интерфейса Path и класса Files");

        Path filepath = Paths.get("file.txt");

        System.out.println("- имя файла: "+filepath.getName(2));
        System.out.println("- путь к файлу: "+filepath);
        System.out.println("- абсолютный путь: "+filepath.toAbsolutePath());
        System.out.println("- родительский каталог: "+filepath.getParent());

        if(Files.exists(filepath)) System.out.println("- файл существует");
        else System.out.println("- файл не существует");

        try{
            if(Files.isHidden(filepath)) System.out.println("- файл скрыт");
            else System.out.println("- файл не скрыт");
        }catch(IOException e){}

        Files.isWritable(filepath); System.out.println("- файл доступн для записи");
        Files.isReadable(filepath); System.out.println("- файл доступн для чтения");

        /* BasicFileAttributes*/
        System.out.println("BasicFileAttributes");
        try{
            BasicFileAttributes att = Files.readAttributes(filepath, BasicFileAttributes.class);

            if (att.isDirectory()) System.out.println("- это каталог");
            else System.out.println("- это не каталог");

            if (att.isRegularFile()) System.out.println("- это обычный файл");
            else System.out.println("- это не обычный файл");

            if (att.isSymbolicLink()) System.out.println("- это символическая ссылка");
            else System.out.println("- это не символическая ссылка");

            System.out.println("- время последней модификации файла: "+att.lastModifiedTime());
            System.out.println("- размер файла: "+att.size()+" байт");
        }catch(IOException e){}

        /* DosFileAttributes*/
        System.out.println("DosFileAttributes");
        try{
            DosFileAttributes att = Files.readAttributes(filepath, DosFileAttributes.class);

            if (att.isDirectory()) System.out.println("- это каталог");
            else System.out.println("- это не каталог");

            if (att.isRegularFile()) System.out.println("- это обычный файл");
            else System.out.println("- это не обычный файл");

            if (att.isSymbolicLink()) System.out.println("- это символическая ссылка");
            else System.out.println("- это не символическая ссылка");

            System.out.println("- время последней модификации файла: "+att.lastModifiedTime());
            System.out.println("- размер файла: "+att.size()+" байт");
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример получения содержимого каталога*/
class ExClass11{

    void method(){
        System.out.println("Получение содержимого каталога");

        String dirname = "d:/pg/";
        /* получение и обработка потока ввода каталога в блоке оператора try с ресурсами*/

        try(DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(dirname))) {
            System.out.println("- каталог: " + dirname);

            /* класс DirectoryStream реализует интерфейс Iterable, поэтому для вывода содержимого каталога
             * можно организовать цикл for в стиле for each*/
            for (Path dir : ds) {
                BasicFileAttributes bfa = Files.readAttributes(dir, BasicFileAttributes.class);
                if (bfa.isDirectory()) System.out.print("<DIR>");
                else System.out.print("     ");
                System.out.println(dir.getName(1));
            }
        }catch (InvalidPathException e) {
        }catch (NotDirectoryException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример получения содержимого отфильтрованного каталога с использованием метасимволов*/
class ExClass12{

    void method(){
        System.out.println("Получение содержимого отфильтрованного каталога с использованием метасимволов");

        String dirname = "d:/pg/";

        /* получение и обработка потока ввода каталога в блоке оператора try с ресурсами*/
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(dirname), "{sr}*.{class}")) {
            System.out.println("- каталог: " + dirname);

            /* класс DirectoryStream реализует интерфейс Iterable, поэтому для вывода содержимого каталога
             * можно организовать цикл for в стиле for each*/
            for (Path dir : ds) {
                BasicFileAttributes bfa = Files.readAttributes(dir, BasicFileAttributes.class);
                if (bfa.isDirectory()) System.out.print("<DIR>");
                else System.out.print("     ");
                System.out.println(dir.getName(1));
            }
        }catch (InvalidPathException e) {
        }catch (NotDirectoryException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример получения отфильтрованного содержимого каталога с использованием DirectoryStream.Filter*/
class ExClass13{

    void method(){
        System.out.println("Получение отфильтрованного содержимого каталога с использованием DirectoryStream.Filter");
        String dirname = "d:/pg";

        /* создание фильтра, возвращающий true, только в отношении доступных для записи файлов*/
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                if (Files.isWritable(entry)) return true;
                else return false;
            }
        };

        /* получение и использование потока ввода из каталога только доступных для записи файлов*/
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(dirname), filter)) {
            System.out.println("Каталог: "+dirname);
            for(Path dir : ds ){
                BasicFileAttributes bfa = Files.readAttributes(dir, BasicFileAttributes.class);
                if (bfa.isDirectory()) System.out.print("<DIR>");
                else System.out.print("     ");
                System.out.println(dir.getName(1));
            }
        }catch (InvalidPathException e) {
        }catch (NotDirectoryException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* использование метода walkFileTree для вывода дерева каталога*/
/* создание специальной версии класса SimpleFileVisitor, в котором переопределяется метод visitFile()*/
class FileVisitor extends SimpleFileVisitor<Path>{
    public FileVisitResult visitFile(Path path, BasicFileAttributes attr) throws IOException{
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}
class ExClass14{

    void method(){
        System.out.println("Использование метода walkFileTree для вывода дерева каталога");

        String dirname = "d:/pg";
        try{
            Files.walkFileTree(Paths.get(dirname), new FileVisitor());
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример использования канала для чтения данных из файла, до версии JDK 7*/
class ExClass15{

    void method(){
        System.out.println("Использование канала для чтения данных из файла, до версии JDK 7");

        FileInputStream fis = null;
        FileChannel fc = null;
        ByteBuffer buf;
        int count;

        try{
            /* сначала открывается файл для ввода*/
            fis = new FileInputStream("file.txt");
            /* затем получается канал к этому файлу*/
            fc = fis.getChannel();
            /* выделение оперативной памяти под буфер*/
            buf = ByteBuffer.allocate(128);
            do{
                /*чтение данных в буфер*/
                count = fc.read(buf);
                /* прекращение чтения по достижении конца файла*/
                if(count != -1){
                    /* подготовить буфер к чтению из него данных*/
                    buf.rewind();
                    /* чтение байт данных из буфера и вывод их на экран как символы */
                    for(int i = 0; i < count; i++){
                        System.out.print((char)buf.get());
                    }
                }
            }while(count != -1);

            System.out.println();

        }catch(IOException e){
        }finally{
            try{
                /* закрытие канала*/
                if(fc != null) fc.close();
            }catch(IOException e){}
            try{
                /* закрытие файла*/
                if(fis != null) fis.close();
            }catch(IOException e){}
        }
    }
}

/*---------------------------------------------------------------------*/

/* пример использования сопоставления для чтения данных из файла, до версии JDK 7*/
class ExClass16{

    void method(){
        System.out.println("Использование сопоставления для чтения данных из файла, до версии JDK 7");

        FileInputStream fis = null;
        FileChannel fc = null;
        MappedByteBuffer mbuf;

        long size;
        try{
            /* сначала открывается файл для ввода*/
            fis = new FileInputStream("file.txt");
            /* затем получается канал к этому файлу*/
            fc = fis.getChannel();
            /* получение размера файла*/
            size = fc.size();
            /* сопоставление файла с буфером*/
            mbuf = fc.map(FileChannel.MapMode.READ_ONLY, 0, size);
            /* чтение байтов из буфера и вывод их на экран как символы */
            for(int i = 0; i < size; i++){
                System.out.print((char)mbuf.get());
            }

            System.out.println();

        }catch(IOException e){
        }finally{
            try{
                /* закрытие канала*/
                if(fc != null) fc.close();
            }catch(IOException e){}
            try{
                /* закрытие файла*/
                if(fis != null) fis.close();
            }catch(IOException e){}
        }
    }
}

/*---------------------------------------------------------------------*/

/* пример использования канала для записи данных в файл, до версии JDK 7*/
class ExClass17{

    void method(){
        System.out.println("Использование канала для записи данных в файл, до версии JDK 7");

        FileOutputStream fos = null;
        FileChannel fc = null;
        ByteBuffer buf;

        try{
            /* сначала открывается файл для вывода данных*/
            fos = new FileOutputStream("file.txt");
            /* затем получается канал к этому файлу для вывода данных*/
            fc = fos.getChannel();
            /* выделение оперативной памяти под буфер*/
            buf = ByteBuffer.allocate(128);
            /* запись некоторого количества байтов в буфер*/
            for(int i = 0; i < 26; i++) buf.put((byte)('A' + i));
            /* подготовить буфер к записи данных*/
            buf.rewind();
            /* запись данных из буфера в выходной файл*/
            fc.write(buf);
        }catch(IOException e){
        }finally{
            try{
                /* закрытие канала*/
                if(fc != null) fc.close();
            }catch(IOException e){}
            try{
                /* закрытие файла*/
                if(fos != null) fos.close();
            }catch(IOException e){}
        }
    }
}

/*---------------------------------------------------------------------*/

/* пример использования сопоставления для записи данных в файл, до версии JDK 7*/
class ExClass18{

    void method(){
        System.out.println("Использование сопоставления для записи данных в файл, до версии JDK 7");

        RandomAccessFile raf = null;
        FileChannel fc = null;
        MappedByteBuffer mbuf;

        try{
            /* сначала открывается файл*/
            raf = new RandomAccessFile ("file.txt", "rw");
            /* затем получается канал к этому файлу*/
            fc = raf.getChannel();
            /* сопоставление файла с буфером*/
            mbuf = fc.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            /* запись некоторого количества байтов в буфер */
            for(int i = 0; i < 26; i++){
                mbuf.put((byte)('A' + i));
            }
        }catch(IOException e){
        }finally{
            try{
                /* закрытие канала*/
                if(fc != null) fc.close();
            }catch(IOException e){}
            try{
                /* закрытие файла*/
                if(raf != null) raf.close();
            }catch(IOException e){}
        }
    }
}

/*---------------------------------------------------------------------*/

public class NIO {

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
    }
}
