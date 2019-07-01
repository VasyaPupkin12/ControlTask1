public class Student {
    private String fullname;
    private int iq;

    public Student(String fullname, int iq) {
        this.fullname = fullname;
        this.iq = iq;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
