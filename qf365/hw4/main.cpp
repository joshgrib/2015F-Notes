#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib> //for system()
#include <fstream>
#include <math.h>
#include <algorithm>
#include <numeric>
#include <vector>

#include <boost/math/distributions.hpp>
#include <boost/accumulators/accumulators.hpp>
#include <boost/accumulators/statistics/stats.hpp>
#include <boost/accumulators/statistics/mean.hpp>
#include <boost/accumulators/statistics/variance.hpp>
#include <boost/accumulators/statistics/kurtosis.hpp>
#include <boost/accumulators/statistics/moment.hpp>
#include <boost/accumulators/statistics/skewness.hpp>

using namespace std;
using namespace boost::accumulators;

string djia[] = {"AAP","AXP","BA","CAT","CSCO","CVX","DD","DIS","GE","GS","HD","IBM","INTC","JNJ","JPM","KO","MCD","MMM","MRK","MSFT","NKE","PFE","PG","TRV","UNH","UTX","V","VZ","WMT","XOM"};

bool printStats(string, string);
void printData(string);
void getData();
void rmData();
void run();
void getAveMoments(string, string);

int main(){
    run();
    return 0;
}

void getAveMoments(string inFileName, string outFileName){
    ifstream readObject;
    string line;
    readObject.open("moments.csv");
    accumulator_set<double, stats<tag::mean> > acc_expRet;
    accumulator_set<double, stats<tag::mean> > acc_stdDev;
    accumulator_set<double, stats<tag::mean> > acc_skew;
    accumulator_set<double, stats<tag::mean> > acc_kurt;
    string ticker, expRet, stdDev, skew, kurt;
    while( getline(readObject, ticker, ',') ){
        //ticker, expRet, stdDev, skew, kurt
        getline(readObject, expRet, ',');
        getline(readObject, stdDev, ',');
        getline(readObject, skew, ',');
        getline(readObject, kurt);
        float expRet_float = ::atof(expRet.c_str());
        float stdDev_float = ::atof(stdDev.c_str());
        float skew_float = ::atof(skew.c_str());
        float kurt_float = ::atof(kurt.c_str());
        acc_expRet(expRet_float);
        acc_stdDev(stdDev_float);
        acc_skew(skew_float);
        acc_kurt(kurt_float);
    }
    ofstream writeObject;
    writeObject.open("aveMoments.csv");
    writeObject << "expRet, stdDev, skew, kurt\n";
    writeObject << mean(acc_expRet) << "," << mean(acc_stdDev) << "," << mean(acc_skew) << "," << mean(acc_kurt) << endl;
    writeObject.close();
}

void run(){
    cout << "Running..." << endl;
    //cout << "Clearing data" << endl;
    //rmData();
    //system("mkdir data");
    //cout << "Getting data" << endl;
    //getData();
    //cout << "Waiting..." << endl;
    //sleep(1000 * 10);
    //cout << "Done waiting!" << endl;
    ofstream statsFile;
    statsFile.open("moments.csv");
    statsFile << "ticker, expRet, stdDev, skew, kurt\n";
    statsFile.close();
    cout << "Computing stats and writing to 'moments.csv'..." << endl;
    for(int i=0; i<30; i++){
        printStats(djia[i], "moments.csv");
        //cout << "Reading " << djia[i] << endl;
    }
    cout << "Getting the averages..." << endl;
    getAveMoments("moments.csv", "aveMoments.csv");
    cout << "Done!" << endl;
}

bool printStats(string ticker, string outFileName){
    ifstream readObject;
    string line;
    string fPath = "data/" + ticker + ".csv";
    readObject.open(fPath.c_str());
    //float closes[1259];
    int count = 0;
    //string writeFile = "ticker, expRet, stdDev, skew, kurt";
    if(readObject.fail()){
        cout << "Could not open file: \"" << ticker << ".csv\"" << endl;
        return false;
    }else{
        string date,open, high, low, close, volume, adjClose;
        accumulator_set<double, stats<tag::mean, tag::variance, tag::kurtosis, tag::skewness> > acc;
        while( getline(readObject, date, ',') ){
            //Date,Open,High,Low,Close,Volume,Adj Close
            getline(readObject, open, ',');
            getline(readObject, high, ',');
            getline(readObject, low, ',');
            getline(readObject, close, ',');
            getline(readObject, volume, ',');
            getline(readObject, adjClose);
            float data = ::atof(close.c_str());
            acc(data);
            count++;
        }
        //cout << "----------------" << endl;
        //cout << ticker << endl;
        //variance and mean - which is maybe exp ret - are off
        //cout << "Mean: " << mean(acc) << endl;
        //cout << "Variance: " << variance(acc) << endl;
        //cout << "Kurtosis: " << kurtosis(acc) << endl;
        //cout << "Skewness: " << skewness(acc) << endl;
        ofstream mFile;
        mFile.open("moments.csv", fstream::app);
        mFile << ticker << "," << mean(acc) << "," << sqrt(variance(acc)) << "," << skewness(acc) << "," << kurtosis(acc) << endl;
        mFile.close();
    }
    readObject.close();
    return true;
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
    //cout << "Putting data in csv files..." << endl;
    system("python run.py");
    //cout << "Done." << endl;
}

void rmData(){
    system("rm -r data");
}
