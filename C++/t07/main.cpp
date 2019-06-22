#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main()
{
    string s;
    cout << "Enter a hexadecimal number:" << endl;
    getline(cin,s);
    int length = s.length();
    int decimal = 0;
    for(int i = 0; i < length; i++){
        char a = s.at(i);
        if(a >= '0' && a <= '9')
            decimal = decimal * 16 + (a - '0');
        else if(a >= 'a' && a <= 'f'){
            decimal = decimal * 16 + (a - 'W');
        }
        else if (a >= 'A' && a <= 'F')
            decimal = decimal * 16 + (a - '7');
        else {
            cout << "Invalid input." << endl;
            return 0;
        }
    }
        cout << "Decimal: " << decimal << endl;

}
