#include <iostream>
#include <string>

using namespace std;
double print(double taxRate, string state, string county, string city){
    cout << "Your tax rate was " << taxRate;
    cout << "\nYou federal tax rate was .02 Your state tax rate was "<< state << ", county tax was " << county << "and city tax was " << city;
}

int main(){
double income = 10000;
double taxRate = 0;
string state;
string county;
string city;

cout << "What state do you live in";
cin >> state;

cout << "What county do you live in";
cin >> county;

cout << "What city do you live in";
cin >> city;

if (state == "S1"){
    taxRate = .2+.1;
}
else if(state =="S2"){
    taxRate = .2+.05;
}

if (county == "03"){
    taxRate += .01;
}

if(city == "C1"){
    taxRate += .01;
}
else if(city == "C2"){
    taxRate += .01;
}
else if(city == "C3"){
    taxRate += .01;
}
print(taxRate, state, county, city);
}

