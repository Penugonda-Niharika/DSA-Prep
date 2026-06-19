# Binary Search Pattern

## What is it?
A search algorithm that works on **sorted arrays** by repeatedly halving the search space. Instead of checking every element (O(n)), it eliminates half the remaining elements each step — giving O(log n) time.

## Core Idea
```
If target == mid → found
If target < mid  → search left half
If target > mid  → search right half
```

## Standard Implementation

### ✅ Iterative (Preferred in Interviews)

```cpp
int binarySearch(vector<int>& arr, int target) {
    int left = 0, right = arr.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;  // safe mid — avoids overflow

        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;  // not found
}
```

### ✅ Recursive

```cpp
int binarySearchRecursive(vector<int>& arr, int target, int left, int right) {
    if (left > right) return -1;

    int mid = left + (right - left) / 2;

    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, right);
    else return binarySearchRecursive(arr, target, left, mid - 1);
}
```

## Complexity

| Approach | Time | Space |
|----------|------|-------|
| Iterative | O(log n) | O(1) |
| Recursive | O(log n) | O(log n) — call stack |

> Iterative is preferred in interviews — no stack overflow risk, less space used.

## Common Variations

### 1. Find First Occurrence (Lower Bound)
```cpp
int firstOccurrence(vector<int>& arr, int target) {
    int left = 0, right = arr.size() - 1, result = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            result = mid;
            right = mid - 1;  // keep searching left
        }
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return result;
}
```

### 2. Find Last Occurrence (Upper Bound)
```cpp
int lastOccurrence(vector<int>& arr, int target) {
    int left = 0, right = arr.size() - 1, result = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            result = mid;
            left = mid + 1;   // keep searching right
        }
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return result;
}
```

### 3. Search in Rotated Sorted Array
```cpp
int searchRotated(vector<int>& arr, int target) {
    int left = 0, right = arr.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;

        // left half is sorted
        if (arr[left] <= arr[mid]) {
            if (target >= arr[left] && target < arr[mid]) right = mid - 1;
            else left = mid + 1;
        }
        // right half is sorted
        else {
            if (target > arr[mid] && target <= arr[right]) left = mid + 1;
            else right = mid - 1;
        }
    }
    return -1;
}
```

## When to Use Binary Search
| Signal in Problem | Apply Binary Search On |
|-------------------|----------------------|
| Sorted array, find element | Direct binary search |
| "Find first/last position" | Lower/upper bound variation |
| "Find minimum in rotated array" | Modified binary search |
| "Find peak element" | Binary search on answer |
| "Minimum/maximum possible value" | Binary search on answer space |

## The Most Common Bug
```cpp
// ❌ WRONG — causes integer overflow for large arrays
int mid = (left + right) / 2;

// ✅ CORRECT — always safe
int mid = left + (right - left) / 2;
```
When `left` and `right` are both large integers, their sum can exceed `INT_MAX` (2,147,483,647), silently wrapping to a negative number. The safe formula avoids this entirely.

## Mistake to Avoid
Using `while (left < right)` instead of `while (left <= right)` — this misses checking the last remaining single element, causing incorrect "not found" results on valid targets.
