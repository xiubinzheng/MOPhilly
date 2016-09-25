package com.xiubinzheng.util;

import java.util.Arrays;

 
public final class propertyFilterUtil {
 
    private propertyFilterUtil() { } //Prevent the class from being constructed
 
    
    /**
     * @return 
     * @possibleValues APTS 5-50 UNITS MASONRY,
     * APTS 100+ UNITS MASONRY, 2121 market street
     * NON PD PKG LOT COMMERCIAL, 
     * RES CONDO 5+ STY MAS+OTH, ex murano
     * NON PD PKG LOT COMMERCIAL, riverside condo
     * VACANT LAND RESIDE < ACRE, the old thrift store
     * ROW 2 STY MASONRY, 613 dickinson street
     * ROW 3 STY MASONRY, 613 washington ave
     * 
     * */
    public static int getPropertyType(String propertyDesc)
    {
    	if(propertyDesc.contains("VACANT LAND"))
    	{
    		return 1;
    	}
    	
    	return 0;
    }
    
    
}
