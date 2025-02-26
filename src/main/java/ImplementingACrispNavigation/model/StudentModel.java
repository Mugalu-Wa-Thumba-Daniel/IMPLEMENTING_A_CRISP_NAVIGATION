package ImplementingACrispNavigation.model;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    private List<Student> students;

    public StudentModel() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(updatedStudent.getId())) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
