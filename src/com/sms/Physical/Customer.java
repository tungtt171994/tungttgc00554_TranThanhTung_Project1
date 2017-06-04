package com.sms.Physical;

import com.sms.FileIO.Helper;
import com.sms.EditType.CompareResult;
import java.io.Serializable;
import java.util.UUID;

public class Customer implements Comparable<Object>{
//About a customer:
//1.	ccode (string): the code of the customer (this should be unique for the customer).
//2.	cus_name (string): the name of the customer.
//3.	phone (string): The phone number of the customer (must contain digits only).

    public String ccode;
    public String cus_name;
    public String phone;

    public Customer(String ccode) {
        this.ccode = ccode;
    }
    
    public Customer(){
//        this.ccode = Helper.getCode();
    }

    @Override
    public int compareTo(Object other) {
         return Helper.compareString(this.ccode, ((Customer)other).ccode);
    }
}
