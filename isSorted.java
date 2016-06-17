public static boolean isSorted(int[] array) 
{
    for (int i = 0; i < a.length - 1; i++) {
        if (a[i] > a[i + 1]) {
            return false;
        }
    }
    return true;
}
/*
soruda fonksiyonun static olması özellikle istendiği için fonksiyon adına static yazmamız gerekiyor. 
Istenmesse yazılmamalı, oraya dikkat et
*/
