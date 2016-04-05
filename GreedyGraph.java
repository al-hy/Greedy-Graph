//Adrian Hy
//CS 241
//Project #4


public class GreedyGraph extends Graph 
{
    private final boolean DEBUG=false;
    private GreedyPriorityQueue q;
    private int components;

    public GreedyGraph(String name) throws java.io.IOException 
    {
            process_header(name);
            add_vertices();
            add_edges();
    }
	
//overriden method from Graph
    protected void add_vertices() 
    {
            if(DEBUG)
                System.out.println("GreedyGraph.add_vertices");
            vertices=new GreedyVertex[order];
            q=new GreedyPriorityQueue();
            
            for (int i=0; i<order; i++) 
            {
                    vertices[i]=new GreedyVertex(i);
            }
    }

//returns vertex of specified index
    public GreedyVertex getVertex(int index) 
    {
            return (GreedyVertex)vertices[index];
    }

//greedy algorithm implemented to track the cheapest cost of an edge to a vertex
    public void greedy(int u) 
    {
        setCost(u,0.0);
            q.add(getVertex(u));
            while (q.size()>0) 
            {
                int v=q.poll().getIndex();
                if (DEBUG) System.out.println("GreedyGraph:visit="+v);
                    markVertex(v);
                for (int w:getNeighbors(v)) 
                {
                    if (!vertexMarked(w)) 
                    {
                        if (isFringe(w)) 
                        {
                            if (newCost(v,w)<costOf(w)) 
                                modifyFringe(v,w);
                        }  
                        else addFringe(v,w);
                        }
                }
            } 

    } 
	
//newCost is the method that must be overridden depending on the algorithm
//implemented
    public double newCost(int v, int w) {
        return 0.0;
    }

    //return the cost of vertext v
    public double costOf(int v) 
    {
        return getVertex(v).getCost();
    }

//return a boolean value that determines if an edge is marked
    public boolean isSelected(Edge e) 
    {
        return getEdge(e).isSelected();
    }

//returns the weight of an edge
    public double weightOf(Edge e) 
    {
        return  getEdge(e).getWeight();
    }
//return a boolean value if an vertex is a fringe
//checks the vertex if it is a fringe
        
    private boolean isFringe(int v) 
    {
        return getVertex(v).isFringe();
    }

    private void setCost(int v, double cost) 
    {
        getVertex(v).setCost(cost);
    }

// Add a new fringe vertex: define its cost & parent, select edge connecting it to tree.
    private final void addFringe(int v, int w) 
    {
    // select edge
            getEdge(v,w).setSelected(true);
    // store vertex info and add vertex to priority queue
            double cost=newCost(v,w);
            if (DEBUG) System.out.println("GreedyGraph:addFringe="+w+"("+cost+")");
            GreedyVertex vertex=getVertex(w);
            vertex.setFringe(true);
            vertex.setParent(v);
            vertex.setCost(cost);
            q.add(vertex);
            if (DEBUG) System.out.println(q);
    }

// Modifies existing fringe vertex
// change the current cost to the cheaper cost and change parent
// deselects old edge
    private final void modifyFringe(int v, int w) 
    {
            if (DEBUG) System.out.println("GreedyGraph:modifyFringe=("+v+","+w+")");	
    //selects new edge
            getEdge(v,w).setSelected(true);
    //deselects old edge
            getEdge(getVertex(w).getParent(),w).setSelected(false);
    //update vertex info and update priority queue
            double cost=newCost(v,w);
            GreedyVertex vertex=getVertex(w);
            vertex.setParent(v);
            vertex.setCost(cost);
            q.promote(vertex);
            if (DEBUG) System.out.println(q);
    }
}	