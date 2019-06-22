#include <iostream>

using namespace std;

int main()
{
    double number, sum = 0;
    cout << "Enter numbers, the last one have to be 1000:" << endl;
    cin  >> number;
    while (number != 1000) {
        sum += number ;
        cin  >> number ;
    }
    cout << "Sum of values is: " << sum + 1000 << endl ;
    return 0;
}
