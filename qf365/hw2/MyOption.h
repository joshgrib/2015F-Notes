#include <iostream>
#include <string>
using namespace std;

class MyOption{
public:
    explicit MyOption(double, double);
    void setStrike(double);
    double getStrike() const;
    void setUnderlying(double);
    double getUnderlying() const;
    string put() const;
    string call() const;
    void choose();
private:
    bool checkValue(double) const;
    void validate(double, double);
    double strike;
    double underlying;
};
