#include <iostream>
#include <string>
#define Included_MyOption_H
using namespace std;

//check that numbers are greater than 0
bool MyOption::checkValue(double value) const
{
    if(value>0){
        return true;
    }
    return false;
}

//ensure that strike and underlying are valid numbers
void MyOption::validate(double strike_maybe, double underlying_maybe)
{
    if(checkValue(strike_maybe) && checkValue(underlying_maybe>0)){
        strike = strike_maybe;
        underlying = underlying_maybe;
    }
    else{
        cout << "Enter some new numbers, they can't be below 0!" << endl;
        double new_strike;
        cout << "New strike price:";
        cin >> new_strike;
        //double newer_strike = atof(new_strike);
        double new_underlying;
        cout << "New underlying price:";
        cin >> new_underlying;
        //double newer_underlying = atof(new_underlying);
        validate(new_strike, new_underlying);
    }
}

//constructor
MyOption::MyOption(double strike_init, double underlying_init) //constructor
{
    validate(strike_init, underlying_init);
    cout << "---\nNew option created!\nStrike:" << strike << "\nUnderlying:" << underlying << "\n---" << endl;
}

//strike setter
void MyOption::setStrike(double new_strike){
    if(checkValue(new_strike)){
        strike = new_strike;
    }
    else{
        cout << "Strike must be positive! Try again:";
        cin >> new_strike;
        setStrike(new_strike);
    }
}

//strike getter
double MyOption::getStrike() const{
    return strike;
}

//underlying setter
void MyOption::setUnderlying(double new_underlying){
    if(checkValue(new_underlying)){
        strike = new_underlying;
    }
    else{
        cout << "Strike must be positive! Try again:";
        cin >> new_underlying;
        setUnderlying(new_underlying);
    }
}

//underlying getter
double MyOption::getUnderlying() const{
    return underlying;
}

//put logic
string MyOption::put() const{
    if(strike == underlying){
        return "At the money";
    }
    else if(strike < underlying){
        return "In the money";
    }
    else{
        return "Out of the money";
    }
}

//call logic
string MyOption::call() const{
    if(strike == underlying){
        return "At the money";
    }
    else if(strike > underlying){
        return "In the money";
    }
    else{
        return "Out of the money";
    }
}
