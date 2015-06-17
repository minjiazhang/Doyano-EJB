import java.sql.*;
public class Test {
    public static void main(String[] a)
	throws Exception {
	Connection conn=null;
	Statement stmt=null;
        Class.forName("org.h2.Driver");
	
    // conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
	Statement stmt = conn.createStatement() ;
	
	//*************************************************blake inputted
	object users = parserobjected();  // unsure about this
        // add application code here
	int userid = users.userid;
	string username = users.username;
	string password = users.password;
	int personalRank = users.personalRank;	
			
			// Execute the query
	ResultSet rs = stmt.executeQuery( "SELECT table_name FROM information_schema.tables" ) ;
	
	// Loop through the result set
	while( rs.next() ) System.out.println( rs.getString(1) );
	
	// Close the result set, statement and the connection
	rs.close() ;
	stmt.execute("CREATE TABLE IF NOT EXISTS USERS(userID INT PRIMARY KEY,username VARCHAR(255), password VARCHAR(255), personalRank INT");
	stmt.execute("CREATE user IF NOT EXISTS user1 PASSWORD 'abcd'");
	stmt.execute("GRANT ALL ON user TO users");
	stmt.close() ;
        conn.close();
	
	//        conn = DriverManager.getConnection("jdbc:h2:~/test", "TestDB", "abcd");
        conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "TestDB", "abcd");

	stmt = conn.createStatement() ;
	stmt.executeQuery("INSERT INTO users VALUES ('"userid","username","password","personalRank")");  //blake inputted
    }
}
