#include <iostream>
#include <string>
#include <fstream>
#include <cmath>

using namespace std;

void readFile()
{
    string operation;
    string digit1;
    string digit2;
    string digit3;
    double num1;
    double num2;
    double num3;
    double result;
    string out_file_name = "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\data\\output.txt";
    string decision;

    ifstream in_stream;
    ofstream out_stream(out_file_name);
    in_stream.open("C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\data\\input.txt");

    if (in_stream.is_open())
    {
        if (out_stream.is_open())
        {
            getline(in_stream, operation, ' ');
            if (operation == "RECTANGLE")
            {
                getline(in_stream, digit1, ' ');
                getline(in_stream, digit2, ' ');

                try
                {
                    num1 = stoi(digit1);
                    num2 = stoi(digit2);
                }
                catch (exception &err)
                {
                    cout << "Rectangle \"Not enough information to calculate\"";
                    exit(0);
                }

                cout << "What do you want to find out about this rectangle\n1.Area\n2.Perimeter\n";
                cin >> decision;
                if (decision == "1")
                {
                    result = num1 * num2;
                    out_stream << "Rectangle Area " << result;
                }
                if (decision == "2")
                {
                    result = 2 * (num1 + num2);

                    out_stream << "Rectangle Perimeter " << result;
                }
            }
            if (operation == "CIRCLE")
            {
                getline(in_stream, digit1, ' ');
                try
                {
                    num1 = stoi(digit1);
                }
                catch (exception &err)
                {
                    cout << "Circle \"Not enough information to calculate\"";
                    exit(0);
                }

                cout << "What do you want to find out about this circle\n1.Area\n2.Perimeter\n";
                cin >> decision;
                if (decision == "1")
                {
                    result = 3.14 * num1 * num1;

                    out_stream << "Circle Area " << result;
                }
                if (decision == "2")
                {
                    result = 2 * 3.14 * num1;

                    out_stream << "Circle Perimeter " << result;
                }
            }
            if (operation == "TRIANGLE")
            {
                getline(in_stream, digit1, ' ');
                getline(in_stream, digit2, ' ');
                getline(in_stream, digit3, ' ');

                try
                {
                    num1 = stoi(digit1);
                    num2 = stoi(digit2);
                    num3 = stoi(digit3);
                }
                catch (exception &err)
                {
                    cout << "Triangle \"Not enough information to calculate\"";
                    exit(0);
                }

                cout << "What do you want to find out about this triangle\n1.Area\n2.Perimeter\n";
                cin >> decision;
                if (decision == "1")
                {
                    result = .25 * sqrt((num1 + num2 + num3) * (-num1 + num2 + num3) * (num1 - num2 + num3) * (num1 + num2 - num3));
                    out_stream << "Triangle Area " << result;
                }
                if (decision == "2")
                {
                    result = num1 + num2 + num3;

                    out_stream << "Triangle Perimeter " << result;
                }
            }
            in_stream.close();
            out_stream.close();
        }
    }
}

int main()
{
    cout << "Geometric Property Calculator\n";
    readFile();
}