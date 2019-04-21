/**
 * 
 */
package com.bjsxt.drp.web.usermgr.actions;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.bjsxt.drp.business.usermgr.manager.FileManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.bjsxt.drp.business.usermgr.model.File;
import com.bjsxt.drp.web.usermgr.forms.UploadActionForm;

public class FileUploadAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse sponse)
			throws Exception {

		UploadActionForm ulf = (UploadActionForm) form;
//		 String path = getServlet().getServletContext().getRealPath("upload") + "\\";
		// File file=new File();
		FormFile myfile = ulf.getMyfile();
		// file.setFile_date(java.sql.Date.valueOf(new Date().toString()));
		// file.setFile_name(ulf.getTitle().trim());
		// file.setFile_path("c:\\"+myfile.getFileName().trim());
		String filePath = request.getRealPath("/");//取当前系统路径

		if (myfile != null) {
			System.out.println("FileName=" + myfile.getFileName());
			File file = new File();
			String ddate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar
					.getInstance().getTime());
			file.setFile_date(java.sql.Date.valueOf(ddate));
			file.setFile_name(ulf.getTitle().trim());
			
//System.out.print(request.getContextPath()+"\n"+path);

			file.setFile_path("/upload/"+ myfile.getFileName());
			
			FileManager.getInstance().addUser(file);
			
			
			FileOutputStream fos = new FileOutputStream(filePath+"/upload/"+ myfile.getFileName());
			fos.write(myfile.getFileData());
			fos.flush();
			fos.close();
		}
		return mapping.findForward("success");

	}

}