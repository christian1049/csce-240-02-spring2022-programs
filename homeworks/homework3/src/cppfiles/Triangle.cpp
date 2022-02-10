#include "../headers/Triangle.h"
#include <cmath>
#include <string>

    Triangle::Triangle(){

    }
    double Triangle::getArea(int n1, int n2, int n3){
        double result = .25 * sqrt((n1 + n2 + n3) * (-n1 + n2 + n3) * (n1 - n2 + n3) * (n1 + n2 - n3));
        return result;
    }
    double Triangle::getPerimeter(int n1, int n2, int n3){
        double result = n1 + n2 + n3;
        return result;
    }
    string Triangle::errorMessage(){
        return "Error!!";
    }
Triangle::~Triangle(){

}
