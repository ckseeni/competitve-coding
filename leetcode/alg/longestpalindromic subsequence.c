int max(int a,int b){
	return (a>b) ? a : b;
}
int lps(char *x,char *y,int m,int n){
	int L[m+1][n+1];
	for(int i=0;i<=m;i++){
		for(int j=0;j<=n;j++){
			if(i==0||j==0)
				L[i][j] = 0;
			else if(x[i-1]==y[j-1])
				L[i][j] = L[i-1][j-1] + 1;
			else
				L[i][j] = max(L[i-1][j],L[i][j-1]);
		}
	}
	return L[m][n];
}
int longestPalindromeSubseq(char* s) {
    int m = strlen(s);
	char y[m];
	for(int i=0;i<m;i++)
		y[i] = s[m-i-1]; 
	return lps(s,y,m,m);
}
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000. 
Input:

"bbbab"

Output:

4

One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:

"cbbd"

Output:

2

One possible longest palindromic subsequence is "bb". 
