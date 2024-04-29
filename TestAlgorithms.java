import ADTPackage.GraphPackage.Graph;
import ADTPackage.Queue.QueueInterface;

public class TestAlgorithms {
    public static void main(String[] args){

    
    Graph<Character> testingGraph = new Graph<Character>();
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

        System.out.println("Testing getDepthFirstTraversal...");
        QueueInterface<Character> depthFirstTravel = testingGraph.getDepthFirstTraversal('A');
        while(!depthFirstTravel.isEmpty())
        {
            System.out.print(depthFirstTravel.dequeue() + ", ");
        } // end while
    
        System.out.println("\n\nTesting getBreadthFirstTraversal...");
        QueueInterface<Character> breadthFirstTravel = testingGraph.getBreadthFirstTraversal('A');
        while(!breadthFirstTravel.isEmpty())
        {
            System.out.print(breadthFirstTravel.dequeue() + ", ");
        } // end while
    
    }
}
