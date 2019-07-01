import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int iq = (int) (Math.random() * 170);
            students.add(new Student("nameStudent" + i, iq));
        }
        EnglishTeacher et = new EnglishTeacher("EnglishTeacher1", 100);
        MathTeacher mt = new MathTeacher("MathTeacher1", 120);
        HistoryTeacher ht = new HistoryTeacher("HistoryTeacher1", 140);
        Exam ex = new Exam(students, et);
        ex.start();
        ex.writeReport();
        ex = new Exam(students, mt);
        ex.start();
        ex.writeReport();
        ex = new Exam(students, ht);
        ex.start();
        ex.writeReport();
    }
}
