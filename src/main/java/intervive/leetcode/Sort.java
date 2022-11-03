package intervive.leetcode;

public class Sort {

    int[] aux;
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return ;
        }
        aux = new int[arr.length];
        int lo = 0;
        int hi = arr.length - 1;
        sort(arr, lo, hi);

    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        int j = lo;
        int k = mid+1;
        for (int i =lo;i<=hi;i++){
            aux[i] = arr[i];
        }
        for (int i =lo;i<=hi;i++){
            if (j>mid){
                arr[i] = aux[k++];
            }else if (k > hi){
                arr[i] = aux[j++];
            }else if (aux[j] < aux[k]){
                arr[i] = aux[j++];
            }else {
                arr[i] = aux[k++];
            }
        }
    }

    public static void main(HWString[] args) {
        int[] arr = {1,5,3,6,2,4};
        Sort sort = new Sort();
        sort.mergeSort(arr);
        for (int i : arr){
            System.out.print(i);
        }
    }
}
