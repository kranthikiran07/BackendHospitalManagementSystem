package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class patient {
    private Connection connection;
    private Scanner scanner;

    public patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient() {
        System.out.println("Enter Patient name: ");
        String name = scanner.next();
        System.out.println("Enter Patient age: ");
        int age = scanner.nextInt();
        System.out.println("Enter Patient gender: ");
        String gender = scanner.next();
        try {
            String query = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3,gender);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("patient Added Successfully!!");
            } else {
                System.out.println("Failed to add Patient!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
         public void viewPatients(){
            String query="select * from patients";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(query);
                 ResultSet resultset=preparedStatement.executeQuery();
                System.out.println("Patients:");
                System.out.println("+------------+----------------------+------+------------+");
                System.out.println("| Patient ID | Name                 | Age  | Gender     |");
                System.out.println("+------------+----------------------+------+------------+");

                while (resultset.next()) {
                    int id =resultset.getInt("id");
                    String name =resultset.getString("name");
                    int age = resultset.getInt("age");
                    String gender = resultset.getString("gender");

                    System.out.printf("| %-10d | %-20s | %-4d | %-10s |\n", id, name, age, gender);
                    System.out.println("+------------+----------------------+------+------------+");
                }


            } catch (SQLException e){
                e.printStackTrace();
            }

        }
        public boolean getPatientById(int id){
        String query="SELECT * FROM patients WHERE id = ?";
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
