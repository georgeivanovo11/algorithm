package sort;

public class Shell extends Sort
{
    public static void sort(Comparable [] mas)
    {
        int N = mas.length;
        int h,i,j;
        for (h = 1; h <= N/9; h = 3*h+1);

        while(h>=1)
        {
            for (i = h; i < N; i++)
            {
                Comparable temp = mas[i];
                for (j = i-h; j>=0 && less(temp,mas[j]); j -= h)
                    mas[j+h]=mas[j];
                mas[j+h]=temp;
            }
            h /= 3;
        }
    }
}