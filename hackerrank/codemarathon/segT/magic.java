import java.io.*;
import java.util.*;

public class Solution {
    int st[];
    Solution(int arr[], int n)
    {
        // Allocate memory for segment tree
        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
 
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
 
        st = new int[max_size]; // Memory allocation
        
        constructSTUtil(arr, 0, n - 1, 0);
        
        int i;
        for(i=0;i<max_size;i++)
            System.out.print(st[i]+" ");
        System.out.println("\n");
        
    }
     int getMid(int s, int e) {
        return s + (e - s) / 2;
    }
    int constructSTUtil(int arr[], int ss, int se, int si)
    {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
           
            st[si] = arr[ss];
            return arr[ss];
            
        }
 
        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(ss, se);
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
                 constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }
     int getSumUtil(int ss, int se, int qs, int qe, int si)
    {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return st[si];
 
        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;
 
        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }
    int getSum(int n, int qs, int qe)
    {
        // Check for erroneous input values
        
        return getSumUtil(0, n - 1, qs, qe, 0);
    }
    void updateValueUtil(int ss, int se, int i, int diff, int si)
    {
        // Base Case: If the input index lies outside the range of 
        // this segment
        if (i < ss || i > se)
            return;
 
        // If the input index is in range of this node, then update the
        // value of the node and its children
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }
     void updateValue(int arr[], int n, int i, int new_val)
    {
        
        // Get the difference between new value and old value
        int diff = new_val - arr[i];
 
        // Update the value in array
        arr[i] = new_val;
 
        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }
 
    // Return sum of elements in range from index qs (quey start) to
   // qe (query end).  It mainly uses getSumUtil()
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        Scanner br=new Scanner(System.in);
        n=br.nextInt();
        int []a=new int[n];
        int []index=new int[n];
        int []index1=new int[n];
        int i;
        for(i=0;i<n;i++)
            {
            a[i]=br.nextInt();
            if(a[i]%2==0)
                {
                index[i]=0;
                index1[i]=1;//even
            }
            else
                {
                    index[i]=1;
                    index1[i]=0;
            }
                
        }
        //int a[]={1,1,0,0,1,0};
        Solution s1=new Solution(index,n);
        Solution s2=new Solution(index1,n);
        
        s1.updateValue(index,n,1,0);
        s2.updateValue(index1,n,1,1);
        System.out.println(s1.getSum(n,0,3));
        System.out.println(s2.getSum(n,0,3));
    }
}
