package com.day6;

import static org.junit.jupiter.api.Assertions.*;

import com.day6.searchatarget.SearchATarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TestSearchATarget {
    //declaring array
    private int [] dataset = new int [1000];

    //for each dataset value
    @BeforeEach
    public void setUp(){
        //initialising dataset with sorted values
        for(int i =0;i< dataset.length;i++){
            dataset[i] =i;
        }
    }

    //testing for two test cases in linear search
    @Test
    void testLinearSearchFound(){
        int target =500;
        int result = SearchATarget.linearSearch(dataset,target);
        assertEquals(target,result, "Target found");
    }

    @Test
    void testLinearSearchotFound(){
        int target = 1001;
        int result = SearchATarget.linearSearch(dataset,target);
        assertEquals(-1,result,"Target Not Found ");
    }

    //testing two cases for linear search
    @Test
    void testBinarySearchFound(){
        int target = 888;
        int result = SearchATarget.binarySearch(dataset,target);
        assertEquals(target , dataset[result],"Target Found");
    }

    @Test
    void testBinarySearchNotFound(){
        int target = 2000;
        int result = SearchATarget.binarySearch(dataset,target);
        assertEquals(-1 , dataset[result],"Target Not Found");
    }

    //test for returning first and last index inside binary array
    @Test
    void findFirstIndex(){
        int target =0;
        int result = SearchATarget.binarySearch(dataset,target);
        assertEquals(target,dataset[result], "First index is ");
    }

    @Test
    void lastFirstIndex(){
        int target = dataset.length-1;
        int result = SearchATarget.binarySearch(dataset,target);
        assertEquals(target,dataset[result], "Last index is ");
    }

}