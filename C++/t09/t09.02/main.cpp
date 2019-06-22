#include <iostream>

using namespace std;

string word1, word2, word3;
unsigned int c12 = 0, c13 = 0, c23 = 0;

void spliter(string inp){
    unsigned int a = 0, fail = 0;
    for(; a < inp.length() ; a++){
        if(inp.at(a) != ' '){
            word1 = word1 + inp.at(a);
        }else{
            a += 1;
            break;
        }
    }
    for(; a < inp.length() ; a++){
        counter += 1;
        if(inp.at(a) != ' '){
            word2 = word2 + inp.at(a);
        }else{
            a += 1;
            break;
        }
    }
    for(; a < inp.length() ; a++){
        if(inp.at(a) != ' '){
            word3 = word3 + inp.at(a);
        }else{
            fail += 1 ;
        }
    }
}


void comparison(){
    if (word1.size() == word2.size()) {
        for(unsigned int a = 0; a < word1.size(); a++)
    }
}



int main(){
    cout << "Enter the 3 words:" << endl;
    string input;
    getline(cin, input);
    spliter(input);
    comparison();

    return 0;
}
