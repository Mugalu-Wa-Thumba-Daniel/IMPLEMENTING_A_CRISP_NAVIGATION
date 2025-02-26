package ImplementingACrispNavigation.controller;

import ImplementingACrispNavigation.model.Student;
import ImplementingACrispNavigation.model.StudentModel;
import ImplementingACrispNavigation.view.DataInputView;
import ImplementingACrispNavigation.view.DisplayView;

public class StudentController {
    private StudentModel studentModel;
    private DataInputView dataInputView;
    private DisplayView displayView;

    public StudentController(StudentModel studentModel, DataInputView dataInputView, DisplayView displayView) {
        this.studentModel = studentModel;
        this.dataInputView = dataInputView;
        this.displayView = displayView;

        // Add event listeners
        this.dataInputView.addAddStudentListener(e -> addStudent());
        this.displayView.addShowStudentsListener(e -> showStudents());
    }

    private void addStudent() {
        String id = dataInputView.getStudentId();
        String name = dataInputView.getStudentName();
        String department = dataInputView.getStudentDepartment();
        String address = dataInputView.getStudentAddress();

        Student student = new Student(id, name, department, address);
        studentModel.addStudent(student);
        dataInputView.showMessage("Student Added Successfully!");
    }

    private void showStudents() {
        displayView.setStudentList(studentModel.getStudents());
    }
}
