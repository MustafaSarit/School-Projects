#include <iostream>


using namespace std;

int main()
{
char digit;
    string num1, num2, num1t,
    num2t, input, total;
    unsigned int counter = 0, carry = 0;
    cout << "Enter two binary numbers:" << endl;

    getline(cin, input);

    unsigned int splitpoint = 0;
    for(unsigned int a = 0 ;
    a < input.length() ; a++){
        if(input.at(a) != ' '){
            num1t = num1t + input.at(a);
        }else{
            splitpoint = a;
            break;
        }
    }
    for(unsigned int a = splitpoint + 1;
    a < input.length() ; a++){
        num2t = num2t + input.at(a);
    }


    if (num1t == "" || num2t == "") {
        cout << "Invalid input." << endl;
        return 0;
    }

    if ((num1t.size() == 1 &&
         num1t[0] - '0' == 0) &&
        (num2t.size() == 1 &&
         num2t[0] - '0' == 0)) {
        cout << "Sum: 0" << endl;
        return 0;
    }

     if(cin.fail()){
        cout << "Invalid input." << endl;
        return 0;
     }
     unsigned int c = 0;
     for (; c < num1t.size(); c++) {
        if(num1t[c] - '0' != 0 ){
            break;
        }
        if(c == num1t.size() - 1 &&
           num1t[c] - '0' == 0)
            num1 = "0";
     }
    for (; c < num1t.size(); c++) {
        num1 = num1 + num1t[c];
     }

     unsigned int b = 0;
     for (; b < num2t.size(); b++) {
        if(num2t[b] - '0' != 0){
            break;
        }
        if(b == num2t.size() - 1 &&
           num1t[b] - '0' == 0)
            num2 = "0";
     }
    for (; b < num2t.size(); b++) {
        num2 = num2 + num2t[b];
     }




    for(unsigned int i = 0;
    i < num1.size(); i++){
        digit = num1[i];
         if( !(digit == '1' || digit == '0')){
            counter += 1;
        }
    }
    for(unsigned int i = 0; i < num2.size(); i++){
        digit = num2[i];
         if( !(digit == '1' || digit == '0')){
            counter += 1;
        }
    }

    if (counter > 0) {
        cout << "Invalid input." << endl;
        return 0;
    }

    if (num1.size() == num2.size()) {
        for(unsigned int a = 1;
        a <= num1.size(); a++) {

            if (num1[num1.size()- a] - '0' +
                num2[num2.size()- a] - '0'
                + carry == 3) {
                total = "1" + total;
                carry = 1;
            }
            else if (num1[num1.size()- a] - '0' +
                     num2[num2.size()- a] - '0'
                     + carry == 2) {
                total = "0" + total;
                carry = 1;


            }else if(num1[num1.size()- a] - '0' +
                     num2[num2.size()- a] - '0'
                     + carry == 1) {
                total = "1" + total;
                carry = 0;

            }else{
                total = "0" + total;
                carry = 0;
            }
            if (a == num1.size() && carry == 1)
                total = "1" + total;
        }
    } else if(num1.size() < num2.size()){
        unsigned int a = 1;
        for(; a <= num1.size(); a++) {

            if (num1[num1.size()- a] - '0' +
                num2[num2.size()- a] - '0'
                + carry == 3) {
                total = "1" + total;
                carry = 1;
            }
            else if (num1[num1.size()- a] - '0' +
                     num2[num2.size()- a] - '0'
                     + carry == 2) {
                total = "0" + total;
                carry = 1;
            }else if(num1[num1.size()- a] - '0' +
                     num2[num2.size()- a] - '0'
                     + carry == 1) {
                total = "1" + total;
                carry = 0;

            }else{
                total = "0" + total;
                carry = 0;
            }
        }
        for(; a <= num2.size(); a++) {
            if (num2[num2.size()- a] - '0'
                + carry == 3) {
                total = "1" + total;
                carry = 1;
            }
            else if (num2[num2.size()- a] - '0'
                     + carry == 2) {
                total = "0" + total;
                carry = 1;
            }else if(num2[num2.size()- a] - '0'
                     + carry == 1) {
                total = "1" + total;
                carry = 0;

            }else{
                total = "0" + total;
                carry = 0;
            }
            if(a == num2.size() && carry == 1){
                total = "1" + total;
            }
        }

    } else{
        unsigned int a = 1;
        for(; a <= num2.size(); a++) {

            if (num1[num1.size()- a] - '0' +
                num2[num2.size()- a] - '0'
                + carry == 3) {
                total = "1" + total;
                carry = 1;
            }
            else if (num1[num1.size()- a] - '0' +
                     num2[num2.size()- a] - '0'
                     + carry == 2) {
                total = "0" + total;
                carry = 1;
            }else if(num1[num1.size()- a] - '0' +
                     num2[num2.size()- a] - '0'
                     + carry == 1) {
                total = "1" + total;
                carry = 0;

            }else{
                total = "0" + total;
                carry = 0;
            }
        }
        for(; a <= num1.size(); a++) {
            if (num1[num1.size()- a] - '0'
                + carry == 3) {
                total = "1" + total;
                carry = 1;
            }
            else if (num1[num1.size()- a] - '0'
                     + carry == 2) {
                total = "0" + total;
                carry = 1;
            }else if(num1[num1.size()- a] - '0' + carry == 1) {
                total = "1" + total;
                carry = 0;

            }else{
                total = "0" + total;
                carry = 0;
            }
            if(a == num1.size() && carry == 1){
                total = "1" + total;
            }
        }

    }
    cout << "Sum: " << total << endl;

    return 0;
}
