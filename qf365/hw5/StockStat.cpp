#include <iostream>
#include <string>
#include <regex>
#include <fstream>
#include <math.h>
#include "StockStat.h"

#include <cstdlib>
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

void StockStat::run(){
    get_data();
    run_stats();
}

int StockStat::get_data(){
    /* Return Codes
     * 0 - Successful run
     * 1 - Incorrect start date format
     * 2 - Incorrect end date format
     */
    cout << "What is it you would like to do?" << endl;
    cout << "  Press \"r\" to run some statistics on a stock" << endl;
    cout << "  Press any other key to exit" << endl;
    string choice;
    cin >> choice;
    if(choice == "r"){//Time to run some stats!
        cout << "Enter a stock to anaylze(Ex: AAP, GOOG, WMT)" << endl;
        string ticker;
        cin >> ticker;
        cout << "Enter start date(MMDDYYYY)" << endl;
        string start_d;
        cin >> start_d;
        if(!std::regex_match(start_d, std::regex("\\d{8}"))){
            cout << "Sorry date format incorrect" << endl;
            return 1;
        }
        cout << "Enter end date(MMDDYYYY)" << endl;
        string end_d;
        cin >> end_d;
        if(!std::regex_match(end_d, std::regex("\\d{8}"))){
            cout << "Sorry date format incorrect" << endl;
            return 2;
        }
        download_data(ticker, start_d, end_d);
        cout << "---\nFile downloaded\n---" << endl;
        return 0;
    }
    return 0;
}
void StockStat::download_data(string ticker, string start_date, string end_date){
    string url = make_url(ticker, start_date, end_date);
    string cmd = "wget \"" + url + "\" -O data.csv";
    system( cmd.c_str() );
}

string StockStat::make_url(string ticker, string start_date, string end_date){
    //wget "http://ichart.yahoo.com/table.csv?s=MSFT&a=0&b=1&c=2000&d=0&e=2&f=2000&g=d&ignore=.csv" -O file.csv
    int s_month = stoi(start_date.substr(0,2)) - 1;
    int s_day   = stoi(start_date.substr(2,2));
    int s_year  = stoi(start_date.substr(4,4));
    int e_month = stoi(end_date.substr(0,2)) - 1;
    int e_day   = stoi(end_date.substr(2,2));
    int e_year  = stoi(end_date.substr(4,4));
    string resp = "http://ichart.yahoo.com/table.csv?";
        resp += "s=" + string(ticker);
        resp += "&a=" + to_string(s_month);
        resp += "&b=" + to_string(s_day);
        resp += "&c=" + to_string(s_year);
        resp += "&d=" + to_string(e_month);
        resp += "&e=" + to_string(e_day);
        resp += "&f=" + to_string(e_year);
        resp += "&g=d";//get daily data, &g=w will get weekly data
        resp += "&ignore=.csv";
    return resp;
}

int StockStat::run_stats(){
    /* Return Codes
     * 0 - Successful run
     * 1 - Stat choice now recognized or chose to exitdata
     * 2 - Data to anaylze choice not recognized or chose to exit
     */
    cout << "What stat would you like to run?" << endl;
    cout << "  1 - Simple average" << endl;
    cout << "  2 - Volatility (standard deviation)" << endl;
    cout << "  3 - Kurtosis" << endl;
    cout << "  4 - Skewness" << endl;
    cout << "  Press any other key to exit" << endl;
    string stat;
    cin >> stat;
    if(stat == "1" || stat == "1" || stat == "1" || stat == "1"){
        cout << "What market data do you want to run the stat on?" << endl;
        cout << "  1 - Close Price" << endl;
        cout << "  2 - High Price" << endl;
        cout << "  3 - Low Price" << endl;
        cout << "  4 - Open Price" << endl;
        cout << "  5 - Adj Close" << endl;
        cout << "  6 - Volume" << endl;
        cout << "  7 - High-low spread" << endl;
        cout << "  Press any other key to exit" << endl;
        string d;
        cin >> d;
        if(d == "1" || d == "2" || d == "3" || d == "4" || d == "5" || d == "6" || d == "7"){
            calc_stats(stoi(stat), stoi(d));
            return 0;
        }
        return 2;
    }else{
        return 1;
    }
    return 0;
}

int StockStat::calc_stats(int stat_choice, int data_choice){
    /* Return Codes
     * 0 - Successful run
     * 1 - Could not open data.csv in current directory
     * 2 - Data choice error
     */
    ifstream readObject;
    string line;
    string fPath = "data.csv";
    readObject.open(fPath.c_str());
    if(readObject.fail()){
        cout << "Could not open \"data.csv\" in current directory" << endl;
        return 1;
    }
    else{
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
            float data;
            switch(data_choice){
                case 1:
                    data = ::atof(close.c_str());
                    break;
                case 2:
                    data = ::atof(high.c_str());
                    break;
                case 3:
                    data = ::atof(low.c_str());
                    break;
                case 4:
                    data = ::atof(open.c_str());
                    break;
                case 5:
                    data = ::atof(adjClose.c_str());
                    break;
                case 6:
                    data = ::atof(volume.c_str());
                    break;
                case 7:
                    data = ::atof(high.c_str()) - ::atof(low.c_str());
                    break;
                default:return 2;
            }
            acc(data);
        }
        ofstream outFile;
        outFile.open("results.csv");
        switch(stat_choice){
            case 1:
                cout << "Average:" << mean(acc) << endl;
                outFile << mean(acc) << endl;
                break;
            case 2:
                cout << "Volatility(std dev):" << sqrt(variance(acc)) << endl;
                outFile << sqrt(variance(acc)) << endl;
                break;
            case 3:
                cout << "Skewness:" << skewness(acc) << endl;
                outFile << skewness(acc) << endl;
                break;
            case 4:
                cout << "Kurtosis:" << kurtosis(acc) << endl;
                outFile << kurtosis(acc) << endl;
                break;
            default: return 3;
        }
    }
    readObject.close();
    return 0;
}
