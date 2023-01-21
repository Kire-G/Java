import java.io.Serializable;
import java.util.Objects;

public class Grade implements Serializable {
    private String subject;
    private int semester;
    private int grade;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Grade(String subject, int semester, int grade){
        this.subject=subject;
        this.semester=semester;
        this.grade=grade;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null || getClass() != o.getClass())return false;
        Grade gr = (Grade)o;
        return grade == gr.grade && semester == gr.semester && Objects.equals(subject, gr.subject);
    }

    @Override
    public int hashCode(){
        return Objects.hash(grade, semester, subject);
    }
}
