package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;


public class QA_Board_DAO {
	//selectAll
		public List<QA_Board_DTO > selectAll() {
			List<QA_Board_DTO > gitList = new ArrayList<QA_Board_DTO>();
			Connection conn = DBUtil.getConnection();
			Statement st = null;
			ResultSet rs = null;
			String sql = "select * from Board";
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					QA_Board_DTO list = makeList(rs);
					gitList.add(list);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, st, rs);
			}
			return gitList;
		}

		private QA_Board_DTO makeList(ResultSet rs) throws SQLException {
			QA_Board_DTO list = QA_Board_DTO.builder()
					.id(rs.getInt("id"))
					.writer(rs.getString("writer"))
					.createdDate(rs.getDate("createdDate"))
					.title(rs.getString("title"))
					.content(rs.getString("contenc"))
					.build();
			return list;
		}
		
		  public int update(QA_Board_DTO update) {
				Connection conn;
				PreparedStatement pst = null;
				ResultSet rs;
				int resultCount = 0;
				String sql = "update Board set title = ?, content = ?, password = ?, qatype = ? where id = ?";
				conn = DBUtil.getConnection();
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, update.getTitle());
					pst.setString(2, update.getContent());
					pst.setString(3, update.getPassword());
					pst.setString(4, update.getQAtype());
					pst.setInt(5, update.getId());
					resultCount = pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBUtil.dbDisconnect(conn, pst, null);
				}
				
				return resultCount;
				
				
			}
}
