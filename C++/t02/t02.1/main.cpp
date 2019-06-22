#include <iostream>

using namespace std;

int main()
{
    double num1, num2;
    cout << "Enter the 1st number:" << endl;
    cin  >> num1;
    cout << "Enter the 2nd number:" << endl;
    cin  >> num2;

    cout << "You have entered:" << endl;
    cout << num1 << " and " << num2 << endl;
    cout << num1 << " + " << num2 << " = " << num1 + num2 << endl;
    cout << num1 << " - " << num2 << " = " << num1 - num2 << endl;
    cout << num1 << " * " << num2 << " = " << num1 * num2 << endl;
    cout << num1 << " / " << num2 << " = " << num1 / num2 << endl;

    return 0;
}
