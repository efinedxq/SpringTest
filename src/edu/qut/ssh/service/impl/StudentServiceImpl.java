package edu.qut.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.qut.ssh.dao.StudentDao;
import edu.qut.ssh.dao.impl.StudentDaoImpl;
import edu.qut.ssh.domain.Student;
import edu.qut.ssh.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Resource(name="studentDao")
	private StudentDao studentDao;

	@Override
	public Student findStudentById(int stuId) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(stuId);
	}
}
