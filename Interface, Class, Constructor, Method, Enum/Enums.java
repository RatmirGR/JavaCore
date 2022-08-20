package Enum;

/* 1) объявление enum (перечисление) вне класса*/

enum Directions{
    /* список именованных констант*/
    NORTH, SOUTH, EAST, WEST;
}

class ExClass1{
    void method(){
        Directions directions = Directions.SOUTH;
        System.out.println(directions);
    }
}

/*---------------------------------------------------------------------*/

/* 2) объявление enum (перечисление) вне класса*/

class ExClass2{

    enum Directions{
        /* список именованных констант*/
        NORTH, SOUTH, EAST, WEST;
    }

    void method(){
        Directions directions = Directions.SOUTH;
        System.out.println(directions);
    }
}

/*---------------------------------------------------------------------*/

/* 3) enum (перечисление) в операторе switch*/

class ExClass3{

    enum Directions{
        /* список именованных констант*/
        NORTH, SOUTH, EAST, WEST;
    }

    void method(){
       switch (Directions.EAST){
           case NORTH:
               System.out.println(Directions.NORTH);
               break;
           case SOUTH:
               System.out.println(Directions.SOUTH);
               break;
           case EAST:
               System.out.println(Directions.EAST);
               break;
           case WEST:
               System.out.println(Directions.WEST);
               break;
           default:
               System.out.println("Direction not found");
       }
    }
}

/*---------------------------------------------------------------------*/

/* 4) enum (перечисление) и метод values*/

class ExClass4{

    enum Directions{
        /* список именованных констант*/
        NORTH, SOUTH, EAST, WEST;
    }

    void method(){
        /* метод values возвращает массив со всеми значениями внутри перечисления*/
        Directions[] directs = Directions.values();
        for (Directions d : directs){
            System.out.println(d);
        }
    }
}

/*---------------------------------------------------------------------*/

/* 5) enum (перечисление) и метод valueOf*/

class ExClass5{

    enum Directions{
        /* список именованных констант*/
        NORTH, SOUTH, EAST, WEST;
    }

    void method(){
        /* метод valueOf возвращает константу указанную в качестве имени */
        Directions direct = Directions.valueOf("WEST");
        System.out.println(direct);
    }
}

/*---------------------------------------------------------------------*/

/* 6) enum (перечисление) с использованием конструктора, переменной и метода*/

class ExClass6{

    enum Directions{
        /* список именованных констант*/
        NORTH(1), SOUTH(2), EAST(3), WEST(4);

        int n;

        /* объявление конструктора*/
        Directions(int n){
            this.n = n;
        }

        int getValue(){ return n;}
    }

    void method(){
        System.out.println(Directions.EAST.name());
        System.out.println(Directions.EAST.getValue());
        Directions.EAST.n = 5;
        System.out.println(Directions.EAST.getValue());
        for (Directions d : Directions.values()){
            System.out.println(d.getValue());
        }
    }
}

/*---------------------------------------------------------------------*/

/* 7) enum (перечисление) с использованием перегрузки конструктора*/

class ExClass7{

    enum Directions{
        /* список именованных констант*/
        NORTH(1), SOUTH(2.0), EAST("Text"), WEST(true);

        int n;
        double d;
        String s;
        boolean b;

        /* перегрузка конструктора*/
        Directions(int n){
            this.n = n;
        }

        Directions(double d){
            this.d = d;
        }

        Directions(String s){
            this.s = s;
        }

        Directions(boolean b){
            this.b = b;
        }
    }

    void method(){
        System.out.println(Directions.NORTH);
        System.out.println(Directions.SOUTH);
        System.out.println(Directions.EAST);
        System.out.println(Directions.WEST);
    }
}

/*---------------------------------------------------------------------*/

/* 8) enum (перечисление) с использованием констант с методами*/

class ExClass8{

    enum Directions{
        /* список именованных констант*/
        NORTH{
            void method1(){
                System.out.println("North");
            }
        },
        SOUTH{
            void method1(){
                System.out.println("South");
            }
        },
        EAST{
            void method1(){
                System.out.println("East");
            }
        },
        WEST{
            void method1(){
                System.out.println("West");
            }
        };

        /* объявление общего метода*/
        abstract void method1();
    }

    void method(){
       Directions.NORTH.method1();
    }
}

/*---------------------------------------------------------------------*/

/* 9) методы класса Enum пакета java.lang*/

class ExClass9{

    enum Directions{
        /* список именованных констант*/
        NORTH, SOUTH, EAST, WEST;
    }

    void method(){
        /* метод ordinal*/
        int idx = Directions.WEST.ordinal();
        System.out.println("порядковый номер: " + idx);

        /* метод compareTo(тип перечисления e) */
        if (Directions.NORTH.compareTo(Directions.SOUTH) > 0){
            System.out.println(Directions.NORTH.compareTo(Directions.SOUTH));
        }

        /* метод equals(тип перечисления e)*/
        if (Directions.EAST.equals(Directions.SOUTH)){
            System.out.println(Directions.EAST.equals(Directions.SOUTH));
        }

        /* сравнение двух констант с помощью оператора ==*/
        if (Directions.WEST == Directions.SOUTH){
            System.out.println(Directions.WEST == Directions.SOUTH);
        }

        /* метод getDeclaringClass*/
        Directions direct = Directions.WEST;
        System.out.println(direct.getDeclaringClass());
    }
}

/*---------------------------------------------------------------------*/

/* 10) пример использования enum (перечисление) */

enum Lights{
    RED(0),YELLOW(1),GREEN(2),ERROR(-1);

    private int value, idx = 0;

    Lights(int value){
        this.value = value;
    }

    Lights nextLight(){
        return Lights.values()[(idx++) % 3];
    }
}

class Timer{
    private final int delay;
    private static final Lights light = Lights.RED;

    Timer(int sec){
        delay = 1000 * sec;
    }

    Lights shift(){
        Lights count = light.nextLight();

        try {
            switch (count){
                case RED: Thread.sleep(delay);break;
                case YELLOW: Thread.sleep(delay/3);break;
                case GREEN: Thread.sleep(delay/2);break;
            }
        }catch (Exception e){
            return Lights.ERROR;
        }
        return count;
    }
}

class TrafficLight{
    public static final int NBR_STEPS = 4;

    void exec(int sec){
        Timer t = new Timer(sec);

        for (int i = 0; i < NBR_STEPS; i++){
            switch (t.shift()){
                case RED:
                    System.out.println("Stop!");
                    break;
                case YELLOW:
                    System.out.println("Wait!");
                    break;
                case GREEN:
                    System.out.println("Walk!");
                    break;
                case ERROR:
                    System.out.println("Time Error");
                    break;
            }
        }
    }
}

/*---------------------------------------------------------------------*/

public class Enums {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.exec(2);
    }
}
