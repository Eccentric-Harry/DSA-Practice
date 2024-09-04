public class BinarySearch{
    public static int search(int[] arr, int target, int start, int end){
        if(start > end) return -1;
            int mid = (start + end) / 2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                return search(arr, target, mid+1, end);
            } else {
            return search(arr, target, start, mid - 1);
        }
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 5;
        int start = 0;q
        int end = arr.length;
        int result = search(arr, target, start, end);
        if(result == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index: " + result);
        }
    }
}