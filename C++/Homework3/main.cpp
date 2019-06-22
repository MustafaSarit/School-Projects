#ifndef _PROGTEST_
#include <cstdio>
#include <cstdlib>
#include <cctype>
#include <cstring>
#include <iostream>
#include <iomanip>
#include <fstream>
#include <sstream>
#include <string>
//
#include <vector>
#include <math.h>
using namespace std;

#define EASTER_OK                0
#define EASTER_INVALID_FILENAME  1
#define EASTER_INVALID_YEARS     2
#define EASTER_IO_ERROR          3


#endif /* _PROGTEST_ */

struct date{
    int day;
    int month;
    int year;
};

date easterfinder(int year){
    date easter;
    easter.year = year;
    int A,B,C,D,E,F,G,H,K,L,M,N,I,P;
    A = year % 19;
    B = year / 100;
    C = year % 100;
    D = B / 4;
    E = B % 4;
    F = (B + 8) / 25;
    G = (B - F + 1) / 3;
    H = ((19 * A) + (B)-(D)-(G) + 15) % 30;
    I = C / 4;
    K = C % 4;
    L = ((2 * E) + (2 * I)-(K)-(H) + 32) % 7;
    M = (A + (11 * H) + (22 * L)) / 451;
    N = (H + L - (7 * M) + 114) / 31;
    P = (H + L - (7 * M) + 114) % 31;
    easter.month = N;
    easter.day = P + 1;
    return easter;
}
bool isNumber(char a){
    if(a >= '0' && a <= '9')
        return 1;
    return 0;
}
bool isAlpha(char a){
    if( (a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z') )
        return 1;
    return 0;
}
/*bool isValidYear(const char * years){
    for(unsigned int a = 0 ; a < strlen(years) ; a++){
        int year = 0;
        if(isNumber(years[a])){
            if( !isNumber(years[a + 1]) || !isNumber(years[a + 2]) || !isNumber(years[a + 3]) )
                return 0;
            year = (years[a] - '0') * 1000 + (years[a + 1] - '0') * 100 + (years[a + 2] - '0') * 10 + (years[a + 3] - '0');
            if(year < 1582 || year > 2200)
                return 0;
            year = 0;
            a += 3;
        }
    }
    return 1;
} */


bool isValidFilename(const char * outFileName){
    if(!(outFileName[strlen(outFileName) - 5] == '.' && outFileName[strlen(outFileName) - 4] == 'h' && outFileName[strlen(outFileName) - 3] == 't' && outFileName[strlen(outFileName) - 2] == 'm' && outFileName[strlen(outFileName) - 1] == 'l') ){
        return 0;
    }
    for(unsigned int a = 0 ; a < strlen(outFileName) ; a++){
        if( !isNumber(outFileName[a]) && !isAlpha(outFileName[a]) && outFileName[a] != '.' && outFileName[a] != '/' && outFileName[a] != '\\'){
            return 0;
        }
    }

    return 1;
}

int stringtointeger(string s){
    int integer = 0;
    for(unsigned long a = s.length() ; a >= 1 ; a--){
        integer += (s.at(a - 1) - '0') * pow(10, (s.length() - a));
    }
    return integer;
}

string spacecleaner(const char * years){
    string s = "";
    for(unsigned int a = 0; a < strlen(years) ; a++)
        if(years[a] != ' ')
            s += years[a];
    return s;
}
vector<int> yearprogresser(const char * years){
    string yearsstring = spacecleaner(years);
    vector<int> yearslist;
    string single = "";
    for( unsigned int n = 0 ; 5 * n < yearsstring.size() ; n++){
        if( n == 0 ){
            single += yearsstring[0];
            single += yearsstring[1];
            single += yearsstring[2];
            single += yearsstring[3];
            if(yearsstring[4] == '-'){
                int y1,y2;
                y1 = stringtointeger(single);
                single = "";
                single += yearsstring[5];
                single += yearsstring[6];
                single += yearsstring[7];
                single += yearsstring[8];
                y2 = stringtointeger(single);
                if(yearsstring[9] == '-')
                    return yearslist;
                for(int i = y1 ; i < y2 + 1 ; i++)
                    yearslist.push_back(i);
                single = "";
                continue;
            }else{
                yearslist.push_back(stringtointeger(single));
            }
            single = "";
        }else if(yearsstring.at((5*n) - 1) == ','){
            if((5*(n+1)) - 1 == yearsstring.size() || yearsstring.at((5*(n+1)) - 1) == ',' ){
                single += yearsstring.at(5 * n);
                single += yearsstring.at( (5 * n) + 1 );
                single += yearsstring.at( (5 * n) + 2 );
                single += yearsstring.at( (5 * n) + 3 );
                yearslist.push_back(stringtointeger(single));
                single = "";
            }else if(yearsstring.at((5*(n+1)) - 1) == '-' ){
                int y1,y2;
                single += yearsstring.at(5 * n);
                single += yearsstring.at( (5 * n) + 1 );
                single += yearsstring.at( (5 * n) + 2 );
                single += yearsstring.at( (5 * n) + 3 );
                y1 = stringtointeger(single);
                single = "";
                single += yearsstring.at(5 * (n + 1) );
                single += yearsstring.at( (5 * (n + 1) ) + 1 );
                single += yearsstring.at( (5 * (n + 1) ) + 2 );
                single += yearsstring.at( (5 * (n + 1) ) + 3 );
                y2 = stringtointeger(single);
                for(int i = y1 ; i < y2 + 1 ; i++)
                    yearslist.push_back(i);
                n++;
                single = "";
            }
        }
    }

    return yearslist;
}
bool isValidYear(const char * years){
    for(unsigned int a = 0 ; a < strlen(years) ; a++){
        int year = 0;
        if( isNumber(years[a]) ){
            if( !isNumber(years[a+1]) || !isNumber(years[a+2]) || !isNumber(years[a+3])){
                return 0;
            }else{
                year += (years[a]-'0') * 1000 + (years[a+1]-'0') * 100 + (years[a+2]-'0') * 10 + (years[a+3]-'0');
                if(year < 1582 || year > 2200)
                    return 0;
            }
            a += 3;
        }
    }

    string single = "";
    for(unsigned int a = 0 ; a < strlen(years) ; a++){
        if( years[a] == ',' || a == strlen(years) - 1 ){
            if(a == strlen(years) - 1)
                single += years[a];
            if( single == "" ||
               single.at(0) == '-' ||
               single[single.size() - 1] == '-' ){
                return 0;
            }
            single = "";
        }else{
            if(years[a] != ' ')
                single += years[a];
        }
    }

    string clean = spacecleaner(years);
    for(unsigned int a = 0 ; a < clean.size() ; a++){
        if(clean.at(a) == '-'){
            string number = "";
            number = number + clean.at(a-4)+ clean.at(a-3)+ clean.at(a-2)+ clean.at(a-1);
            int y1 = stringtointeger(number);
            number = "";
            number = number + clean.at(a + 1) + clean.at(a+2) + clean.at(a+3) + clean.at(a+4);
            int y2 = stringtointeger(number);
            if(y1 > y2)
                return 0;
        }
    }
    if(clean == "")
        return 0;
    else{
        for(unsigned int b = 0 ; b < clean.size() ; b++){
            if(isNumber(clean.at(b)))
                return 1;
            return 0;
        }
    }
    return 1;
}

string months(int i){
    switch (i) {
        case 3:
            return "March";
        case 4:
            return "April";
        default:
            break;
    }
    return "";
}

string dateprinter(date a){
    return "<tr><td>" + to_string(a.day)  + "</td><td>" + months(a.month) + "</td><td>" + to_string(a.year) + "</td></tr>\n";
}

int easterReport ( const char * years, const char * outFileName )
{
    if(!isValidFilename(outFileName))
        return EASTER_INVALID_FILENAME;
    for(unsigned int a = 0 ; a < strlen(years) ; a++){
        if( !isNumber(years[a]) && years[a] != ',' && years[a] != '-' && years[a] != ' ' )
            return EASTER_INVALID_YEARS;
    }
    for(unsigned int i = 0; i < strlen(years); i++){
        if(isNumber(years[i]))
            break;
        if(i == strlen(years))
            return EASTER_INVALID_YEARS;
    }
    if(!isValidYear(years))
        return EASTER_INVALID_YEARS;

    vector<int> yearlist = yearprogresser(years);
    if(yearlist.size() == 0)
        return EASTER_INVALID_YEARS;
    ofstream output;
    output.open(outFileName);
    if(output.bad() || output.fail())
        return EASTER_IO_ERROR;
    output << "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n<title>C++</title>\n</head>\n<body>\n<table width=\"300\">\n<tr><th width=\"99\">day</th><th width=\"99\">month</th><th width=\"99\">year</th></tr>\n";
    for(int year:yearlist){
        output << dateprinter(easterfinder(year));
    }
    output << "</table>\n</body>\n</html>";
    output.close();

    return EASTER_OK;
}

#ifndef _PROGTEST_
int main ( int argc, char * argv[] )
{
    cout << easterReport( "2012,2014-2020- 2022", "out0.html" );
    cout << easterReport( "-2000", "out1.html" );
    cout << easterReport( "2001 , 2002  ,  2003 ,2005,2006", "out2.html" );
    cout << easterReport( "2000,2011,2010-2020", "out3.html" );
    cout << easterReport( "2000-3000", "out4.html" );
    return 0;
}
#endif /* _PROGTEST_ */
