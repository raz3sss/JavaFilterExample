/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.filterexample.constant;

/**
 *
 * @author Rajesh
 */
public class SQLConstant {
    
    public static final String USER_INSERT = "INSERT INTO " + TableConstant.TABLE_USER +
    "(userName, password, email) VALUES (?,?,?)"; 
    
    public static final String USER_GETALL =  "SELECT * FROM " + TableConstant.TABLE_USER;
    
}
