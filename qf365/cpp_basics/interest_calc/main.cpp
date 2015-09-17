#include <iostream>
#include <string>
#include <iomanip>
#include <cmath>
using namespace std;

int t; //years
double r; //interest rate
double p; //principal

int COMPOUNDED = 1;

int main()
{
    cout << "Enter # of yrs:";
    cin >> t;
    cout << "Enter interest rate(out of 1):";
    cin >> r;
    cout << "Enter principal:";
    cin >> p;
    for(int i;i<=t;i++){
        cout << p*pow((1+(r/COMPOUNDED)), COMPOUNDED*i) << endl;
    }
}
