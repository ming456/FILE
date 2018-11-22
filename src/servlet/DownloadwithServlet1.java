package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
@WebServlet("/download1")
public class DownloadwithServlet1 extends HttpServlet {
	ServletConfig config = null;
    public DownloadwithServlet1() {
        super();
     }
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Filename=new String(request.getParameter("Filename1").getBytes("ISO-8859-1"));
		//String Filename=request.getParameter("Filename1");
		System.out.println(Filename);
		SmartUpload su = new SmartUpload();
	
		su.initialize(config, request, response);
	
		su.setContentDisposition(null);
		
		try {
			su.downloadFile("D:/epce/File1/WebContent/upload/"+Filename);
			//D:/epce/File1/WebContent/upload/java.doc;
			su.downloadFile("");
			response.sendRedirect("Filedisplay.jsp");
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}
}
