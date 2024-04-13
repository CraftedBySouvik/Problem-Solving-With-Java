package com.souvik.dsa.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

    private List<T> container;
    private int head;

    public Queue() {
        container = new ArrayList<>();
        head = 0;
    }

    public int size(){
        return container.size() - head;
    }

    public boolean add(T element){
        try {
            container.add(element);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isEmpty(){
        return head == container.size();
    }

    public T poll(){
        if(isEmpty()) return null;
        else{
            head++;
            return container.get(head-1);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=head;i<container.size();i++){
            sb.append(container.get(i));
            if(i != container.size()-1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
