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
    double mv = 5.4;
    double *ptr = &mv;

    cout << mv << endl;    //5.4
    cout << ptr << endl;   //0x7ffd6caca8b8
    cout << *ptr << endl;   //5.4
    //the asterisk dereferences the pointer and returns the value

    return 0;
}
