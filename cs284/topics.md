# CS284 - Data Structures
[Markdown syntax](https://help.github.com/articles/github-flavored-markdown/)
## Syllabus info
### Topics
+ Stages of software development
+ Testing
+ UML diagrams
+ Elementary data structures (lists, stacks, queues, and maps)
+ Use of elementary data structures in application frameworks (e.g., JFC-Java Foundation Classes)
+ Searching
+ Sorting
+ Introduction to asymptotic complexity analysis.

### Outcomes
+ [software-lifecycle] Explain the steps in different models of the Software lifecycle, and understand different design, testing and debugging techniques. Understand the importance of Abstract Data Types and Data Structures. Use UML to represent ADTs. [requirements]
+ [complexity] Learn about Big-O and calculate the Big O of diverse algorithms and use it to compare efficiency. [problem-solving]
+ [Collections] Use and understand the Collection class in Java, with major emphasis on Lists, Stacks and Queues. [software]
+ [Trees] Implement Binary Search Trees, Max/Min-Heaps, Priority Queues, and understand self-balancing Binary Search Trees such as Red-Black and AVL trees. [software]
+ [Sets-Maps] Understand what are Sets and Maps, and more specifically implement hash tables. [software]
+ [Sorting] Program sorting algorithms including bubble sort, insertion sort, selection sort, shell sort, quick sort, merge sort, heap sort. [software]
+ [Programming] Combine different classes to implement big programming assignments, including a final project that combines some of the data structures studied in class. [problem-solving]

## Notes

### Software development life cycle
+ Steps
    + Requirement gathering/ analysis
    + Design
    + Implementaion/coding
    + Testing
    + Deployment
    + Maintenance
+ Design, testing, debugging techniques
    + Black box - test things without access to code
    + White box  test by using the code
+ Importance of Abstract Data Types and Data Structures
+ UML to represent Abstract Data Types

### Complexities
+ What is Big-O and how is it calculated

| Big-O      | Name | Example |
|:----------:|:-----|:---------------|
| O(1)       | Constant | `print n` |
| O(logn)    | Logarithmic | Binary search - start in middle then keep splitting
| O(n)       | Linear | `for x in n: print n`
| O(nlog(n)) | nlong(n) | Merge sort and other "divide and conquer algorithms"
| O(n^2)     | Quadratic | Nested `for` loops, bubble sort
| O(2^n)     | Exponential | Finding the super set of a set
| O(n!)      | Factorial | Traveling salesman by brute-force, trying every path from each new node
(From fastest to slowest)

Any constants and less significant terms can be dropped

### Abstract data structures
| Data structure | Add      | Remove      | Description |
|:--------------:|:--------:|:-----------:|:------------|
| Linked List    | Anywhere | Anywhere    | Nodes have links to one or both neighbor nodes
| Stack          | To top   | From top    | Linked list, only the head can be accessed
| Queue          | To top   | From bottom | Linked list, only add to head and remove from tail

### Trees
+ Implement BSTs, Max/Min Heaps, Priority Queues
+ Understand self-balancing BSTs like Red-Black and AVL trees

### Set-Maps
+ Understand what sets and maps are, specifically how to implement hash-tables

### Sorting algorithms
| Algorithm     | [Worst case time complexity](http://bigocheatsheet.com/) | How it works |
|:-------------:|:-------------:|:-------------|
|Bubble sort    | O(n^2)        | Pass through the data from one end to the other, and swap two adjacent elements whenever the first is greater than the last.
|Insertion sort | O(n^2)        | With each iteration, it takes the next element waiting to be sorted, and adds it, in proper location, to those elements that have already been sorted.
|Selection sort | O(n^2)        | Continually find the smallest object and move it to the front, at the end of the sorted items
|Shell sort     | O(nlog(n)^2)  |
|Quick sort     | O(n^2), typically O(nlog(n))| First, divide the data into two groups of “high” values and “low” values. Then, recursively process the two halves. Finally, reassemble the now sorted list.
|Merge sort     | O(nlong(n))   | A merge sort works recursively. First it divides a data set in half, and sorts each half separately. Next, the first elements from each of the two lists are compared. The lesser element is then removed from its list and added to the final result list.
|Heap sort      | O(nlong(n))   | Put everything in a heap, then continuall remove the root node

```java
/*Bubble sort*/
for (int i = 0; i < data.Length; i++){}
    for (int j = 0; j < data.Length - 1; j++){}
        if (data[j] > data[j + 1])
        {
            tmp = data[j];
            data[j] = data[j + 1];
            data[j + 1] = tmp;
        }
   }
}
```

```java
/*Insertion sort*/
for (int i = 0; i <= data.Length; i++) {
    int j = i;
    while (j > 0 && data[i] < data[j - 1])
        j--;
    int tmp = data[i];
    for (int k = i; k > j; k--)
        data[k] = data[k - 1];
    data[j] = tmp;
}
```

```
/*Selection sort*/
for i = 1:n,
    k = i
    for j = i+1:n, if a[j] < a[k], k = j
    → invariant: a[k] smallest of a[i..n]
    swap a[i,k]
    → invariant: a[1..i] in final position
end

/*Shell sort*/
h = 1
while h < n, h = 3*h + 1
while h > 0,
    h = h / 3
    for k = 1:h, insertion sort a[k:h:n]
    → invariant: each h-sub-array is sorted
end
```

```java
/*Quick sort*/
Array quickSort(Array data) {
    if (Array.Length <= 1)
        return;
    middle = Array[Array.Length / 2];
    Array left = new Array();
    Array right = new Array();
    for (int i = 0; i < Array.Length; i++)
        if (i != Array.Length / 2) {
            if (Array[i] <= middle)
                left.Add(Array[i]);
            else
                right.Add(Array[i]);
        }
    return concatenate(quickSort(left), middle, quickSort(right));
}
```

```java
/*Merge sort*/
int[] mergeSort (int[] data) {
    if (data.Length == 1)
        return data;
    int middle = data.Length / 2;
    int[] left = mergeSort(subArray(data, 0, middle - 1));
    int[] right = mergeSort(subArray(data, middle, data.Length - 1));
    int[] result = new int[data.Length];
    int dPtr = 0;
    int lPtr = 0;
    int rPtr = 0;
    while (dPtr < data.Length) {
        if (lPtr == left.Length) {
            result[dPtr] = right[rPtr];
            rPtr++;         
        } else if (rPtr == right.Length) {
            result[dPtr] = left[lPtr];
            lPtr++;
        } else if (left[lPtr] < right[rPtr]) {
            result[dPtr] = left[lPtr];
            lPtr++;
        } else {
            result[dPtr] = right[rPtr];
            rPtr++;         
        }
        dPtr++;
    }
    return result;
}
```

```java
/*Heap sort*/
Heap h = new Heap();
for (int i = 0; i < data.Length; i++)
    h.Add(data[i]);
int[] result = new int[data.Length];
for (int i = 0; i < data.Length; i++)
    data[i] = h.RemoveLowest();
```

### Programming
+ Combine classes to implement big assignments, including a final project that combines data structures covered in class
