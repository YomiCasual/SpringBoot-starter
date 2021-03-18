package com.example.demo.student;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    public StudentRepository studentRepository;

    public List<Student> getStudents() {
            return studentRepository.findAll();
    }

    public String addNewStudent(Student student) {
        try{
            studentRepository.save(student);
            return "Student Saved Successfully";
        } catch(Exception e) {
            throw e;
        }
    }

    public Optional<Student> getStudentById(String id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Student with the the id does not exist");
        }

        return studentRepository.findById(id);
    }

    @Transactional
    public String updateStudent(String id, String name, String email) {
        Student student = studentRepository.findById((id))
                .orElseThrow(() -> {
                    return new IllegalStateException("Student with this id not found");
                });

        if(name != null && name.length() > 0) {
            student.setName(name);
        }
        if(email != null && email.length() > 0) {
          /*Optional<Student>  studentOptional = studentRepository.findStudentByEmail(email);*/
            student.setName(name);
        }
        return "Student Update Successfully";
    }

}
