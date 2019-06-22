#include <iostream>
#include <math.h>
#include <iomanip>

using namespace std;

int main(){
    int iteration;
    double x,y,ip,time,speed,ap;
    cin  >> iteration;
    if(cin.fail() || (iteration <= 0)){
        cout << "Invalid input." << endl;
        return 0;
    }
    cin  >> x >> y >> ip >> time >> speed >> ap;
    if(cin.fail()){
        cout << "Invalid input." << endl;
        return 0;
    }

    while(iteration != 0){
        x = x + (speed * time * cos(ip));
        y = y + (speed * time * sin(ip));
        ip = ip + (time * ap);
        ip = fmod(ip, 2 * M_PI);
        cout << fixed << setprecision(2) << "x: " << x << ", y: " << y << ", phi: " << ip << endl;
        iteration -= 1;
    }
    return 0;
}
