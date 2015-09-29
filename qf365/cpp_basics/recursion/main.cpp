/*
RECURSION
9/29/15
Josh Gribbon
QF 365
*/

#include <iostream>
#include <string>
using namespace std;

unsigned long fac(unsigned long);

int main(){
    cout << fac(5) << endl;
    cout << fac(2) << endl;
    cout << fac(15) << endl;
    return 0;
}

unsigned long fac(unsigned long n){
    //Given an integer, returns the factorial of the number, or 0 for error
    if (n==1)
        return 1;
    else
        return n * fac(n-1);
};
