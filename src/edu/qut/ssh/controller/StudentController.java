package edu.qut.ssh.controller;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import edu.qut.ssh.domain.Student;
import edu.qut.ssh.service.StudentService;
//spring注解
@Scope("prototype")
@Controller("controller")
//struts注解
@Namespace("/")
public class StudentController extends ActionSupport{
	@Resource(name="studentService")
	private StudentService studentService;
	private int stuId;
	private Student student = null;
	//struts注解
	@Action(value="controller",results={@Result(name="input",location="/WEB-INF/content/index.jsp")})
	public String findStudentById(){
	    student = studentService.findStudentById(stuId);
		return INPUT;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
//  可以省略       因为属于Spring
//	public void setStudentService(StudentService studentService) {
//		this.studentService = studentService;
//	}
	public int getStuId() {
		return stuId;
	}
	//不可以省略    因为属于Struts 
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public Student getStudent() {
		return student;
	}
	//不可以省略    因为属于Struts
	public void setStudent(Student student) {
		this.student = student;
	}
}
