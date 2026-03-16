import java.util.*;
public class bfs_two_rabbit{
    public static int bfss(char maze[][],int R,int C,int x1,int y1,int x2,int y2,boolean b[][])
    {
        int dir[][]={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{x1,y1,0});
        b[x1][y1]=true;
        int min=Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            int cur[]=q.poll();
            if(cur[0]==x2 && cur[1]==y2)
                {
                  return cur[2];   
                }
            for(int k=0;k<8;k++)
            {
                int x=dir[k][0]+cur[0];
                int y=dir[k][1]+cur[1];
                if(x>=0&&x<R&&y>=0&&y<C&&!b[x][y]&&(maze[x][y]!='#'&&maze[x][y]!='R'))
                {
                 q.offer(new int[]{x,y,cur[2]+1});
                 b[x][y]=true;
                }
                 
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt();
        int C=sc.nextInt();
        boolean q1=false;
        char maze[][]=new char[R][C];
        int x1=-1,x2=-1,y1=-1,y2=-1,x3=-1,y3=-1;
        for(int r=0;r<R;r++)
        {
            for(int c=0;c<C;c++)
            {
                maze[r][c]=sc.next().charAt(0);
                if(maze[r][c]=='R'&&!q1)
                {
                    x1=r;
                    y1=c;
                    q1=true;
                }
                else if(maze[r][c]=='R')
                {
                    x3=r;
                    y3=c;
                }
                if(maze[r][c]=='C')
                {
                    x2=r;
                    y2=c;
                }
            }
        }
        boolean b1[][]=new boolean[R][C];
        boolean b2[][]=new boolean[R][C];
        int r1=bfss(maze,R,C,x1,y1,x2,y2,b1);
        int r2=bfss(maze,R,C,x3,y3,x2,y2,b2);
        if(r1==-1)
            System.out.print(r1);
        else if(r2==-1)
            System.out.print(r2);
        else if (r1==r2) 
            System.out.print(r1+" "+r2);
        else
            System.out.print(Math.min(r1,r2));
       
    }
}