package question2;

import question1.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String path = "/home/congpv/Downloads/javaweb/dechan_new/hocvien.txt";
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        loadFileToCollection(students);
        Map<Integer, Student> map = students
                .stream()
                .collect(Collectors.toMap(Student::getId, Function.identity()));
        map.entrySet().forEach(System.out::println);
        List<Student> studentShow=new ArrayList<>(map.values());
        studentShow.forEach(System.out::println);
    }

    static List<Student> loadFileToCollection(ArrayList<Student> students) throws FileNotFoundException {
        Reader readerFile = new FileReader(path);
        try (Scanner inputFile = new Scanner(readerFile)) {
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                String[] data = line.split(";");
                int studentId = Integer.parseInt(data[0]);
                String studentName = data[1];
                String studentBirthday = data[2];
                Float studentScore = Float.parseFloat(data[3]);
                Student student = new Student(studentId, studentName, studentBirthday, studentScore);

                students.add(student);

            }
        }
        return students;

    }

    static void show() {
        System.out.println(students.size());
        students.forEach(System.out::println);
    }

    static void remove() {
        System.out.println("Enter student's id");
        int id = input.nextInt();
        List<Student> removeStudent = students.stream()
                .filter(student -> student.getId() == id)
                .collect(Collectors.toList());
        if (removeStudent.isEmpty()) {
            System.out.println("Id not match");
        } else {
            students.removeAll(removeStudent);
        }

    }

    static void arrange() {
        students.sort(Comparator.comparing(Student::getScore));
        students.forEach(System.out::println);
    }

}
