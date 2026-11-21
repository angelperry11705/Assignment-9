public class DoctoralStudent extends GraduateStudent {
    public static final String LEVEL = "Doctoral";

    private String advisor;

    public DoctoralStudent(String name, String thesisTopic, String advisor) {
        super(name, thesisTopic);
        this.advisor = advisor;
    }

    @Override
    public String getLevel() {
        return LEVEL;
    }

    public String getAdvisor() {
        return advisor;
    }

    @Override
    public String toString() {
        return getName() + " (" + getLevel() + ", GPA " + String.format("%.2f", getGPA()) +
                ", thesis: " + getThesisTopic() + ", advisor: " + advisor + ")";
    }
}
