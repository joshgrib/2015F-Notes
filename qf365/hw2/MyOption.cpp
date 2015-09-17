#include <iostream>
#include <string>
#define Included_MyOption_H
using namespace std;

//check that numbers are greater than 0
bool MyOption::checkValue(double value)
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
double MyOption::getStrike(){
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
double MyOption::getUnderlying(){
    return underlying;
}

//put logic
string MyOption::put(){
    if(strike == underlying){
        cout << "At the money" << endl;
    }
    else if(strike < underlying){
        cout << "In the money" << endl;
    }
    else{
        cout << "Out of the money" << endl;
    }
}

//call logic
string MyOption::call(){
    if(strike == underlying){
        cout << "At the money" << endl;
    }
    else if(strike > underlying){
        cout << "In the money" << endl;
    }
    else{
        cout << "Out of the money" << endl;
    }
}

//prompt choice of put or call
string MyOption::choose(){
    cout << "---\nStrike    :" << strike << "\nUnderlying:" << underlying << endl;
    cout << "Do you want to put or call?(p/c)" << endl;
    cin >> choice;
    if(choice == "p"){
        put();
    }
    else if(choice == "c"){
        call();
    }
    else{
        cout << "Choice not recognized. Please only enter \"p\" or \"c\". Try again..." << endl;
        choose();
    }
}
