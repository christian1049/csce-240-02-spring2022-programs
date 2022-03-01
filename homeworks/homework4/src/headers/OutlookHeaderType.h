#ifndef OUTLOOKHEADERTYPE_H_
#define OUTLOOKHEADERTYPE_H_

#include "BaseEmailHeaderType.h"

class OutlookHeaderType: public BaseEmailHeaderType 
{
    public:
        OutlookHeaderType();
        void getInfo();   
        virtual~OutlookHeaderType();    
};
#endif