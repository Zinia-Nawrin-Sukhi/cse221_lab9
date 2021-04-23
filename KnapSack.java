import java.io.*;
import java.util.*;
public class KnapSack {
    
    public static void main(String[] args) {
        //int [][] graph;
        BufferedReader obj= null;
        try {
            String str,str2;
            FileReader fr = new FileReader("E:\\cse221\\lab\\lab9\\knapsackGraph.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            str2=obj.readLine();
            // convert this to int
            int n = Integer.parseInt(str);
            int W=Integer.parseInt(str2);
            System.out.println(n);
            System.out.println(W);
          
            // creat the matrix 
            int  graph[][]=new int[n+1][W+1];
            int benefits[]=new int[n+1];
            int weight[]=new int[n+1];
            while ((str = obj.readLine()) != null ) {
 
                StringTokenizer st = new StringTokenizer(str," ");
                
                int token1 = Integer.parseInt(st.nextToken());
                
                int token2 = Integer.parseInt(st.nextToken());
                
                benefits[token1]=token2;
              
                
                int token3= Integer.parseInt(st.nextToken());
               
                weight[token1]=token3;
           
            }
          
                for(int j=1;j<=n;j++){
                  for(int w=1;w<=W;w++){
                    if(weight[j]>w){
                    graph[j][w]=graph[j-1][w];
                   }
                    else{
                      graph[j][w]=Math.max(benefits[j]+graph[j-1][w-weight[j]],graph[j-1][w]);
                }
                
            }
                 
            }
            
               for (int i= 0;i<n+1;i++){
                    for(int j = 0;j <W+1;j++){
                        // print
                        System.out.print(graph[i][j]+" ");
                    }
                    System.out.println();
                }
            
        }
  
   
            
         catch (IOException e) {
            
            e.printStackTrace();
            
        }
    }
    }
 