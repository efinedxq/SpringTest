package edu.qut.ssh.dao;

import edu.qut.ssh.domain.Student;

public interface StudentDao {
	Student findStudentById(int stuId);
}
