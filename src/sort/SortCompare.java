package sort;

import java.util.Random;

public class SortCompare
{
    public static void testAll()
    {
        int N = 1000; int L = 1000;
        System.out.println( performTest("insertion", N,L) + " - insertion");
        System.out.println(performTest("shell", N,L) + " - shell");
        System.out.println(performTest("merge", N,L) + " - merge");
        System.out.println(performTest("quick", N,L) + " - quick");
        System.out.println(performTest("java", N,L) + " - java");
        System.out.println(performTest("heap", N,L) + " - heap");

    }

    public static double performTest(String title, int number, int length)
    {
        //title - название сортировки
        //number - количество случайных массивов
        //length - длина каждого массива

        Random rand = new Random();
        double total = 0.0;
        Double[] mas = new Double[length];


        for(int i=0; i<number; i++)
        {
            //Выполнение одного эксперимента
            //1. Генерация
            for(int j=0; j<length; j++)
                mas[j] = rand.nextDouble();
            //2.Сортировка
            total+=getTime(title,mas);
            //3.Проверка
            if(!isSorted(mas))
                System.out.print("false");
        }

        return total;
    }

    private static double getTime(String title, Double[] mas)
    {
        long startTime = System.nanoTime()/1000;

        switch(title)
        {
            //simple
            case "insertion": Insertion.sort(mas); break;
            case "shell": Shell.sort(mas); break;
            case "merge": Merge.sort(mas); break;
            case "quick": Quick.sort(mas); break;
            case "java": Java.sort(mas); break;
            case "heap": Heap.sort(mas); break;
        }

        long finishTime = System.nanoTime()/1000;

        return finishTime - startTime;
    }

    public static boolean isSorted(Comparable[] mas)
    {
        for (int i=1; i<mas.length; i++)
        {
            if (less(mas[i], mas[i-1]))
                return false;
        }
        return true;
    }

    private static boolean less (Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }
}