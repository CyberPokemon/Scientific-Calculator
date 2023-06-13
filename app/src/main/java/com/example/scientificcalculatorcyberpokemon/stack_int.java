package com.example.scientificcalculatorcyberpokemon;

public class stack_int {
    int arr[], size,top;
    stack_int(int n)
    {
        size = n;
        arr=new int[n];
        top=-1;
    }
    void push(int item)
    {
        if(top==size-1)//overflow
            System.out.println("overflow");
        else
            arr[++top]=item;
    }
    int pop()
    {
        if(top==-1)//underflow
            return top;
        else
            return arr[top--];
    }
    int peek()
    {
        if(top==-1)
            return top;
        else
            return arr[top];
    }
    boolean isFull()
    {
        return (top==size-1);
    }
    boolean isEmpty()
    {
        return (top==-1);
    }
}
