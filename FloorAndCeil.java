public class FloorAndCeil{
    public int[] getFloorAndCeil(int x, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        
        int[] result = new int[2];
        result[0] = getFloor(x, arr);
        result[1] = getCeil(x, arr);
        return result;
    }
    public int getCeil(int x, int[] arr){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high){
            int mid = (low+high) >> 1;
            if(arr[mid] == x){
                return arr[mid];
            }else if(arr[mid] < x){
                low = mid+1;
            }else{
                ans = arr[mid];
                high = mid-1;
            }
        }
        return ans;
    }
    public int getFloor(int x, int[] arr){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high){
            int mid = (low+high) >> 1;
            if(arr[mid] == x){
                return arr[mid];
            }else if(arr[mid] < x){
                ans = arr[mid];
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        FloorAndCeil fc = new FloorAndCeil();
        int x = 7;
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int[] result = fc.getFloorAndCeil(x, arr);
        System.out.println("The floor of " + x + " is " + result[0] + " and the ceil of " + x + " is " + result[1]);
    }
}