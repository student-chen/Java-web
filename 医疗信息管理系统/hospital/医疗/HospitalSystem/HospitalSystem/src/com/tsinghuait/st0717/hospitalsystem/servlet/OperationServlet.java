package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tsinghuait.st0717.hospitalsystem.service.OperationService;
import com.tsinghuait.st0717.hospitalsystem.service.PatientService;

public class OperationServlet extends BaseServltes {

	@Override
	protected RequestDispatcher delete(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		String name=(String)arg0.getSession().getAttribute("doctorLoginTree");
		System.out.println("Login_patientMcName:"+name);
		PatientService patientService=new PatientService();
		String sql="select * from patient where isfinished=0 and mcName='"+name+"'";
	    arg0.setAttribute("operationPatient",patientService.selePatient(sql));			
		RequestDispatcher rd=arg0.getRequestDispatcher("view_linli/operationPatient.jsp");
		return rd;
	}

	protected RequestDispatcher executeQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		return this.select(request, response);
	}
	protected RequestDispatcher insert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=GBK");
		 RequestDispatcher rd=null;
		OperationService os=new OperationService();//实例化一个OperationService对象
		//获得病人的名字
	/*	String patientName=request.getParameter("patientName").toString();
		System.out.println("patientName1"+patientName);*/
		String patientName=getParamByMyFilter(request,"patientName");
		//获得由页面隐藏的病人的Id
		String p=request.getParameter("pId");
		int patientId=Integer.parseInt(p);
		/*System.out.println(p);
		int patientId=0;
		if(p==null){
			String oid="select oid from patient where name='"+patientName+"'";
			patientId=os.returnOid(oid);
		}
		else
		{
			patientId=Integer.parseInt(p);
		}*/
		//获得病人的科别
		String patientType=request.getParameter("patientType");
		System.out.print(patientType);
		String date=request.getParameter("date");	//得到手术日期
		String sh=request.getParameter("shour");	//得到手术开始时间的小时
		String sm=request.getParameter("sminute");  //得到手术开始时间的分钟
		String eh=request.getParameter("ehour");    //得到手术结束时间的小时
		String em=request.getParameter("eminute");  //得到手术结束时间的分钟
		String Starttime=date+" "+sh+":"+sm+":00";  //手术开始时间
		String Endtime=date+" "+eh+":"+em+":00";    //手术结束时间
		System.out.println("Starttime"+Starttime+"Endtime"+Endtime);
		String sqla="select operatingRoomId from operation where startTime='"+Starttime+"' and endTime='"+Endtime+"'";
		int roomId=os.returnRoomId(sqla);  //查询该段时间的已用病房
	/*	if(roomId<=0)
		{
			//request.getHeader("refresh,0;url=operationServlet?opertion=4");
		}*/
		//获得此次手术所需花费的金额  (如何才能避免用户填入的是字母)
		String money=request.getParameter("pay");
		float pay=Float.parseFloat(money);
		//通过病室编号查询该病室的Id
		String No=request.getParameter("No");
		String sql2="select id from operationRoom where orNo='"+No+"'";
		int orNo=os.returnId(sql2);//根据病室的编号获得其ID
		if(roomId==orNo)//如果orNo等于roomId则该手术室是不可用的
		{
			//System.out.println("该手术室不可用");
	        rd=request.getRequestDispatcher("/operationServlet?opertion=4&name="+patientName+"&id="+patientId);
	        JOptionPane.showMessageDialog(null,"该手术室不可用");
		}
		else
		{
			System.out.println("手术室编号"+orNo);
			//获得辅助医师的Id
			String extDoctorName=request.getParameter("extDoctorName");
			String sql3="select id from doctor where name='"+extDoctorName+"'";
			int extDoctorId=os.returnId(sql3);//根据姓名获得辅助医师ID
	        //获得主刀医师的Id
			String pkDoctorName=request.getParameter("pkDoctorName");
			String sql4="select id from doctor where name='"+pkDoctorName+"'";
			int pkDoctorId=os.returnId(sql4);//根据姓名获得主刀医师ID
			System.out.println("extDoctorId"+extDoctorId+"pkDoctorId"+pkDoctorId);
	        //向手术表(operation)中插入信息
			String sql11="insert into operation values("+pay+","+orNo+","+patientId+","+pkDoctorId+","+extDoctorId+",1,'"+Starttime+"','"+Endtime+"')";
			boolean flag1=os.insertOperation(sql11);
			//向收据表(receipt)中插入信息
			String sql22="insert into receipt values('"+patientType+"',"+pay+",'"+patientName+"',"+patientId+",getdate(),0)";
			boolean flag2=os.insertOperation(sql22);
			//查询该段时间的operationId
			String sql="select id from operation where  patenitID="+patientId+" and startTime='"+Starttime+"' and endTime='"+Endtime+"'";
		    int operationId=os.returnId(sql);
			//向手术室安排表(operationSchedule)中插入信息
			String sql33="insert into operationSchedule values("+orNo+","+operationId+",'"+Starttime+"','"+Endtime+"')";
			boolean flag3=os.insertOperation(sql33);
			//修改病人的处理字段(isfinished)
			String sql44="update patient set isfinished=1 where oid="+patientId;	
			boolean flag4=os.updateOperation(sql44);
			System.out.println("flag1:"+flag1);
			System.out.println("flag2:"+flag2);
			System.out.println("flag3:"+flag3);
			System.out.println("flag4:"+flag4);
			if(flag1==false||flag2==false||flag3==false||flag4==false)
			{
			     System.out.println("添加失败...");
			     rd=request.getRequestDispatcher("/operationServlet?opertion=4&name="+patientName+"&id="+patientId);
			     JOptionPane.showMessageDialog(null,"手术添加失败，请确认您的信息是否准确");
			}
	      rd=request.getRequestDispatcher("/patientServlet?isfinished=1");
	      JOptionPane.showMessageDialog(null,"手术添加成功");
	    }
		return rd;
	}
	
	String sqlOrNo = null;
	protected RequestDispatcher select(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获得病人名字
	/*	String p=request.getParameter("name");
		String patientName=null;
		if(p!=null){
			patientName=new String(p.trim().getBytes("iso-8859-1"),"gbk");
		}
		System.out.println("patientName2:"+patientName+" \np:"+p);*/
		String patientName=getParamByMyFilter(request, "name");
		//获得病人编号
		String i=request.getParameter("id");
		int oid=0;
		if(i!=null){
			oid=Integer.parseInt(i);
		}
		System.out.println("oid:"+oid);
		request.setAttribute("pName",patientName);
		request.setAttribute("oid", oid);
		OperationService os=new OperationService();
		String sqlDoctorName="select name from doctor";
		request.setAttribute("DoctorName", os.selectDoctor(sqlDoctorName));
	    String slqOrNo="select orNO from operationRoom where isUseable=1";
		request.setAttribute("roomOrNo",os.selectorNo(slqOrNo));
		RequestDispatcher rd=request.getRequestDispatcher("view_linli/addOperation.jsp");
		return rd;
	}

	@Override
	protected RequestDispatcher update(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
