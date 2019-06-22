#include <iostream>

using namespace std;

int main()
{
    string name;
    int num;
    cout << "Enter your name (no accents): ";
    getline(cin, name);
    cout << "Enter an integer: ";
    cin  >> num;
    cout << "Hi, " << name << "." << endl;
    cout << num << " x 3 = " << num * 3 << endl ;
    cout << num << " / 3 = " << num / 3 << endl ;

    return 0;
}
