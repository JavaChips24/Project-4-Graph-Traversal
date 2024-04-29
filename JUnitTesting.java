import ADTPackage.*;
import ADTPackage.GraphPackage.*;
import ADTPackage.Queue.QueueInterface;

import org.junit.Test;
import static org.junit.Assert.*;


public class JUnitTesting
{
    @Test
    public void testIsEmpty()
    {
        var emptyGraph = new Graph<Integer>();
        assertTrue("Newly creatd graph should be empty", emptyGraph.isEmpty());
    }

    @Test
    public void testAddVertex()
    {
        var testingGraph = new Graph<Integer>();
        assertTrue("Adding vertex should be true", testingGraph.addVertex(1));
    }

    @Test
    public void testGetNumberOfVertices(){
        var testingGraph = new Graph<Integer>();
        testingGraph.addVertex(1);
        testingGraph.addVertex(2);
        assertTrue("Numer of vertices should be 2", testingGraph.getNumberOfVertices()==2);

    } // end getNumberOfVertices

    @Test
    public void testBreadthFirstTraversal()
    {
        var testingGraph = new Graph<Character>();
        String correctResult = "A, B, E, D, F, H, G, C, I, ";
        //Add vertices to the graph
        testingGraph.addVertex('A');
        testingGraph.addVertex('B');
        testingGraph.addVertex('C');
        testingGraph.addVertex('D');
        testingGraph.addVertex('E');
        testingGraph.addVertex('F');
        testingGraph.addVertex('G');
        testingGraph.addVertex('H');
        testingGraph.addVertex('I');

        //Connect the vertices
        testingGraph.addEdge('A', 'B');
        testingGraph.addEdge('A', 'E');
        testingGraph.addEdge('A', 'D');
        testingGraph.addEdge('B', 'E');
        testingGraph.addEdge('D', 'G');
        testingGraph.addEdge('E', 'F');
        testingGraph.addEdge('E', 'H');
        testingGraph.addEdge('G', 'H');
        testingGraph.addEdge('H', 'I');
        testingGraph.addEdge('F', 'H');
        testingGraph.addEdge('F', 'C');
        testingGraph.addEdge('C', 'B');

        QueueInterface<Character> breadthFirstTravel = testingGraph.getBreadthFirstTraversal('A');
        String output = "";
        while(!breadthFirstTravel.isEmpty())
        {
            output += breadthFirstTravel.dequeue() + ", ";
        } // end while
    
        assertTrue("getBreadthFirstTraversal done correctly", correctResult.equals(output));
    }

    @Test
    public void testgetDepthFirstTraversal()
    {
        var testingGraph = new Graph<Character>();
        String correctResult = "A, B, E, F, H, I, C, D, G, ";
        //Add vertices to the graph
        testingGraph.addVertex('A');
        testingGraph.addVertex('B');
        testingGraph.addVertex('C');
        testingGraph.addVertex('D');
        testingGraph.addVertex('E');
        testingGraph.addVertex('F');
        testingGraph.addVertex('G');
        testingGraph.addVertex('H');
        testingGraph.addVertex('I');

        //Connect the vertices
        testingGraph.addEdge('A', 'B');
        testingGraph.addEdge('A', 'E');
        testingGraph.addEdge('A', 'D');
        testingGraph.addEdge('B', 'E');
        testingGraph.addEdge('D', 'G');
        testingGraph.addEdge('E', 'F');
        testingGraph.addEdge('E', 'H');
        testingGraph.addEdge('G', 'H');
        testingGraph.addEdge('H', 'I');
        testingGraph.addEdge('F', 'H');
        testingGraph.addEdge('F', 'C');
        testingGraph.addEdge('C', 'B');

        QueueInterface<Character> depthFirstTravel = testingGraph.getDepthFirstTraversal('A');
        String output = "";
        while(!depthFirstTravel.isEmpty())
        {
            output += depthFirstTravel.dequeue() + ", ";
        } // end while
    
        assertTrue("getDepthFirstTraversal done correctly", correctResult.equals(output));
    }

}
