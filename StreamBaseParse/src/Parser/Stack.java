package Parser;

import java.util.LinkedList;

public class Stack<S> {
		private LinkedList<S> stack;
		private S data;
		
	   public Stack(){
		  this.stack = new LinkedList<S>();
	   }
	   public S getData() {
	      return this.data;
	   }
	   public void setData(S Data) {
		  this.data = Data;
	   }
	   public void push(S item) {
	      stack.addFirst(item);
	   }
	   public S pop() {
	      return stack.removeFirst();
	   }
	   public S topItem() {
		   return stack.getFirst();
	   }
	   public boolean hasItems() {
	      return !stack.isEmpty();
	   }
	   public int size() {
	      return stack.size();
	   }
		
}
