package Operators;

import java.util.ArrayList;

public class Operators {

    enum Numbers{
        ONE, TWO
    }

    /* 1) операторы выбора*/

    void exampleMethod1(){
        int a = 1, b = 0;

        /* условный оператор if*/
        if(a > b){
            System.out.println("условный оператор if a > b");
        }

        boolean flag = true;

        if(flag){
            System.out.println("условный оператор if flag");
        }

        /*------------------------*/

        /* условный оператор if else*/
        if(a > b){
            System.out.println("условный оператор if else a > b");
        }else{
            System.out.println("условный оператор if else");
        }

        /*------------------------*/

        /* вложенный условный оператор if*/
        if(a > b){
            if(a < b){
                System.out.println("вложенный условный оператор if a < b");
            }
            if(a == b){
                System.out.println("вложенный условный оператор if else a == b");
            }else{
                System.out.println("вложенный условный оператор if else a > b");
            }
        }else{
            System.out.println("вложенный условный оператор if else");
        }

        /*------------------------*/

        /* конструкция if-else-if*/
        if(a > b){
            System.out.println("конструкция if-else-if a > b");
        }else if(a < b){
            System.out.println("конструкция if-else-if a < b");
        }else if(a == b){
            System.out.println("конструкция if-else-if a == b");
        }else{
            System.out.println("конструкция if-else-if else");
        }

        /*------------------------*/

        /* конструкция switch case с целочисленным типом*/
        final int c = 23;
        final int d = 1;
        switch(a){
            case c:
                System.out.println("switch c");
                break;
            case d:
                System.out.println("switch d");
                break;
            default:
                System.out.println("default");
        }

        /*------------------------*/

        /* конструкция switch case с типом String*/
        String str = "text";

        switch(str){
            case "text":
                System.out.println("switch text");
                break;
            case "text2":
                System.out.println("switch text2");
                break;
            default:
                System.out.println("default");
        }

        /*------------------------*/

        /* конструкция switch case с типом перечисления*/

        switch(Numbers.ONE){
            case ONE:
                System.out.println("ONE");
                break;
            case TWO:
                System.out.println("TWO");
                break;
            default:
                System.out.println("default");
        }
    }

    /*---------------------------------------------------------------------*/

    /* 2) операторы цикла*/

    void exampleMethod2(){

        /* цикл while*/
        boolean flag = true;

        while(flag){
            System.out.println("цикл while");
            flag = false;
        }

        /*------------------------*/

        /* цикл do while*/
        do{
            System.out.println("цикл do while");
            flag = false;
        }while(flag);

        /*------------------------*/

        /* цикл for*/
        for (int i = 0; i < 3; i++){
            System.out.println("цикл for i < 10");
        }

        for (int i = 0; !flag; i++){
            System.out.println("цикл for !flag");
            if (!flag) flag = true;
        }

        for ( ;!flag; ){
            System.out.println("цикл for ; !flag1; ");
            if (!flag) flag = true;
        }

        for ( ; ; ){
            System.out.println("цикл for ; ; ");
            if(flag) break;
        }

        /*------------------------*/

        /* цикл for (for each) одномерный массив*/
        int[] arr = {1,2,3};

        for(int i : arr){
            System.out.println("цикл for (for each) одномерный массив " + i);
        }

        /*------------------------*/

        /* цикл for (for each) двумерный массив*/
        int[][] arr2 = {{1},{2,3}};

        for(int[] a : arr2){
            for (int i : a)
                System.out.println("цикл for (for each) двумерный массив " + i);
        }

        /*------------------------*/

        /* цикл for (for each) ArrayList*/
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        for(int i: arrayList) {
            System.out.println("цикл for (for each) ArrayList<Integer> " + i);
        }

        /*------------------------*/

        /* пример1 - треугольник из точек*/
        for (int i = 0; i < 10; i++){
            for (int j = i; j < 10; j++){
                System.out.print(".");
            }
            System.out.println();
        }
        for (int i = 0; i < 10; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(".");
            }
            System.out.println();
        }

        /*------------------------*/

        /* пример2 - поиск элемента в массиве*/
        int[] arrNums = {8,3,7,1,5};
        int num = 5;
        flag = false;

        for (int x : arrNums){
            if (x == num){
                flag = true;
                break;
            }
        }

        if (flag){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }

    }

    /*---------------------------------------------------------------------*/

    /* 3) операторы перехода*/

    void exampleMethod3(){

        /* - оператор break*/

        /* выход из оператора ветвления switch*/
        switch (1){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("0");
        }

        /* выход из цикла while*/
        while (true){
            System.out.println("true break");

            if (true){
                break;
            }
        }

        /* использования break с меткой*/
        boolean flag1 = true;
        boolean flag2 = true;

        one: while (flag1){
            System.out.println("flag1 break с меткой");

            two: while (flag2) {
                System.out.println("flag2 break с меткой");

                if (true){
                    break one;
                }
            }
        }

        /* ошибка использования break с меткой*/
        one: while (flag1) {
            System.out.println("flag1 break с меткой ошибка");
            flag1 = false;
        }

        /*------------------------*/

        /* - оператор continue*/

        /* использования оператора continue*/
        int a = 0;
        boolean flag = true;

        while (flag){
            if (a == 2){
                flag = false;
            }

            a++;

            System.out.println("if flag continue before");

            if (flag){
                continue;
            }

            System.out.println("if flag continue after");
        }

        /* использования оператора continue с меткой*/

        a = 0;
        int b = 0;
        flag1 = true;
        flag2 = true;

        one: while (flag1) {
            System.out.println("flag1 continue с меткой");
            if (a == 1){
                flag2 = false;
            }

            while (flag2) {
                if (a == 1){
                    continue one;
                }
                System.out.println("flag2 continue с меткой");
                a++;
            }
            if (b == 1){
                flag1 = false;
            }
            b++;
        }

        /* -- оператор return*/

        class ExClass {

            /* оператор return возвращает значение и управление*/
            int method1() {
                return 34;
            }

            /* оператор return возвращает управление*/
            void method2() {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Operators operators = new Operators();
        operators.exampleMethod1();
        operators.exampleMethod2();
        operators.exampleMethod3();
    }
}
