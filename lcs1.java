import java.io.*;
import java.util.*;
import java.util.Scanner;
public class lcs1
{
  public static void main(String [] args)
  {
    String s; 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a string"); 
    s = sc.nextLine();  
    System.out.println("You entered String "+s);
    String q;
    System.out.println("Enter a string"); 
    q = sc.nextLine();  
    System.out.println("You entered String "+q);
    int m=s.length();
    int n=q.length();
    lcs(s,q,m,n);
  }
  public static void lcs(String a, String b, int m, int n)
  {
    int [][]graph=new int[m+1][n+1];
    for(int i=0; i<=m; i++)
    {
      for(int j=0; j<=n; j++)
      {
        if(i==0 || j==0)
        {
          graph[i][j]=0;
        }
        else if(a.charAt(i-1)==b.charAt(j-1))
        {
          graph[i][j]=graph[i-1][j-1]+1;
        }
        else
        {
          graph[i][j]=Math.max(graph[i][j-1],graph[i-1][j]);
        }
      }
    }
    int index=graph[m][n];
    int temp=index;
    char []f=new char[index+1];
    f[index]=' ';
    
    int i=m, j=n;
    
    while (i>0 && j>0)
    {
      if(a.charAt(i-1)==b.charAt(j-1))
      {
        f[index-1] = a.charAt(i-1);
        i--;
        j--;
        index--;
      }
      else if (graph[i-1][j]>graph[i][j-1])
      {
        i--; 
      }
      else 
      {
        j--;
      }
    }
    System.out.print("The LCS of given two strings are ");
    for(int x=0; x<=temp; x++)
    {
      System.out.print(f[x]);
    }
    System.out.println();
    for(int u=0; u<m; u++)
    {
      for(int v=0; v<n; v++)
      {
        System.out.print(graph[u][v]+" ");
      }
      System.out.println();
    }
  }
  
}