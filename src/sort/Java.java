package sort;

public class Java extends Sort
{
    private static int cutOff = 8;

    public static void sort(Comparable mas[])
    {
        qsort(mas, 0, mas.length-1);
    }

    private static void qsort(Comparable mas[], int s, int f)
    {

        int n = f-s+1;

        //если массив маленький - сортируем вставками
        if (n<=cutOff) {
            insertionSort(mas, s,f);
            return;
        }

        //нашли средний элемент методом медианы
        int med = median3(mas, s,s+n/2, f);
        exch(mas, s,med);

        //разпределяем элементы равные ключу по краям массива
        Comparable v = mas[s];
        int i=s+1, j=f;
        int p=s+1, q=f;
        while(true)
        {
            while(less(mas[i],v) && i<f)
                i++;
            while(less(v,mas[j]) && j>s+1)
                j--;

            if(i==j && mas[i]==v) {
                exch(mas, i, p);
                p++;
            }

            if(i>=j)
                break;

            exch(mas, i,j);
            if(mas[i]==v){
                exch(mas,i,p);
                p++;
            }
            if(mas[j]==v){
                exch(mas,j,q);
                q--;
            }
        }

        //перемещаем равные элементы в центр
        i=j+1;
        for(int k=s; k<p; k++, j--)
            exch(mas,k,j);
        for(int k=f; k>q; k--,i++)
            exch(mas,k,i);

        qsort(mas, s,j);
        qsort(mas, i,f);
    }

    private static void insertionSort(Comparable mas[], int s, int f)
    {
        int i,j;
        for(i = s+1; i<=f; i++)
        {
            Comparable temp = mas[i];
            for(j=i-1; j>=s && less(temp, mas[j]); j--)
                mas[j+1]=mas[j];
            mas[j+1]=temp;
        }
    }

    private static int median3(Comparable mas[], int a, int b, int c)
    {
        if(less(mas[a],mas[b]))
        {
            if(less(mas[b], mas[c]))
                return b;
            else if(less(mas[c],mas[a]))
                return a;
            else
                return c;
        }
        if(less(mas[c],mas[b]))
            return b;
        else if (less(mas[a], mas[c]))
            return a;
        else
            return c;
    }
}

