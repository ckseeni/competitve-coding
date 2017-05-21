import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		int arr[] = new int[n];
		String b = in.nextLine();
		System.out.println(b);
		String a[] = b.split(" ");
		for(int i=0;i<n;i++)
			System.out.println(a[i]);
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(a[i]);
		for(int i=0;i<(n/2);i++){
			if(i%2==0){
				int t = arr[i];
				arr[i] = arr[n-i-1];
				arr[n-i-1] = t;
			}
		}
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
    }
}
Young Timofey has a birthday today! He got kit of n cubes as a birthday present from his parents. Every cube has a number ai, which is written on it. Timofey put all the cubes in a row and went to unpack other presents.

In this time, Timofey's elder brother, Dima reordered the cubes using the following rule. Suppose the cubes are numbered from 1 to n in their order. Dima performs several steps, on step i he reverses the segment of cubes from i-th to (n - i + 1)-th. He does this while i ≤ n - i + 1.

After performing the operations Dima went away, being very proud of himself. When Timofey returned to his cubes, he understood that their order was changed. Help Timofey as fast as you can and save the holiday — restore the initial order of the cubes using information of their current location.
Input

The first line contains single integer n (1 ≤ n ≤ 2·105) — the number of cubes.

The second line contains n integers a1, a2, ..., an ( - 109 ≤ ai ≤ 109), where ai is the number written on the i-th cube after Dima has changed their order.
Output

Print n integers, separated by spaces — the numbers written on the cubes in their initial order.

It can be shown that the answer is unique.
Examples
Input

7
4 3 7 6 9 1 2

Output

2 3 9 6 7 1 4

Input

8
6 1 4 2 5 6 9 2

Output

2 1 6 2 5 4 9 6

Note

Consider the first sample.

    At the begining row was [2, 3, 9, 6, 7, 1, 4].
    After first operation row was [4, 1, 7, 6, 9, 3, 2].
    After second operation row was [4, 3, 9, 6, 7, 1, 2].
    After third operation row was [4, 3, 7, 6, 9, 1, 2].
    At fourth operation we reverse just middle element, so nothing has changed. The final row is [4, 3, 7, 6, 9, 1, 2]. So the answer for this case is row [2, 3, 9, 6, 7, 1, 4]. 

