#include <iostream>
#include <string>
using namespace std;

void numList()
{
    for(int i=0; i<100; i++){
        if(i == 49){
            cout << "Midway point of loop" << endl;
        }
        if((i>49) && (i<99)){
            cout << i << endl;
        }
        if(i==99){
            cout << "Final count reach of: " << i << endl;
        }
    }
}

void gradeCalc(){
    double input;
    for(int i=0;i<10;i++){
        cout << "Enter a grade:";

    }
}

int total;
int gradeCounter;
double average = static_cast<double>(total)/gradeCounter; //temp float copy for higher precision

int main(){
    numList();
    return 0;
}
