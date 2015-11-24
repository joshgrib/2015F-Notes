#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib> //for system()
#include <fstream>

using namespace std;

string djia[] = {"AAP","AXP","BA","CAT","CSCO","CVX","DD","DIS","GE","GS","HD","IBM","INTC","JNJ","JPM","KO","MCD","MMM","MRK","MSFT","NKE","PFE","PG","TRV","UNH","UTX","V","VZ","WMT","XOM"};

/*
void printClose(string ticker){
    ifstream file ( ticker + ".csv" ); // declare file stream: http://www.cplusplus.com/reference/iostream/ifstream/
    string value;
    while ( file.good() )
    {
         getline ( file, value, ',' ); // read a string until next comma: http://www.cplusplus.com/reference/string/getline/
         cout << string( value, 1, value.length()-2 ); // display value removing the first and the last character from it
    }
}
*/

void printData(string ticker){
    ifstream readObject;
    string line;
    string fPath = "data/" + ticker + ".csv";
    readObject.open(fPath.c_str());
    if(readObject.fail()){
        cout << "Could not open file: " << ticker << endl;
    }else{
        while(readObject.good()){
            cout << "\n";
            readObject >> line;
            cout << line;
        }
    }
    readObject.close();
}

void getData(){
    cout << "Putting data in csv files..." << endl;
    system("python run.py");
    cout << "Done." << endl;
}

void rmData(){
    system("rm -r data/*");
}

int main(){
    //system("mkdir ./data");
    cout << "Running..." << endl;
    for(int i=0; i<30; i++){
        printData(djia[i]);
        cout << "Reading " << djia[i] << endl;
    }
    return 0;
}
