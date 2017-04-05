package sort;

public class Quick extends Sort
{
    public static void sort(Comparable[] mas)
    {
        int N = mas.length;
        qsort(mas, 0,N-1);
    }

    private static void qsort(Comparable[] mas, int s, int f)
    {
        if (f<=s) return;
        int j = partition(mas,s,f);
        qsort(mas,s,j-1);
        qsort(mas,j+1, f);
    }

    private static int partition(Comparable[] mas, int s, int f)
    {
        Comparable v = mas[s];
        int l = s+1;
        int r = f;

        while(true)
        {
            while (less(mas[l],v) && l<f)
                l++;
            while (less(v, mas[r]) && r>s)
                r--;
            if(r<=l)
                break;
            exch(mas,l,r);
            l++;
            r--;
        }
        exch(mas,s,r);
        return r;
    }
}
