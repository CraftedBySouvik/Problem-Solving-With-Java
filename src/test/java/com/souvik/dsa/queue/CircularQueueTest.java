package com.souvik.dsa.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircularQueueTest {

    @Test
    void shouldAddElement(){

        CircularQueue queue = new CircularQueue(5);
        int prevSize = queue.size();
        queue.enqueue(5);
        assertEquals(queue.size(), prevSize + 1);
    }
    @Test
    void shouldRemoveElement() {
        CircularQueue queue = new CircularQueue(5);
        int prevSize = queue.size();
        queue.dequeue();
        if(prevSize == 0){
            assertEquals(queue.size(), prevSize);
        }
        else{
            assertEquals(queue.size(), prevSize - 1);
        }
    }

    @Test
    void shouldMaintainFifo(){
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.dequeue(), 3);
        assertEquals(queue.dequeue(), -1);
    }

    @Test
    void shouldPrintElementsWithToString() {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals("[1,2,3]",queue.toString());
        queue.dequeue();
        queue.dequeue();
        assertEquals("[3]", queue.toString());
        queue.dequeue();
        assertEquals("[]",queue.toString());
    }

}
