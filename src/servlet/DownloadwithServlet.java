package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Filebean;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/download")
public class DownloadwithServlet extends HttpServlet {
	ServletConfig config = null;

	public DownloadwithServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// doPost(request,response);
		//String Filename = request.getParameter("Filename1");
		// System.out.println(Filename+"1111");
		//String action = request.getParameter("method");
		//System.out.println(action);
		action(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void action(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String Filename = request.getParameter("Filename1");
		String action = request.getParameter("method");
		System.out.println(action);
		if ("search2".equals(action)) {
			//System.out.println(action);
		  //response.sendRedirect("download.jsp");
		    search2(request,response);
		}
		if ("search".equals(action)) {
			//System.out.println("asdasdadas");
			search(request, response);
		}
		if ("search1".equals(action)) {
			Filebean f = new Filebean();
			String type = request.getParameter("column");
			String keyword = request.getParameter("value");
			String sqlSearch = "SELECT * FROM file";
			HttpSession session = request.getSession();
			StringBuffer sb = new StringBuffer();
			sb = f.upload1();
			session.setAttribute("message", sb);
			try {
				response.sendRedirect("Filedisplay.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void search2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Filename=new String(request.getParameter("name").getBytes("ISO-8859-1"));
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


	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Filebean f = new Filebean();
		String type = request.getParameter("column");
		String keyword = request.getParameter("value");
		String sqlSearch = "SELECT * FROM file";
		HttpSession session = request.getSession();
		StringBuffer sb = new StringBuffer();
		if (keyword != null) {
			sb = f.search(type, keyword);
			//System.out.println(sb.toString());
			//System.out.println(type+"****");
			//System.out.println(sb.toString());
			session.setAttribute("message", sb);
			try {
				response.sendRedirect("Filedisplay.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			sb = f.upload1();
			session.setAttribute("message", sb);
			try {
				response.sendRedirect("Filedisplay.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// private void downloading(HttpServletRequest request,
		// HttpServletResponse response) throws ServletException {
		// String Filename=request.getParameter("Filename1");
		// String path ="/upload/"+;
		// //System.out.println(222222222);
		// SmartUpload su = new SmartUpload();
		//
		// su.initialize(config, request, response);
		//
		// su.setContentDisposition(null);
		//
		// try {
		// try {
		// System.out.println(222222222);
		// su.downloadFile(path);
		// } catch (ServletException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// } catch (SmartUploadException e) {
		// e.printStackTrace();
		// }
		// }

		// private void search(HttpServletRequest request, HttpServletResponse
		// response) {
		// // TODO Auto-generated method stub
		// Filebean f=new Filebean();
		// String type = request.getParameter("column");
		// String keyword = request.getParameter("value");
		// String sqlSearch = "SELECT * FROM file";
		// HttpSession session = request.getSession();
		// StringBuffer sb=new StringBuffer();
		// if(keyword!=null){
		// System.out.println(111111111);
		// sb=f.search(type,keyword);
		// session.setAttribute("message", sb);
		// try {
		// response.sendRedirect("Filedisplay.jsp");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// else{
		// sb=f.upload1();
		// session.setAttribute("message", sb);
		// try {
		// response.sendRedirect("Filedisplay.jsp");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }
	}
}