#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

class MyOption
{
public: //access specifier
    MyOption() //class constructor
    {
        cout << "MyOption object created" << endl;
    }
    void optionParams(string optionType, double theStrike, double theUnderlying)
    {
        if(optionType == "Put")
        {
            if(theStrike == theUnderlying)
            {
                cout << "At the money" << endl;
            }
            else if(theStrike < theUnderlying)
            {
                cout << "In the money" << endl;
            }
            else
            {
                cout << "Out of the money" << endl;
            }
        }
        else if(optionType == "Call")
        {
            if(theStrike == theUnderlying)
            {
                cout << "At the money" << endl;
            }
            else if(theStrike > theUnderlying)
            {
                cout << "In the money" << endl;
            }
            else
            {
                cout << "Out of the money" << endl;
            }
        }
        else
        {
            cout << "Option type not recognized" << endl;
        }
    }
    void openBook(string courseName) const //const means it doesn't modify the class
    {
        cout << "Welcome to the grade book for: " << courseName << "!" << endl;
    }
};

int main()
{
    MyOption myOpt;
    myOpt.optionParams("Put", 2000, 1900);
    myOpt.optionParams("Put", 2000, 2000);
    myOpt.optionParams("Put", 2000, 2100);
    myOpt.optionParams("Call", 2000, 1900);
    myOpt.optionParams("Call", 2000, 2000);
    myOpt.optionParams("Call", 2000, 2100);
    cin.get(); //linux equivalent of system("pause");
    return 0;
}
