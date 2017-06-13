package com.sms.Physical;

import com.sms.FileIO.Sort;
import com.sms.EditType.CompareResult;
import java.io.Serializable;
import java.util.UUID;

public class Order implements Comparable<Object> {
//About ordering:
//1.	pcode (string): the code of the product to be ordered.
//2.	ccode (string): the code of the customer.
//3.	quantity (integer): the number of  ordered products.

    public String pcode;
    public String ccode;
    public Integer quantity;

    public Order(){
        
    }
    
    public String getCombineCode(){
        return pcode + ccode;
    }

    @Override
    public int compareTo(Object other) {
        Order orderOther = (Order)other;
        return Sort.compareString(this.getCombineCode(), orderOther.getCombineCode());
    }

}
