//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSub(int x,int y){
        x /= 3;
        y /= 3;
        return x * 3 + y;
    }
    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][])
    {
        boolean[][] rows = new boolean[10][10];
        boolean[][] cols = new boolean[10][10];
        boolean[][] subgrid = new boolean[10][10];
        for(int i = 0;i<9;++i){
            for(int j = 0;j<9;++j){
                rows[i][grid[i][j]] = true;
                cols[j][grid[i][j]] = true;
                subgrid[findSub(i,j)][grid[i][j]] = true;
            }
        }
        class Sudoku{
            public boolean helper(int i,int j){
                if(i == 9){
                    return true;
                }
                
                int nexti = i;
                int nextj = j + 1;
                if(nextj == 9){
                    nexti++;
                    nextj = 0;
                }
                
                if(grid[i][j] == 0){
                    for(int choose = 1;choose < 10;++choose){
                        if(!rows[i][choose] && !cols[j][choose] && !subgrid[findSub(i,j)][choose]){
                            grid[i][j] = choose;
                            rows[i][choose] = true;
                            cols[j][choose] = true;
                            subgrid[findSub(i,j)][choose] = true;
                            if(helper(nexti,nextj)) return true;
                            grid[i][j] = 0;
                            rows[i][choose] = false;
                            cols[j][choose] = false;
                            subgrid[findSub(i,j)][choose] = false;
                        }
                    }
                }
                else{
                    return helper(nexti,nextj);
                }
                return false;
            }
        }
        Sudoku s = new Sudoku();
        return s.helper(0,0);
    }
    
    
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i = 0;i<9;++i){
            for(int j = 0;j<9;++j){
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}