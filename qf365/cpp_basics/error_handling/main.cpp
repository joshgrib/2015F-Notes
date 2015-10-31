/*
    Exemption Handling
    Throw - signals an exemption
    Catch - catches a thrown exemption
    Try - try to do something, then catch errors and handle them
*/
/*
#include <iostream>
#include <string>
#include <vector>
using namespace std;

/*
int myTest(int a){
    if(a==13){throw "Unlucky number!";}
    int out = a;
    return out;
}
int main(){
    for(int i=0; i<20; i++){
        try{
            cout << myTest(i) << endl;
        }
        catch (const char* msg){
            cerr << msg << endl;
        }
    }
}
*/

/*
              _
          .-'` `}
  _./)   /       }
.'o   \ |       }
'.___.'`.\    {`
/`\_/  , `.    }
\=' .-'   _`\  {
 `'`;/      `,  }
    _\       ;  }
   /__`;-...'--'

    _.-"""-,
   .'  ..::. `\
  /  .::' `'` /
 / .::' .--.=;
 | ::' /  C ..\
 | :: |   \  _.)
  \ ':|   /  \
   '-, \./ \)\)
      `-|   );/
         '--'-'
*/
/*
int main(){
    vector<int> myV(100,0);
    for(int i=1; i<101; i++){
        myV.at(i) = i;
    }
    for(int i=1; i<101; i++){
        try{
            cout << myV.at(i) << endl;
        }
        /*
            _.-"""-,
           .'  ..::. `\
          /  .::' `'` /
         / .::' .--.=;
         | ::' /  C ..\
         | :: |   \  _.)
          \ ':|   /  \
           '-, \./ \)\)
              `-|   );/
                 '--'-'
         ___________________
        < This is squirelly >
         -------------------
                \   ^__^
                 \  (oo)\_______
                    (__)\       )\/\
                        ||----w |
                        ||     ||
        __  ,,      ,,  __
        ) ) /")    ("\ ( (
        \( /<(      )>\ )/
         `( )`)    ('( )'
           `-`-    -'-'
        *//*
        catch (exception& e){
            cerr << "Oh no!" << endl;
        }
        /*
                    %%%%%%
                   %%%% = =         WHAMMO!
                   %%C    >
                    _)' _( .' ,
                 __/ |_/\   " *. o
                /` \_\ \/     %`= '_  .
               /  )   \/|      .^',*. ,
              /' /-   o/       - " % '_
             /\_/     <       = , ^ ~ .
             )_o|----'|          .`  '
         ___// (_  - (\
        ///-(    \'   \\
        *//*
    }
    return 0;
}
*/

#include <iostream>
#include <string>
#include <exception>
#include <vector>
using namespace std;

int myFun(int a, int b)
{
    if(a == 0 || b == 0)
    {
        throw "Come on no negative numbers!!!!";
    }
    int out = a/b;
    return out;
}

int myFunTest(int a)
{
    if(a == 13)
    {
        throw "Unlucky number, this floor does not exist, Jason returns!!!!";
    }
    int out = a;
    return out;
}

int main()
{
    /*
    int a = 0;
    int b = 1;

    try
    {
        int myAnswer = myFun(123,0);
        cout << myAnswer << endl;
    }
    catch (const char* msg)
    {
        cerr << msg << endl;
    }

    try
    {
        int myAnswer = myFun(124,3);
        cout << myAnswer << endl;
    }
    catch (const char* msg)
    {
        cerr << msg << endl;
    }

    for(int i = 0; i < 20; i++)
    {
        try
        {
            cout << myFunTest(i) << endl;
        }
        catch (const char* msg)
        {
            cerr << msg << endl;
        }
    }


    string myAr[] = {"a","b"};

    try
    {
        cout << myAr[1] << endl;
    }
    catch(const char* e)
    {
        cout << e << endl;
    }
    */

    vector<int> myVec(100,0);

    for(int i=0;i<100;i++)
    {
        myVec.at(i) = i;
    }
/*
    for(int i=0;i<110;i++)
    {
        cout << myVec.at(i) << endl;
    }
*/

    try
    {
        for(int i=0;i<110;i++)
        {
            cout << myVec.at(i) << endl;
        }
    }
    catch(std::exception& e)
    {
        std::cout << "The following vector is out of range: " << "vec1" << std::endl;
    }

    return 0;
}
