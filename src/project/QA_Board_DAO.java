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
				.createdDate(rs.getDate("createdDate")).title(rs.getString("title")).content(rs.getString("contenc"))
				.build();
		return list;
	}
}
