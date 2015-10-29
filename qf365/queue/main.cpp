#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main(){
    queue<string> myQ;
    myQ.push("D");
    myQ.push("E");
    myQ.push("S");
    myQ.push("S");
    myQ.push("E");
    myQ.push("R");
    myQ.push("T");
    myQ.push("S");

    cout << myQ.front() << endl;
    myQ.pop();
    cout << myQ.front() << endl;
    myQ.pop();
    cout << myQ.front() << endl;
    myQ.pop();
    cout << myQ.front() << endl;
    myQ.pop();
    cout << myQ.front() << endl;
    myQ.pop();
    cout << myQ.front() << endl;
    myQ.pop();
    cout << myQ.front() << endl;
    myQ.pop();
    cout << myQ.front() << endl;
    myQ.pop();
    return 0;
}
