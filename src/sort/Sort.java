package sort;

public class Sort
{
    protected static boolean less (Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    protected static void exch (Comparable[] mas, int i, int j)
    {
        Comparable temp = mas[i];
        mas[i] = mas[j];
        mas[j] = temp;
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

    public static void show(Comparable[] mas)
    {
        for(int i=0; i<mas.length; i++)
        {
            System.out.print(mas[i].toString() + " ");
        }
        System.out.println();
    }
}