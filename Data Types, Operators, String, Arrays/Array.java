public class Array {

    /* 1) объявление ссылочной переменной массива*/

    void exampleMethod1(){

        /* 1 вариант*/
        int[] array1a, array2a, array3a;

        /* 2 вариант*/
        int array1b[], array2b[], array3b[];
    }

    /*---------------------------------------------------------------------*/

    /* 2) создание массива и обращение к нему*/

    void exampleMethod2(){

        /* создание массива 1 вариант*/
        int[] array1;
        array1 = new int[3];

        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 3;

        /* создание массива 2 вариант*/
        int[] array2 = new int[3];

        array2[0] = 1;
        array2[1] = 2;
        array2[2] = 3;

        /* создание массива 3 вариант*/
        int[] array3 = {1,2,3};

        /* создание массива 4 вариант*/
        int[] array4;
        array4 = new int[]{1,2,3};

        /* создание массива 5 вариант*/
        int[] array5 = new int[]{1,2,3};

        /* обращение к массиву*/
        int a = array5[0];
        int b = array5[1];
        int c = array5[2];

        /* обращение к массиву - ошибка*/
        //int a1 = array5[-1];
        //int b1 = array5[3];
    }

    /*---------------------------------------------------------------------*/

    /* 3) создание двумерного и трехмерного массивов*/

    void exampleMethod3(){

        /* двумерный массив*/
        int[][] array1 = new int[2][3];

        array1[0][0] = 1;
        array1[0][1] = 2;
        array1[0][2] = 3;

        array1[1][0] = 4;
        array1[1][1] = 5;
        array1[1][2] = 6;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                System.out.print(array1[i][j]);
            }
            System.out.print(" ");
        }

        System.out.println("--------------------");

        /* трехмерный массив*/
        int[][][] array2 = new int[1][2][3];
        //     1  2  3
        array2[0][0][0] = 1;
        array2[0][0][1] = 2;
        array2[0][0][2] = 3;

        array2[0][1][0] = 4;
        array2[0][1][1] = 5;
        array2[0][1][2] = 6;
        for (int i = 0; i < array2.length; i++){
            for (int j = 0; j < array2[0].length; j++) {
                for (int g = 0; g < array2[0][0].length; g++) {
                    System.out.print(array2[i][j][g]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /*---------------------------------------------------------------------*/

    /* 4) Отдельное разервирования памяти для массива*/

    void exampleMethod4(){

        int[][][] array = new int[1][][];

        array[0] = new int[2][];
        array[0][0] = new int[3];
        array[0][1] = new int[3];
        array[0][0][0] = 1;
        array[0][0][1] = 2;
        array[0][0][2] = 3;
        array[0][1][0] = 4;
        array[0][1][1] = 5;
        array[0][1][2] = 6;

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++) {
                for (int g = 0; g < array[0][0].length; g++) {
                    System.out.print(array[i][j][g]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /*---------------------------------------------------------------------*/

    /* 5) Отдельное резервирования памяти для каждого элемента массива*/

    void exampleMethod5(){

        int[][][] array = new int[1][][];
        array[0] = new int[2][];
        array[0][0] = new int[1];
        array[0][1] = new int[3];
        array[0][0][0] = 1;
        array[0][1][0] = 4;
        array[0][1][1] = 5;
        array[0][1][2] = 6;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++) {
                for (int g = 0; g < array[0][j].length; g++) {
                    System.out.print(array[i][j][g]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /*---------------------------------------------------------------------*/

    /* 6) определение длины массива и копирования массива*/

    void exampleMethod6(){

        /* определение длины массива*/
        int[] array1 = new int[5];

        System.out.println("длина массива: "+array1.length);
        System.out.println("--------");

        /* копирования массива с помощью arraycopy*/
        int[] array2 = new int[5];
        int[] array3 = new int[array2.length * 2];
        for (int i = 0; i < array2.length; i++)
            array2[i] = i;

        System.arraycopy(array2, 0, array3, 0, array2.length);
        for (int as : array2){
            System.out.print(as);
        }
        System.out.println();

        for (int as : array3){
            System.out.print(as);
        }
        System.out.println("\n--------");

        /* копирования массива с помощью Arrays.copyOf*/
        int[] array4 = Arrays.copyOf(array3, array3.length);

        /* копирования массива с помощью Arrays.copyOfRange*/
        int[] array5 = Arrays.copyOfRange(array2, 0, 3);
    }

    /*---------------------------------------------------------------------*/

    /* 7) пример применения некоторых методов из класса Arrays*/

    void exampleMethod7(){
        System.out.println("Применение некоторых методов из класса Arrays");

        /* выделение и инициализация массива*/
        int[] array = new int[10];
        for(int i = 0; i < 10; i++) array[i] = -3 * i;

        /* вывод, отсортировка и снова вывод содержимого массива*/
        System.out.print("исходный массив: ");
        display(array);
        Arrays.sort(array);
        System.out.print("отсортированный массив: ");
        display(array);

        /* заполнение массива и вывод его содержимого*/
        Arrays.fill(array, 2, 6, -1);
        System.out.print("массив после вызова метода fill(): ");
        display(array);

        /* отсортировка и вывод содержимого массива*/
        Arrays.sort(array);
        System.out.print("массив после повторной сортировки: ");
        display(array);

        /* выполнение двоичного поиска значения -9*/
        int index = Arrays.binarySearch(array, -9);
        System.out.println("значение -9 находится на позиции: "+index);
    }

    static void display(int array[]){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*---------------------------------------------------------------------*/

    public static void main(String[] args) {
        Array array = new Array();
        array.exampleMethod1();
        array.exampleMethod2();
        array.exampleMethod3();
        array.exampleMethod4();
        array.exampleMethod5();
        array.exampleMethod6();
        array.exampleMethod7();
    }
}
