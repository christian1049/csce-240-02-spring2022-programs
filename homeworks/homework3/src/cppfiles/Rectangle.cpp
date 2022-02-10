#include "../headers/Rectangle.h"
#include <string>
    Rectangle::Rectangle(){

    }
    double Rectangle::getArea(int n1, int n2){
        double result = n1 *n2;
        return result;
    }
    double Rectangle::getPerimeter(int n1, int n2){
        double result = 2 * (n1 + n2);
        return result;
    }
    string Rectangle::errorMessage(){
        return "Error";
    }
Rectangle::~Rectangle(){
    
}