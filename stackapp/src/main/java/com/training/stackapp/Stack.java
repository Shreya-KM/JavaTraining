package com.training.stackapp;

import java.util.Arrays;

public class Stack {
    private int stkArray[];
    private int size;
    private int curr;
    
    public Stack(int size) {
     this.size=size;
     this.curr=-1;
     stkArray = new int[size];
    }
    
    public void push(int element) throws StackException{
     if(this.isFull()) {
      throw new StackException("Stack is Full");
     }
     this.stkArray[curr++]=element;
    }
    
    public int pop() throws StackException{
     if(this.isEmpty()) {
      throw new StackException("stack is empty");
     }
     else {
      return this.stkArray[--curr];
     }
    }
    
    public boolean isFull() {
     if(this.curr>=this.size)
      return true;
     else
      return false;
    }
    
    public boolean isEmpty() {
     if(this.curr <= 0)
      return true;
     else
      return false;
    }
    
    public void display() {
     System.out.println(Arrays.toString(this.stkArray));
    }
}
 