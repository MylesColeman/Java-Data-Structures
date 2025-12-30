/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayadt;

/**
 *
 * @author E4109732
 */
public class DriverClass {
    public static void main(String[] args){
        ArrayADT existingADT = new ArrayADT(new int[] { 1, 5, 9, 2, 3});
        
        for (int i = 0; i < existingADT.numberOfElements(); i++)
        {
            System.out.print(existingADT.get(i) + " ");
        }
        
        System.out.println(" ");
        
        existingADT.remove(2);
        for (int i = 0; i < existingADT.numberOfElements(); i++)
        {
            System.out.print(existingADT.get(i) + " ");
        }
        
        System.out.println(" ");
        
        existingADT.add(4);
        for (int i = 0; i < existingADT.numberOfElements(); i++)
        {
            System.out.print(existingADT.get(i) + " ");
        }
        
        System.out.println(" ");
        
        if (existingADT.isEmpty()){
            System.out.println("Array Empty");
        }
        else{
            System.out.println("Array Not Empty");
        }
        
        if(existingADT.isFull()){
            System.out.println("Array Full");
        }
        else{
            System.out.println("Array Not Full");
        } 
        
        existingADT.empty();
        for (int i = 0; i < existingADT.numberOfElements(); i++)
        {
            System.out.print(existingADT.get(i) + " ");
        }
    }
}