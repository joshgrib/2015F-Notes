#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib> //for system()

using namespace std;

bool CLEAR_DATA = false;

int main(){
    //system("mkdir ./data");
    cout << "Running..." << endl;
    cout << "Putting data in csv files..." << endl;
    system("python run.py");
    cout << "Done." << endl;
    if(CLEAR_DATA){
        system("rm -r data/*");
    }
    return 0;
}
