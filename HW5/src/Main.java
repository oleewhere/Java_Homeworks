import courses.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Path studentsPath = Path.of("students.txt");
        Path coursesPath = Path.of("courses.txt");
        Path resultPath = Path.of("result.txt");


        //Students txt
        Files.write(studentsPath, List.of(
                "1;Oleh;21;3",
                "2;Anya;18;1",
                "3;Stepan;22;4",
                "4;Mykyta;19;2"
        ));

        //Courses txt
        Files.write(coursesPath, List.of(
                "101;Java Core;1",
                "101;Java Core;2",
                "102;Web Development;2",
                "103;Databases;3"
        ));

        List<Student> students = new ArrayList<>();
        Map<Integer, String> studentNames = new HashMap<>();

        for (String line : Files.readAllLines(studentsPath)) {
            if (line.isBlank()) continue;

            String[] p = line.split(";");
            if (p.length < 4) {
                System.out.println("Skipped incorrect line: " + line);
                continue;
            }

            Student s = new Student(
                    Integer.parseInt(p[0].trim()),
                    p[1].trim(),
                    Integer.parseInt(p[2].trim()),
                    Integer.parseInt(p[3].trim())
            );
            students.add(s);
            studentNames.put(s.getId(), s.getName());
        }

        //Sorting by age
        students.sort((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("================================================");


        List<String> resultLines = new ArrayList<>();
        for (String line : Files.readAllLines(coursesPath)) {
            if (line.isBlank()) continue;

            String[] p = line.split(";");
            if (p.length < 3) {
                System.out.println("Skipped incorrect line: " + line);
                continue;
            }

            int courseId = Integer.parseInt(p[0].trim());
            String courseName = p[1].trim();
            int studentId = Integer.parseInt(p[2].trim());

            Course enrollment = new Course(
                    courseId, courseName, studentId, studentNames.getOrDefault(studentId, "Unknown")
            );

            System.out.println(enrollment);
            resultLines.add(enrollment.toString());
        }

        Files.write(resultPath, resultLines);
    }
}