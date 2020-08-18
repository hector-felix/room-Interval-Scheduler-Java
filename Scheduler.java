/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc401project1finished;

import java.util.Scanner;

/**
 *
 * @author Hector Felix, Kevin Baker
 */
public class Scheduler {

    public static void MaxHeapify(Interval[] Intervals, int n, int i) {
        int Max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && Intervals[l].getStart() > Intervals[Max].getStart()) {
            Max = l;
        }
        if (r < n && Intervals[r].getStart() > Intervals[Max].getStart()) {
            Max = r;
        }
        if (Max != i) {
            Interval temp = Intervals[i];
            Intervals[i] = Intervals[Max];
            Intervals[Max] = temp;
            MaxHeapify(Intervals, n, Max);
        }
    }

    public static void HeapSort(Interval[] interval) {
        int a = interval.length;
        for (int i = a / 2 - 1; i >= 0; i--) {
            MaxHeapify(interval, a, i);
        }
        for (int i = a - 1; i >= 0; i--) {
            Interval temp = interval[0];
            interval[0] = interval[i];
            interval[i] = temp;
            MaxHeapify(interval, i, 0);
        }
    }

    public static Room mostIntervals(DHArrayList<Room> roomList) {
        Room tempRoom = roomList.get(0);
        for (int i = 1; i < roomList.getSize(); i++) {
            if (tempRoom.getLength() < roomList.get(i).getLength()) {
                tempRoom = roomList.get(i);
            }
        }
        return tempRoom;
    }

    public static void doHeap() {
        Interval[] heapInterval = makeHeap();
        HeapSort(heapInterval);
        DHArrayList<Room> roomList = new DHArrayList<>();
        Room c1 = new Room(0, 1);
        roomList.add(c1);
        roomList.get(0).IntervalList.add(heapInterval[0]);
        roomList.get(0).setTimeAvailable(heapInterval[0].getFinish());

        for (int i = 1; i < heapInterval.length; i++) {
            int roomListSize = roomList.getSize();
            boolean unplaced = true;
            for (int j = 0; j < roomListSize; j++) {
                if (heapInterval[i].getStart() >= roomList.get(j).getTimeAvailable()) {
                    roomList.get(j).IntervalList.add(heapInterval[i]);
                    roomList.get(j).setTimeAvailable(heapInterval[i].getFinish());
                    unplaced = false;
                    break;
                }
            }
            if (unplaced) {
                Room tempRoom = new Room(heapInterval[i].getFinish(), roomList.getSize() + 1, heapInterval[i]);
                roomList.add(tempRoom);
            }
        }

        System.out.println("\n-~-~-~-~-~-~-~-~Interval-~Scheduling-~-~-~-~-~-~-~-~-");
        System.out.println(mostIntervals(roomList));
        //does the set of mutually compatible intervals of maximum possible size mean most intervals assigned to one room?
        System.out.println("\n~-~-~-~-~-~-~-~Interval-~Partitioning-~-~-~-~-~-~-~-~");
        for (int i = 0; i < roomList.getSize(); i++) {
            System.out.println(roomList.get(i));
        }
    }

    public static Interval[] makeHeap() {
        int attributes, start, end;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of intervals:");
        attributes = input.nextInt();
        Interval[] heapInterval = new Interval[attributes];
        System.out.println("Please enter the start time of intervals:");
        start = input.nextInt();
        System.out.println("Please enter end time of intervals:");
        end = input.nextInt();
        for (int i = 0; i < attributes; i++) {
            heapInterval[i] = new Interval();
        }
        for (int i = 0; i < attributes; i++) { // making all intervals randomly
            heapInterval[i].setStart((int) ((Math.random() * (end - start)) + start));
            heapInterval[i].setFinish((int) ((Math.random() * (end - heapInterval[i].getStart())) + heapInterval[i].getStart() + 1));
            heapInterval[i].setNumberInterval(i);
        }
        System.out.println("\n-~-~-~-~-~-~-~-~Initial-~Intervals-~-~-~-~-~-~-~-~");
        for (Interval hi1 : heapInterval) {
            System.out.println(hi1);
        }
        return heapInterval;
    }
}
