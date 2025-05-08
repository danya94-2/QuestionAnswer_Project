package project;

import java.util.List;

public class QA_Board_Service {
	QA_Board_DAO qa_Board_DAO = new QA_Board_DAO();

	public List<QA_Board_DTO> selectAll() {
		return qa_Board_DAO.selectAll();
	}

	public int deleteById (int id) {
		return qa_Board_DAO.deleteById(id);
	}
}
