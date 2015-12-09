//look up vector slicing for final
#include <iostream>
using namespace std;

int bsearch(int[], int, int, int);

int main(){
    int sortedArr[16] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    cout << bsearch(sortedArr, 5, 0, 15) << endl;
    cout << bsearch(sortedArr, 14, 0, 15) << endl;
    cout << bsearch(sortedArr, 18, 0, 15) << endl;
    return 0;
}

int bsearch(int A[], int key, int min, int max){
    if (max < min){
        cout << "Not found." << endl;
        return -1;
    }else{
        int mid = min + ((max-min)/2);
        if (A[mid] > key){
            cout << "Slicing, using the first half" << endl;
            return bsearch(A, key, min, mid - 1);
        }else if (A[mid] < key){
            cout << "Slicing, using the second half" << endl;
            return bsearch(A, key, mid + 1, max);
        }else{
            cout << "Found it!" << endl;
            return mid;
        }
    }
}
