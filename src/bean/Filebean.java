package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import henu.utils.DbcpPool;

import com.mysql.jdbc.PreparedStatement;

public class Filebean {
	private String Filename;
	private String Filestyle;
    private String Filetime;
    //private String FileExt;
	//public String getFileExt() {
		//return FileExt;
	//}

	//public void setFileExt(String fileExt) {
		//FileExt = fileExt;
	//}

	public String getFiletime() {
		return Filetime;
	}

	public void setFiletime(String filetime) {
		Filetime = filetime;
	}

	public String getFilestyle() {
		return Filestyle;
	}

	public void setFilestyle(String filestyle) {
		Filestyle = filestyle;
	}

	private String Filepath;
	private int Filesize;
	private String author;
	private String description;

	public String getFilename() {
		return Filename;
	}

	public void setFilename(String filename) {
		Filename = filename;
	}

	public String getFilepath() {
		return Filepath;
	}

	public void setFilepath(String filepath) {
		Filepath = filepath;
	}

	public int getFilesize() {
		return Filesize;
	}

	public void setFilesize(int filesize) {
		Filesize = filesize;
	}

	public String getauthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int upload(Filebean file1) {
		String sql = "insert into file(Filename,Filestyle,Filetime,Filepath,Filesize,author,description)"
				+ "values(?,?,?,?,?,?,?)";
		int result = DbcpPool.Result1(sql,Filename,Filestyle,Filetime,Filepath,Filesize,author,description);
		return result;
		
	}

	public StringBuffer upload1() {
		String sql = "select * from file";
		ResultSet rs = null;
		rs = DbcpPool.executeQuery(sql);
		StringBuffer sb = new StringBuffer();
		try {
			// ������ѯ�����ƴ��ΪStringBuffer����
			while (rs.next()) {
				String Filename1=rs.getString("Filename");
				System.out.println(Filename1+"*");
				sb.append("<tr><td>");
				sb.append(rs.getString("Filename"));
				sb.append("</td><td>");
				sb.append(rs.getString("Filestyle"));
				sb.append("</td><td>");
				sb.append(rs.getString("Filetime"));
				sb.append("</td><td>");
				sb.append(rs.getString("Filepath"));
				sb.append("</td><td>");
				sb.append(rs.getString("Filesize"));
				sb.append("</td><td>");
				sb.append(rs.getString("author"));
				sb.append("</td><td>");
				sb.append(rs.getString("description"));
				sb.append("</td><td>");
//				sb.append("<a href='download.jsp?name=" + Filename1 +"'>下载</a>");
				sb.append("<a href='/File1/download?method=search2&name=" + Filename1 +"'>下载</a>");
				sb.append("&nbsp;");
				sb.append("<a href='upload.jsp'>上传</a>");
				sb.append("</td></tr>");
			}
			DbcpPool.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb;

	}
	public StringBuffer search(String type,String keyword){
		String sqlSearch = "SELECT * FROM file WHERE " + type + " LIKE '%" + keyword + "%'";
		ResultSet rs = DbcpPool.executeQuery(sqlSearch);
		StringBuffer sb = new StringBuffer();
		try {
			while(rs.next())
			{ 
				String Filename1=rs.getString("Filename");
				//System.out.println(Filename1+"***");
				sb.append("<tr><td>");
				sb.append(rs.getString("Filename"));
				sb.append("</td><td>");
				sb.append(rs.getString("Filestyle"));
				//System.out.println(rs.getString("Filestyle"));
				sb.append("</td><td>");
				sb.append(rs.getString("Filetime"));
				//System.out.println(rs.getString("Filetime"));
				sb.append("</td><td>");
				sb.append(rs.getString("Filepath"));
				sb.append("</td><td>");
				sb.append(rs.getString("Filesize"));
				sb.append("</td><td>");
				sb.append(rs.getString("author"));
				sb.append("</td><td>");
				sb.append(rs.getString("description"));
				sb.append("</td><td>");
				//sb.append("<a href='download.jsp?name=" + Filename1 +"'>下载</a>");
				sb.append("<a href='/File1/download?method=search2&name=" + Filename1 +"'>下载</a>");
				sb.append("&nbsp;");
				sb.append("<a href='upload.jsp'>上传</a>");
				sb.append("</td></tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return sb;
		
	}
}
