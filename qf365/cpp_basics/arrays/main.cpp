#include <iostream>
#include <string>
#include <cmath>
#include <cstdlib>
using namespace std;

int main(){
    double myArr[391][3];
    for(int i=0; i<391; i++){
        //counter
        myArr[i][0] = i;

        //random int
        myArr[i][1] = (rand()%100); //somewhat random int between 0 and 100

        //sum of previous random ints
        int sum = 0;
        for(int j=0; j<i; j++){
            sum += myArr[j][1];
        }
        myArr[i][2] = sum;
    }

    for(int i=0; i<391; i++){
        cout << "----------------" << endl;
        cout << myArr[i][0] << " | ";
        cout << myArr[i][1] << " | ";
        cout << myArr[i][2] << endl;
    }

    return 0;
}
