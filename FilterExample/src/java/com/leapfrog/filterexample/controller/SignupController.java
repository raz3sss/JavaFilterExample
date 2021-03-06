/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.filterexample.controller;

import com.leapfrog.filterexample.dao.UserDAO;
import com.leapfrog.filterexample.dao.impl.UserDAOImpl;
import com.leapfrog.filterexample.entity.User;
import com.leapfrog.filterexample.system.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rajesh
 */
public class SignupController extends Controller{
    
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User objUser = new User();
        objUser.setUserName(request.getParameter("username"));
        objUser.setPassword(request.getParameter("password"));
        objUser.setEmail(request.getParameter("email"));
        try {
            if(userDAO.insert(objUser)>0){
                
                request.getRequestDispatcher("/WEB-INF/views/default.jsp").forward(request, response);
            }
            else{
                
                request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
    }
    
}
