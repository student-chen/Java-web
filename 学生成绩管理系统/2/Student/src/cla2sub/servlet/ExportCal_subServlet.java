package cla2sub.servlet;

import impl.Cla2SubImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import entity.Cla2Sub;

public class ExportCal_subServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			resp.setContentType("text/html");
			resp.setContentType("application/vnd.ms-excel");
			Cla2SubImpl cla2SubImpl = new Cla2SubImpl();
			String search_type = req.getParameter("search_type");
			String search_value = java.net.URLDecoder.decode(req
					.getParameter("value"), "UTF-8");
			List<Cla2Sub> list_cla2Sub = cla2SubImpl.query(search_type,
					search_value);
			String classes_name = list_cla2Sub.get(0).getClasses().getName();
			String fileName = classes_name + ".xls";
			resp.setHeader("Content-Disposition", "attachment;" + " filename="
					+ new String(fileName.getBytes(), "ISO-8859-1"));
			OutputStream os = resp.getOutputStream();
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			WritableSheet ws = wwb.createSheet(classes_name + "课程表", 0);
			WritableFont title_big = new WritableFont(WritableFont.ARIAL, 16,
					WritableFont.BOLD);
			WritableFont title_little = new WritableFont(WritableFont.ARIAL,
					12, WritableFont.BOLD);
			WritableCellFormat f1 = new WritableCellFormat(title_big);
			f1.setAlignment(Alignment.CENTRE);
			f1.setVerticalAlignment(VerticalAlignment.CENTRE);
			f1.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
			WritableCellFormat f2 = new WritableCellFormat(title_little);
			f2.setAlignment(Alignment.CENTRE);
			f2.setVerticalAlignment(VerticalAlignment.CENTRE);
			f2.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
			WritableCellFormat f3 = new WritableCellFormat();
			f3.setAlignment(Alignment.CENTRE);
			f3.setVerticalAlignment(VerticalAlignment.CENTRE);
			f3.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
			ws.setRowView(0, 600);
			ws.setRowView(1, 500);
			ws.mergeCells(0, 0, 1, 0);
			Label label;
			label = new Label(0, 0, classes_name + "课程表  ", f1);
			ws.addCell(label);
			label = new Label(2, 0, "班主任："
					+ list_cla2Sub.get(0).getClasses().getTecName(), f3);
			ws.addCell(label);
			String[] title = { "班级名", "科目名", "主讲教师名" };

			for (int i = 0; i < title.length; i++) {
				label = new Label(i, 1, title[i], f2);
				ws.addCell(label);
				ws.setColumnView(i, 15);
			}
			for (int i = 0; i < list_cla2Sub.size(); i++) {
				label = new Label(0, i + 2, list_cla2Sub.get(i).getClasses()
						.getName(), f3);
				ws.addCell(label);
				label = new Label(1, i + 2, list_cla2Sub.get(i).getSubject()
						.getName(), f3);
				ws.addCell(label);
				label = new Label(2, i + 2, list_cla2Sub.get(i).getTeacher()
						.getName(), f3);
				ws.addCell(label);
				ws.setRowView(i + 2, 400);
			}
			wwb.write();
			wwb.close();
			os.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
