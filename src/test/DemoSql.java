package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoSql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		democreat();
//		demoselect();
		
	}
		

	private static void demoselect() {
		// TODO Auto-generated method stub
		//格式：jdbc:mysql://主机IP：端口号/数据库名
				String url="jdbc:mysql://192.168.131.131:3306/dbtest?useUnicode = true&characterEncoding=utf8";
				String user = "root";
				String password = "wky8013wl";
				//选择要操作的数据库种类  -----加载驱动（反射）
				Connection con =null;
				PreparedStatement pstmt =null;
				ResultSet rs = null;
				try {
					Class.forName("org.gjt.mm.mysql.Driver");
					//创建连接 主机IP 端口号 用户名 密码
					con = DriverManager.getConnection(url, user, password);
					//创建命令窗口（SQL语句）
					pstmt = con.prepareStatement("select * from tab_stu");
					//运行SQL语句并查看结果  如果是增删改查，则返回受影响的行数 如果是查询返回的是查询的结果
					//运行的时候，注意 如果是增删改则调用executeUpdate 返回int 若果查询  则调用ResultSet 
					rs = pstmt.executeQuery();
					//查看结果集
					while(rs.next()){
						System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t "+rs.getString("sex"));
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						if(rs!=null)
							rs.close();
						if(pstmt!=null)
							pstmt.close();
						if(con!=null)
							con.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}

	private static void democreat() {
		// TODO Auto-generated method stub
		//格式：jdbc:mysql://主机IP：端口号/数据库名
		String url="jdbc:mysql://192.168.131.131:3306/dbtest?useUnicode = true&characterEncoding=utf8";
		String user = "root";
		String password = "wky8013wl";
		//选择要操作的数据库种类  -----加载驱动（反射）
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			//创建连接 主机IP 端口号 用户名 密码
			con = DriverManager.getConnection(url, user, password);
			//创建命令窗口（SQL语句）
			pstmt = con.prepareStatement("insert into tab_stu(id,name,sex) values(?,?,?)");
			//运行SQL语句并查看结果  如果是增删改查，则返回受影响的行数 如果是查询返回的是查询的结果
			//运行的时候，注意 如果是增删改则调用executeUpdate 返回int 若果查询  则调用ResultSet 
			pstmt.setInt(1,1);
			pstmt.setString(2,"王五");
			pstmt.setString(3,"男");
			//执行语句
			System.out.println(pstmt.executeUpdate());
			//查看结果集
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
