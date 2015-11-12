#include <iostream>
#include <fstream>
using namespace std;

int main(){
    ofstream myFile1;
    ofstream myFile2;
    myFile1.open("data1.csv");
    int MAX1 = 50000;
    for(int i=0;i<MAX1;i++){
        myFile1 << i;
        myFile1 << ",";
    }
    myFile1 << MAX1;
    myFile1.close();
    myFile2.open("data2.csv");
    int MAX2 = 100000;
    for(int i=MAX1+1;i<MAX2;i++){
        myFile2 << i;
        myFile2 << ",";
    }
    myFile2 << MAX2;
    myFile2.close();
    return 0;
}
