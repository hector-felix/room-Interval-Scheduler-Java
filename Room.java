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
public class Room {
    int timeAvailable, precedence;
    Interval[] intervals;
    DHArrayList<Interval> IntervalList = new DHArrayList<>();
    boolean occupied;
    
    public Room(int timeAvailable, int precedence, Interval interval){
        this.timeAvailable = timeAvailable;
        this.precedence = precedence;
        this.IntervalList.add(interval);
    }
    
    public Room(int timeAvailable, int precedence){
        this.timeAvailable = timeAvailable;
        this.precedence = precedence;
    }
       
    public int getPrecedence() {
        return precedence;
    }
    
    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }
    
    public int getTimeAvailable(){
        return timeAvailable;
    }
    
    public void setTimeAvailable(int timeAvailable){
        this.timeAvailable = timeAvailable;
    }
    
    public boolean isOccupied(){
        return occupied;
    }
    
    public int getLength() {
        return IntervalList.getSize();
    }
    
        @Override
    public String toString() {
        return "Class [id=" + precedence + ", intervals=[" + IntervalList.toString() + "]";
    }
}