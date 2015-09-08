#include <iostream>
#include <string>
#include <cstdlib>

using namespace std;

class GradeBook
{
public: //access specifier
    GradeBook() //class constructor
    {
        cout << "Grade book object created" << endl;
    }
    void openBook(string courseName) const //const means it doesn't modify the class
    {
        cout << "Welcome to the grade book for: " << courseName << "!" << endl;
    }
};

int main()
{
    GradeBook myGB;
    myGB.openBook("QF365");
    cin.get(); //linux equivalent of system("pause");
    return 0;
}
