//Be sure to have an extra pair of socks ready, this will knock your socks off

/*
Programming Final
"Sticks" game
Group Members: Austin Lowey, Josh Gribbon, Alessandra Chieff, Rebecca Abernethy
Commands used:
    Basic cin/cout, while loops, arrays, strings, random numbers, time delays,
    changing the color of the debugger window, clearing the screen, saving scores
*/



#include <iostream>
#include <string>
#include <fstream>//scoreboard
#include <cstdlib>//random
#include <stdlib.h>//random
#include <stdio.h>//random
#include <time.h>//delay

using namespace std;

class hands
{
public:
    //create variables
    int attacker;//hand that is attacking
    int attacked;//hand getting attacked
    int hand;//input for value function
    int clapVal;//used for clapping

    int value(int hand)
    {
        //display the value of a hand
        switch(hand)
        {
        case 1:
            return 1;
        case 2:
            return 2;
        case 3:
            return 3;
        case 4:
            return 4;
        default:
            return 0;
        }
    }
    int compete(int attacker, int attacked)
        //return the value of the attacked hand
    {
        if(attacker == 0 || attacked == 0)//if either hand is 0, don't allow the move
        {
            cout<<"!!!Sorry that move is not allowed!!!"<<endl;
        }
        else//otherwise, add the hands, and set that value as the attacked hand, if it is now out set it to 0
        {
            attacked = attacker + attacked;
            if(attacked < 5)
            {
                return attacked;
            }
            else
            {
                return 0;
            }
        }
    }
    int clap(int yourRight, int yourLeft)
    {
        clapVal = (yourRight + yourLeft);//add both your hands
        if(clapVal%2 != 0)//if it's not an even number, its not allowed
        {
            cout<<"Clap not allowed"<<endl;
        }
        if(clapVal%2 == 0)//if it is an even number, it is allowed
        {
            cout<<"Clap executed"<<endl;
            clapVal = clapVal/2;
            return clapVal;
        }
    }
};//end of hands class

int EL=1;//enemy left
int ER=1;//enemy right
int YL=1;//your left
int YR=1;//your right
int choice1;//game mode
int hitterHand;//hand that is attacking
int hitHand;//hand that gets hit
int randChoice1;//random number
int randPicture;//random number for ascii picture
int randChoice2;//random number
//int win;
//int lose;
//variables for the scoreboard:
int easyWin;
int easyLoss;
int hardWin;
int hardLoss;
int totalWin;
int totalLoss;

string firstYourLeftHand [5]  =  {" _____  ","    ||  ","   |||  ","  ||||  "," |||||  "};
string secondYourLeftHand [5] =  {" |||||  "," ___||  "," __|||  "," _||||  "," |||||  "};
string thirdYourLeftHand [5]  =  {" | 1  ) "," | 1  ) "," | 1  ) "," | 1  ) "," | 1  ) "};
string fourthYourLeftHand [5] =  {" |___|  "," |___|  "," |___|  "," |___|  "," |___|  "};

string firstYourRightHand [5] =  {" _____  "," ||     "," |||    "," ||||   "," |||||  "};
string secondYourRightHand [5]=  {" |||||  "," ||___  "," |||__  "," ||||_  "," |||||  "};
string thirdYourRightHand [5] =  {"(  2 |  "," ( 2 |  ","(  2 |  ","(  2 |  ","(  2 |  "};
string fourthYourRightHand [5]=  {" |___|  "," |___|  "," |___|  "," |___|  "," |___|  "};

string firstEnemyRightHand [5] = {" _____  "," _____  "," _____  "," _____  "," _____  "};
string secondEnemyRightHand [5]= {" | 2 |  "," | 2 |  "," | 2 |  "," | 2 |  "," | 2 |  "};
string thirdEnemyRightHand [5] = {"(    |  ","(  __|  ","(   _|  ","(    |  ","(    |  "};
string fourthEnemyRightHand [5]= {" |||||  "," ||     "," |||    "," ||||   "," |||||  "};
string fifthEnemyRightHand [5] = {"        "," ||     "," |||    "," ||||   "," |||||  "};

string firstEnemyLeftHand [5]  = {" _____  "," _____  "," _____  "," _____  "," _____  "};
string secondEnemyLeftHand [5] = {" | 1 |  "," | 1 |  "," | 1 |  "," | 1 |  "," | 1 |  "};
string thirdEnemyLeftHand [5]  = {" |    ) "," |__  ) "," |_   ) "," |    ) "," |    ) "};
string fourthEnemyLeftHand [5] = {" |||||  ","    ||  ","   |||  ","  ||||  "," |||||  "};
string fifthEnemyLeftHand [5]  = {"        ","    ||  ","   |||  ","  ||||  "," |||||  "};

