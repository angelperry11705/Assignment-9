import java.util.ArrayList;

public class Roster {
    private ArrayList<Student> students;

    public Roster() {
        students = new ArrayList<Student>();
    }

    public void add(Student student) {
        if (student == null) {
            throw new NullPointerException();
        }
        students.add(student);
    }

    public int size() {
        return students.size();
    }

    public Student find(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public boolean removeByName(String name) {
        Student s = find(name);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }

    public ArrayList<Student> getByLevel(String level) {
        ArrayList<Student> result = new ArrayList<Student>();
        for (Student s : students) {
            if (s.getLevel().equals(level)) {
                result.add(s);
            }
        }
        return result;
    }

    public int removeNotInGoodStanding() {
        int count = 0;
        for (int i = students.size() - 1; i >= 0; i--) {
            if (!students.get(i).isGoodStanding()) {
                students.remove(i);
                count++;
            }
        }
        return count;
    }

    public double averageGPA() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (Student s : students) {
            total += s.getGPA();
        }
        return total / students.size();
    }

    public void printReport() {
        System.out.printf("%-10s %-10s %5s %5s  %s%n",
                "Name", "Level", "GPA", "Min", "Thesis topic");
        System.out.println("------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-10s %-10s %5.2f %5.2f",
                    s.getName(),
                    s.getLevel(),
                    s.getGPA(),
                    s.getMinGPA());

            if (s instanceof GraduateStudent) {
                GraduateStudent gs = (GraduateStudent) s;
                System.out.print("  " + gs.getThesisTopic());
            }

            System.out.println();
        }
    }
}
