#include <iostream>
#include <string>
#define Included_MyOption_H
using namespace std;

bool MyOption::checkValue(double value) const{
    //check that numbers are greater than 0
    if(value>0){
        return true;
    }
    return false;
}
void MyOption::validate(double strike_maybe, double underlying_maybe){
    //ensure that strike and underlying are valid numbers
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
MyOption::MyOption(double strike_init, double underlying_init){
    //constructor
    validate(strike_init, underlying_init);
    cout << "---\nNew option created!\nStrike:" << strike << "\nUnderlying:" << underlying << "\n---" << endl;
}
void MyOption::setStrike(double new_strike){
    //strike setter
    if(checkValue(new_strike)){
        strike = new_strike;
    }
    else{
        cout << "Strike must be positive! Try again:";
        cin >> new_strike;
        setStrike(new_strike);
    }
}
double MyOption::getStrike() const{
    //strike getter
    return strike;
}
void MyOption::setUnderlying(double new_underlying){
    //underlying setter
    if(checkValue(new_underlying)){
        strike = new_underlying;
    }
    else{
        cout << "Strike must be positive! Try again:";
        cin >> new_underlying;
        setUnderlying(new_underlying);
    }
}
double MyOption::getUnderlying() const{
    //underlying getter
    return underlying;
}
string MyOption::put() const{
    //put logic
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
string MyOption::call() const{
    //call logic
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
void MyOption::choose(){
    //Ask if the user wants to put or call
    cout << "Would you like to put(p) or call(c)?" << endl;
    string choice;
    cin >> choice;
    if((choice == "p") || (choice == "P")){
        cout << put() << endl;
    }
    else if((choice == "c") || (choice == "C")){
        cout << call() << endl;
    }
    else{
        cout << "Sorry choice not recognized. Try again." << endl;
        choose();
    }
}
