#include <iostream>
using namespace std;

int fac(int num){
    int fact = 1;
    if(num == 0){
        return 1;
    }
    for(int a = num ; a > 0 ; a--){
        fact = fact * a;
    }
    return fact;
}
int coef(int n, int k){
    int coeff;
    coeff = fac(n) / (fac(k) * fac(n-k));
    return coeff;
}

int main() {
    int n,k;
    cout << "Enter n and k:" << endl;
    cin >> n;
    cin >> k;
    if(cin.fail() || n < k || n < 0 || k < 0){
        cout << "Invalid input." << endl;
        return 0;
    }
    cout << "C = " << coef(n,k) << endl;
    return 0;
}
