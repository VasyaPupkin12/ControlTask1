import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exam {
    private Map<Student, Boolean> result;
    ArrayList<Student> students;
    AbstractTeacher teacher;

    public Exam(ArrayList<Student> students, AbstractTeacher teacher) {
        this.students = students;
        this.teacher = teacher;
        result = new HashMap<>();
    }

    public void start() {
        teacher.setMood((int) Math.round(Math.random()));
        students.forEach(s -> result.put(s, teacher.testStudent(s)));
    }

    public void clearResult() {
        result.clear();
        students.clear();
        teacher = null;
    }

    public void writeReport() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(teacher.getStudy() + ".txt"));
            StringBuilder str = new StringBuilder();
            str.append("Преподаватель " + teacher.getFullname());
            str.append(", настроение " + teacher.getMood() + "\n");
            writer.write(str.toString());
            writer.newLine();
            ArrayList<StringBuilder> list = new ArrayList<>();
            result.forEach((k, v) -> {
                if (v == Boolean.TRUE) {
                    StringBuilder buf = new StringBuilder();
                    buf.append(k.getFullname() + "(IQ=" + k.getIq() + ")");
                    buf.append("- сдал\n");
                    list.add(buf);
                } else {
                    StringBuilder buf = new StringBuilder();
                    buf.append(k.getFullname() + "(IQ=" + k.getIq() + ")");
                    buf.append("- не сдал\n");
                    list.add(buf);
                }

            });
            for (StringBuilder s : list) writer.write(s.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
