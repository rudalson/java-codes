package design.pattern.memento;

import java.util.Stack;

public class MementoMain {

	public static void main(String[] args) {
		
		Stack<Memento> mementos = new Stack<>();
		Originator originator = new Originator();
		
		originator.setState("state1");
		mementos.push(originator.createMemento());
		
		originator.setState("state2");
		mementos.push(originator.createMemento());
		
		originator.setState("state3");
		mementos.push(originator.createMemento());
		
		originator.setState("stateLast");
		mementos.push(originator.createMemento());
		
		originator.restoreMemento(mementos.pop());
		System.out.println(originator.getState());
	}

}
