# Two Pointer Technique

## What is it?
A pattern where two index pointers traverse a data structure (usually a sorted array) from different positions — often one from the start and one from the end — to solve problems in **O(n)** instead of **O(n²)**.

## When to Use It
- Array or string is **sorted** (or can be sorted)
- Problem involves finding a **pair**, **triplet**, or **subarray** matching a condition
- Keywords: "pair with sum", "remove duplicates", "palindrome check", "merge two sorted arrays"

## Classic Problem: Pair with Target Sum

**Problem:** Given a sorted array, find if there exists a pair whose sum equals a target value.

### ❌ Brute Force — O(n²)

```cpp
bool hasPairBruteForce(vector<int>& arr, int target) {
    int n = arr.size();
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] + arr[j] == target) return true;
        }
    }
    return false;
}
```

### ✅ Two Pointer — O(n)

```cpp
bool hasPairTwoPointer(vector<int>& arr, int target) {
    int left = 0, right = arr.size() - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) return true;
        else if (sum < target) left++;   // need a bigger sum
        else right--;                    // need a smaller sum
    }
    return false;
}
```

## Why It Works
Since the array is sorted:
- If the current sum is **too small**, moving `left` forward only increases the sum
- If the current sum is **too large**, moving `right` backward only decreases the sum
- This guarantees we never need to recheck a pair — each pointer moves at most `n` times total

## Complexity Comparison

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n²) | O(1) |
| Two Pointer | O(n) | O(1) |

## Common Variations of This Pattern
- **Remove duplicates from sorted array** (slow/fast pointer)
- **Reverse a string/array in-place** (start/end pointer)
- **Container with most water**
- **3Sum problem** (fix one element, two-pointer on the rest)
- **Valid palindrome check**

## Mistake to Avoid
Using two pointers on an **unsorted array** without sorting first — the logic only works because of the sorted order. Sorting costs O(n log n), so factor that into total complexity if the array isn't already sorted.
