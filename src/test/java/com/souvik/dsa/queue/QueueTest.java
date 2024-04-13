package com.souvik.dsa.queue;

import org.junit.jupiter.api.Test;

import static  org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void shouldAddElement(){

        Queue<Integer> queue = new Queue<>();
        int prevSize = queue.size();
        queue.add(5);
        assertEquals(queue.size(), prevSize + 1);
    }
    @Test
    void shouldRemoveElement() {
        Queue<Integer> queue = new Queue<>();
        int prevSize = queue.size();
        queue.poll();
        if(prevSize == 0){
            assertEquals(queue.size(), prevSize);
        }
        else{
            assertEquals(queue.size(), prevSize - 1);
        }
    }

    @Test
    void shouldMaintainFifo(){
        Queue<String> queue = new Queue<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        assertEquals(queue.poll(), "first");
        assertEquals(queue.poll(), "second");
        assertEquals(queue.poll(), "third");
        assertEquals(queue.poll(), null);
    }

    @Test
    void shouldPrintElementsWithToString() {
        Queue<String> queue = new Queue<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        assertEquals("[first,second,third]",queue.toString());
        queue.poll();
        queue.poll();
        assertEquals("[third]", queue.toString());
        queue.poll();
        assertEquals("[]",queue.toString());
    }


}
