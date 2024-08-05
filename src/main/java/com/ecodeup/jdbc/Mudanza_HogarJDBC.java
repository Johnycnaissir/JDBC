package com.ecodeup.jdbc;


import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;


public class Mudanza_HogarJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mudanzahogar?serverTimezone=UTC";
        String username = "root";
        String password = "2024";

        try {

            Connection connection = getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String queryCreate = "INSERT INTO mudanzahogar values ('423', 'GONZALO', 'CALI');";
            String queryRead = "SELECT * from mudanzahogar";
            String queryUpdate = "UPDATE mudanzahogar SET id_nit = '124', nombre = 'PEDRO', ciudad = 'CARTAGENA' WHERE id_nit = '123'";
            String queryDelete = "DELETE from mudanzahogar WHERE nombre = 'GONZALO'";


            //Consulta de Registros//
            ResultSet resultSet = statement.executeQuery(queryRead);
            while(resultSet.next()){
                System.out.println (resultSet.getString("nombre"));

            }

            // Inserción de Registros //
            statement.execute(queryCreate);
            resultSet = statement.executeQuery(queryRead);
            while(resultSet.next()){
                System.out.println (resultSet.getString("nombre"));

            }

            // Actualización de Registros //
            statement.execute(queryUpdate);
            resultSet = statement.executeQuery(queryRead);
            while(resultSet.next()){
                System.out.println (resultSet.getString("nombre"));

            }

            // Eliminación de Registros //
            statement.execute(queryDelete);
            resultSet = statement.executeQuery(queryRead);
            while(resultSet.next()){
                System.out.println (resultSet.getString("nombre"));

            }





            connection.close();
            statement.close();
            //resultSet.close();
            System.out.println("Confirmo el ingreso a la Base de Datos");
        }catch (SQLException e){
            e.printStackTrace(); System.out.println("NO se puede ingresar a la Base de Datos");
        }
    }
}



