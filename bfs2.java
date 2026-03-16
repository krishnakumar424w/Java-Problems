
import java.util.*;
public class bfs1{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int R=sc.nextInt();
        int C=sc.nextInt();
        char maze[][]=new char[R][C];
        int x1=-1,x2=-1,y1=-1,y2=-1;
        for(int r=0;r<R;r++)
        {
            for(int c=0;c<C;c++)
            {
                maze[r][c]=sc.next().charAt(0);
                if(maze[r][c]=='R')
                {
                    x1=r;
                    y1=c;
                }
                if(maze[r][c]=='C')
                {
                    x2=r;
                    y2=c;
                }
            }
        }
        int dir[][]={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        Queue<int[]>q=new LinkedList<>();
        int steps=0;
        q.offer(new int[]{x1,y1});
        boolean b[][]=new boolean[R][C];
        b[x1][y1]=true;
        while(!q.isEmpty())
        {
            steps++;
            for(int ctr=0;ctr<q.size();ctr++)
            {
            int cur[]=q.poll();
            if(cur[0]==x2 && cur[1]==y2)
            {
                
                System.out.print(steps+1);
                return;
            }
            for(int k=0;k<8;k++)
            {
                int x=dir[k][0]+cur[0];
                int y=dir[k][1]+cur[1];
                if(x>=0&&x<R&&y>=0&&y<C&&!b[x][y]&&maze[x][y]!='#')
                    {
                 q.offer(new int[]{x,y});
                 b[x][y]=true;
                }
            }
            }
        }

        System.out.print(-1);
    }
}