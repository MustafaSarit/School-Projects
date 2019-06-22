#include <iostream>
#include <math.h>

using namespace std;

int main()
{
    cout << "Enter the parameters:" << endl;
    double a, b, c, root1, root2, disc, test;
    cin >> a;
    cin >> b;
    cin >> c;
    test = b*b - 4*a*c ;
    if (test < 0){
        cout<< "There is no resolution in R." << endl;
        return 0;
    }
    disc = sqrt(b*b - 4*a*c);
    root1 = ( -b + disc ) / ( 2 * a) ;
    root2 = ( -b - disc ) / ( 2 * a) ;
    cout << "Root 1: " << root1 << endl;
    cout << "Root 2: " << root2 << endl;
    return 0;
}
