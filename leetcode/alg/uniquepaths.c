A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.



This is a fundamental DP problem. First of all, let's make some observations.

Since the robot can only move right and down, when it arrives at a point, there are only two possibilities:

    It arrives at that point from above (moving down to that point);
    It arrives at that point from left (moving right to that point).

Thus, we have the following state equations: suppose the number of paths to arrive at a point (i, j) is denoted as P[i][j], it is easily concluded that P[i][j] = P[i - 1][j] + P[i][j - 1].

The boundary conditions of the above equation occur at the leftmost column (P[i][j - 1] does not exist) and the uppermost row (P[i - 1][j] does not exist). These conditions can be handled by initialization (pre-processing) --- initialize P[0][j] = 1, P[i][0] = 1 for all valid i, j. Note the initial value is 1 instead of 0!

Now we can write down the following (unoptimized) code.

class Solution {
    int uniquePaths(int m, int n) {
        vector<vector<int> > path(m, vector<int> (n, 1));
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                path[i][j] = path[i - 1][j] + path[i][j - 1];
        return path[m - 1][n - 1];
    }
};

As can be seen, the above solution runs in O(n^2) time and costs O(m*n) space. However, you may have observed that each time when we update path[i][j], we only need path[i - 1][j] (at the same column) and path[i][j - 1] (at the left column). So it is enough to maintain two columns (the current column and the left column) instead of maintaining the full m*n matrix. Now the code can be optimized to have O(min(m, n)) space complexity.

class Solution {
    int uniquePaths(int m, int n) {
        if (m > n) return uniquePaths(n, m); 
        vector<int> pre(m, 1);
        vector<int> cur(m, 1);
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++)
                cur[i] = cur[i - 1] + pre[i];
            swap(pre, cur);
        }
        return pre[m - 1];
    }
};

Further inspecting the above code, we find that keeping two columns is used to recover pre[i], which is just cur[i] before its update. So there is even no need to use two vectors and one is just enough. Now the space is further saved and the code also gets much shorter.

class Solution {
    int uniquePaths(int m, int n) {
        if (m > n) return uniquePaths(n, m);
        vector<int> cur(m, 1);
        for (int j = 1; j < n; j++)
            for (int i = 1; i < m; i++)
                cur[i] += cur[i - 1]; 
        return cur[m - 1];
    }
}; 

Well, till now, I guess you may even want to optimize it to O(1) space complexity since the above code seems to rely on only cur[i] and cur[i - 1]. You may think that 2 variables is enough? Well, it is not. Since the whole cur needs to be updated for n - 1 times, it means that all of its values need to be saved for next update and so two variables is not enough.
2 years ago







This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps down and n-1 steps right and these can be done in any order.

For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order. That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the path :-

D R R R D R R R

We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply following formula:-

Total permutations = (m+n)! / (m! * n!)

Following is my code doing the same :-

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
    }
}


