package Collections;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/* пример применения списка свойств в классе Properties*/
class ExProperties{

    void method(){
        System.out.println("Применение списка свойств в классе Properties");

        /* создание объекта типа Properties*/
        Properties prop = new Properties();
        prop.put("иллинойс", "спрингфилд");
        prop.put("миссури", "джефферсон-сити");
        prop.put("вашингтон", "олимпия");
        prop.put("калифорния", "сакраменто");
        prop.put("индиана", "индианаполис");

        /* получение множества ключей*/
        Set<?> set = prop.keySet();

        /* вывод всех штатов и их столицы*/
        for(Object name : set) System.out.println("- столица штата "+ name+" ("+prop.getProperty((String) name) + ")");

        /* найти штат, отсутствующий в списке, указав значение, выбираемое по умолчанию*/
        String str = prop.getProperty("флорида", "не найдена");
        System.out.println("- столица штата флорида "+str+".");
    }
}

/*---------------------------------------------------------------------*/

/* переделанный предыдущий пример, в котором используется список свойств по умолчанию*/
class ExPropertiesV2{

    void method(){
        System.out.println("Переделанный предыдущий пример, в котором используется список свойств по умолчанию");

        /* создание объекта типа Properties – в качестве списка по умолчанию*/
        Properties defprop = new Properties();
        defprop.put("флорида", "тэлесси");
        defprop.put("висконсин", "мэдисон");

        /* создание объекта типа Properties и передача ему списка по умолчанию*/
        Properties prop = new Properties(defprop);
        prop.put("иллинойс", "спрингфилд");
        prop.put("миссури", "джефферсон-сити");
        prop.put("вашингтон", "олимпия");
        prop.put("калифорния", "сакраменто");
        prop.put("индиана", "индианаполис");

        /* получение множества ключей*/
        Set<?> set = prop.keySet();

        /* вывод всех штатов и их столицы*/
        for(Object name : set) System.out.println("столица штата: "+ name+"  –  "+prop.getProperty((String) name));

        /* найти штат, отсутствующий в списке, указав значение, выбираемое по умолчанию*/
        String str = prop.getProperty("флорида", "не найдена");
        System.out.println("столица штата флорида: "+str);
    }
}

/*---------------------------------------------------------------------*/

/* пример использования методов store() и load()*/
class ExStoreAndLoad{

    void method(){
        /* создание объекта типа Properties*/
        Properties prop = new Properties();

        /* создание потока ввода*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        FileInputStream fis = null;
        boolean changed = false;
        try {
            /* попытка открыть файл base.dat*/
            fis = new FileInputStream("base.dat");

            /* если телефонная книга уже существует, загрузить существующие телефонные номера*/
            if (fis != null) {
                prop.load(fis);
                fis.close();
            }

            /* разрешение пользователю вводить новые имена и номера телефонов абонентов*/
            do {
                System.out.println("введите имя (‘exit’ для завершения): ");
                name = br.readLine();

                if (name.equals("exit")) continue;

                System.out.println("введите номер: ");
                number = br.readLine();
                prop.put(name, number);
                changed = true;
            } while (!name.equals("exit"));

            /* сохранение телефонной книги, если она изменилась*/
            if (changed) {
                FileOutputStream fos = new FileOutputStream("base.dat");
                prop.store(fos, "телефонная книга");
                fos.close();
            }

            /* поиск в телефонной книги по имени*/
            do {
                System.out.println("введите имя для поиска (‘exit’ для завершения): ");
                name = br.readLine();

                if (name.equals("exit")) continue;

                number = (String) prop.get(name);
                System.out.println(number);
            } while (!name.equals("exit"));
        }catch(FileNotFoundException e){
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

/* пример2 использования методов store() и load() - try с ресурсами*/
class ExStoreAndLoadV2{

    void method(){
        Properties prop = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        boolean flag = false;

        try(FileInputStream fis = new FileInputStream("base.dat");
            FileOutputStream fos = new FileOutputStream("base.dat")){
            if (fis != null) prop.load(fis);

            do{
                System.out.print("input name: ");
                name = br.readLine();

                if (name.equals("exit")) continue;

                System.out.print("input number: ");
                number = br.readLine();
                prop.put(name, number);
                flag = true;
            }while(!name.equals("exit"));

            if (flag) prop.store(fos, "phonebook");

            do{
                System.out.print("find name: ");
                name = br.readLine();
                if (name.equals("exit")) continue;
                System.out.println(prop.getProperty(name, "not find"));
            }while(!name.equals("exit"));
        }catch(IOException e){}
    }
}

/*---------------------------------------------------------------------*/

public class PropertiesExample {
    public static void main(String[] args) {
        new ExProperties().method(); System.out.println("---------------------");
        new ExPropertiesV2().method(); System.out.println("---------------------");
        new ExStoreAndLoad().method(); System.out.println("---------------------");
        new ExStoreAndLoadV2().method(); System.out.println("---------------------");
    }
}
