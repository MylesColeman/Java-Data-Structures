/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrayadt;

/**
 *
 * @author E4109732
 */
public class ArrayADT {
    // Instance Variables
    private int[] data;
    private int numberOfEntries;
    private final int capacity;
    
    // Constructor
    public ArrayADT(int size){
        this.data = new int[size];
        numberOfEntries = 0;
        capacity = size;
    }
    
    public ArrayADT(int[] array){
        data = array;
        this.numberOfEntries = array.length;
        this.capacity = array.length;
    }
    
    public String add(int entry){
        if (numberOfEntries == capacity){
            return "Array is Full!";
        }
        else{
            data[numberOfEntries] = entry;
            numberOfEntries++;
            
            return "The item: " + entry + " has been added.";
        }
    }
    
    public boolean remove(int position){
        if (position > numberOfEntries || position < 0){
            return false;
        }
        else{
            data[position] = 0;
            
            for(int i = position; i < numberOfEntries - 1; i++){
                data[i] = data[i + 1];
            }
            
            data[numberOfEntries - 1] = 0;
            numberOfEntries--;
            
            return true;
        }
    }
    
    public int get(int index){
        if (index >= numberOfEntries || index < 0){
            return -999;
        }
        else{
            return data[index];
        }
    }
    
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }
    
    public boolean isFull(){
        return numberOfEntries == capacity;
    }
    
    public int numberOfElements(){
        return numberOfEntries;
    }
    
    public void empty(){
        data = null;
        numberOfEntries = 0;
    }
}