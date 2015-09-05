#include <iostream>
#include <string>
using namespace std;

int num = 0;
double inputNum = 0;
double maxNum = -9999999999999;
double minNum = 9999999999999;

int main()
{
    cout << "Input a number:" << endl;
    cin >> num;
    if (num%2 == 0){
        cout << "Even" << endl;
    }
    else{
        cout << "Odd" << endl;
    }
    while(1){
        cout << "Enter numbers, -1 to stop" << endl;
        cin >> inputNum;
        if(inputNum < minNum)
        {
            minNum = inputNum;
        }
        if(inputNum > maxNum)
        {
            maxNum = inputNum;
        }
        if(inputNum == -1)
        {
            cout << "Max:" << maxNum << endl;
            cout << "Min:" << minNum << endl;
            break;
        }
    }
    return 0;
}
