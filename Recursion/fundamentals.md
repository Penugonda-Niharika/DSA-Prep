# Recursion Fundamentals

## What is it?
A function that **calls itself** to solve a smaller version of the same problem, until it reaches a **base case** that stops the recursion.

## Two Essential Parts
1. **Base Case** — the condition where recursion stops (prevents infinite loop)
2. **Recursive Case** — the function calling itself with a smaller/simpler input

## How it Works in Memory
Every recursive call is pushed onto the **call stack**. When the base case is hit, calls start returning and popping off the stack one by one.

```
factorial(4)
└── factorial(3)
    └── factorial(2)
        └── factorial(1)
            └── returns 1   ← base case
        └── returns 2
    └── returns 6
└── returns 24
```

## Classic Examples

### 1. Factorial
```cpp
int factorial(int n) {
    if (n <= 1) return 1;          // base case
    return n * factorial(n - 1);   // recursive case
}
```

### 2. Fibonacci
```cpp
int fibonacci(int n) {
    if (n <= 1) return n;                          // base case
    return fibonacci(n - 1) + fibonacci(n - 2);   // recursive case
}
// ⚠️ This is O(2^n) — very slow for large n
// Use memoization or iteration for better performance
```

### 3. Sum of Array
```cpp
int arraySum(vector<int>& arr, int index) {
    if (index == arr.size()) return 0;                  // base case
    return arr[index] + arraySum(arr, index + 1);       // recursive case
}
```

### 4. Reverse a String
```cpp
void reverseString(string& s, int left, int right) {
    if (left >= right) return;                  // base case
    swap(s[left], s[right]);                    // process
    reverseString(s, left + 1, right - 1);      // recursive case
}
```

### 5. Binary Search (Recursive)
```cpp
int binarySearch(vector<int>& arr, int target, int left, int right) {
    if (left > right) return -1;                // base case — not found
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;         // base case — found
    if (arr[mid] < target)
        return binarySearch(arr, target, mid + 1, right);
    return binarySearch(arr, target, left, mid - 1);
}
```

## Complexity Analysis

| Problem | Time | Space (Call Stack) |
|---------|------|--------------------|
| Factorial(n) | O(n) | O(n) |
| Fibonacci(n) | O(2^n) | O(n) |
| Array Sum | O(n) | O(n) |
| Binary Search | O(log n) | O(log n) |

> Space complexity of recursion is **never O(1)** — the call stack always uses memory proportional to the depth of recursion.

## Recursion vs Iteration

| | Recursion | Iteration |
|---|---|---|
| Readability | Cleaner for tree/graph problems | Cleaner for simple loops |
| Space | O(depth) — call stack overhead | O(1) usually |
| Risk | Stack overflow for deep recursion | No stack overflow |
| Best for | Trees, graphs, backtracking, divide & conquer | Arrays, simple repetition |

## Common Mistakes
- **Missing base case** → infinite recursion → stack overflow crash
- **Wrong base case condition** → off-by-one errors in results
- **Not reducing the problem** → recursive call with same input → infinite loop
- **Ignoring return value** → writing `fibonacci(n-1) + fibonacci(n-2)` but forgetting `return`

## Key Insight
> Every recursive solution can be converted to an iterative one using an explicit stack.
> Recursion just uses the **call stack** implicitly — that's the only real difference.
