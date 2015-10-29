#include <iostream>
#include <string>
#include <queue>
#include <l
using namespace std;

int main(){
    queue<string> myQ;
    myQ.push("Troy");
    myQ.push("Kevin");
    myQ.push("Otis");
    myQ.push("Raba");
    myQ.push("Lindsey");

    while(!myQ.empty()){
        cout << myQ.front() << endl;
        myQ.pop();
    }

    return 0;
}
