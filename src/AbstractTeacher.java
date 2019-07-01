public abstract class AbstractTeacher implements Teacher {
    private String fullname;
    private int iq;
    private String study;
    private int mood;

    @Override
    public boolean testStudent(Student student) {
        int luck = (int) Math.round(Math.random());
        return ((student.getIq() > this.iq) || (student.getIq() / this.iq > (1 - luck * this.mood)));
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

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }
}
