package comA;

/*
 *
 * length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LIS {

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        System.out.println(nonRecursive(arr));
    }

    private static int nonRecursive(int[] arr) {
        int[] LIS = { 1, -1, -1, -1, -1, -1, -1, -1, -1};

        for(int i=1;i<arr.length;i++){

            int max = 1;
            for(int j=i-1;j>=0;j--){

                if(arr[i]>arr[j] && max<LIS[j]+1){
                    max = LIS[j]+1;
                }
            }
            LIS[i] = max;
        }
        return LIS[arr.length-1];
    }
}
