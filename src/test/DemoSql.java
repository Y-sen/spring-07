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
		//��ʽ��jdbc:mysql://����IP���˿ں�/���ݿ���
				String url="jdbc:mysql://192.168.131.131:3306/dbtest?useUnicode = true&characterEncoding=utf8";
				String user = "root";
				String password = "wky8013wl";
				//ѡ��Ҫ���������ݿ�����  -----�������������䣩
				Connection con =null;
				PreparedStatement pstmt =null;
				ResultSet rs = null;
				try {
					Class.forName("org.gjt.mm.mysql.Driver");
					//�������� ����IP �˿ں� �û��� ����
					con = DriverManager.getConnection(url, user, password);
					//��������ڣ�SQL��䣩
					pstmt = con.prepareStatement("select * from tab_stu");
					//����SQL��䲢�鿴���  �������ɾ�Ĳ飬�򷵻���Ӱ������� ����ǲ�ѯ���ص��ǲ�ѯ�Ľ��
					//���е�ʱ��ע�� �������ɾ�������executeUpdate ����int ������ѯ  �����ResultSet 
					rs = pstmt.executeQuery();
					//�鿴�����
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
		//��ʽ��jdbc:mysql://����IP���˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.131.131:3306/dbtest?useUnicode = true&characterEncoding=utf8";
		String user = "root";
		String password = "wky8013wl";
		//ѡ��Ҫ���������ݿ�����  -----�������������䣩
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			//�������� ����IP �˿ں� �û��� ����
			con = DriverManager.getConnection(url, user, password);
			//��������ڣ�SQL��䣩
			pstmt = con.prepareStatement("insert into tab_stu(id,name,sex) values(?,?,?)");
			//����SQL��䲢�鿴���  �������ɾ�Ĳ飬�򷵻���Ӱ������� ����ǲ�ѯ���ص��ǲ�ѯ�Ľ��
			//���е�ʱ��ע�� �������ɾ�������executeUpdate ����int ������ѯ  �����ResultSet 
			pstmt.setInt(1,1);
			pstmt.setString(2,"����");
			pstmt.setString(3,"��");
			//ִ�����
			System.out.println(pstmt.executeUpdate());
			//�鿴�����
			
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
