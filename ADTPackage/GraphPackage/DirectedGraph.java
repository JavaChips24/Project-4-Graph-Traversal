package ADTPackage.GraphPackage;
import java.util.Iterator;
import ADTPackage.Dictionary.*; // Classes that implement various ADTs
import ADTPackage.Queue.*;
/**
   A class that implements the ADT directed graph.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class DirectedGraph<T> implements GraphInterface<T>
{
	private DictionaryInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;

	public DirectedGraph()
	{
		vertices = new UnsortedLinkedDictionary<>();
		edgeCount = 0;
	} // end default constructor

	/* Implementations of the graph operations go here. 
	. . . */

	public boolean addVertex(T vertexLabel)
	{	@SuppressWarnings("unchecked")
		VertexInterface<T> addOutcome = vertices.add(vertexLabel, new Vertex(vertexLabel));
		return addOutcome == null;
	}

	public boolean addEdge(T begin, T end, double edgeWeight)
	{
		boolean result =false;
		VertexInterface<T> beginVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);
		if( (beginVertex != null) && (endVertex != null) )
			result = beginVertex.connect(endVertex, edgeWeight));

		if(result)
			edgeCount++;
		return result;
	} // end addEdge

	public boolean addEdge(T begin, T end)
	{
		return addEdge( begin, end, 0);
	} // end addEdge

	public boolean hasEdge(T begin, T end)
	{
		boolean found = false;
		VertexInterface<T> beginVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);
		if ( (beginVertex != null) && (endVertex != null) )
		{
			Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
			while (!found && neighbors.hasNext())
			{
				VertexInterface<T> nextNeighbor = neighbors.next();
				if (endVertex.equals(nextNeighbor))
				found = true;
			} // end while
		} // end if
		return found;
	} // end hasEdge 

	public boolean isEmpty()
	{
	   return vertices.isEmpty();
	} // end isEmpty
	public void clear()
	{
	   vertices.clear();
	   edgeCount = 0;
	} // end clear
	public int getNumberOfVertices()
	{
	   return vertices.getSize();
	} // end getNumberOfVertices
	public int getNumberOfEdges()
	{
	   return edgeCount;
	} // end getNumberOfEdges 

	protected void resetVertices()
	{
	   Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
	   while (vertexIterator.hasNext())
	   {
		  VertexInterface<T> nextVertex = VertexIterator.next();
		  nextVertex.unvisit();
		  nextVertex.setCost(0);
		  nextVertex.setPredecessor(null);
	   } // end while
	} // end resetVertices 

	public QueueInterface<T> getBreadthFirstTraversal(T origin)
{
   resetVertices();
   QueueInterface<T> traversalOrder = new LinkedQueue<>();
   QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();
   VertexInterface<T> originVertex = vertices.getValue(origin);
   originVertex.visit();
   traversalOrder.enqueue(origin);    // Enqueue vertex label 
   vertexQueue.enqueue(originVertex); // Enqueue vertex
   while (!vertexQueue.isEmpty())
   {
      VertexInterface<T> frontVertex = vertexQueue.dequeue();
      Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
      while (neighbors.hasNext())
      {
         VertexInterface<T> nextNeighbor = neighbors.next();
         if (!nextNeighbor.isVisited())
         {
            nextNeighbor.visit();
            traversalOrder.enqueue(nextNeighbor.getLabel());
            vertexQueue.enqueue(nextNeighbor);
         } // end if
      } // end while
   } // end while
   return traversalOrder;
} // end getBreadthFirstTraversal 
} // end DirectedGraph