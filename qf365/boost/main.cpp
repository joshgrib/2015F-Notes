#include <fstream>
#include <sstream>
/*
#include <boost\random.hpp>
#include <boost/generator_iterator.hpp>
#include <boost/accumulators/accumulators.hpp>
#include <boost\accumulators/statistics/stats.hpp>
#include <boost/accumulators/statistics/mean.hpp>
#include <boost/accumulators/statistics\moment.hpp>
#include <boost\accumulators/statistics\variance.hpp>
#include <boost/tokenizer.hpp>
*/
#include <boost/random.hpp>
#include <boost/generator_iterator.hpp>
#include <boost/accumulators/accumulators.hpp>
#include <boost/accumulators/statistics/stats.hpp>
#include <boost/accumulators/statistics/mean.hpp>
#include <boost/accumulators/statistics/moment.hpp>
#include <boost/accumulators/statistics/variance.hpp>
#include <boost/tokenizer.hpp>
using namespace std;
using namespace boost::accumulators;

int main(){
    /*
        ifstream inNew("C:/Program Files/boost/altr20141106.csv");
        accumulator_set<double, stats<tag::mean, tag::moment<2> > > acc;
        if(!inNew){
            cout << "get your forward slash correct!!!" << endl;
        }
        if (inNew){
             //int i = 0;
             string line;
             while (getline(inNew, line)){
                //stringstream sep(line);
                acc(stod(line));
                //i++;
            }
            cout << "Expected Return is:: " << mean(acc) << std::endl;
            cout << "Moment: " << moment<2>(acc) << std::endl;
         }
         inNew.close();
     */
    ifstream inNew("C:/Program Files/boost/altr20141106.csv");
    accumulator_set<double, stats<tag::mean, tag::variance > > acc;
    accumulator_set<double, stats<tag::mean, tag::variance > > acc2;
    accumulator_set<double, stats<tag::mean, tag::variance > > acc3;
    if (inNew)
    {
        string line;
        while (getline(inNew, line,',')) //comma means more than 1 column,
        {
            cout << line << endl;
            acc(stod(line));
            getline(inNew, line,',');
            cout << line << endl;
            acc2(stod(line));
            getline(inNew, line);
            cout << line << endl;
            acc3(stod(line));
        }
        cout << "Expected Return is:: " << mean(acc) << std::endl;
        cout << "Variance: " << variance(acc) << std::endl;
        cout << "Expected Return is:: " << mean(acc2) << std::endl;
        cout << "Variance: " << variance(acc2) << std::endl;
        cout << "Expected Return is:: " << mean(acc3) << std::endl;
        cout << "Variance: " << variance(acc3) << std::endl;
    }
    inNew.close();

    return 0;
}
