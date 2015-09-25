#include <iostream>
#include <string>
#include "MyOption.h"
#include "MyOption.cpp"
using namespace std;

int main(){
    MyOption op1(1000, 2000);
    cout << "Strike is:" << op1.getStrike() << endl;
    op1.setStrike(2100);
    cout << "Strike is:" << op1.getStrike() << endl;
    cout << "Put:  " << op1.put() << endl;
    cout << "Call: " << op1.call() << endl;
    op1.choose();
    return 0;
}

/* Terminal output
    ---
    New option created!
    Strike:1000
    Underlying:2000
    ---
    Strike is:1000
    Strike is now:2100
    Put:  Out of the money
    Call: In the money
    Would you like to put(p) or call(c)?
    b
    Sorry choice not recognized. Try again.
    Would you like to put(p) or call(c)?
    P
    Out of the money
*/
