package action;

import svc.AdminProductUploadService;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import vo.ActionForward;
import vo.ShoseInfo;

public class AdminProductImageUploadAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String saveFolder = "/images/";
			ServletContext application = request.getServletContext();
				String uploadPath = application.getRealPath("/images"); // 업로드 경로

				int size = 10 * 1024 * 1024; // 10메가 바이트까지 전송
				String name = "";
				String subject = "";
				String filename1 = "";
				String origfilename1 = "";

				MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8",
						new DefaultFileRenamePolicy());
				
				name = multi.getParameter("brand");
				subject = multi.getParameter("model");
				subject = multi.getParameter("kind");
				filename1 = multi.getParameter("fileName1");
				
				Enumeration files = multi.getFileNames(); // Enumeration iterator 다음 내용이 있는지 없는지 확인.

				String file1 = (String) files.nextElement();
				filename1 = multi.getFilesystemName(file1);
				origfilename1 = multi.getOriginalFileName(file1);
				
		
		ShoseInfo shoesinfo=new ShoseInfo();
		boolean UploadSuccess =false;
		
		shoesinfo.setBrand(request.getParameter("model"));
		shoesinfo.setModel(request.getParameter("shoeimage"));

		
		AdminProductUploadService adminProductUploadService = new AdminProductUploadService();
		UploadSuccess=adminProductUploadService.getAdminProductUpload(shoesinfo);
		request.setAttribute("UploadSuccess",UploadSuccess);
		
		ActionForward forward = new ActionForward("AdminProductUpload.jsp",false);
		return forward;
	}



}