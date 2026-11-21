public class GraduateStudent extends Student {
    public static final String LEVEL = "Graduate";

    private String thesisTopic;

    public GraduateStudent(String name, String thesisTopic) {
        super(name);
        this.thesisTopic = thesisTopic;
    }

    @Override
    public String getLevel() {
        return LEVEL;
    }

    @Override
    public double getMinGPA() {
        return 3.0;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    @Override
    public String toString() {
        return getName() + " (" + getLevel() + ", GPA " + String.format("%.2f", getGPA()) +
                ", thesis: " + thesisTopic + ")";
    }
}
