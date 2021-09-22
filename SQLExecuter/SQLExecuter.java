import java.sql.*;

public class SQLExecuter {
	public static void main (String args[]) {
		Connection conn = null;
		try {
			String userName = args [0];
			String passwd   = args [1];
						
			String query = "select uname, passwd from users where uname = ? ";
			conn = DriverManager.getConnection ("jdbc:odbc:logistics", "admin", "letmein");
			
			PreparedStatement stmnt = conn.prepareStatement (query);
			stmnt.setString(1, userName);
			ResultSet rs = stmnt.executeQuery ();
			while ( rs.next() ) {
				// do something
			}
			rs.close ();
			stmnt.close ();
			conn.close ();
		} catch (SQLException err) {
			err.printStackTrace ();
		}
	}
}