void sleep(long d)
{
    clock_t start=clock();
    while(clock() - start < d); //loop until time's up
}
void dispGame()
{
    system("CLS");
    cout<<"----------------------------"<<endl;
    cout<<"|   "<<firstEnemyLeftHand[EL] <<"    "<<firstEnemyRightHand[ER] <<"   |"<<endl;
    cout<<"|   "<<secondEnemyLeftHand[EL]<<"    "<<secondEnemyRightHand[ER]<<"   |"<<endl;
    cout<<"|   "<<thirdEnemyLeftHand[EL] <<"    "<<thirdEnemyRightHand[ER] <<"   |"<<endl;
    cout<<"|   "<<fourthEnemyLeftHand[EL]<<"    "<<fourthEnemyRightHand[ER] <<"   |"<<endl;
    cout<<"|   "<<fifthEnemyLeftHand[EL] <<"    "<<fifthEnemyRightHand[ER] <<"   |"<<endl;
    cout<<"|                          |"<<endl;
    cout<<"|   "<<firstYourLeftHand[YL] <<"    "<<firstYourRightHand[YR] <<"   |"<<endl;
    cout<<"|   "<<secondYourLeftHand[YL]<<"    "<<secondYourRightHand[YR]<<"   |"<<endl;
    cout<<"|   "<<thirdYourLeftHand[YL] <<"    "<<thirdYourRightHand[YR] <<"   |"<<endl;
    cout<<"|   "<<fourthYourLeftHand[YL]<<"    "<<fourthYourRightHand[YR]<<"   |"<<endl;
    cout<<"|                          |"<<endl;
    cout<<"----------------------------"<<endl;
}
void viewScores()
{
    ifstream readObject;

    string line;

    readObject.open("scores.txt");
    if(readObject.fail())
    {
        cout<<"Could not open scores file, must misnamed or deleted"<<endl;
        system("pause");
        exit(1);
    }
    else
    {
        cout << "\n";
        readObject >> line;
        cout << "--------------------------" << endl;
        cout << "   Easy wins :" << line << endl;
        readObject >> line;
        cout << "   Easy Loses:" << line << endl;
        readObject >> line;
        cout << "   Hard wins :" << line << endl;
        readObject >> line;
        cout << "   Hard Loses:" << line << endl;
        readObject >> line;
        cout << "   Total wins :" << line << endl;
        readObject >> line;
        cout << "   Total Loses:" << line << endl;
        cout << "--------------------------" << endl;
        cout << "\n";
    }
    readObject.close();
}
void updateScores(int easyWins, int easyLosses, int hardWins, int hardLosses, int totalWins, int totalLosses)
{
    ofstream writeObject;
    writeObject.open("scores.txt");
    writeObject << easyWins<< endl;
    writeObject << easyLosses<< endl;
    writeObject << hardWins<< endl;
    writeObject << hardLosses<< endl;
    writeObject << totalWins<< endl;
    writeObject << totalLosses<< endl;
}
void addEasyWin()
{
    ifstream readObject;

    int easyWins;
    int easyLosses;
    int hardWins;
    int hardLosses;
    int totalWins;
    int totalLosses;

    readObject.open("scores.txt");
    if(readObject.fail())
    {
        cout<<"Could not open scores file, must misnamed or deleted"<<endl;
        system("pause");
        exit(1);
    }
    else
    {
        readObject >> easyWins;
        readObject >> easyLosses;
        readObject >> hardWins;
        readObject >> hardLosses;
        readObject >> totalWins;
        readObject >> totalLosses;
        easyWins++;
        totalWins++;
    }
    readObject.close();
    updateScores(easyWins,easyLosses, hardWins, hardLosses, totalWins, totalLosses);
}
void addEasyLoss()
{
    ifstream readObject;

    int easyWins;
    int easyLosses;
    int hardWins;
    int hardLosses;
    int totalWins;
    int totalLosses;

    readObject.open("scores.txt");
    if(readObject.fail())
    {
        cout<<"Could not open scores file, must misnamed or deleted"<<endl;
        system("pause");
        exit(1);
    }
    else
    {
        readObject >> easyWins;
        readObject >> easyLosses;
        readObject >> hardWins;
        readObject >> hardLosses;
        readObject >> totalWins;
        readObject >> totalLosses;
        easyLosses++;
        totalLosses++;
    }
    readObject.close();
    updateScores(easyWins,easyLosses, hardWins, hardLosses, totalWins, totalLosses);
}
void addHardWin()
{
    ifstream readObject;

    int easyWins;
    int easyLosses;
    int hardWins;
    int hardLosses;
    int totalWins;
    int totalLosses;

    readObject.open("scores.txt");
    if(readObject.fail())
    {
        cout<<"Could not open scores file, must misnamed or deleted"<<endl;
        system("pause");
        exit(1);
    }
    else
    {
        readObject >> easyWins;
        readObject >> easyLosses;
        readObject >> hardWins;
        readObject >> hardLosses;
        readObject >> totalWins;
        readObject >> totalLosses;
        hardWins++;
        totalWins++;
    }
    readObject.close();
    updateScores(easyWins,easyLosses, hardWins, hardLosses, totalWins, totalLosses);
}
void addHardLoss()
{
    ifstream readObject;

    int easyWins;
    int easyLosses;
    int hardWins;
    int hardLosses;
    int totalWins;
    int totalLosses;

    readObject.open("scores.txt");
    if(readObject.fail())
    {
        cout<<"Could not open scores file, must misnamed or deleted"<<endl;
        system("pause");
        exit(1);
    }
    else
    {
        readObject >> easyWins;
        readObject >> easyLosses;
        readObject >> hardWins;
        readObject >> hardLosses;
        readObject >> totalWins;
        readObject >> totalLosses;
        hardLosses++;
        totalLosses++;
    }
    readObject.close();
    updateScores(easyWins,easyLosses, hardWins, hardLosses, totalWins, totalLosses);
}

