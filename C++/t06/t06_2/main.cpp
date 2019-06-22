#include <iostream>
using namespace std;

int main() {
    int decimal = 0, digit;
    char binary = '0';
    cout << "Input binary number:" << endl;
    binary  = cin.get();
    if( !(binary == '1' || binary == '0') || cin.fail() ){
        cout << "Wrong input." << endl;
        return 0;
    }

    while( cin.good() && (binary == '0' || binary == '1') ){
        digit = binary - '0';
        decimal = decimal * 2 + digit;
        binary = cin.get();
    }

    if(cin.fail() || !(binary == '\n')){
        cout << "Wrong input." << endl;
        return 0;
    }
    cout << "Decimal number is: " << decimal << endl;
    return 0;
}
