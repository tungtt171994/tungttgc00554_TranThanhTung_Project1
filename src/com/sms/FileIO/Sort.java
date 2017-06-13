package com.sms.FileIO;

import com.sms.EditType.CompareResult;
import com.sms.Physical.Customer;
import com.sms.Physical.Product;
import java.util.ArrayList;
import java.util.Random;

public class Sort {
    //QuickSort
    public static <T> void quicksort(ArrayList<T> array) 
    {
        realQuicksort(array, 0, array.size()-1);
    }
    
    private static <T> void realQuicksort(ArrayList<T> array,int left, int right)
    {
        
        if(left >= right) 
        {
            return;
        }
        T pivot = array.get((left + right)/2);
        int index = partition(array, left, right,pivot);
        realQuicksort(array, left, index -1);
        realQuicksort(array, index, right);
    }
    
    private static <T> int partition(ArrayList<T> array, int left, int right, Object pivot) 
    {
          
        while(left <= right)
        {
            
            while(((Comparable)array.get(left)).compareTo(pivot) == CompareResult.LESS)
            {
                left ++;
            }
            
            while(((Comparable)array.get(right)).compareTo(pivot) == CompareResult.GREATER)
            {
                right --;
            }
            
             if(left <= right)
             {
                 swap(array, left, right);
                 
                 left++;
                 right--;
             }
        }
        
        return left;
    }
    
    public static <T> int binarysreach(ArrayList<T> array, T fakeDataWithCode)
    {
        return realBinarysreach(array,fakeDataWithCode,0,array.size());
    }
    
    private static <T> int realBinarysreach(ArrayList<T> array, T fakeDataWithCode, int left, int right)
    {
        
        System.out.println("Size: "+array.size() + " - Left: " + left + " - Right: " + right);
         
        if(left > right)
        {
            return -1;
        }
        
        int middle = (left + right)/2;
        System.out.println("Middle: " + middle);
        int compareResult = ((Comparable)array.get(middle)).compareTo(fakeDataWithCode);
        
        if(compareResult == CompareResult.EQUAL)
        {
            return middle;
        }else if(compareResult == CompareResult.GREATER){
            return realBinarysreach(array, fakeDataWithCode, left, middle -1);
            
        }else{
            return realBinarysreach(array, fakeDataWithCode, middle + 1, right);
        }
    }
    //Xáo trộn data khi load file
    public static <T> void shuffleArray(ArrayList<T> array) 
    {
        int n = array.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(array, i, change);
        }
    }
    

    private static <T> void swap(ArrayList<T> array, int i, int change) {
        T cacheData = array.get(i);
        array.set(i, array.get(change));
        array.set(change, cacheData);
    }
    //So sánh bảng sửa và tạo mới
    public  static int compareString(String a, String b){
        int result = a.compareTo(b);
        if(result > 0){
            return CompareResult.GREATER;
        }else if(result < 0){
            return CompareResult.LESS;
        }else{
             return CompareResult.EQUAL;
        }
    }
    
    public static Customer getCustomerByCode(ArrayList<Customer> customers,String code){
        int result = Sort.binarysreach(customers,new Customer(code));
        
        if(result == -1) return null;
        
        return customers.get(result);

    }
    
    public static int getIndexCustomerByCode(ArrayList<Customer> customers,String code){
        int result = Sort.binarysreach(customers,new Customer(code));
        
        return result;
    }
    
    public static Product getProductByCode(ArrayList<Product> products,String code){
        int result = Sort.binarysreach(products,new Product(code));
        
        if(result == -1) return null;
        
        return products.get(result);

    }
    
    public static int getIndexProductByCode(ArrayList<Product> products,String code){
        int result = Sort.binarysreach(products,new Product(code));
        
        return result;
    }
}
  