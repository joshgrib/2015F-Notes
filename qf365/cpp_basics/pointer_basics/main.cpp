#include <iostream>
#include <string>
using namespace std;

void ex1();
void ex2();
void ex3();
void initArrayTwo(double, int, int);
void ex4();

int main(){
    ex1();
    return 0;
}

//delete(thing) when you're done with the thing and dont need it any more - saves memory, especially if you're allocating memory before needing it
void ex1(){
    double mv = 5.4;
    double *ptr; //declaration of a pointer

    ptr = &mv; //assigning the pointer to a location in memory

    cout << mv << endl;    //5.4
    cout << ptr << endl;   //0x7ffd6caca8b8
    cout << *ptr << endl;   //5.4
    //the asterisk dereferences the pointer and returns the value
}

void ex2(){
    double *d_ptr;
    d_ptr = new double[10]; //allocating a space in memory, makes an empty space to put something in later, makes the program faster than assigned memory when it's needed

    int *i_ptr;
    i_ptr = new int[10];

    string *s_ptr;
    s_ptr = new string[10];

    cout << d_ptr << endl;
    cout << i_ptr << endl;
    cout << s_ptr << endl;
}

void ex3(){
    size_t array_size;
    int *numbers;

    cout << "How large should the array be?" << endl;
    cin >> array_size;

    numbers = new int[array_size];

    cout << "The size of the new dyamic array is: " << array_size << endl;

    for(int i=0; i<array_size; i++){
        numbers[i] = 2*i;
    }
    for(int i=array_size; i>0; i--){
        cout << "numbers[" << i-1 << "]\n" << "  value: " << numbers[i-1] << "\n  location: " << &numbers[i-1] << endl;
    }
    delete(numbers);
}

void initArrayTwo(double **myArray, int theRows, int theCols){
    for(int i=0; i<theRows; i++){
        for(int j=0; j<theCols; j++){
            myArray[i][j] = 0;
        }
    }
}

void ex4(){
    int theRows = 10;
    int theCols = 10;

    double **myArray;
    myArray = new double *[theRows];
    for(int i=0; i<=theCols; ++i){
        myArray[i] = new double[theCols];
    }

    initArrayTwo(myArray, theRows, theCols);

    cout << "[" << endl;
    for(int i=0; i<theRows; i++){
        cout << "[";
        for(int j=0; j<theCols; j++){
            cout<<myArray[i][j] << ", ";
        }
        cout << "],";
        cout << endl;
    }
    cout << "]";
    cout << endl;
}
