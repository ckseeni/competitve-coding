import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long xTreasure = in.nextLong();
        long yTreasure = in.nextLong();
        int n = in.nextInt();
        long[][] direction = new long[n][2];
        for(int direction_i=0; direction_i < n; direction_i++){
            for(int direction_j=0; direction_j < 2; direction_j++){
                direction[direction_i][direction_j] = in.nextLong();
            }
			xTreasure = xTreasure - direction[direction_i][0];
			yTreasure = yTreasure - direction[direction_i][1];
        }
		System.out.println(xTreasure+" "+yTreasure);
        // your code goes here
    }
}

