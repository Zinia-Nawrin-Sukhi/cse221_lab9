import java.io.*;
import java.util.*;
public class BellmanFord
{
    public static void main(String[]args)
    {
        BufferedReader obj=null;
        PriorityQueue<Integer> q=new PriorityQueue<Integer>(); 
        int r=0;
        int t;
        
        try
        {
            String str;
            FileReader fr=new FileReader("E:\\cse221\\lab\\lab4\\dijkstraGraph.txt");
            obj=new BufferedReader(fr);
            str=obj.readLine();
            int v=Integer.parseInt(str);
            System.out.print(v);
            System.out.println();
            int[]key=new int[v];
            int []parent=new int[v];
            int graph[][]=new int[v][v];
            while((str=obj.readLine())!=null)
            {
                StringTokenizer st=new StringTokenizer(str," ");
                int token1=Integer.parseInt(st.nextToken());
                int token2=Integer.parseInt(st.nextToken());
                int token3=Integer.parseInt(st.nextToken());
                graph[token1][token2]=token3;
                //graph[token2][token1]=token3;
            }
             for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
         System.out.print(graph[i][j]+" "); 
        }
       System.out.println();  
      }  
            
            for(int i=0; i<v;i++)
            {
                key[i]=100000;
                parent[i]=0;
            }
            key[0]=0;
            for(int i=0;i<v;i++)
            {
            q.add(key[i]);
              }
             int min_key=-1;
            while(q.size()!=0)
            {
                t=(int)q.remove(); 
                for(int i=0;i<v;i++)
                {
                if(t==key[i])
                {
                min_key=i;
                
                System.out.println("---"+min_key);
                //System.out.println();
                 }
                }
                for(int i=0;i<v-1 ;i++){
                  if(graph[min_key][i]!=0){
                {
                    if(q.contains(key[i]) && key[min_key]+graph[min_key][i]<key[i])
                    {
                        parent[i]=min_key;
                        key[i]=graph[min_key][i]+key[min_key];
                        q.add(key[i]);
                    }
                }
                }
            }
                for(int i=0;i<v;i++){
                     
                  if(graph[min_key][i]!=0){
                {
                    if(q.contains(key[i]) && key[min_key]+graph[min_key][i]<key[i])
                    {
                      System.out.println("negative cycle " );
                    }
                }
                  }
                }
            for(int i=0;i<v;i++)
            {
            System.out.println(key[i]+" ");
        }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    }
