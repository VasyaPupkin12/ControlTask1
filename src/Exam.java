import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exam {
    private Map<Student, Boolean> result;
    ArrayList<Student> students;
    AbstractTeacher teacher;

    public Exam(ArrayList<Student> students, AbstractTeacher teacher){
        this.students = students;
        this.teacher = teacher;
        result = new HashMap<>();
    }

    public void start(){
        teacher.mood = (int)Math.round(Math.random());
        for(Student s : students)
            result.put(s, teacher.testStudent(s));
    }

    public void clearResult(){
        result.clear();
        students.clear();
        teacher = null;
    }

    public void writeReport(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(teacher.study + ".txt"));
            writer.write(String.format("Преподаватель %s, настроение %d\n", teacher.fullname, teacher.mood));
            writer.newLine();
            for(Map.Entry<Student, Boolean> s: result.entrySet()){
                if(s.getValue() == Boolean.TRUE){
                    writer.write(String.format("%s(IQ=%d) - сдал\n", s.getKey().fullname, s.getKey().iq));
                }
                else
                {
                    writer.write(String.format("%s(IQ=%d) - не сдал\n", s.getKey().fullname, s.getKey().iq));
                }
            }
            writer.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