int main()
{
    system("Color 84");//set background to grey and text to red
    hands gameHands;

    cout<<"--------------------------------------------------"<<endl;
    cout<<"|                                                |"<<endl;
    cout<<"|                 'CHOPSTICKS'                   |"<<endl;
    cout<<"|                                                |"<<endl;
    cout<<"|         By: Austin Lowey, Josh Gribbon,        |"<<endl;
    cout<<"|    Alessandra Chieff, and Rebecca Abernethy    |"<<endl;
    cout<<"|                                                |"<<endl;
    cout<<"|    **Please take note of the Stevens theme     |"<<endl;
    cout<<"|              and enjoy the game!!!             |"<<endl;
    cout<<"|                                                |"<<endl;
    cout<<"--------------------------------------------------"<<endl;
    system("pause");
    system("CLS");

    while(2)
    {
        system("CLS");
        cout << "--------------------------------" << endl;
        cout << "| Choose a mode:               |" << endl;
        cout << "| 1 for easy(random AI moves)  |" << endl;
        cout << "| 2 for hard(intelligent AI)   |" << endl;
        cout << "| 3 to see the rules           |" << endl;
        cout << "| 4 to see the scoreboard      |" << endl;
        cout << "| 0 to exit                    |" << endl;
        cout << "--------------------------------" << endl;
        cin >> choice1;

        if (choice1 == 1)//Easy mode
        {
            while(1)
            {
                //DISPLAY GAME
                dispGame();

                if(YL+YR == 0)
                {
                    cout<<"The computer wins!!!"<<endl;
                    addEasyLoss();
                    system("pause");
                    exit(1);
                }

                //PLAYER MAKES A MOVE
                cout<<"Choose a hand to hit with"<<endl;
                cin>>hitterHand;
                cout<<"Choose a hand to hit or press 3 to clap"<<endl;
                cin>>hitHand;

                if(hitHand == 1)
                {
                    if(hitterHand == 1)
                    {
                        EL=gameHands.compete(YL,EL);
                    }
                    if(hitterHand == 2)
                    {
                        EL=gameHands.compete(YR,EL);
                    }
                }
                if(hitHand == 2)
                {
                    if(hitterHand == 1)
                    {
                        ER=gameHands.compete(YL,ER);
                    }
                    if(hitterHand == 2)
                    {
                        ER=gameHands.compete(YR,ER);
                    }
                }
                if(hitHand == 3)
                {
                    YR = gameHands.clap(YR,YL);
                    YL = YR;
                }

                system("CLS");

                //DISPLAY GAME
                dispGame();

                if(EL+ER == 0)
                {
                    cout<<"You win!!!"<<endl;
                    addEasyWin();
                    system("pause");
                    exit(1);
                }

                //COMPUTER MAKES A RANDOM MOVE
                {
                    randChoice1 = 1 + ( std::rand() % ( 2 - 1 + 1 ) );
                    randChoice2 = 1 + ( std::rand() % ( 2 - 1 + 1 ) );
                    cout<<"------------------------------------------------"<<endl;
                    if(YL != 0 && YR != 0)
                    {
                        if(randChoice2 == 1)
                        {
                            if(randChoice1 == 1)
                            {
                                YL=gameHands.compete(EL,YL);
                                cout<<"Computer Move: Left hits left"<<endl;
                            }
                            if(randChoice1 == 2)
                            {
                                YL=gameHands.compete(EL,YR);
                                cout<<"Computer Move: Left hits right"<<endl;
                            }
                        }
                        if(randChoice2 == 2)
                        {
                            if(randChoice1 == 1)
                            {
                                YR=gameHands.compete(ER,YL);
                                cout<<"Computer Move: Right hits left"<<endl;
                            }
                            if(randChoice1 == 2)
                            {
                                YR=gameHands.compete(ER,YR);
                                cout<<"Computer Move: Right hits right"<<endl;
                            }
                        }
                    }
                    if(YR == 0 && YR != 0)
                    {
                        if(randChoice1 == 1)
                        {
                            YL=gameHands.compete(EL,YL);
                            cout<<"Computer Move: Left hits left"<<endl;
                        }
                        if(randChoice1 == 1)
                        {
                            YR=gameHands.compete(ER,YL);
                            cout<<"Computer Move: Right hits left"<<endl;
                        }
                    }
                    if(YR != 0 && YR == 0)
                    {
                        if(randChoice1 == 2)
                        {
                            YL=gameHands.compete(EL,YR);
                            cout<<"Computer Move: Left hits right"<<endl;
                        }
                        if(randChoice1 == 2)
                        {
                            YR=gameHands.compete(ER,YR);
                            cout<<"Computer Move: Right hits right"<<endl;
                        }
                    }
                }//end of random computer move

                //delay here
                cout<<"Time:3\r";
                sleep(1000);
                cout<<"Time:2\r";
                sleep(1000);
                cout<<"Time:1\r";
                sleep(1000);
                system("CLS");
            }//end of while statement and easy game
            cout<<"GAME OVER!!!"<<endl;
            viewScores();
            system("pause");
            exit(1);

        }//end of easy mode menu option

        //---------------------------------------------------------------------------------------------------------

        if (choice1 == 2)//Hard mode
        {
            while(1)
            {
                //DISPLAY GAME
                dispGame();

                if(YL+YR == 0)
                {
                    cout<<"The computer wins!!!"<<endl;
                    addHardLoss();
                    system("pause");
                    exit(1);
                }

                //PLAYER MAKES A MOVE
                cout<<"Choose a hand to hit with"<<endl;
                cin>>hitterHand;
                cout<<"Choose a hand to hit or press 3 to clap"<<endl;
                cin>>hitHand;

                if(hitHand == 1)
                {
                    if(hitterHand == 1)
                    {
                        EL=gameHands.compete(YL,EL);
                    }
                    if(hitterHand == 2)
                    {
                        EL=gameHands.compete(YR,EL);
                    }
                }
                if(hitHand == 2)
                {
                    if(hitterHand == 1)
                    {
                        ER=gameHands.compete(YL,ER);
                    }
                    if(hitterHand == 2)
                    {
                        ER=gameHands.compete(YR,ER);
                    }
                }
                if(hitHand == 3)
                {
                    YR = gameHands.clap(YR,YL);
                    YL = YR;
                }

                system("CLS");

                //DISPLAY GAME
                dispGame();

                if(EL+ER == 0)
                {
                    cout<<"You win!!!"<<endl;
                    addHardWin();
                    system("pause");
                    exit(1);
                }

                //COMPUTER MAKES AN INTELLIGENT MOVE, IF NONE APPLY GO RANDOM MOVE

                /*
                OLD CLAP MOVE- NOT SURE IF IT WILL STAY
                if(((EL==2 && ER==1) || (EL==1 && ER==2)) && (YL==1 && YR==1)) //key opening move
                {
                ER=3;
                EL=0;
                cout<<"Clap executed"<<endl;
                }
                */

                else if((EL==1 && ER==1) && ((YL==0 && YR==1) || (YL==1 && YR==0)))  //if human player is in this scenario, it's about to be end game
                {
                    ER=2;
                    EL=0;

                }
                else if(((ER==4 && EL==0) || (ER==0 && EL==4)) && (YL==1 && YR==1))
                {
                    ER=2;
                    EL=2;
                }

                // Note to self: add other specific cases here
                // Note to self: Priority conditions/algorithms start here

                else if(YL==0 && (EL+YR>4))
                {
                    int compete(int EL, int YR); //EL hits YR
                }

                else if(YL==0 && (ER+YR>4))
                {
                    int compete(int ER, int YR); //ER hits YR
                }

                else if(YR==0 && (EL+YL>4))
                {
                    int compete(int EL, int YL); //EL hits YL
                }

                else if(YR==0 && (ER+YL>4))
                {
                    int compete(int ER, int YL);//ER hits YL
                }
                else {
                    randChoice1 = 1 + ( std::rand() % ( 2 - 1 + 1 ) );
                    randChoice2 = 1 + ( std::rand() % ( 2 - 1 + 1 ) );
                    cout<<"------------------------------------------------"<<endl;
                    if(YL != 0 && YR != 0)
                    {
                        if(randChoice2 == 1)
                        {
                            if(randChoice1 == 1)
                            {
                                YL=gameHands.compete(EL,YL);
                                cout<<"Computer Move: Left hits left"<<endl;
                            }
                            if(randChoice1 == 2)
                            {
                                YL=gameHands.compete(EL,YR);
                                cout<<"Computer Move: Left hits right"<<endl;
                            }
                        }
                        if(randChoice2 == 2)
                        {
                            if(randChoice1 == 1)
                            {
                                YR=gameHands.compete(ER,YL);
                                cout<<"Computer Move: Right hits left"<<endl;
                            }
                            if(randChoice1 == 2)
                            {
                                YR=gameHands.compete(ER,YR);
                                cout<<"Computer Move: Right hits right"<<endl;
                            }
                        }
                    }
                    if(YR == 0 && YR != 0)
                    {
                        if(randChoice1 == 1)
                        {
                            YL=gameHands.compete(EL,YL);
                            cout<<"Computer Move: Left hits left"<<endl;
                        }
                        if(randChoice1 == 1)
                        {
                            YR=gameHands.compete(ER,YL);
                            cout<<"Computer Move: Right hits left"<<endl;
                        }
                    }
                    if(YR != 0 && YR == 0)
                    {
                        if(randChoice1 == 2)
                        {
                            YL=gameHands.compete(EL,YR);
                            cout<<"Computer Move: Left hits right"<<endl;
                        }
                        if(randChoice1 == 2)
                        {
                            YR=gameHands.compete(ER,YR);
                            cout<<"Computer Move: Right hits right"<<endl;
                        }
                    }
                }//end of random computer move

                //delay here
                cout<<"Time:3\r";
                sleep(1000);
                cout<<"Time:2\r";
                sleep(1000);
                cout<<"Time:1\r";
                sleep(1000);
                system("CLS");
            }//end of while statement and hard game
            cout<<"GAME OVER!!!"<<endl;
            viewScores();
            system("pause");
            exit(1);
        }//end of hard mode menu option

        //---------------------------------------------------------------------------------------------------------

        if (choice1 == 3)//show rules
        {
            system("CLS");
            cout<<"---------------------------------------------------------"<<endl;
            cout<<"|                         OBJECTIVE                     |"<<endl;
            cout<<"|             Eliminate both enemy hands before         |"<<endl;
            cout<<"|                 they eliminate your hands.            |"<<endl;
            cout<<"|                                                       |"<<endl;
            cout<<"|                        HOW TO PLAY                    |"<<endl;
            cout<<"|  Each hand starts with 1 finger extended on each hand |"<<endl;
            cout<<"|             Players alternate taking turns            |"<<endl;
            cout<<"|        Each player is allowed one move each turn      |"<<endl;
            cout<<"|                                                       |"<<endl;
            cout<<"|                          MOVES                        |"<<endl;
            cout<<"|          TAP                            CLAP          |"<<endl;
            cout<<"| Player hits one enemy         Player can divide an    |"<<endl;
            cout<<"|hand with one of their       even number of fingers in |"<<endl;
            cout<<"|  own, enemy now has          one hand to an empty hand|"<<endl;
            cout<<"|sum of those two hands.         or combine two hands.  |"<<endl;
            cout<<"|                                                       |"<<endl;
            cout<<"|                         WINNING                       |"<<endl;
            cout<<"|   Once a hand has five fingers up, the hand is out.   |"<<endl;
            cout<<"|         Once both hands are out player has lost.      |"<<endl;
            cout<<"---------------------------------------------------------"<<endl;
            system("pause");
        }//end of rules if statement

        //---------------------------------------------------------------------------------------------------------

        if(choice1 == 4)//view scoreboard
        {
            system("CLS");
            viewScores();
            system("pause");
        }//end of scoreboard if statement

    }//end of menu while statement
}//end of main
