//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        PriorityQueue<Meeting> pq = new PriorityQueue<>((a,b) -> a.eTime - b.eTime);
        for(int i = 0;i<n;++i){
            pq.add(new Meeting(start[i],end[i]));
        }
        Meeting prev = pq.poll();
        int count = 1;
        while(!pq.isEmpty()){
            Meeting curr = pq.poll();
            if(curr.sTime > prev.eTime){
                ++count;
                prev = curr;
            }
        }
        return count;
    }
}
class Meeting{
    int sTime;
    int eTime;
    Meeting(int sTime,int eTime){
        this.sTime = sTime;
        this.eTime = eTime;
    }
}
