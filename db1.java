package sqlapp;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.sqlite.JDBC;

public class exampledb {
	
	  	private static String url1 = "jdbc:sqlite:D:/Other/Downloads/SQLiteStudio/exampledb";
	    private static exampledb instance = null;
	    public static synchronized exampledb getInstance() throws SQLException {
	        if (instance == null)
	            instance = new exampledb();
	        return instance;
	    }
	  	private Connection connection;
	    private exampledb() throws SQLException {
	        // ������������ �������, � ������� ����� ��������
	        // � ����� ������ Sqlite
	        DriverManager.registerDriver(new JDBC());
	        // ��������� ����������� � ���� ������
	        this.connection = DriverManager.getConnection(url1);
	    }
	    public  static int insert(users users) {
	        /*try (PreparedStatement statement = this.connection.prepareStatement(
                    "INSERT INTO users (Name, Surname, Patronymic, City, Street, Telnumber, Email, Wifi_router,MobileInternet, TV) Values (?,?,?,?,?,?,?,?,?,?)")) {
	        		statement.setObject(1, users.getName());
	        		statement.setObject(2, users.getSurname());  
	        		statement.setObject(3, users.getPatronymic());
	        		statement.setObject(4, users.getCity());  
	        		statement.setObject(5, users.getStreet());  
	        		statement.setObject(6, users.getTelnumb());  
	        		statement.setObject(7, users.getEmail());  
	        		statement.setObject(8, users.getWifi());  
	        		statement.setObject(9, users.getMobileinternet());  
	        		statement.setObject(10, users.getTV()); 
		        // ��������� ������
        statement.execute();*/
	    	try{
	            Class.forName("org.sqlite.JDBC").getDeclaredConstructor().newInstance();
	            try (Connection conn = DriverManager.getConnection(url1))
	            { 
	                String sql = "INSERT INTO users (Name, Surname, Patronymic, City, Street, Telnumber, Email, Wifi_router,MobileInternet,TV,Password) Values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
	                    preparedStatement.setString(1, users.getName());
	                    preparedStatement.setString(2, users.getSurname());  
	                    preparedStatement.setString(3, users.getPatronymic());
	                    preparedStatement.setString(4, users.getCity());  
	                    preparedStatement.setString(5, users.getStreet());  
	                    preparedStatement.setString(6, users.getTelnumb());  
	                    preparedStatement.setString(7, users.getEmail());  
	                    preparedStatement.setString(8, users.getWifi());  
	                    preparedStatement.setString(9, users.getMobileinternet());  
	                    preparedStatement.setString(10, users.getTV());
	                    preparedStatement.setString(11, users.getPassowrd());
	                    return  preparedStatement.executeUpdate();
	                }
	            }
	        }
	        catch(Exception ex){
	            System.out.println(ex);
	        }
	        return 0;
	    }
	    
}
