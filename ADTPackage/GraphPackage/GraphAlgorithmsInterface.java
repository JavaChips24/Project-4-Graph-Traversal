package ADTPackage.GraphPackage;
import ADTPackage.Queue.QueueInterface; // Classes that implement various ADTs
import ADTPackage.Stack.StackInterface;


/** 
   An interface of methods that process an existing graph. 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public interface GraphAlgorithmsInterface<T>
{
   /** Performs a breadth-first traversal of this graph.
       @param origin  An object that labels the origin vertex of the traversal.
       @return  A queue of labels of the vertices in the traversal, with
                the label of the origin vertex at the queue's front. */
   public QueueInterface<T> getBreadthFirstTraversal(T origin);

   /** Performs a depth-first traversal of this graph.
       @param origin  An object that labels the origin vertex of the traversal.
       @return  A queue of labels of the vertices in the traversal, with
                the label of the origin vertex at the queue's front. */
   public QueueInterface<T> getDepthFirstTraversal(T origin);

   /** Finds the shortest-length path between two given vertices in this graph.
       @param begin  An object that labels the path's origin vertex.
       @param end    An object that labels the path's destination vertex.
       @param path   A stack of labels that is empty initially;
                     at the completion of the method, this stack contains
                     the labels of the vertices along the shortest path;
                     the label of the origin vertex is at the top, and
                     the label of the destination vertex is at the bottom       
       @return  The length of the shortest path. */
   public int getShortestPath(T begin, T end, StackInterface<T> path);

} // end GraphAlgorithmsInterface
