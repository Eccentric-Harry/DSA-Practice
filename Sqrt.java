import java.util.Scanner;
public class Sqrt{
    static long floorSqrt(long n) {
        long low = 1;
        long high = n;
        while(low<=high){
            long mid = (low+high)>>1;
            if(mid*mid == n){
                return mid;
            }else if(mid*mid < n){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low-1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(floorSqrt(n));
    }
}