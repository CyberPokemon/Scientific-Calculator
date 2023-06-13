package com.example.scientificcalculatorcyberpokemon;

public class stack_String {
    String arr[];
    int size,top;
    stack_String(int n)
    {
        size = n;
        arr=new String[n];
        top=-1;
    }
    void push(String item)
    {
        if(top==size-1)//overflow
            System.out.println("overflow");
        else
            arr[++top]=item;
    }
    String pop()
    {
        if(top==-1)//underflow
            return "-1";
        else
            return arr[top--];
    }
    String peek()
    {
        if(top==-1)
            return "-1";
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
