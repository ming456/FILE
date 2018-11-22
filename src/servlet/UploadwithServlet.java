package servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Filebean;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UploadwithServlet extends HttpServlet {
	// ����servletconfig������Ϊinitialize()�����Ĳ���
	ServletConfig servletconfig;

	public UploadwithServlet() {
		super();
	}

	// ��ʼ��servletconfig����
	public void init(ServletConfig config) throws ServletException {
		this.servletconfig = config;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		StringBuffer sb=new StringBuffer();
		HttpSession session=request.getSession();
		// 1.ʵ����һ��SmartUpload����
		SmartUpload su = new SmartUpload();
		// 2.��ʼ��SmartUpolad����
		try {
			su.initialize(servletconfig, request, response);
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		// 3.�����ļ��ϴ��� ����
		su.setAllowedFilesList("doc,docx,txt");
		// �����ļ�����ֽ���
		su.setMaxFileSize(3 * 1024 * 1024);
		// �ļ�������ֽ���
		su.setTotalMaxFileSize(12 * 1024 * 1024);
		// 4.ʹ��upload�ϴ�

		try {
			su.upload();
		} catch (ServletException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (SmartUploadException e2) {
			e2.printStackTrace();
		}
		// 5.�ļ�����

     Date getDate = Calendar.getInstance().getTime();

String dateStr1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getDate);
		
		Request req = su.getRequest();
		
		Files files = su.getFiles();
		
		File file = files.getFile(0);
		String Filename=file.getFileName();
		String path ="D:/epce/File1/WebContent/upload/"+Filename;
		
		String extFile = file.getFileExt();
		
	     File myFile =su.getFiles().getFile(0); 
	     Filebean file1=new Filebean();
	    
	     file1.setFilename(myFile.getFileName());
	     file1.setFilestyle(req.getParameter("Filestyle"));
	     file1.setFiletime(dateStr1);
	     file1.setFilepath(myFile.getFilePathName());
	     //System.out.println(myFile.getFilePathName());
	     file1.setFilesize(myFile.getSize());
	     file1.setAuthor(req.getParameter("author"));
	     //System.out.println(req.getParameter("author"));
	     file1.setDescription(req.getParameter("description"));
	     //System.out.println(111111);
	     if(file1.upload(file1)>0){
	    	 try {
				file.saveAs(path);
				sb=file1.upload1();
				session.setAttribute("message",sb);
		    	response.sendRedirect("Filedisplay.jsp");
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
	     else{
	    	 response.sendRedirect("upload.jsp");
	     }
	}
}
