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
	// selectAll
	public List<QA_Board_DTO> selectAll() {
		List<QA_Board_DTO> gitList = new ArrayList<QA_Board_DTO>();
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from Board";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
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
	
	// selectByTitle
	public List<QA_Board_DTO> selectByTitle(String title) {
		List<QA_Board_DTO> titleList = new ArrayList<QA_Board_DTO>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from Board where title = ?";

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, title);
			rs = st.executeQuery();

			while (rs.next()) {
				QA_Board_DTO list = makeList(rs);
				titleList.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}


		return titleList;
	}

	private QA_Board_DTO makeList(ResultSet rs) throws SQLException {
		QA_Board_DTO list = QA_Board_DTO.builder().id(rs.getInt("id")).writer(rs.getString("writer"))
				.createdDate(rs.getDate("createdDate")).title(rs.getString("title")).content(rs.getString("content"))
				.build();
		return list;
	}
		
		public int update(QA_Board_DTO update) {
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			int resultCount = 0;
			String sql = "update Board set title = ?, content = ? where id = ?";
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, update.getTitle());
				pst.setString(2, update.getContent());
				pst.setInt(3, update.getId());
				resultCount = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, null);
			}
			
			return resultCount;
		}

		public int deleteById(int id) {
			int result = 0;
			Connection conn = DBUtil.getConnection();
			PreparedStatement st = null;
			String sql = "delete from Board where id = ?";
			try {
				st = conn.prepareStatement(sql);
				st.setInt(1, id);
				result = st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}

}
