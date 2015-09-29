/*
Container classes
9/29/15
Josh Gribbon
QF 365
*/

#include <iostream>
#include <string>
#include "bag1.h"
#include "bag1.cpp"
using namespace std;


int main(){
    bag myB(10);
    myB.insert(3);

    cout << "Size:" << myB.get_size() << endl;

    return 0;
}
