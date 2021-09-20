public class StudentManagement {
    Student[] students = new Student[100];
    int num = 0;

    /**
     * sameGroup is checked relationship of group.
     * @param s1 is group of student 1.
     * @param s2 is group of student 2.
     * @return
     */
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * addStudent.
     * @param newStudent is a new student.
     */
    public void addStudent(Student newStudent) {
        if (newStudent != null) {
            students[num] = newStudent;
            num++;
        }
    }

    /**
     * get students by group.
     * @return students by group.
     */
    public String studentsByGroup() {
        String allclass = "";
        String liststudent = "";
        for (int i = 0; i < num; i++) {
            String group = students[i].getGroup();
            if (allclass.contains(group) == true) {
                continue;
            }
            allclass += group + " ";
            liststudent += group + "\n";
            liststudent += students[i].getInfo() + "\n";
            for (int j = i + 1; j < num; j++) {
                if (sameGroup(students[i], students[j]) == true) {
                    liststudent += students[j].getInfo() + "\n";
                }
            }
        }
        return liststudent.trim();
    }

    /**
     * remove student.
     * @param id is an id.
     */
    public void removeStudent(String id) {
        for (int i = 0; i < num - 1; i++) {
            if ((students[i].getId()).equals(id) == true) {
                for (int j = i + 1; j < num; j++) {
                    students[j - 1] = students[j];
                }
                num--;
                break;
            }
        }
        if (students[num - 1] != null && (students[num - 1].getId()).equals(id) == true) {
            students[num - 1] = null;
            num--;
        }
    }
}
