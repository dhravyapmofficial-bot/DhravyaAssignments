package org.testleaf.week4day1assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

    public static void main(String[] args) {
        String company[]={"HCL","Wipro","Aspire sytems","CTS"};

        List<String> companyList=new ArrayList<String>();
        Collections.addAll(companyList, company);

        Collections.sort(companyList);

        for(int i=companyList.size()-1;i>=0;i--){
            System.err.print(companyList.get(i)+" ");
        }
        


    }

}

