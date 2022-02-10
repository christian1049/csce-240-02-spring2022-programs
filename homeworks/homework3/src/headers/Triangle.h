#ifndef TRIANGLE_H_
#define TRIANGLE_H_

#include "Shape.h"

class Triangle: public Shape 
{
    public:
        Triangle();
        double getArea(int n1, int n2, int n3);
        double getPerimeter(int n1, int n2, int n3);
        string errorMessage();
        virtual ~Triangle();
};
#endif