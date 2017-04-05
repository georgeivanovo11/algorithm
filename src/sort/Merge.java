package sort;

public class Merge extends Sort
{
    public static void sort(Comparable[] mas)
    {
        Comparable[] temp = new Comparable[mas.length];
        for(int k=0; k<mas.length; k++)
            temp[k]=mas[k];
        recursionSort(mas, temp, 0, mas.length-1);
    }

    private static void recursionSort(Comparable[] mas, Comparable[] temp, int s, int f)
    {
        if(f<=s) return;
        int mid = s+(f-s)/2;
        recursionSort(temp, mas,s,mid);
        recursionSort(temp, mas,mid+1, f);
        merge(mas,temp, s,mid,f);
    }

    private static void merge(Comparable[] mas, Comparable[] temp, int s, int mid, int f)
    {
        int i = s,  j = mid+1;

        for(int k=s; k<=f; k++)
        {
            if (i>mid)
            {mas[k] = temp[j]; j++;}
            else if (j>f)
            {mas[k] = temp[i];j++;}
            else if(less(temp[i], temp[j]))
            {mas[k] = temp[i];i++;}
            else
            {mas[k] = temp[j];j++;}
        }
    }
}

