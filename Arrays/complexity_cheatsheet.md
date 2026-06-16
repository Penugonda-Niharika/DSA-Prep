# Arrays — Time & Space Complexity Cheatsheet (C++)

## Static Array — `int arr[n]`

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| Access by index | O(1) | Direct memory address calculation |
| Search (unsorted) | O(n) | Linear scan |
| Search (sorted) | O(log n) | Binary search |
| Insert at end | O(1) | If space exists |
| Insert at middle/start | O(n) | Elements must shift right |
| Delete at end | O(1) | Just decrement size |
| Delete at middle/start | O(n) | Elements must shift left |
| Traverse | O(n) | Visit every element once |

## Dynamic Array — `std::vector<int>`

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| `push_back()` | O(1) amortized | Doubles capacity on overflow |
| `pop_back()` | O(1) | No shifting needed |
| `insert()` at index | O(n) | Shifts elements |
| `erase()` at index | O(n) | Shifts elements |
| `operator[]` | O(1) | No bounds check |
| `at()` | O(1) | With bounds check |
| `size()` | O(1) | Stored internally |

## Space Complexity
- Static array of n elements → **O(n)**
- Auxiliary space for most array algorithms → **O(1)** (in-place)
- Algorithms using extra array (e.g. prefix sum, merge sort) → **O(n)**

## Key Insight
> Accessing any index is O(1) because arrays are stored in **contiguous memory**.
> Address of `arr[i]` = Base Address + (i × size of data type)

## Quick C++ Snippet

```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<int> v = {10, 20, 30, 40, 50};

    // O(1) access
    cout << v[2] << "\n";          // 30

    // O(1) amortized insert at end
    v.push_back(60);

    // O(n) insert at beginning
    v.insert(v.begin(), 5);

    // O(n) traversal
    for (int x : v) cout << x << " ";

    return 0;
}
```

## Common Mistakes
- Using `v.size() - 1` when `v` is empty → **unsigned integer underflow** (wraps to huge number)
- Forgetting that `insert()` and `erase()` are O(n), not O(1)
- Assuming `vector` is always better — raw arrays have less overhead for fixed-size problems
