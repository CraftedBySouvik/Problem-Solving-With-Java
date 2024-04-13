package com.souvik.dsa.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class CircularQueue {

    private int head, tail, capacity;
    private int[] container;


    public CircularQueue(int capacity) {
        this.capacity= capacity;
        this.container = new int[capacity];
        log.info("{}",this.container.length);
        this.head=0;
        this.tail=0;

    }

    public boolean enqueue(int element){
        // check if capacity is full
        if((tail+1)%capacity == head) return false;

        container[tail++]= element;
        return true;
    }

    public int dequeue(){
        // check if empty
        if(head==tail) return -1;

        return container[head++];
    }

    public int size(){
        if(tail >= head) return tail-head;
        else return tail-1+ capacity - head;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(tail >= head){
            for(int i=head; i< tail;i++) {
                sb.append(container[i]);
                if(i != tail-1) sb.append(",");
            }
        }
        else{
            for(int i=head; i< capacity;i++) {
                sb.append(container[i]);
                sb.append(",");
            }
            for(int i=0;i<tail;i++){
                sb.append(container[i]);
                if(i!=tail-1) sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
