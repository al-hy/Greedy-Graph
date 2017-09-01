


public class GreedyVertex extends Vertex implements Comparable<GreedyVertex>
{
    private double cost;
    private boolean fringe;

    public GreedyVertex(int index) 
    {
        this(index, Double.POSITIVE_INFINITY);
    }

    public GreedyVertex(int index, double cost) 
    {
        super(index);
        fringe=false;
        parent=0;
        this.cost=cost;
    }


    public int compareTo(GreedyVertex that) 
    {
        if (this.cost<that.cost) return -1;
        if (this.cost==that.cost) 
        {
            if (this.index<that.index) return -1;
            else return 1;
        }
        return 1;
    }

    public double getCost() 
    {
        return cost;
    }

    public void setCost(double cost) 
    {
        this.cost=cost;
    }

    public boolean isFringe() 
    {
        return fringe;
    }

    public void setFringe(boolean fringe) 
    {
        this.fringe=fringe;
    }
}
