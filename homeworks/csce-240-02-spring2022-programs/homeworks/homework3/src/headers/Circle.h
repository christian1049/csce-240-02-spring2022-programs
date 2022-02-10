#ifndef CIRCLE_H_
#define CIRCLE_H_

#include "Shape.h"

class Circle: public Shape 
{
    public:
        Circle();
        double getArea(int n1);
        double getPerimeter(int n1);
        string errorMessage();
        virtual ~Circle();
};
#endif