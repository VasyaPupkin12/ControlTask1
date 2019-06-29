public abstract class AbstractTeacher implements Teacher{
    protected String fullname;
    protected int iq;
    protected String study;
    protected int mood;

    @Override
    public boolean testStudent(Student student) {
        int luck = (int)Math.round(Math.random());
        return ((student.iq > this.iq) && (student.iq / this.iq > (1 - luck * this.mood)));
    }
}
