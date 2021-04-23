//import java.io.*;
import java.util.*;
public class Lcs{
  public static void main(String[]args){
   String p="MISSISSIPPI";
   String q="SIMMIPPIMMI";
   int m=p.length();
 int n=q.length();
   lcs(p,q,m,n);
  }
  public static void lcs(String p,String q,int m,int n){
   int L[][]=new int[m+1][n+1];
   for(int i=0;i<=m;i++){
     for(int j=0;j<=n;j++){
       if(i==0 || j==0){
        L[i][j]=0; 
       }
       else if(p.charAt(i-1)==q.charAt(j-1)){
        L[i][j]=L[i-1][j-1]+1; 
       }
        else{
          L[i][j]=Math.max(L[i-1][j],L[i][j-1]);
        }
     }
   }
   int index=L[m][n];
    int temp=index;
    char []f=new char[index];
     int i=m, j=n;
    
    while (i>0 && j>0)
    {
      if(p.charAt(i-1)==q.charAt(j-1))
      {
        f[index-1] = p.charAt(i-1);
        i--;
        j--;
        index--;
      }
      else if (L[i-1][j]>L[i][j-1])
      {
        i--; 
      }
      else 
      {
        j--;
      }
    }
System.out.print("The LCS of given two strings are ");
    for(int x=0; x<temp; x++)
    {
      System.out.print(f[x]);
    }
    System.out.println();
    for(int u=0; u<=m; u++)
    {
      for(int v=0; v<=n; v++)
      {
        System.out.print(L[u][v]+" ");
      }
      System.out.println();
   }
  }
}