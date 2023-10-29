package sit.int202.sitspace.models;

import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public class AllStudent {
    private List<Student> studentList;

    public AllStudent() {
        this.studentList = new ArrayList<>();
    }

    public int addStudent(int id, String name, double score) {
        char grade = calculateGrade(score);
        if (grade == '!') {
            return -1;
        }
        Student student = new Student(id, name, score, grade);
        studentList.add(student);
        if (studentList.size() > 1) {
            studentList.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Integer.compare(o1.getId(), o2.getId());
                }
            });
        }
        return 1;
    }

    public int removeStudent(int id) {
        Student studentToRemove = getStudentById(id);
        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            return 1;
        } else {
            return -1;
        }
    }


    private char calculateGrade(double score) {
        if (score >= 80 && score <= 100) {
            return 'A';
        } else if (score >= 70 && score < 80) {
            return 'B';
        } else if (score >= 60 && score < 70) {
            return 'C';
        } else if (score >= 50 && score < 60) {
            return 'D';
        } else if (score >= 0 && score < 50) {
            return 'F';
        } else {
            return '!';
        }
    }

    public Student getStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
