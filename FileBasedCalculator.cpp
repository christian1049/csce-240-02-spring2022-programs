#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main(){
    cout << "File based Calculator \n";

    string operation;
    string digit1;
    string digit2;
    string out_file_name = "output.txt";
    double num1;
    double num2;
    double result;
    
    ifstream myfile;
    ofstream out_myfile(out_file_name);

    myfile.open("C:\\Users\\chris\\OneDrive\\Desktop\\input.txt");

    if(myfile.is_open()){
        if(out_myfile.is_open()){
            getline(myfile, operation);
            getline(myfile, digit1);
            getline(myfile, digit2);
        
            num1 = stoi(digit1);
            num2 = stoi(digit2);

            if(operation == "add"){
                result = num1 + num2;
                operation = "adding";
            }
            else if(operation == "subtract"){
                result = num1 - num2;
                operation = "subtracting";
            }
            else if(operation == "multiply"){
                result = num1 * num2;
                operation = "multiplying";
            }
            else if(operation == "divide"){
                result = num1 / num2;
                operation = "dividing";
            }
            out_myfile << "The result of " << operation << " on " << num1 << " and " << num2 << " is below \n";
            out_myfile << result;

            myfile.close();
            out_myfile.close();
        }
    }
    else 
		cout << "Unable to open file - " << endl;
}