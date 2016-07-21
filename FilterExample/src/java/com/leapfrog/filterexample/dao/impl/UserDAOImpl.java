/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.filterexample.dao.impl;

import com.leapfrog.filterexample.constant.DBConstant;
import com.leapfrog.filterexample.constant.SQLConstant;
import com.leapfrog.filterexample.dao.UserDAO;
import com.leapfrog.filterexample.dbutil.DbConnection;
import com.leapfrog.filterexample.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rajesh
 */
public class UserDAOImpl implements UserDAO{
    private DbConnection db = new DbConnection();

    @Override
    public int insert(User user) throws ClassNotFoundException, SQLException {
        db.open();
        PreparedStatement stmt =  db.initStatement(SQLConstant.USER_INSERT);
        stmt.setString(1, user.getUserName());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getEmail());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public User login(String userName, String password) throws ClassNotFoundException, SQLException {
        for(User u: getAll()) {
            if(u.getUserName().equals(userName) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    @Override
    public User getById(int id) throws ClassNotFoundException, SQLException{
        for(User u: getAll()){
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() throws ClassNotFoundException, SQLException {
        List<User> userList = new ArrayList<>();
        db.open();
        db.initStatement(SQLConstant.USER_GETALL);
        ResultSet rs = db.executeQuery();
        while(rs.next()){
            User objUser = new User();
            objUser.setId(rs.getInt("id"));
            objUser.setUserName(rs.getString("userName"));
            objUser.setPassword(rs.getString("password"));
            objUser.setEmail(rs.getString("email"));
            userList.add(objUser);
        }
        db.close();
        return userList;
    }
    
}
