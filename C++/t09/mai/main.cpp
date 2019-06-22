#include <iostream>
#include <string>
using namespace std;

bool failfinder(string s){
    int scounter = 0;
    int wcounter = 0;
    for(unsigned int a = 0 ; a < s.size() ; a++ ){
        if(s.at(a) == ' '){
            scounter++;
        }
        else{
            wcounter++;
        }
    }
    if(scounter == 2 && wcounter > 2 && s.at(0) != ' ' && s.at(s.size() - 1) != ' '){
        return true;
    }
    return false;
}

string lowerize(string s){
    string tmp = "";
    char x;
    for(unsigned int a = 0 ; a < s.size() ; a++){
        if( s.at(a) >= 'A' && s.at(a) <= 'Z'){
            x = s.at(a) + 32;
            tmp = tmp + x;
        }else
            tmp = tmp + s.at(a);
    }
    return tmp;
}

int main() {
    int spacelocation;
    string input,w1 = "",w2 = "",w3 = "";
    cout << "Enter the 3 words:" << endl;
    getline(cin, input);

    if(!failfinder(input)){
        cout << "Invalid input." << endl;
        return 0;
    }


    for(unsigned int a = 0 ; a < input.size() ; a++){
        if( input.at(a) == ' '){
            spacelocation = a;
            break;
        }
        w1 = w1 + input.at(a);
    }
    for(unsigned int a = spacelocation + 1 ; a < input.size() ; a++){
        if( input.at(a) == ' '){
            spacelocation = a;
            break;
        }
        w2 = w2 + input.at(a);
    }
    for(unsigned int a = spacelocation + 1 ; a < input.size() ; a++){
        if( input.at(a) == ' '){
            spacelocation = a;
            break;
        }
        w3 = w3 + input.at(a);
    }

    w1 = lowerize(w1);
    w2 = lowerize(w2);
    w3 = lowerize(w3);

    if (w1 == w2)
        cout << "Word1 and word2 are the same." << endl;
    else
        cout << "Word1 and word2 are not the same." << endl;

    if (w1 == w3)
        cout << "Word1 and word3 are the same." << endl;
    else
        cout << "Word1 and word3 are not the same." << endl;

    if (w2 == w3)
        cout << "Word2 and word3 are the same." << endl;
    else
        cout << "Word2 and word3 are not the same." << endl;

    cout << "The number of characters in word1 is: " << w1.size() << endl;
    cout << "The number of characters in word2 is: " << w2.size() << endl;
    cout << "The number of characters in word3 is: " << w3.size() << endl;
    return 0;
}
