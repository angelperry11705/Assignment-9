public class Student {
    private String name;
    private double totalPoints;
    private int courseCount;

    public Student(String name) {
        this.name = name;
        this.totalPoints = 0.0;
        this.courseCount = 0;
    }

    public void addCourse(double gradePoints) {
        totalPoints += gradePoints;
        courseCount++;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return "Undergraduate";
    }

    public double getGPA() {
        if (courseCount == 0) {
            return 0.0;
        }
        return totalPoints / courseCount;
    }

    public double getMinGPA() {
        return 2.0;
    }

    public boolean isGoodStanding() {
        return getGPA() >= getMinGPA();
    }

    @Override
    public String toString() {
        return getName() + " (" + getLevel() + ", GPA " + String.format("%.2f", getGPA()) + ")";
    }
}
