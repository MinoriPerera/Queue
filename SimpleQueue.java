/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructuresandalgorithms;

/**
 *
 * @author Asus
 */
    public class SimpleQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    // Constructor
    public SimpleQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // Insert method
    public void insert(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot insert " + value);
            return;
        }
        if (rear == maxSize - 1) { // wrap-around
            rear = -1;
        }
        queueArray[++rear] = value;
        nItems++;
    }

    // Remove method
    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot remove.");
            return -1;
        }
        int temp = queueArray[front++];
        if (front == maxSize) { // wrap-around
            front = 0;
        }
        nItems--;
        return temp;
    }

    // Peek method
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return queueArray[front];
    }

    // IsEmpty method
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // IsFull method
    public boolean isFull() {
        return (nItems == maxSize);
    }

    // Size method
    public int size() {
        return nItems;
    }

    // Main method to test the queue
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);

        System.out.println("Front element is: " + queue.peekFront()); // Output: 10
        System.out.println("Removed element is: " + queue.remove()); // Output: 10
        System.out.println("Front element after removal is: " + queue.peekFront()); // Output: 20

        queue.remove();
        queue.remove();
        queue.remove(); // Should indicate the queue is empty
    }
}

