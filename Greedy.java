//Adrian Hy
//Project #4 
//CS 241

package greedy;

import graph.*;
import java.io.IOException;
import java.util.*;

public class Greedy extends GreedyGraph
{
    boolean checkSPT;
    double SPTcost = 0;
    double MSTcost = 0;
    
    public Greedy(String name) throws IOException 
    {
        super(name);
    }
    
    public void minSpanningTree(int v)
    {
        checkSPT = false;
        greedy(v);
        
    }
    
    @Override
    public double newCost(int v, int w)
    {
        double weightOf = weightOf(getEdge(v,w));
        if(checkSPT)
        {
            SPTcost = costOf(v) + weightOf;
            return SPTcost;
        }
        else
        {
            MSTcost = weightOf;
            return MSTcost;
        }
            
    }
    
    public void shortPathTree(int v, boolean checkSPT)
    {
        this.checkSPT = checkSPT;
        unmarkAll();
        greedy(v);
        
    }
    
    public static void main(String[] args) throws IOException
    {
       
       ArrayList<Integer> shortPath = new ArrayList<>();
       Greedy spt = new Greedy(args[0]);
       Greedy mst = new Greedy(args[0]);
       double totalMST = 0;
       double totalSPT = 0;
       
       System.out.println(mst);
       
       
       System.out.println("Minimum Spanning Tree: ");
       mst.minSpanningTree(0);
       
       Edge[] edgesForMST = mst.getEdges();
       Edge[] edgesForSPT = spt.getEdges();
       
       
       System.out.println();
       
       for(int i = 0; i < edgesForMST.length; i++)
       {
           if(mst.isSelected(edgesForSPT[i]))
           {
                System.out.println(edgesForMST[i]);
                totalMST += edgesForMST[i].getWeight();
           }
       }
       
       System.out.println();
       System.out.println("Total Edge cost for MST: " + totalMST);
      
       
       System.out.println();
       
       spt.shortPathTree(0, true);
       
       System.out.println("Shortest Path Tree: ");
       System.out.println();
       
       int index = spt.order-1;
       
       for(int i = 0; i < edgesForSPT.length; i++)
       {
           if(spt.isSelected(edgesForSPT[i]))
           {
                System.out.println(edgesForSPT[i]);
                totalSPT += edgesForSPT[i].getWeight();
           }
       }
       
       System.out.println();
       System.out.println("Total edge cost for SPT: " + totalSPT);
       
       System.out.println();
       
       while(index != 0)
       {
           shortPath.add(index);
           index = spt.getVertex(index).getParent();
       }
       
       shortPath.add(spt.getVertex(index).getParent());
       shortPath.trimToSize();
       
       System.out.print("Short Path from 0 - " + (mst.order-1) + " : [ ");
       
       for(int i = (shortPath.size() -1); i >= 0; i--)
       { 
            System.out.print(shortPath.get(i) + " ");
       }
       
       System.out.println("]");
       
       double shortestPath = spt.costOf(spt.order -1);
       
       System.out.println("Shortest Path Cost: " + shortestPath);
       
    }
    
}