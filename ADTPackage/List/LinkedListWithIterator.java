package ADTPackage.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
   A class that implements the ADT list by using a chain of linked nodes.
   The list has an iterator. The class is similar to LList.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
   private Node firstNode;
   private int  numberOfEntries;;

   public LinkedListWithIterator()
   {
      initializeDataFields();
   } // end default constructor

   private void initializeDataFields()
   {
      firstNode = null;
      numberOfEntries = 0;
   } // end initializeDataFields

/*	< Implementations of the methods of the ADT list go here;
     you can see them in Chapter 12, beginning at Segment 12.7 >
   . . . */

   public void add(T newEntry){
      Node newNode = new Node(newEntry);
      if(isEmpty())
         firstNode = newNode;
      else{
         Node lastNode = getNodeAt(numberOfEntries);
         lastNode.setNextNode(newNode);
      }
      numberOfEntries++;
   }

   public void add(int newPosition, T newEntry){
      if((newPosition >= 1) && (newPosition <= numberOfEntries +1)){
         Node newNode = newNode(newEntry);
         if(newPosition == 1){
            newNode.setNextNode(firstNode);
            firstNode = newNode;
         } // end if
         else{
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
         } // end else
         numberOfEntries++;
      } // end if
      else
         throw new IndexOutOfBoundsException("Illegal position parameter to add operation");

   }

   public T remove(int givenPosition){
      T result = null;                           // Return value
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: !isEmpty()
         if (givenPosition == 1)                 // Case 1: Remove first entry
         {
            result = firstNode.getData();        // Save entry to be removed
            firstNode = firstNode.getNextNode(); // Remove entry
         }
         else                                    // Case 2: Not first entry
         {
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeToRemove = nodeBefore.getNextNode();
            result = nodeToRemove.getData();    // Save entry to be removed
            Node nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);  // Remove entry
         } // end if
         numberOfEntries--;                     // Update count
         return result;                         // Return removed entry
      } // end if
      else
         throw new IndexOutOfBoundsException("Illegal position given to remove operation.");

   }
   
   /** Removes all entries from this list. */
   public void clear(){

   }

   public T replace(int givenPosition, T newEntry){
      if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
      {
         // Assertion: !isEmpty()
         Node desiredNode = getNodeAt(givenPosition);
         T originalEntry = desiredNode.getData();
         desiredNode.setData(newEntry);
         return originalEntry;
      }
      else
         throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
   }
   
   /** Retrieves the entry at a given position in this list.
       @param givenPosition  An integer that indicates the position of
                           the desired entry.
      @return  A reference to the indicated entry.
      @throws  IndexOutOfBoundsException if either
               givenPosition < 1 or givenPosition > getLength(). */
   public T getEntry(int givenPosition){

   }
   
   /** Retrieves all entries that are in this list in the order in which
       they occur in the list.
      @return  A newly allocated array of all the entries in the list.
               If the list is empty, the returned array is empty. */
   public T[] toArray(){

   }
   
   /** Sees whether this list contains a given entry.
       @param anEntry  The object that is the desired entry.
      @return  True if the list contains anEntry, or false if not. */
   public boolean contains(T anEntry){

   }
   
   /** Gets the length of this list.
       @return  The integer number of entries currently in the list. */
   public int getLength(){

   }
      
   /** Sees whether this list is empty.
       @return  True if the list is empty, or false if not. */
   public boolean isEmpty(){

   }
   
   public Iterator<T> iterator()
   {
	   return new IteratorForLinkedList();
   } // end iterator

	public Iterator<T> getIterator()
	{
	   return iterator();
	} // end getIterator
   
	private class IteratorForLinkedList implements Iterator<T>
	{
      private Node nextNode;

		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		} // end default constructor
		
      // Implementations of the methods in the interface Iterator go here.

	} // end IteratorForLinkedList
	
	private class Node
	{
      private T    data; // Entry in list
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      } // end constructor
      
      private Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
} // end LinkedListWithIterator
