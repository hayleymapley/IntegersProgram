package nz.ac.vuw.hayley.integersprogram;

import ecs100.*;
import java.util.*;

public class IntegersProgram {

	private ArrayList<Integer> allNums = new ArrayList<Integer>();

	public IntegersProgram() {
		UI.initialise();
		UI.setDivider(1);
		UI.addButton("New list", this::newList);
		//UI.addTextField("Add an entry", this::addNum);
		UI.addButton("Add an entry", this::addNumButton);
		UI.addButton("Show list", this::displayList);
		UI.addTextField("Contains", this::doContains);
		UI.addTextField("Remove", this::doRemove);
		UI.addButton("Average", this::doAverage);
		UI.addButton("Negative/Positive", this::doNegative);
		UI.addButton("Double", this::doDouble);
		UI.addButton("Quit", UI::quit);
	}
	//AddNum Textfield
	/*public void addNum(String numStr) {
		try {
			int num = Integer.parseInt(numStr);
			if (num >= 0) {
				this.allNums.add(num);
				this.displayList();
			}
		} catch (Exception e) {
			UI.println("Please try again. (Tip: enter an integer!)");
		}
	}*/
	
	//AddNumButton
	public void addNumButton() {
		UI.println("Enter the numbers you wish to add to the array. When you enter a negative number, the entry will end.");
		int num = UI.askInt("");
		while (num >= 0) {
			this.allNums.add(num);
			num = UI.askInt("");
		}
		this.displayList();
	}

	public void displayList() {
		UI.clearText();
		UI.printf("The current list has %d numbers: %n", this.allNums.size());
		for (int i=0; i<this.allNums.size(); i++) {
			UI.printf("%3d: %s%n", i,this.allNums.get(i));
		}
		UI.println("------------------------------------");
	}

	public void doContains(String numStr) {
		try {
			int num = Integer.parseInt(numStr);
			if (this.allNums.contains(num)) {
				UI.println(num + " is in the list.");
			} else {
				UI.println(num + " is not in the list.");
			}
		} catch (Exception e) {
			UI.println("Please try again. (Tip: enter an integer!)");
		}
	}

	public void doRemove(String numStr) {
		try {
			int num = Integer.parseInt(numStr);
			if (this.allNums.remove(new Integer(num))) {
				UI.println(num + " was removed.");
			} else {
				UI.println(num + " was not found.");
			}
			this.displayList();
		} catch (Exception e) {
			UI.println("Please try again. (Tip: enter an integer!)");
		}
	}

	public void doAverage() {
		int value = 0;
		int total = 0;
		int average = 0;
		for (int i=0; i<this.allNums.size(); i++) {
			value = this.allNums.get(i);
			total = total + value;
			average = total/this.allNums.size();
		} UI.println("The average of the current list is " + average);
	}
	
	public void doNegative() {
		for (int i=0; i<this.allNums.size(); i++) {
			int num = this.allNums.get(i);
			int negNum = num *-1;
			this.allNums.set(i, negNum);
		}
		this.displayList();
	}
	
	public void doDouble() {
		for (int i=0; i<this.allNums.size(); i++) {
			int num = this.allNums.get(i);
			int doubleNum = num *2;
			this.allNums.set(i, doubleNum);
		}
		this.displayList();
	}
	
	public void newList() {
		this.allNums = new ArrayList<Integer>();
		this.displayList();
	}

	public static void main(String[] args) {
		new IntegersProgram();
	}

}
