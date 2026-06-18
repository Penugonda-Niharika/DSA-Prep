# Sliding Window Technique

## What is it?
A technique where you maintain a "window" (a contiguous subarray/substring) that expands or shrinks over the data, avoiding recomputation from scratch — turning many O(n²) or O(n³) brute-force problems into O(n).

## When to Use It
- Problem involves a **contiguous subarray or substring**
- Keywords: "maximum/minimum subarray of size k", "longest substring with condition", "smallest window containing X"
- You're recalculating a sum/count for every shifting range — that recalculation is the inefficiency this pattern removes

## Two Types

| Type | Use Case |
|------|----------|
| Fixed-size window | Window size `k` is given upfront |
| Variable-size window | Window grows/shrinks based on a condition |

## Classic Problem: Maximum Sum Subarray of Size K

**Problem:** Given an array, find the maximum sum of any contiguous subarray of size `k`.

### ❌ Brute Force — O(n × k)

```cpp
int maxSumBruteForce(vector<int>& arr, int k) {
    int n = arr.size();
    int maxSum = INT_MIN;

    for (int i = 0; i <= n - k; i++) {
        int windowSum = 0;
        for (int j = i; j < i + k; j++) {
            windowSum += arr[j];
        }
        maxSum = max(maxSum, windowSum);
    }
    return maxSum;
}
```

### ✅ Sliding Window — O(n)

```cpp
int maxSumSlidingWindow(vector<int>& arr, int k) {
    int n = arr.size();
    int windowSum = 0, maxSum = INT_MIN;

    for (int i = 0; i < n; i++) {
        windowSum += arr[i];                 // add new element

        if (i >= k - 1) {
            maxSum = max(maxSum, windowSum);
            windowSum -= arr[i - (k - 1)];   // remove leftmost element of window
        }
    }
    return maxSum;
}
```

## Why It Works
Instead of recalculating the sum of every new window from scratch, we **slide** the window by one position: add the new element entering the window, subtract the old element leaving it. Each element is processed once → O(n).

## Complexity Comparison

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n × k) | O(1) |
| Sliding Window | O(n) | O(1) |

## Common Variations of This Pattern
- **Longest substring without repeating characters** (variable window + hash set)
- **Smallest subarray with sum ≥ target** (variable window)
- **Longest substring with at most K distinct characters**
- **Maximum of all subarrays of size k** (uses deque, not just two pointers)

## Sliding Window vs Two Pointer — What's the Difference?
They look similar but solve different shapes of problems:

| | Two Pointer | Sliding Window |
|---|---|---|
| Goal | Find a pair/specific elements | Track a contiguous range/subarray |
| Movement | Pointers can jump independently | Window grows/shrinks contiguously |
| Example | Pair sum in sorted array | Max sum subarray of size k |

## Mistake to Avoid
Forgetting to subtract the **outgoing element** when the window slides forward — this is the most common bug, and it silently gives wrong sums instead of crashing, making it hard to catch.
