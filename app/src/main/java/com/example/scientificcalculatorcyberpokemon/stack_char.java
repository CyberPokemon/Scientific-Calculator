package com.example.scientificcalculatorcyberpokemon;

public class stack_char {
    char arr[];
    int size,top;
    stack_char(int n)
    {
        size = n;
        arr=new char[n];
        top=-1;
    }
    void push(char item)
    {
        if(top==size-1)//overflow
            System.out.println("overflow char array");
        else
            arr[++top]=item;
    }
    char pop()
    {
        if(top==-1)//underflow
        {return ' ';}
        else
            return arr[top--];
    }
    char peek()
    {
        if(top==-1)
            return ' ';
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
