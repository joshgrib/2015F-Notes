#include <iostream>
#include <string>
#include "MyOption.h"
#include "MyOption.cpp"
using namespace std;

int main(){
    MyOption op1(1000, 2000);
    cout << "Strike is:" << op1.getStrike() << endl;
    op1.setStrike(2100);
    cout << "Strike is now:" << op1.getStrike() << endl;
    cout << "Put:  " << op1.put() << endl;
    cout << "Call: " << op1.call() << endl;
    //op1.choose();
    return 0;
}
