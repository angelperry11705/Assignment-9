import java.util.ArrayList;

public class RosterMain {

    public static void main(String[] args) {
        giveIntro();

        Roster roster = buildRoster();

        System.out.println("The roster has " + roster.size() + " students.");
        System.out.println();

        roster.printReport();
        System.out.printf("Average GPA: %.2f%n", roster.averageGPA());

        System.out.println();

        System.out.println("Looking for Dan: " + roster.find("Dan"));
        System.out.println("Looking for Zoe: " + roster.find("Zoe"));

        System.out.println();

        System.out.println("Bob leaves the university: removed = "
                + roster.removeByName("Bob"));
        System.out.println("Zoe leaves the university: removed = "
                + roster.removeByName("Zoe"));

        System.out.println();

        System.out.println("The graduate students:");
        ArrayList<Student> grads = roster.getByLevel(GraduateStudent.LEVEL);
        printList(grads);

        System.out.println();

        int removed = roster.removeNotInGoodStanding();
        System.out.println(removed + " students are not in good standing and were removed.");

        System.out.println();

        roster.printReport();
        System.out.printf("Average GPA: %.2f%n", roster.averageGPA());
    }

    public static void giveIntro() {
        System.out.println("This program keeps a roster of students in an ArrayList.");
        System.out.println("The roster holds plain, graduate and doctoral students together.");
        System.out.println();
    }

    public static Roster buildRoster() {
        Roster roster = new Roster();

        roster.add(withGrades(new Student("Alice"),
                new double[]{4.0, 3.5, 3.0}));

        roster.add(withGrades(new Student("Bob"),
                new double[]{2.0, 1.5, 1.0}));

        roster.add(withGrades(new GraduateStudent("Carol", "Robotics"),
                new double[]{3.5, 3.0}));

        roster.add(withGrades(new GraduateStudent("Dan", "Networks"),
                new double[]{3.0, 2.5}));

        roster.add(withGrades(new DoctoralStudent("Eve", "AI", "Lee"),
                new double[]{4.0, 3.0}));

        roster.add(withGrades(new DoctoralStudent("Fay", "Security", "Park"),
                new double[]{3.5, 3.0}));

        return roster;
    }

    public static Student withGrades(Student student, double[] gradePoints) {
        for (double points : gradePoints) {
            student.addCourse(points);
        }
        return student;
    }

    public static void printList(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("  (none)");
            return;
        }

        for (Student s : list) {
            System.out.println("  " + s.getName() + " (" + s.getLevel() + ")");
        }
    }
}
