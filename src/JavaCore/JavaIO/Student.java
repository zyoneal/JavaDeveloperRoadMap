package JavaCore.JavaIO;

import JavaCore.Collections.SetAndMap.Map.TreeMap.SubjectGrade;

import java.io.Serializable;
import java.util.Set;

// Serializable - для того что бы можно было сериализировать обьект в бинарный поток и передать в файл или по сети
// Каждое поле в этом обьекте должно быть сериалайзбл. Если есть ссылочный тип, надо заимплементить ему Serializable
// Если мы не можем имплементить сериалайзбл у поля можно написать перед ним, перед его типом
// transient и оно не будет сериализироваться и передаваться в файл (Будет просто игнорироваться, будет null)
public class Student implements Serializable {

    private String studentName;

    private float averageGrade;

    private Set<SubjectGrade> grades;

    public Student(String studentName, float averageGrade, Set<SubjectGrade> grades) {
        this.studentName = studentName;
        this.averageGrade = averageGrade;
        this.grades = grades;
    }

    public String getStudentName() {
        return studentName;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public Set<SubjectGrade> getGrades() {
        return grades;
    }

}
