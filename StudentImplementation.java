package studentDatabase.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImplementation implements StudentInterface{
	Scanner scanner=new Scanner(System.in);
	@Override
	public void saveStudent() {
		System.out.println("Enter ID:");
		int id=scanner.nextInt();
		System.out.println("Enter NAME:");
		String name=scanner.next();
		System.out.println("Enter AGE:");
		int age=scanner.nextInt();
		System.out.println("Enter MARKS:");
		double marks=scanner.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into studentdetails values(?,?,?,?)");
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setInt(3,age);
			preparedStatement.setDouble(4,marks);
			preparedStatement.execute();
			connection.close();
			System.out.println("DATA SAVED");
			System.out.println("*********************************");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent() {
		System.out.println("Enter student ID to be Deleted:");
		int id=scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("delete from studentdetails where id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.execute();
			connection.close();
			System.out.println("DATA DELETED");
			System.out.println("*********************************");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter student MARKS to be Updated:");
		double marks=scanner.nextDouble();
		System.out.println("Enter ID to which Marks to be Updated:");
		int id=scanner.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("update studentdetails set marks=? where id=?");
			preparedStatement.setDouble(1,marks);
			preparedStatement.setInt(2,id);
			preparedStatement.execute();
			connection.close();
			System.out.println("DATA UPDATED");
			System.out.println("*********************************");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void getStudentByMarks() {
		System.out.println("Enter student MARKS to whos details to be Fetched:");
		double marks=scanner.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from studentdetails where marks=?");
			preparedStatement.setDouble(1,marks);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Id is:"+resultSet.getInt(1));
				System.out.println("Name is:"+resultSet.getString(2));
				System.out.println("Age is:"+resultSet.getInt(3));
				System.out.println("Marks is:"+resultSet.getDouble(4));
				System.out.println("-------------------");
			}
			connection.close();
			System.out.println("DATA Fetched");
			System.out.println("*********************************");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from studentdetails");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Id is:"+resultSet.getInt(1));
				System.out.println("Name is:"+resultSet.getString(2));
				System.out.println("Age is:"+resultSet.getInt(3));
				System.out.println("Marks is:"+resultSet.getDouble(4));
				System.out.println("-------------------");
			}
			connection.close();
			System.out.println("DATA Fetched");
			System.out.println("*********************************");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
