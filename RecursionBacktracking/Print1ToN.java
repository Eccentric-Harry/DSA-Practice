public class Print1ToN{
    public static void main(String[] args){
        int n = 10;
        helper(1, 10);
    }
    private static void helper(int start, int target){
        if(start > target) return;
        System.out.println(start);
        helper(start+1, target);
    }
}