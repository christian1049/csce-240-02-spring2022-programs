#ifndef RECTANGLE_H_
#define RECTANGLE_H_

#include "Shape.h"

class Rectangle: public Shape 
{
    public:
        Rectangle();
        double getArea(int n1, int n2);
        double getPerimeter(int n1, int n2);
        string errorMessage();
        virtual ~Rectangle();
};
#endif