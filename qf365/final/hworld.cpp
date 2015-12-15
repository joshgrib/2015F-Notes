#include <iostream>
using namespace std;

int main(){
    for(int i=100; i>0; i--){
        if(i == 50)
            cout << "Hello world!" << endl;
        else
            cout << i << endl;
    }
    return 0;
}
