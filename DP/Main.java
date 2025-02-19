import java.util.*;
public class Main{
    public static void permutate(String str, int n, int[] visited, ArrayList<String> li, StringBuilder sb){
        if(sb.length() == n){
            li.add(sb.toString());
            return;
        }
        for(int i = 0; i < 3; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                sb.append(str.charAt(i));
                permutate(str,n,visited,li,sb);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = 0;
            }
        }
    }
    public static void main(String[] args){
        ArrayList<String> li = new ArrayList<>();
        int[] visited = new int[3];
        Arrays.fill(visited,0);
        permutate("abc", 3, visited, li, new StringBuilder() );
        System.out.println(li);
    }
}a