package ADTPackage.GraphPackage;
import java.util.Iterator;
import ADTPackage.Dictionary.*; 
import ADTPackage.Queue.*;
import ADTPackage.Stack.*;

public final class Graph<T> implements GraphInterface<T> {
    private DictionaryInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;

	public Graph()
	{
		vertices = new UnsortedLinkedDictionary<>();
		edgeCount = 0;
	} // end default constructor

	/* Implementations of the graph operations go here. 
	. . . */
    
    // basic GraphInterfect implemented
    public boolean addVertex(T vertexLabel){
        VertexInterface<T> result = vertices.add(vertexLabel, new Vertex<>(vertexLabel));
        return result == null;
    } // end addVertex
    public boolean addEdge(T begin, T end, double edgeWeight){
        boolean result = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if ( (beginVertex != null) && (endVertex != null) )
            result = beginVertex.connect(endVertex, edgeWeight);
        if (result)
            edgeCount++;
        return result;
    } // end addEdge

    public boolean addEdge(T begin, T end){
        return addEdge(begin, end, 0);
    } // end addEdge

    public boolean hasEdge(T begin, T end){
        boolean hasEdge = false;
        VertexInterface<T> beginVertex = vertices.getValue(begin);
        VertexInterface<T> endVertex = vertices.getValue(end);
        if( beginVertex != null && endVertex != null)
        {
            Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighboriterator();
            while(!hasEdge && neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if(endVertex.equals(nextNeighbor))
                    hasEdge = true;
            } // end while
        } // end if
        return hasEdge;
    } // end hasEdge

    public boolean isEmpty(){
        return vertices.isEmpty();
    } // end isEmpty

    public int getNumberOfVertices(){
        return vertices.getSize();
    } // end getNumberOfVertices

    public int getNumberOfEdges(){
        return edgeCount;
    } // end getNumberOfEdges

    public void clear(){
        vertices.clear();
        edgeCount = 0;
    } // end clear

    // helper method
    protected void resetVertices()
    {
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while(vertexIterator.hasNext())
        {
            VertexInterface<T> nextVertex = vertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setPredecessor(null);
        } // end while
    } // end reset Vertices

   public QueueInterface<T> getBreadthFirstTraversal(T origin);

   public QueueInterface<T> getDepthFirstTraversal(T origin);

   public StackInterface<T> getTopologicalOrder();

   public int getShortestPath(T begin, T end, StackInterface<T> path);

   public double getCheapestPath(T begin, T end, StackInterface<T> path);
}
