#include <iostream>

using namespace std;

int main()
{
    double input;
    cout << "Enter a number:" << endl;
    cin  >> input;

    if (cin.fail()){
        cout << "Invalid input." << endl;
    } else {
        while (cin.peek() != '\n') {
            cout << "Invalid input." << endl;
            return 0;
        }
        cout << input << " : Input number well formated." << endl ;
    }
    return 0;
}
