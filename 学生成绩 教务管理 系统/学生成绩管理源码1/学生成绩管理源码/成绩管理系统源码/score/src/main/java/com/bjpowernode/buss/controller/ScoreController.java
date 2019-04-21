package com.bjpowernode.buss.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.criterion.DetachedCriteria;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bjpowernode.buss.entity.base.ScoreEntity;
import com.bjpowernode.buss.entity.base.StudentEntity;
import com.bjpowernode.buss.entity.base.TeacherEntity;
import com.bjpowernode.buss.service.ScoreService;
import com.bjpowernode.common.controller.BaseController;
import com.bjpowernode.common.util.AjaxJson;
import com.bjpowernode.common.util.Pagination;

@Controller
@RequestMapping("/scoreController")
public class ScoreController extends BaseController {

	private static final Logger logger = Logger.getLogger(ScoreController.class);
	
	String[] excelHeader = { "学生学号", "课程名称", "分数", "学期", "班级", "教师工号","教师姓名", "学生姓名"};    

	@Autowired
	private ScoreService scoreService;

	/**
	 * 初始访问
	 * 
	 * @param
	 * @param model
	 * @return
	 */
	@RequestMapping(params = "goScore")
	public ModelAndView goScore(HttpServletRequest request) {
		return new ModelAndView("buss/score");
	}

	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(HttpServletRequest request, HttpServletResponse response, ScoreEntity scoreEntity,
			String studentid, String teacherid) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("保存成功！");
		j.setSuccess(true);
		try {
			TeacherEntity teacher = this.scoreService.get(TeacherEntity.class, teacherid);
			StudentEntity student = this.scoreService.get(StudentEntity.class, studentid);
			scoreEntity.setTeacherEntity(teacher);
			scoreEntity.setStudentEntity(student);
			this.scoreService.save(scoreEntity);
		} catch (Exception e) {
			j.setMsg("保存失败！");
			j.setSuccess(false);
		}
		return j;

	}

	@RequestMapping(params = "update")
	@ResponseBody
	public AjaxJson update(HttpServletRequest request, HttpServletResponse response, ScoreEntity scoreEntity,
			String studentid, String teacherid) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("更新成功！");
		j.setSuccess(true);
		try {
			TeacherEntity teacher = this.scoreService.get(TeacherEntity.class, teacherid);
			StudentEntity student = this.scoreService.get(StudentEntity.class, studentid);
			scoreEntity.setTeacherEntity(teacher);
			scoreEntity.setStudentEntity(student);
			this.scoreService.update(scoreEntity);
		} catch (Exception e) {
			j.setMsg("更新失败！");
			j.setSuccess(false);
		}
		return j;

	}

	@RequestMapping(params = "delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson delete(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("删除成功！");
		j.setSuccess(true);
		try {
			for (String id : ids.split(",")) {
				ScoreEntity scoreEntity = new ScoreEntity();
				scoreEntity.setId(id);
				this.scoreService.delete(scoreEntity);
			}
		} catch (Exception e) {
			j.setMsg("删除失败！");
			j.setSuccess(false);
		}
		return j;

	}

	@RequestMapping(params = "uploadScore", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson uploadScore(@RequestParam("scoreExcel") MultipartFile scoreExcel) {
		AjaxJson j = new AjaxJson();
		j.setMsg("导入成功！");
		j.setSuccess(true);
		try {
			if (!scoreExcel.isEmpty()) {
				InputStream is = scoreExcel.getInputStream();
				String[] fileName = scoreExcel.getOriginalFilename().split("\\.");
				List<ScoreEntity> scoreList = new ArrayList<ScoreEntity>();
				// 判断excel版本
				if ("xls".equals(fileName[1])) {
					// List<String> results =
					// ExcelImportUtil.getExcelStringList(is);
					HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
					for (int i = 0; i < hssfWorkbook.getNumberOfSheets(); i++) {
						HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(i);
						if (hssfSheet == null) {
							continue;
						}
						// 循环行Row
						for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
							HSSFRow hssfRow = hssfSheet.getRow(rowNum);
							if (hssfRow != null) {
								ScoreEntity se = new ScoreEntity();
								TeacherEntity te = new TeacherEntity();
								StudentEntity stu = new StudentEntity();
								HSSFCell stuNum = hssfRow.getCell(0);
								HSSFCell courseName = hssfRow.getCell(1);
								HSSFCell score = hssfRow.getCell(2);
								HSSFCell term = hssfRow.getCell(3);
								HSSFCell className = hssfRow.getCell(4);
								HSSFCell teacherNum = hssfRow.getCell(5);
								int stuInt = (int) stuNum.getNumericCellValue();
								int teacherInt = (int) teacherNum.getNumericCellValue();
								te = this.scoreService.findUniqueByProperty(TeacherEntity.class, "teachernum",
										String.valueOf(teacherInt));
								stu = this.scoreService.findUniqueByProperty(StudentEntity.class, "studentnum",
										String.valueOf(stuInt));
								BigDecimal bd = new BigDecimal(score.getNumericCellValue());
								se.setTeacherEntity(te);
								se.setStudentEntity(stu);
								se.setClassname(className.getStringCellValue());
								se.setCoursename(courseName.getStringCellValue());
								se.setScore(bd);
								se.setTerm(term.getStringCellValue());

								scoreList.add(se);
							}
						}
					}
				} else if ("xlsx".equals(fileName[1])) {
					XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
					for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
						XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
						// Read the Row
						for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
							XSSFRow xssfRow = xssfSheet.getRow(rowNum);
							if (xssfRow != null) {
								ScoreEntity se = new ScoreEntity();
								TeacherEntity te = new TeacherEntity();
								StudentEntity stu = new StudentEntity();
								XSSFCell stuNum = xssfRow.getCell(0);
								XSSFCell courseName = xssfRow.getCell(1);
								XSSFCell score = xssfRow.getCell(2);
								XSSFCell term = xssfRow.getCell(3);
								XSSFCell className = xssfRow.getCell(4);
								XSSFCell teacherNum = xssfRow.getCell(5);
								int stuInt = (int) stuNum.getNumericCellValue();
								int teacherInt = (int) teacherNum.getNumericCellValue();
								te = this.scoreService.findUniqueByProperty(TeacherEntity.class, "teachernum",
										String.valueOf(teacherInt));
								stu = this.scoreService.findUniqueByProperty(StudentEntity.class, "studentnum",
										String.valueOf(stuInt));
								BigDecimal bd = new BigDecimal(score.getNumericCellValue());
								se.setTeacherEntity(te);
								se.setStudentEntity(stu);
								se.setClassname(className.getStringCellValue());
								se.setCoursename(courseName.getStringCellValue());
								se.setScore(bd);
								se.setTerm(term.getStringCellValue());

								scoreList.add(se);
							}
						}
					}
				}else{
					j.setMsg("请导入正确的excel文件！");
					j.setSuccess(false);
				}

				this.scoreService.saveBatch(scoreList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("导入失败！");
			j.setSuccess(false);
		}
		return j;

	}
	
	@RequestMapping(params = "exportExcel")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String teachername,String coursename,
			String term,String name) throws Exception {
		DetachedCriteria condition = DetachedCriteria.forClass(ScoreEntity.class);
		List<ScoreEntity> scoreList = this.scoreService.findData(condition, name, teachername, coursename, term);
		
		HSSFWorkbook wb = new HSSFWorkbook();    
        HSSFSheet sheet = wb.createSheet("sheet1");    
        HSSFRow row = sheet.createRow((int) 0);    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
    
        for (int i = 0; i < excelHeader.length; i++) {    
            HSSFCell cell = row.createCell(i);    
            cell.setCellValue(excelHeader[i]);    
            cell.setCellStyle(style);    
            sheet.autoSizeColumn(i);    
        }    
    
        for (int i = 0; i < scoreList.size(); i++) {    
            row = sheet.createRow(i + 1);    
            ScoreEntity scoreEntity = scoreList.get(i);    
            row.createCell(0).setCellValue(scoreEntity.getStudentEntity().getStudentnum());    
            row.createCell(1).setCellValue(scoreEntity.getCoursename());    
            row.createCell(2).setCellValue(scoreEntity.getScore().toString());    
            row.createCell(3).setCellValue(scoreEntity.getTerm());
            row.createCell(4).setCellValue(scoreEntity.getClassname());
            row.createCell(5).setCellValue(scoreEntity.getTeacherEntity().getTeachernum());
            row.createCell(6).setCellValue(scoreEntity.getTeacherEntity().getTeachername());
            row.createCell(7).setCellValue(scoreEntity.getStudentEntity().getName());
            
        }    
		
		response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=studentScore.xls");    
        OutputStream ouputStream = response.getOutputStream();    
        try{
        	 wb.write(ouputStream);    
             ouputStream.flush();    
             ouputStream.close(); 
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	ouputStream.flush();    
            ouputStream.close(); 
        }
       

	}
	
	@RequestMapping(params = "datagrid")
	@ResponseBody
	public void datagrid(HttpServletRequest request, HttpServletResponse response, ScoreEntity ve, String name,
			String teachername, String coursename, String term) throws Exception {
		String page = request.getParameter("page");// easyui datagrid 分页 页号
		String rows = request.getParameter("rows");// easyui datagrid 分页 页数
		if (page == null) {
			page = "0";
		}
		if (rows == null) {
			rows = "0";
		}

		DetachedCriteria condition = DetachedCriteria.forClass(ScoreEntity.class);
		Pagination<?> pagination = scoreService.findPageData(condition, ve, Integer.parseInt(page),
				Integer.parseInt(rows), name, teachername, coursename, term);

		JSONObject jobj = new JSONObject();
		jobj.put("total", pagination.getTotalCount());
		jobj.put("rows", pagination.getDatas());

		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jobj.toString());

	}

}
