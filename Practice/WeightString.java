import java.util.*;
public class WeightString{
    public static int[] values = new int[26];
    public static void main(String[] args){
        insertValues();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Character> s = new ArrayList<>();
        formedString(s,n);
    }
    public static void insertValues(){
        values[0] = 1;
        int prev = 1;
        for(int i = 1; i<26; i++){
            values[i] = (i+1)*prev + prev;
            prev = values[i];
        }
    }
    public static void formedString(List<Character> s, int k){
        int low = 0;
        int high = 25;
        while(k!=0){
            int ind = findFloor(k,low,high);
            s.add((char) (ind+'A'));
            k = k - values[ind];
        }
        for(int i = s.size()-1; i>=0; i--){
            System.out.print(s.get(i));
        }
    }
    public static int findFloor(int k, int low, int high){
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(values[mid]<=k){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}