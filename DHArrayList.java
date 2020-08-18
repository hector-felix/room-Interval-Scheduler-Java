/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc401project1finished;

/**
 *
 * @author Hector Felix, Kevin Baker
 */
public class DHArrayList <E> implements BareBonesArrayList<E> {

	private int size;	// How many elements are there in the AL
	private int capacity;	// How big is the AL
	private E[] myArray;	// This is the reference to actual data
	
	// Constructors
	
	// Default constructor, creates an array list of size 2
	public DHArrayList() {
		this.capacity = 20;
		this.size = 0;		// Initially there is no data
		myArray = (E[]) new Object[this.capacity]; // Create the
		// array with default size
	}
	
	// Overloaded constructor; creates an AL of user defined size
	public DHArrayList(int capacity) {
		this.capacity = capacity;
		this.size = 0;		// Initially there is no data
		myArray = (E[]) new Object[this.capacity]; // Create the
		// array with default size
	}
	
	public DHArrayList(DHArrayList<E> a) {
		this.size = a.size;
		this.capacity = a.capacity;
		this.myArray = (E[]) a.myArray;
	}
	@Override
	public void add(E a) {
		// This method adds an element to the end of the AL
		if(size < capacity) {
			// This means there is space at the end of the AL
			myArray[size] = a;	// size gives the index of first
								// empty location
			size++;		// Update the total number of elements in AL
		}
		else {
			// We do not have space to add the element
			this.reallocate();	// Call reallocate
			this.add(a);	// Once we have bigger AL, then add data
		}
		
	}

	public boolean isEmpty() {
        return size==0;
    }
	
	private void reallocate() {
		// This method doubles the capacity of the AL
		this.capacity *= 2;
		E[] temp = (E[]) new Object[this.capacity];
		// Now, we have an empty array double the size
		// Copy over the elements from original array to temp
		for(int i = 0; i < myArray.length;i++) {
			temp[i] = myArray[i];
		}
		// Now update the reference to reflect the change
		this.myArray = temp;
		
	}

	@Override
	public void add(int index, E a) {
		// This method inserts the data at given index
		// First, check if the index is valid or not
		if(index < 0 || index > size) {
			System.out.println("Invalid index!");
			return;
		}
		else if(index == size) {
			// This indicates that the element needs to be added
			// at the end of the AL
			// Now, we have a method for that!
			this.add(a); // Call the add() method to handle
		}
		else {
			// We will insert the data by shifting elements
			// Is there enough space to shift?
			if(this.capacity == this.size) {
				// AL is already full
				this.reallocate();
			}
			// We have space to shift elements
			for(int i = size; i > index; i--) {
				this.myArray[i] = this.myArray[i -1];
			}
			// Don't forget to insert
			this.myArray[index] = a;
			// Update the total number of elements
			this.size++;
		}
		
	}

	@Override
	public E remove(int index) {
		// This method deletes an element from the given index
		// Make sure that the index is valid
		if(index < 0 || index >= size) {
			System.out.println("Invalid index!");
			return null;
		}
		// We will save the element to be deleted in a temp
		E temp = myArray[index];
		// Then we need to shift elements to the left
		for(int i = index; i < size -1 ; i++) {
			this.myArray[i] = this.myArray[i+1];
		}
		// Don't forget to update size
		size--;		
		return temp;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index >= size) {
			System.out.println("Invalid index!");
			return null;
		}
		return myArray[index];
	}

	@Override
	public void set(int index, E a) {
		if(index < 0 || index >= size) {
			System.out.println("Invalid index!");
			return;
		}
		myArray[index] = a;
		
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public int indexOf(E a) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Method to print the contents of the AL
	// We will override the toString method
	public String toString() {
		String s = "";
		for(int i = 0; i < size; i++) {
                    if(i < size - 1) {
			s = s + myArray[i] + ", ";
                    }
                    else
                        s = s + myArray[i] + "";
		}
		return s;
	}

	public boolean check(E a) {
        for (int i = 0; i < size; i++) {
            if( a ==  myArray[i]) {
                return true; 
            }
        }
        return false;
    }
}