#include <iostream>
#include <string>
#include "MyOption.h"
#include "MyOption.cpp"
using namespace std;

int main()
{
    MyOption op1(1000, 2000);
    cout << "Strike is:" << op1.getStrike() << endl;
    op1.setStrike(2100);
    op1.choose(); //prompts for p or c and cout's the result
    return 0;
}

/*
Make choice a set variable too
getter/setter method
return where you're at in relation to the money at any point
update "where" with every change!
    New strike price? Maybe you're out of the money now!
*/
