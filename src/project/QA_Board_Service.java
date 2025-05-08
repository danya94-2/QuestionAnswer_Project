package project;

import java.util.List;

public class QA_Board_Service {
	QA_Board_DAO qa_Board_DAO = new QA_Board_DAO();

	public List<QA_Board_DTO> selectAll() {
		return qa_Board_DAO.selectAll();
	}
	public int update(QA_Board_DTO update) {
		return qa_Board_DAO.update(update);
	}


	// selectByTitle
	public List<QA_Board_DTO> selectByTitle(String title) {
		return qa_Board_DAO.selectByTitle(title);
	}

	public int deleteById (int id) {
		return qa_Board_DAO.deleteById(id);
	}
}
