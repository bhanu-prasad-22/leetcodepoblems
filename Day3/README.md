⭐ PART 1 — LINKEDLIST 
What is LinkedList?

A sequential list where each element points to the next.

Pros:

Fast insertion at start or middle → O(1)

No resizing cost

Perfect for implementing queues/stacks

Cons:

Slow access → O(n)

More memory (pointers)

In Java:
LinkedList<Integer> list = new LinkedList<>();
list.add(10);
list.addFirst(5);
list.addLast(20);
list.removeFirst();
list.removeLast();

⭐ PART 2 — STACK 
What is Stack?

LIFO = Last In First Out

Operations:

push()

pop()

peek()

Example:

Stack<Integer> st = new Stack<>();
st.push(10);
st.push(20);
st.pop();   // 20

Stack is used for:

Reverse sequences

Parentheses problems

DFS

Undo/Redo

Recursion simulation

⭐ PART 3 — QUEUE 
Queue = FIFO

First In First Out

Java:
Queue<Integer> q = new LinkedList<>();
q.add(10);
q.add(20);
q.remove();   // removes 10
q.peek();     // front element


Used in:

BFS

Producer-consumer

Thread jobs

Task scheduling

⭐ PART 4 — DEQUE 
Deque = Double-ended queue

Insert/remove from both ends

Java:
Deque<Integer> dq = new ArrayDeque<>();
dq.addFirst(10);
dq.addLast(20);
dq.removeFirst();
dq.removeLast();


Used in:

Sliding window maximum

LRU Cache

Advanced queue problems

📝 PART 5 — MINI EXERCISES 

Choose ANY ONE to code:

✔️ Exercise A:

Create a Stack and reverse a string:
Input: "bhanu"
Output: "unahb"

✔️ Exercise B:

Create a Queue and print elements in FIFO order.

✔️ Exercise C:

Use Deque to add numbers at both ends and print final structure.

✔️ Exercise D:

Use LinkedList to:

add 5 values

remove first

remove last

print list


solution:

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;


class Exercise
{
    public static void main(String[] args) {
        Stack<Character> st=new Stack<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String s=sc.nextLine();

        for(int i=0;i<s.length();i++)
        {
             st.push(s.charAt(i));
        }
        while(!st.isEmpty())
        {
            System.out.print(st.pop());
        }
        System.out.println();

        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(10);
        dq.addFirst(1);
        dq.addLast(20);
        dq.addLast(2);
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq);
    }
}
