package com.training.stackapp;

public class StackException extends Exception{
 
        public StackException(String errorMessage) {
  super();
  this.errorMessage = errorMessage;
 }

  private String errorMessage;

  public String getErrorMessage() {
   return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
   this.errorMessage = errorMessage;
  }
        
        
}
 