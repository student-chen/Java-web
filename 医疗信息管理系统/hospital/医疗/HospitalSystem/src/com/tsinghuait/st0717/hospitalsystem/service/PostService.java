package com.tsinghuait.st0717.hospitalsystem.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLServerDBManager;
import com.tsinghuait.st0717.hospitalsystem.dto.Nurse;
import com.tsinghuait.st0717.hospitalsystem.dto.Post;

public class PostService {
	/**
	 * 按作者姓名查找
	 * 
	 * @return 装dto对象的collection集合
	 * 
	 * @forword 作者列表
	 */
	public Collection searchPostsById(String sql) {
		Collection<Post> col = null;
		ResultSet rs = SQLServerDBManager.execQuery(sql);
		if (rs != null) {
			col = new ArrayList<Post>();
			try {
				while (rs.next()) {
					Post dto = new Post();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					col.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return col;
	}
	/**
	 * 分页技术
	 * 
	 */
	int rowsPages=0;//总行数
	int pageCount=1;//显示页数
	public ArrayList selectRowsPost(String sql,int page,int pageSize){
		ArrayList<Post> arr=null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery(sql);
			  if(rs!=null){
				 arr=new ArrayList<Post>();
					//取得总纪录数
					rs.last();
					rowsPages=rs.getRow();
					pageCount=(rowsPages/pageSize)+(rowsPages%pageSize==0?0:1);		
					if(page>=pageCount){
						page=pageCount;
					}
					int indexCount=(page-1)*pageSize+1;
					rs.absolute(indexCount);
					int i=0;
				 do{
					Post dto=new Post();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
				    arr.add(dto);
				    i++;
				}while(rs.next()&&i<pageSize);
			  }
			} catch (SQLException e) {
				System.out.println("数据库  职称表 post 遍历操作失败");
				e.printStackTrace();
			}
		return arr;
	}	
	/**
	 * 数据库  职称表 post 查询
	 * */
	//查询
	public ResultSet selectPost(String sql){
		ResultSet rs=null;
		rs=new SQLConnection().executeQuery(sql);
		return rs;		
	}
	//查询返回护士职称表的id
	public int selectPostId(String sql){
		int num=0;
		ResultSet rs=this.selectPost(sql);
		if(rs!=null){
			Nurse dto=new Nurse();
			try {
				dto.setPostid(rs.getInt("postid"));
				System.out.println("dto:"+dto.getPostid());
				num=dto.getPostid();
				System.out.println("num:"+num);
			} catch (SQLException e) {
				System.out.println("返回护士职称表的id出错...");
				e.printStackTrace();
			}
		}
		return num;
	}
	
	 //对职称中的表进行  添加,修改,删除 
	public int executeUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	
	//遍历职称表
	public ArrayList selectRowsPost(String sql){
		ArrayList<Post> arr=null;
		ResultSet rs=new SQLConnection().executeQuery(sql);
		if(rs!=null){
			arr=new ArrayList<Post>();
			try {
				while(rs.next()&&rs!=null){
					Post dto=new Post();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
				    arr.add(dto);
				}
			} catch (SQLException e) {
				System.out.println("数据库  职称表 post 遍历操作失败");
				e.printStackTrace();
			}
		}
		return arr;
	}	
	//对数据库操作
	public int execteUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
//	删除职称表信息
    public int deleteById(String id){
    	int num=0;
    	num=new SQLConnection().executeUpdate("delete from post where id="+id);
    	return num;
    }
    
    //修改职称表信息
    public int updateById(String sql) { 
    	int num=0;
    	num=new SQLConnection().executeUpdate(sql);
    	return num;
    }    
    //添加职称表信息
    public int insertPost(String name){
    	int num=0;
    	num=new SQLConnection().executeUpdate("insert into post values('"+name+"')");
    	return num;
    }
	public int getPageCount() {
		return pageCount;
	}
	public int getRowsPages() {
		return rowsPages;
	}

	public int deleteDoctorBatch(String ids[]){
		int refrenceRows=0;
		for (int i=0;i<ids.length;i++){
			refrenceRows=this.deleteById(ids[i]);
		}
		return refrenceRows;
	}
}