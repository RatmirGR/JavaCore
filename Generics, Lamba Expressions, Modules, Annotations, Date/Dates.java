package Date;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

/* пример вывода различных форматов*/
class ExDate{

    void method(){
        System.out.println("Вывод различных форматов");

        Date date = new Date();

        /* вывод даты*/
        DateFormat df;

        df= DateFormat.getDateInstance(DateFormat.SHORT, Locale.CANADA);
        System.out.println("- канада: "+df.format(date));

        df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ITALY);
        System.out.println("- италия: "+df.format(date));

        /* вывод времени*/
        df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
        System.out.println("- англия: "+df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US);
        System.out.println("- сша: "+df.format(date));

        /* вывод даты и времени*/
        df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL, Locale.CHINA);
        System.out.println("- китай: "+df.format(date));
    }
}

/* класс SimpleDateFormat*/
class ExSimpleDateFormat{

    void method(){
        System.out.println("Применение класса SimpleDateFormat");

        Date date = new Date();

        SimpleDateFormat sdf;

        sdf = new SimpleDateFormat("hh:mm:ss");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("E MMM dd yyyy");
        System.out.println(sdf.format(date));

        System.out.println("- - - -");

        sdf = new SimpleDateFormat("a hh:mm:ss (HH:mm:ss) - (E - EEEE) dd.MM.yy (dd MMM yyyy - dd MMMM yyyy)");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("(часы в формате суток - kk) (часы в формате 'AM/PM' - KK) (милсек. в сек. - SSS)");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("(z - zzzz) (Z - XXX) - G - (день недели в мес. - FF) (YY - YYYY)");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("(неделя в мес. - WW) (неделя в году - ww) (день в году - DD)");
        System.out.println(sdf.format(date));
    }
}

/* таблица символов форматирующих строк*/
class ExTableFormat{

    void method(){
        Date date = new Date();

        String[] arrFormat = {"d","D","h","H","k","K","m","M","s","S","w","W","y","Y","z","Z","X","E","F","a","G"};

        SimpleDateFormat[] arr = new SimpleDateFormat[21];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new SimpleDateFormat(arrFormat[i]);
        }

        System.out.println("d - день месяца (1-31): "+arr[0].format(date));
        System.out.println("D - день в году (1 – 366): "+arr[1].format(date));
        System.out.println("h - часы в формате AM/PM (1-12): "+arr[2].format(date));
        System.out.println("H - часы с сутках (0 – 23): "+arr[3].format(date));
        System.out.println("k - часы в формате суток (1-24): "+arr[4].format(date));
        System.out.println("K - часы в формате (AM/PM (0 – 11): "+arr[5].format(date));
        System.out.println("m - минуты (0 – 59): "+arr[6].format(date));
        System.out.println("M - месяцы: "+arr[7].format(date));
        System.out.println("s - секунды (0 – 59): "+arr[8].format(date));
        System.out.println("S - миллисекунды в секунде: "+arr[9].format(date));
        System.out.println("w - неделя в году (1 – 52): "+arr[10].format(date));
        System.out.println("W - неделя в месяце (1 – 5): "+arr[11].format(date));
        System.out.println("y - год: "+arr[12].format(date));
        System.out.println("Y - неделя в году: "+arr[13].format(date));
        System.out.println("z - часовой пояс: "+arr[14].format(date));
        System.out.println("Z - часовой пояс в формате по стандарту RFC 822: "+arr[15].format(date));
        System.out.println("X - часовой пояс в формате по стандарту ISO 8601: "+arr[16].format(date));
        System.out.println("E - день недели (например, четверг): "+arr[17].format(date));
        System.out.println("F - день недели в месяце: "+arr[18].format(date));
        System.out.println("a - AM (до полудня) или PM (после полудня): "+arr[19].format(date));
        System.out.println("G - эра (AD – после рождества христова, или нашей эры," +
                "ВС – до рождества христова, или до нашей эры): "+arr[20].format(date));
    }
}

/* классы LocalDate, LocalTime м LocalDateTime*/
class ExLocalDateTime{

    void method(){

        System.out.println("Пример применения классов LocalDate, LocalTime и LocalDateTime");

        /* получение текущей даты и времени в стандартном формате*/
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
    }
}

/* форматирование даты и времени - класс DateTimeFormatter*/
class ExDateTimeFormatter{

    void method(){
        /* получение текущей даты и времени в форматированном формате*/
        LocalDate date1 = LocalDate.now();

        /* использование метода format() и ofLocalizedDate()*/
        System.out.println(date1.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

        LocalTime time1 = LocalTime.now();

        /* использование метода format() и ofLocalizedTime()*/
        System.out.println(time1.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
    }
}

/* форматирование даты и времени - шаблон*/
class ExOfPattern{

    void method(){
        LocalDateTime dateTime = LocalDateTime.now();

        /* использование метода ofPattern()*/
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy',' hh':'mm a")));
    }
}

/* синтаксический анализ символьных строк даты и времени*/
class ExLocalDateParse{

    void method(){
        /* получение объекта типа LocalDateTime, выполнив синтаксический анализ символьной строки даты и времени*/
        /* использования метода parse()*/
        LocalDate date = LocalDate.parse("25 02 2003", DateTimeFormatter.ofPattern("dd MM yyyy"));
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd MMMM yy")));

        LocalTime time = LocalTime.parse("11:34", DateTimeFormatter.ofPattern("HH':'mm"));
        System.out.println(time.format(DateTimeFormatter.ofPattern("HH-mm")));

        LocalDateTime dt = LocalDateTime.parse("02.03.2003 11:34",DateTimeFormatter.ofPattern("dd'.'MM'.'yyyy kk:mm"));
        System.out.println(dt.format(DateTimeFormatter.ofPattern("dd'-'MMM'-'yyyy HH':'mm")));
    }
}

public class Dates {

    public static void main(String[] args) {
        new ExDate().method(); System.out.println("--------------------");
        new ExSimpleDateFormat().method(); System.out.println("--------------------");
        new ExTableFormat().method(); System.out.println("--------------------");
        new ExLocalDateTime().method(); System.out.println("--------------------");
        new ExDateTimeFormatter().method(); System.out.println("--------------------");
        new ExOfPattern().method(); System.out.println("--------------------");
        new ExLocalDateParse().method(); System.out.println("--------------------");

    }
}
