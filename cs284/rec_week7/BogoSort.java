public class BogoSort{
    public static void main(String[] args) {
        int[] array={4, 3, 2, 1};

        BogoSort mySort = new BogoSort();
        System.out.println("Unsorted array: ");
        display(array);

        mySort.sort(array);

        System.out.println("Sorted array: ");
        display(array);
    }

    public static void sort(int[] arr)
    {
        int shuffle=1;
        for(;!isSorted(arr);shuffle++)
            shuffle(arr);
        System.out.println(shuffle + " shuffles later....");
    }

    public static void shuffle(int[] arr)
    {
        int i=arr.length-1;
        while(i>0)
            swap(arr,i--,(int)(Math.random()*i));
    }

    public static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static boolean isSorted(int[] arr)
    {

        for(int i=1;i<arr.length;i++)
            if(arr[i]<arr[i-1])
                return false;
        return true;
    }

    public static void display(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
