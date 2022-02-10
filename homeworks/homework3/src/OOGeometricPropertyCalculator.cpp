#include <iostream>
#include <string>
#include <fstream>
#include <cmath>

#include "cppfiles/Shape.cpp"
#include "cppfiles/Triangle.cpp"
#include "cppfiles/Rectangle.cpp"
#include "cppfiles/Circle.cpp"

using namespace std;


int main(){
    Triangle triangle;
    Rectangle rectangle;
    Circle circle;

    string operation;
    string digit1;
    string digit2;
    string digit3;
    double num1;
    double num2;
    double num3;
    double result;

    string out_file_name = "C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\homeworks\\homework3\\data\\output.txt";
    string decision;

        ifstream in_stream;
        ofstream out_stream(out_file_name);
        in_stream.open("C:\\Users\\chris\\OneDrive\\Desktop\\CSCE240\\csce-240-02-spring2022-programs\\homeworks\\homework3\\data\\input.txt");
        
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
                    if (decision == "1"){                    
                        out_stream << "Rectangle Area " << rectangle.getArea(num1, num2);
                    }else if (decision == "2")
                    {
                        out_stream << "Rectangle Perimeter " << rectangle.getPerimeter(num1,num2);
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
                        out_stream << "Circle Area " << circle.getArea(num1);
                    }
                    else if(decision == "2")
                    {
                        result = 2 * 3.14 * num1;

                        out_stream << "Circle Perimeter " << circle.getPerimeter(num1);
                    }
                    else{
                        out_stream << circle.errorMessage();
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
                        out_stream << "Triangle Area " << triangle.getArea(num1, num2, num3);
                    }
                    else if (decision == "2")
                    {
                        out_stream << "Triangle Perimeter " << triangle.getPerimeter(num1,num2,num3);
                    }
                    else{
                        out_stream << triangle.errorMessage();
                    }
                }
                in_stream.close();
                out_stream.close();
            }
        }
};

