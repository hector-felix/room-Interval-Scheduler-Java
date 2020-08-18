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
public class Interval {
    int start, finish, intervalNumber;

    public Interval(int start, int finish, int intervalNumber) {
        this.start = start;
        this.finish = finish;
        this.intervalNumber = intervalNumber;
    }

    public Interval(){
    }
    
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    
    public int getFinish() {
        return finish;
    }    
    
    public void setFinish(int finish) {
        this.finish = finish;
    }

    public int getIntervalNumber() {
        return intervalNumber;
    }
    public void setNumberInterval(int intervalNumber) {
        this.intervalNumber = intervalNumber;
    }
    
    public String toString() {
        return "[" + intervalNumber + ", [" + start + ", " + finish + "]]";
    }
}