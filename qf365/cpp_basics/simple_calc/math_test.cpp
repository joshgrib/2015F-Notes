#include <iostream>
#include <string>
using namespace std;

double num1 = 0;
double num2 = 0;
int choice = 0;
double ans = 0;

int main()
{
    cout << "Enter two numbers:" << endl;
    cin >> num1;
    cin >> num2;
    cout << "What would you like to do with them?\n1 - Add\n2 - Subtract\n3 - Multiply\n4 - Divide" << endl;
    cin >> choice;
    switch(choice)
    {
        case 1:
            ans = (num1 + num2);
            break;
        case 2:
            ans = (num1 - num2);
            break;
        case 3:
            ans = (num1 * num2);
            break;
        case 4:
            ans = (num1 / num2);
            break;
        default:
            cout << "Choice not recognized" <<endl;
            break;
    };
    cout << "Answer: " << ans << endl;
    return 0;
}
