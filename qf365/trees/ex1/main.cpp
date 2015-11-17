#include <iostream>
#include <string>
using namespace std;

int heapArr[16] = {0};
bool rooted = false;

void myReheap(int i){
    //if i>parent, swap and recurse
    int swap;
    int j;
    //cout << "Reheaping" << endl;
    if(i%2 == 1){
        j = i-1;
    }else{
        j = i;
    }
    if(heapArr[i] > heapArr[j/2]){
        swap = heapArr[i];
        heapArr[i] = heapArr[j/2];
        heapArr[j/2] = swap;
        myReheap(j/2);
    }
}

bool addVal(int n){
    if(!rooted){
        heapArr[0] = n;
        rooted = true;
        cout << "rooted with " << heapArr[0] << endl;
        return true;
    }else{
        for(int i=1;i<15;i++){
            if(heapArr[i] == 0){
                heapArr[i] = n;
                cout << "Added " << n << " to index " << i << endl;
                myReheap(i);
                return true;
            }
        }
    }
    cout << "Error adding value:" << n << endl;
    return false;
}

string printHeap(){
    for(int i=0;i<15;i++){
        cout << heapArr[i] << " ";
    }
}

int main(){
    addVal(4);
    addVal(2);
    addVal(7);
    addVal(8);
    addVal(9);
    addVal(12);
    addVal(45);
    addVal(23);
    addVal(41);
    addVal(31);
    addVal(71);
    addVal(81);
    addVal(91);
    addVal(121);
    addVal(451);
    addVal(231);
    printHeap();
    return 0;
}
