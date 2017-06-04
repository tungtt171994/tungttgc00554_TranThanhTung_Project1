package com.sms.Physical;

import com.sms.FileIO.Helper;
import com.sms.EditType.CompareResult;
import java.io.Serializable;

public class Product implements Comparable{
//About a product:
//1.	pcode (string): the code of the product (this should be unique for the product).
//2.	pro_name (string): the name of the product.
//3.	quantity (integer): the number of  products with the same code in a shop at beginning of a day.
//4.	saled (integer): the number of  products with the same code, which are saled in the day. Condition: saled ≤ quantity.
//5.	price (double): The price of the product.

    public String pcode;
    public String pro_name;
    public Integer quantity;
    public Integer saled;
    public double price;

    public Product(){
    }
    
        public Product(String pcode){
        this.pcode = pcode;
    }

    @Override
    public int compareTo(Object other) {
        return Helper.compareString(this.pcode, ((Product)other).pcode);
    }


}
