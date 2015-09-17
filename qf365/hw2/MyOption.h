#include <iostream>
#include <string>
using namespace std;

class MyOption
{
public:
    explicit MyOption(double, double);
    void setStrike(double);
    double getStrike();
    void setUnderlying(double);
    double getUnderlying();
    string choose();

private:
    bool checkValue(double);
    void validate(double, double);
    string put();
    string call();
    double strike;
    double underlying;
    string choice;
};
