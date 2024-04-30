package com.esha.StudentFestDetails.StudentFestDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esha.StudentFestDetails.StudentFestDetails.entity.Student;
import com.esha.StudentFestDetails.StudentFestDetails.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentrepo;

	public List<Student> getAllStudents() {
		return studentrepo.findAll();
	}

	public void addStudent(Student student) {
		studentrepo.save(student);
	}

	public Student getStudent(int studid) {
		return studentrepo.findById(studid).get();
		
	}

	public void updateStudent(int studid, Student student) {
			Student studdb=studentrepo.findById(studid).get();
			studdb.setFirstname(student.getFirstname());
			studdb.setLastname(student.getLastname());
			studdb.setCourse(student.getCourse());
			studdb.setCountry(student.getCountry());
			studentrepo.save(studdb);
		}
		
	public void deleteStudent(int studid) {
		studentrepo.deleteById(studid);
		
	}
}
