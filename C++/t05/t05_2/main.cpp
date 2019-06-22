#include <iostream>

using namespace std;

int main()
{
    int input;
    cout << "Enter number of stairs:" << endl;
    cin  >> input ;

    if (cin.fail() || input < 0){
        cout << "Invalid input." << endl;
    } else {
        for (int i = 1; i <= input; i++) {
            for (int j = 1; j < i; j++) {
                cout << "X" ;
            }
            cout << "_" << endl;
        }

    }

    return 0;
}
