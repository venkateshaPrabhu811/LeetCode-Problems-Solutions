//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0;i<n;++i){
            int findgcd = gcd(numerator[i],denominator[i]);
            int x = numerator[i] / findgcd;
            int y = denominator[i] / findgcd;
            
            String curr = x + "/" + y;
            String target = (y-x) + "/" + y;
            if(map.containsKey(target)){
                count += map.get(target);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return count;
    }
    public static int gcd(int a,int b){
         return b==0 ? a : gcd(b, a%b);
    }
}