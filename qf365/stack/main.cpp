#include <stack>
#include <iostream>
#include <string>
using namespace std;

int main(){
    stack<string> MyStack;

    string in = "desserts";
    /*cout << "Whats the word?" << endl;
    cin >> in;*/
    int inLen = in.length();
    string input[inLen];

    for(int i=0; i<inLen; i++)
        input[i] = in[/*inLen-1-*/i];

    int inputLength = (sizeof(input)/sizeof(*input));

    for(int i=0; i<inputLength; i++)
        MyStack.push(input[i]);

    cout << "Stack size: " << MyStack.size() << endl;

    for(int i=0; i<inputLength; i++){
        cout << MyStack.top() << endl;
        MyStack.pop();
    }

    cout << "Stack size: " << MyStack.size() << endl;

    return 0;
}
