/*
    Exemption Handling
    Throw - signals an exemption
    Catch - catches a thrown exemption
    Try - try to do something, then catch errors and handle them
*/
#include <iostream>
#include <string>
using namespace std;

int myTest(int a){
    if(a==13){throw "Unlucky number!";}
    int out = a;
    return out;
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
