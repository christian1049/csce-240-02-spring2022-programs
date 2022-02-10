#include "../headers/Circle.h"
#include <string>
    Circle::Circle(){

    }
    double Circle::getArea(int n1){
        double result = 3.14 * n1 * n1;
        return result;
    }
    double Circle::getPerimeter(int n1){
        double result = 2 * 3.14 * n1;
        return result;
    }
    string Circle::errorMessage(){
        return "Erro!r";
    }
Circle::~Circle(){
    
}