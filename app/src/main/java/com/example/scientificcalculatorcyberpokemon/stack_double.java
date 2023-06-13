package com.example.scientificcalculatorcyberpokemon;

public class stack_double {
    double arr[];
    int size,top;
    stack_double(int n)
    {
        size = n;
        arr=new double[n];
        top=-1;
    }
    void push(double item)
    {
        if(top==size-1)//overflow
            System.out.println("overflow");
        else
            arr[++top]=item;
    }
    double pop()
    {
        if(top==-1)//underflow
            return top;
        else
            return arr[top--];
    }
    double peek()
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
