import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends User{

    List<Grade> grades;
    public Student(String faculty_number, String egn){
        super(faculty_number, egn);
        grades = new ArrayList<>();
    }

    @Override
    public UserType getUserType(){
        return UserType.STUDENT;
    }
    public List<Grade> getGrades(){
        return grades;
    }

    @Override
    public String toString(){
        return"Student {" + grades +"} "+super.toString();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Student student = (Student) o;
//        return Objects.equals(grades, student.grades);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), grades);
//    }
}
