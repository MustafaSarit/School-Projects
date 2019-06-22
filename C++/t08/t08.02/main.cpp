#include <iostream>
using namespace std;

bool isPrime(int n){
    if(n <= 1)
        return 0;
    for(int i = 2 ; i*i <= n ; i++){
        if(n % i == 0){
            return 0;
        }
    }
    return 1;
}
void interval(int n,int k){
    for(int i = n ; i <= k ; i++ ){
        if( isPrime(i) ){
            cout << i << endl;
        }
    }
}
int main() {
    int a,b;
    cout << "Define interval:" << endl;
    cin >> a;
    cin >> b;
    if( cin.fail() || a > b ){
        cout << "Invalid input." << endl;
        return 0;
    }
    interval(a, b);
    return 0;
}
