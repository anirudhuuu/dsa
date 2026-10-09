# Stacks

A stack is a data structure that supports a subset of the operations available
in a dynamic array. Elements can only be added and removed from one end of the
array, referred to as the **top of the stack**.

In the physical world, a stack can be visualized as a stack of plates. You may
add or remove a plate from the top, but you cannot add or remove one from the
middle. The stack data structure works the same way.

Stacks operate using **LIFO (Last In, First Out)**: the last element added to
the stack is the first element removed. The three primary stack operations are
`push`, `pop`, and `peek` (also called `top`).

In many languages there is no built-in stack data structure, but a dynamic
array can be used to simulate one.

## Push

The **push** operation adds an element to the top of the stack. In dynamic
array terms, this means appending an element to the end. This is an efficient
`O(1)` operation.

It helps to visualize a stack as a vertical array. When elements are added,
the top points to the last item inserted.

```java
// Using the append operation from dynamic arrays to add to the stack.
public void push(int n) {
    stack.add(n);
}
```

![Adding elements to the top of a stack](https://imagedelivery.net/CLfkmk9Wzy8_9HRyug4EVA/0e9488cb-496d-4e28-f395-83ae1f02c300/sharpen=1)

Since a stack removes elements in the reverse order in which they were
inserted, it can be used to reverse sequences, such as strings.

## Pop

The **pop** operation removes and returns the top element of the stack. In
dynamic array terms, this means reading and removing the last element. This is
also an efficient `O(1)` operation.

```java
public int pop() {
    return stack.remove(stack.size() - 1);
}
```

![Removing the top element from a stack](https://imagedelivery.net/CLfkmk9Wzy8_9HRyug4EVA/a4640d1e-c45e-4c36-7b3f-ae7e43cce000/sharpen=1)

Before popping, check whether the stack is empty to avoid an error.

## Peek / Top

The **peek** operation returns the top element without removing it. It is also
called `top` and runs in `O(1)` time.

```java
public int peek() {
    return stack.get(stack.size() - 1);
}
```

The stack must contain at least one element before calling `peek` or `top`.

## Example Implementation

```java
class Stack {
    ArrayList<Integer> stack = new ArrayList<>();

    public Stack() {
    }

    void push(int n) {
        stack.add(n);
    }

    int pop() {
        return stack.remove(stack.size() - 1);
    }

    int top() {
        return stack.get(stack.size() - 1);
    }

    int size() {
        return stack.size();
    }
}
```

## Time Complexity

| Operation  | Big-O Time Complexity | Notes                                          |
| ---------- | --------------------- | ---------------------------------------------- |
| Push       | `O(1)`                | Adds to the top of the stack.                  |
| Pop        | `O(1)`                | Check whether the stack is empty first.        |
| Peek / Top | `O(1)`                | Retrieves the top element without removing it. |
