#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib> //for system()
#include <fstream>
#include <math.h>

#include <algorithm>
#include <numeric>
#include <vector>

using namespace std;

string djia[] = {"AAP","AXP","BA","CAT","CSCO","CVX","DD","DIS","GE","GS","HD","IBM","INTC","JNJ","JPM","KO","MCD","MMM","MRK","MSFT","NKE","PFE","PG","TRV","UNH","UTX","V","VZ","WMT","XOM"};

float std_dev(float, int);
void printStats(string);
void printData(string);
void getData();
void rmData();

int main(){
    //system("mkdir ./data");
    cout << "Running..." << endl;
    //printStats("AAP");
    for(int i=0; i<30; i++){
        printData(djia[i]);
        //cout << "Reading " << djia[i] << endl;
    }

    return 0;
}

float std_dev(float data[], int n){
    /*From :http://www.programiz.com/cpp-programming/examples/standard-deviation*/
    float mean = 0.0, sum_dev = 0.0;
    for(int i=0; i<n; ++i)
        mean += data[i];
    mean = mean/n;
    for(int j=0; j<n; ++j)
        sum_dev += (data[j]-mean) * (data[j] * mean);
    return sqrt(sum_dev/n);
}

float getKurt(float data[], int n){
    //
}

void printStats(string ticker){
    ifstream readObject;
    string line;
    string fPath = "data/" + ticker + ".csv";
    readObject.open(fPath.c_str());
    float closes[1259];
    int count = 0;
    /*Stuff from online*/
    int n, i, x; double avg, var = 0, skewness = 0, S, k = 0;
    vector<int> v;
    /*End of online stuff*/
    if(readObject.fail()){
        cout << "Could not open file: \"" << ticker << ".csv\"" << endl;
    }else{
        string date,open, high, low, close, volume, adjClose;
        while( getline(readObject, date, ',') ){
            //Date,Open,High,Low,Close,Volume,Adj Close
            getline(readObject, open, ',');
            getline(readObject, high, ',');
            getline(readObject, low, ',');
            getline(readObject, close, ',');
            getline(readObject, volume, ',') ;
            getline(readObject, adjClose) ;
            closes[count] = ::atof(close.c_str());
            count++;
        }
    }
    readObject.close();

    /*Stuff found online*/
    for (i = 0; i < 1259; i++)
    {
        x = closes[i];
        v.push_back(x);
    }
    sort(v.begin(), v.end());
    for (i = 0; i < n; i++)
        cout << v[i] << " ";
    int sum = accumulate(v.begin(), v.end(), 0);
    avg = (double)sum/n;
    //cout << "\nMean = " << avg << endl;
    vector<int>::iterator it;
    if (n % 2 != 0)
    {
       x = (n+1)/2;
       it = v.begin() + x;
       nth_element(v.begin(), it, v.end());
       //cout << "Median = " << *(v.begin() + x -1) << endl;
    }
    else
    {
        float m;
        x = (n)/2 - 3;
        it = v.begin() + x;
        m = (*(v.begin()+ x - 1) + (*(v.begin() + x - 2 )))/2;
        //cout << "Median = " << m << endl;
    }
    for (i = 0; i < n; i++)
    {
        var += (v[i] - avg)*(v[i] - avg);
    }
    var = (double)(var)/(n - 1);
    //cout << "Variance = " << var << endl;
    S = (double)sqrt(var);
    for (i = 0; i < n; i++)
        skewness += (v[i] - avg)*(v[i] - avg)*(v[i] - avg);
    skewness = skewness/(n * S * S * S);
    cout << "Skewness = " << skewness << endl;
    for (i = 0; i < n; i++)
        k += (v[i] - avg)*(v[i] - avg)*(v[i] - avg)*(v[i] - avg);
    k = k/(n*S*S*S*S);
    k -= 3;
    cout << "Kurtosis = " << k << endl;
    /*End of online stuff*/
    int close_size = 1259 /*sizeof(closes) / sizeof(closes[0])*/;
    cout << "Std dev of " << ticker << ": " << std_dev(closes, close_size) << endl;
}

void printData(string ticker){
    ifstream readObject;
    string line;
    string fPath = "data/" + ticker + ".csv";
    readObject.open(fPath.c_str());
    //int count=0;
    if(readObject.fail()){
        cout << "Could not open file: \"" << ticker << ".csv\"" << endl;
    }else{
        string date,open, high, low, close, volume, adjClose;
        while( getline(readObject, date, ',') ){
            //Date,Open,High,Low,Close,Volume,Adj Close
            getline(readObject, open, ',');
            getline(readObject, high, ',');
            getline(readObject, low, ',');
            getline(readObject, close, ',');
            getline(readObject, volume, ',') ;
            getline(readObject, adjClose) ;
            cout << "Date: " << date << " " ;
            cout << "Open: " << open << " " ;
            cout << "High: " << high << " " ;
            cout << "Low: " << low << " " ;
            cout << "Close: " << close << " " ;
            cout << "Volume: " << volume << " " ;
            cout << "Adj Close: " << adjClose << "\n";
            //count++;
            /*cout << "\n";
            readObject >> line;
            cout << line;*/
        }
        //cout << count << endl;
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
