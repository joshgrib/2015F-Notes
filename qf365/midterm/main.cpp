#include <iostream>
#include <string>
using namespace std;

int main(){
    for(int i=0; i<10; i++)
        cout << "Hello World" << endl;
    string myArr[5] = {"I", "UNDERSTAND","HOW","TO","CODE"};
    for(int j=0; j<5; j++)
        cout << myArr[j] << endl;
    return 0;
}
