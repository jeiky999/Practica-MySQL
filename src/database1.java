import java.sql.*;

public class database1{
	
	public static void main (String args[]) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/myDatabase";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} 
		catch (ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Error loading driver");
		}
		
		try {
			Connection c = DriverManager.getConnection(dbUrl, user, password);
			Statement s = c.createStatement();
			
			ResultSet r = s.executeQuery("SELECT Nume,Prenume, Varsta FROM myTable");
			System.out.println("Nume | Prenume | Varsta");
			System.out.println("-----------------------");
			
			while(r.next()) {
				
				System.out.println(r.getString(1) + "|" + r.getString(2) + "|" + r.getInt("Varsta"));
				
			}
			
			r.close();
			s.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
