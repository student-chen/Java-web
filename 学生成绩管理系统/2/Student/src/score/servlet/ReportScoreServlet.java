package score.servlet;

import impl.ClassesImpl;
import impl.ScoreImpl;
import impl.TeacherImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Border;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import entity.Classes;
import entity.Operator;
import entity.Score;
import entity.Teacher;

@SuppressWarnings("deprecation")
public class ReportScoreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private TeacherImpl teacherImpl = new TeacherImpl();
	private ScoreImpl scoreImpl = new ScoreImpl();
	private ClassesImpl classesImpl=new ClassesImpl();
	private Teacher teacher;
	private List<Score>beans = null;
	private List<Classes> cla_list;
	private Label label=null;
	private Number number = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		response.setContentType("text/html");
		Operator operator = (Operator) request.getSession().getAttribute("log_operator");
		int ope_rol_id = operator.getRole().getId();
		if(ope_rol_id==2){
			 teacher =teacherImpl.query("ope_id", operator.getId() + "").get(0);
			 cla_list=classesImpl.query("cla_tec", teacher.getName());
			 if(cla_list.size()==0){
				 response.sendRedirect("pages/noclass.jsp");				 
			 }
			 else{
					response.setContentType("application/vnd.ms-excel"); // 保证不乱码
					String claName=cla_list.get(0).getName();
					String fileName =claName+ "学生成绩表.xls";
					response.setHeader("Content-Disposition", "attachment;"
							+ " filename="
							+ new String(fileName.getBytes(), "ISO-8859-1"));
					OutputStream os = response.getOutputStream();
					WritableWorkbook book = Workbook.createWorkbook(os);
					beans=scoreImpl.query("cla_tec_stu_all", teacher.getName());
					int length = beans.size();
					int sheetSize = 10;
					int sheetNum = 1;
					if (length % sheetSize > 0) {
						sheetNum = length / sheetSize + 1;
					} else {
						sheetNum = length / sheetSize;
					}
					try {
						for (int pg = 0; pg < sheetNum; pg++) {
							WritableSheet ws = book.createSheet(
									("第-" + (pg + 1) + "-页"), pg);
							WritableFont title_big = new WritableFont(
									WritableFont.ARIAL, 16, WritableFont.BOLD);
							WritableFont title_little = new WritableFont(
									WritableFont.ARIAL, 12, WritableFont.BOLD);
							WritableFont cell = new WritableFont(WritableFont.ARIAL, 11);
							WritableCellFormat cell_format = new WritableCellFormat(
									cell);
							WritableCellFormat title_big_format = new WritableCellFormat(
									title_big);
							WritableCellFormat title_little_format = new WritableCellFormat(
									title_little);
							ws.setRowView(0, 600);
							title_big_format.setBorder(Border.ALL,BorderLineStyle.THIN);	
							title_big_format.setAlignment(jxl.format.Alignment.CENTRE);
							title_big_format
									.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
							title_little_format
									.setAlignment(jxl.format.Alignment.CENTRE);
							title_little_format
									.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
							title_little_format.setBorder(Border.ALL,BorderLineStyle.THIN);
							cell_format.setAlignment(jxl.format.Alignment.CENTRE);
							cell_format
									.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
							cell_format.setBorder(Border.ALL,BorderLineStyle.THIN);
							cell_format.setWrap(false);
							ws.mergeCells(0, 0, 5, 0);
							label = new Label(0, 0, claName+"学生成绩表", title_big_format);
							ws.addCell(label);
							String ss[] = { "学生学号", "学生姓名", "课程科目", "考试分数", "平时分数",
									"科目总分" };
							for (int i = 0; i < 6; i++) {
								label = new Label(i, 1, ss[i], title_little_format);
								ws.addCell(label);
								ws.setColumnView(i, 14);
							}
							for (int i = pg * sheetSize; i < (pg + 1) * sheetSize; i++) {
								if (i < length) {
									Score bean = (Score) beans.get(i);
									for (int j = 0; j < 6; j++) {
										switch (j) {
										case 0:
											label = new Label(j, i + 2
													- (pg * sheetSize), bean
													.getStudent().getNo(), cell_format);
											break;
										case 1:
											label = new Label(j, i + 2
													- (pg * sheetSize), bean
													.getStudent().getName(),
													cell_format);
											break;
										case 2:
											label = new Label(j, i + 2
													- (pg * sheetSize), bean
													.getSubject().getName(),
													cell_format);
											break;
										case 3:
											number = new Number(j, i + 2
													- (pg * sheetSize),
													bean.getDaily(), cell_format);
											break;
										case 4:
											number = new Number(j, i + 2
													- (pg * sheetSize), bean.getExam(),
													cell_format);
											break;
										default:
											number = new Number(j, i + 2
													- (pg * sheetSize),
													bean.getCount(), cell_format);
										}
										if (j == 0 || j == 1 || j == 2)
											ws.addCell(label);
										else
											ws.addCell(number);
									}
								} else {
									break;
								}
							}
						}
						book.write();
						book.close();
						os.close();
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
				}
			}	
		}		
	}
}