package com.example.scientificcalculatorcyberpokemon;

public class stack_long {
    long arr[], size,top;
    stack_long(int n)
    {
        size = n;
        arr=new long[n];
        top=-1;
    }
    void push(long item)
    {
        if(top==size-1)//overflow
            System.out.println("overflow");
        else
            arr[(int)++top]=item;
    }
    long pop()
    {
        if(top==-1)//underflow
            return top;
        else
            return arr[(int)top--];
    }
    long peek()
    {
        if(top==-1)
            return top;
        else
            return arr[(int)top];
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
