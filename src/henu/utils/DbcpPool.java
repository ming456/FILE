package henu.utils;
import henu.utils.DbcpPool;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbcpPool {
	/**
	 * ����JDBC��ض���
	 */
	protected static Statement s = null;
	protected static ResultSet rs = null;
	protected static Connection conn = null;
	private static BasicDataSource dataSource = null;

	// ��ʼ�����ݿ����ӳ�
	public static void init() {
		if (dataSource != null) {
			try {
				dataSource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			dataSource = null;
		}
		// ʹ��Properties���������ݿ����ӳ���Ϣ
		try {
			Properties p = new Properties();
			p.setProperty("driverClassName", "com.mysql.jdbc.Driver");
			p.setProperty("url", "jdbc:mysql://localhost:3306/txt");
			p.setProperty("username", "root");
			p.setProperty("password", "0823112013");
			p.setProperty("maxActive", "100");
			p.setProperty("maxIdle", "100");
			p.setProperty("maxWait", "1000");
			p.setProperty("removeAbandoned", "false");
			p.setProperty("removeAbandonedTimeout", "120");
			p.setProperty("testOnBorrow", "true");
			p.setProperty("logAbandoned", "true");
			// ��ָ����Ϣ��������Դ
			dataSource = (BasicDataSource) BasicDataSourceFactory
					.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �����ӳ��л�ȡ����
	public static synchronized Connection getConnection() throws SQLException {
		if (dataSource == null) {
			init();
		}
		Connection conn = null;
		if (dataSource != null) {
			conn = dataSource.getConnection();
		}
		return conn;
	}

	/**
	 * ִ��INSERT/UPDATE/DELETE SQL���
	 * 
	 * @param sql
	 *            SQL��䣬�ַ�������
	 * @return ִ�н����int����
	 */
	public static int executeUpdate(String sql) {
		int result = 0;
		try {
			s = getConnection().createStatement();
			result = s.executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ִ��SELECT SQL���
	 * 
	 * @param sql
	 *            SQL��䣬�ַ�������
	 * @return ResultSet�����
	 */
	public static ResultSet executeQuery(String sql) {

		try {
			s = getConnection().createStatement();
			rs = s.executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * ִ�ж�̬SQL���
	 * 
	 * @param sql
	 *            ���в����Ķ�̬SQL��䡣
	 * @return ����PreparedStatement����
	 */
	public static PreparedStatement executePreparedStatement(String sql)
	{
		PreparedStatement ps = null;
		try{
			ps = getConnection().prepareStatement(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ps;
	}

	/**
	 * ����ع�
	 */
	public static void rollback() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * �ر����ݿ����Ӷ���
	 */
	public static void close() {
		try {
			if (rs != null)
				rs.close();
			if (s != null)
				s.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static int Result1(String sql,String Filename,String Filestyle,String Filetime,String Filepath,int Filesize,String author,String description){
	    int result = 0;
	    try{
	    	PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
	    	ps.setString(1, Filename);
	    	ps.setString(2, Filestyle);
	    	ps.setString(3, Filetime);
	    	ps.setString(4, Filepath);
	    	ps.setInt(5, Filesize);
	    	ps.setString(6, author);
	    	ps.setString(7,description);
	    	//ִ��SQL���
	    	result =ps.executeUpdate();
	    	ps.close();
	    	}catch(SQLException e)
	    	{
	    		e.printStackTrace();
	    	}
		return result;
	}

}
