package sort;

public class Heap
{
    public static void sort(Comparable[] mas)
    {
        int N = mas.length;
        //рассматриваем массив от 1 до N (см методы less, exch)
        //1. создание кучи
        for(int k=N/2; k>=1; k--)
            sink(mas, k, N);
        //2. выстраивание
        while(N>1)
        {
            exch(mas,1,N); N--;
            sink(mas,1,N);
        }
    }

    private static void sink(Comparable[] mas, int k, int N)
    {
        while(2*k<=N)
        {
            int j = 2*k;
            if(j+1<=N && less(mas, j,j+1))
                j++;
            if(!less(mas,k,j))
                break;
            exch(mas,k,j);
            k=j;
        }
    }

    private static boolean less (Comparable[] mas, int i, int j)
    {
        return mas[i-1].compareTo(mas[j-1]) < 0;
    }

    private static void exch(Comparable[] mas, int i, int j)
    {
        Comparable temp = mas[i-1];
        mas[i-1]=mas[j-1];
        mas[j-1]=temp;
    }
}

