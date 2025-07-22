package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class doctor {
    private Connection connection;


    public doctor(Connection connection) {
        this.connection = connection;

    }


    public void viewdoctors(){
        String query="select * from doctors";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultset=preparedStatement.executeQuery();
            System.out.println("doctors:");
            System.out.println("+------------+----------------------+--------------------+");
            System.out.println("| doctor ID  | Name                 | specialization     |");
            System.out.println("+------------+----------------------+--------------------+");

            while (resultset.next()) {
                int id =resultset.getInt("id");
                String name =resultset.getString("name");
                String specilization=resultset.getString("specialization");

                System.out.printf("| %-10d | %-20s | %-18s |\n", id, name,specilization);
                System.out.println("+------------+----------------------+-------------------+");
            }


        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public boolean getdoctorById(int id){
        String query="SELECT * FROM doctors WHERE id = ?";
        try{
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

