/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.scholl_web_application.data.connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jesus Gutierrez
 */
public class ConnectionDb {

    private static final String URL = "jdbc:mysql://localhost:3306/paginaweb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection connectionDb() {
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)){
            System.out.println("Se logro conectar con la base de datos");
            return connection;
        } catch (Exception e) {
            System.out.println("Se produjo un error en la conexion de con la base de datos");
            return null;
        }
    }
}