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

    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();
        
        // Get the origin vertex and mark it as visited
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        
        // Enqueue the origin vertex
        vertexQueue.enqueue(originVertex);
    
        // Perform breadth-first traversal
        while (!vertexQueue.isEmpty()) {
            VertexInterface<T> currentVertex = vertexQueue.dequeue();
            traversalOrder.enqueue(currentVertex.getLabel()); // Enqueue vertex label
    
            // Visit all unvisited neighbors of the current vertex
            Iterator<VertexInterface<T>> neighborIterator = currentVertex.getNeighborIterator();
            while (neighborIterator.hasNext()) {
                VertexInterface<T> neighbor = neighborIterator.next();
                if (!neighbor.isVisited()) {
                    neighbor.visit();
                    vertexQueue.enqueue(neighbor);
                }
            }
        }
        
        return traversalOrder;
    } // end getBreadthFirstTraversal

    public QueueInterface<T> getDepthFirstTraversal(T origin) {
        // Reset the visited status of all vertices
        resetVertices();
        
        // Queue to store the traversal order
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        
        // Stack to perform depth-first traversal
        StackInterface<VertexInterface<T>> vertexStack = new ResizableArrayStack<>();
        
        // Get the vertex corresponding to the origin value and mark it as visited
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        
        // Enqueue the origin vertex label into the traversal order queue
        traversalOrder.enqueue(origin); // Enqueue vertex
        
        // Push the origin vertex onto the stack
        vertexStack.push(originVertex); // Push vertex
        
        // Perform depth-first traversal
        while (!vertexStack.isEmpty()) {
            // Peek the top vertex from the stack
            VertexInterface<T> topVertex = vertexStack.peek();
            
            // Get an unvisited neighbor of the top vertex
            VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();
                
            if (nextNeighbor != null) {
                // If an unvisited neighbor is found, mark it as visited,
                // enqueue its label, and push it onto the stack
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            } else {
                // If no unvisited neighbor is found, pop the top vertex
                // from the stack
                vertexStack.pop();
            }
        }
        
        // Return the traversal order queue
        return traversalOrder;
    }

   public StackInterface<T> getTopologicalOrder()
   {

   }

   public int getShortestPath(T begin, T end, StackInterface<T> path)
   {

   }

   public double getCheapestPath(T begin, T end, StackInterface<T> path)
   {

   }
}
