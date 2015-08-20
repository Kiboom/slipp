package slipp.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3307/slipp_dev";        // 사용하려는 데이터베이스명을 포함한 URL 기술
		String id = "root";                                                    // 사용자 계정
		String pw = "3132";                                                // 사용자 계정의 패스워드		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
			return DriverManager.getConnection(url,id,pw);              // DriverManager 객체로부터 Connection 객체를 얻어온다.
		} catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void addUser(User user) throws SQLException {
		String sql = "insert into USERS values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);   // prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			pstmt.executeUpdate();
		} finally {							// finally는 catch와는 다르게 exception이 발생하든 않든 무조건 try후 반드시 실행됨.
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}

	public User findByUserId(String userId) throws SQLException {
		String sql = "select * from USERS where userId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  userId);
			
			rs = pstmt.executeQuery();	// excecuteUpdate와는 달리 데이터를 꺼내와야하기 때문에 ResultSet으로 리턴.
			
			if (!rs.next()){
				return null;
			}
			
			return new User(
					rs.getString("userId"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("email"));
		}finally {
			if(rs != null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
		
				
	}

	public void removeUser(String userId) throws SQLException {
		String sql = "delete from USERS where userId = ?";		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);   // prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt.setString(1, userId);
			
			pstmt.executeUpdate();
		} finally {							// finally는 catch와는 다르게 exception이 발생하든 않든 무조건 try후 반드시 실행됨.
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}

	public void updateUser(User user) throws SQLException {
		String sql = "update USERS set password = ?, name = ?, email = ? where userId =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);   // prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUserId());
			
			pstmt.executeUpdate();
		} finally {							// finally는 catch와는 다르게 exception이 발생하든 않든 무조건 try후 반드시 실행됨.
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}

}
