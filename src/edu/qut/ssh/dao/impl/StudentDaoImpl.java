package edu.qut.ssh.dao.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.qut.ssh.dao.StudentDao;
import edu.qut.ssh.domain.Student;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Resource(name = "student")
	private Student student;
	@Resource(name = "dataSource")
	private DataSource ds;

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5)
	@Override
	public Student findStudentById(int stuId) {
		// TODO Auto-generated method stub

		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql = "select * from student where stuId = ?";

		student = (Student) jt.query(sql, new Object[] {stuId}, new ResultSetExtractor() {

			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				Student s = new Student();
				while (rs.next()) {

					s.setStuId(rs.getInt("stuId"));

					s.setStudentName(rs.getString("studentName"));
				}
				return s;
			}
		});

		return student;
	}

	public Student getStudent() {
		return student;
	}
	
	// public void setStudent(Student student) {
	// this.student = student;
	// }

}
