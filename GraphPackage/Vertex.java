package GraphPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ADTPackage.*; // Classes that implement various ADTs
import ADTPackage.List.LinkedListWithIterator;
import ADTPackage.List.ListWithIteratorInterface;
/**
 A class of vertices for a graph.
@author Frank M. Carrano
@author Timothy M. Henry
@version 5.0
*/
class Vertex<T> implements VertexInterface<T>
    {
    private T label;
    private ListWithIteratorInterface<Edge> edgeList; // Edges to neighbors
    private boolean visited;                          // True if visited
    private VertexInterface<T> previousVertex;        // On path to this vertex
    private double cost;                              // Of path to this vertex

    public Vertex(T vertexLabel)
    {
        label = vertexLabel;
        edgeList = new LinkedListWithIterator<>();
        visited = false;
        previousVertex = null;
        cost = 0;
    } // end constructor

    /* Implementations of the vertex operations go here.
    . . . */

    public T getLabel()
    {
        return label;
    } // end getLabel

    public void visit()
    {

    } // end visit
 
    public void unvisit()
    {
        
    } // end unvisit

    public boolean isVisited()
    {

    } // end isVisited
 
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
    {

    } // end connect
                          
    public boolean connect(VertexInterface<T> endVertex)
    {

    } // end connect

    public Iterator<VertexInterface<T>> getNeighborIterator()
    {

    } // end getNeighborIterator

    public Iterator<Double> getWeightIterator()
    {

    } // end getWeightIterator
 
    public boolean hasNeighbor()
    {

    } // end hasNeighbor
 
    public VertexInterface<T> getUnvisitedNeighbor()
    {

    } // end getUnvisitedNeighbor
 
    public void setPredecessor(VertexInterface<T> predecessor)
    {

    } // end setPredecessor
 
    public VertexInterface<T> getPredecessor()
    {

    } // end getPredecessor
 
    public boolean hasPredecessor()
    {

    } // end hasPredecessor
 
    public void setCost(double newCost)
    {
        cost = newCost;
    } // end setCost
 
    public double getCost()
    {
        return cost;
    } // end getCost


    private class NeighborIterator implements Iterator<VertexInterface<T>>
    {
        private Iterator<Edge> edges;
        private NeighborIterator()
        {
            edges = edgeList.getIterator();
        } // end default constructor
        public boolean hasNext()
        {
            return edges.hasNext();
        } // end hasNext
        public VertexInterface<T> next()
        {
            VertexInterface<T> nextNeighbor = null;
            if (edges.hasNext()){
                Edge edgeToNextNeighbor = edges.next();
                nextNeighbor = edgeToNextNeighbor.getEndVertex();
            }
            else
                throw new NoSuchElementException();
            return nextNeighbor;
        } // end next
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
    protected class Edge
    {
        private VertexInterface<T> vertex; // Vertex at end of edge
        private double weight;

        protected Edge(VertexInterface<T> endVertex, double edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        } // end constructor

        protected Edge(VertexInterface<T> endVertex)
        {
            vertex = endVertex;
            weight = 0;
        } // end constructor

        protected VertexInterface<T> getEndVertex()
        {
            return vertex;
        } // end getEndVertex

        protected double getWeight()
        {
            return weight; 
        } // end getWeight
    } // end Edge
} // end Vertex