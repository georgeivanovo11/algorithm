package sort;

public class Insertion extends Sort
{
    public static void sort(Comparable [] mas)
    {
        int N = mas.length;
        int i,j;

        for(i=1; i < N; i++)
        {
            Comparable temp = mas[i];
            for(j=i-1; j>=0 && less(temp, mas[j]); j--)
                mas[j+1] = mas[j];
            mas[j+1] = temp;
        }
    }
}
