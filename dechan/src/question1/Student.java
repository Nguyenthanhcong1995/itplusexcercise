package question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Student implements Activity, Search  {
    Scanner input = new Scanner(System.in);
    List<Student> studentList = new ArrayList<>();
    private int id;
    private String name;
    private String birthDay;
    private double score;

    public Student(int id, String name, String birthDay, double score) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.score = score;
    }
    public Student(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", score=" + score +
                '}';
    }
    @Override
    public void add() {
        System.out.println("Enter student's id: ");
        int studentId = input.nextInt();
        System.out.println("Enter student's name: ");
        input.next();
        String studentName = input.nextLine();
        System.out.println("Enter student's birthday: ");
        String birthDay = input.nextLine();
        System.out.println("Enter student's score");
        double score = input.nextDouble();
        Student student = new Student(studentId, studentName, birthDay, score);
        studentList.add(student);
    }

    @Override
    public void edit() {
        System.out.println("Enter student's id");
        int studentId = input.nextInt();
        List<Student> studentEdit = new ArrayList<>();
        for (Student edit : studentList) {
            if (studentId == edit.getId()) {
                studentEdit.add(edit);
                System.out.println("Enter new name");
                String studentName = input.nextLine();
                edit.setName(studentName);
                System.out.println("Enter new birthday");
                String birthday = input.nextLine();
                edit.setBirthDay(birthday);
                System.out.println("Enter new score");
                double score = input.nextDouble();
                edit.setScore(score);
            }
            if (studentEdit.isEmpty()) {
                System.out.println("Id not match");
            }else {
                System.out.println("Edit successful");
            }
        }
    }

    @Override
    public void searchBy(String name) {
        System.out.println("Enter student's name");
        String studentName = input.nextLine();
        List<Student> search = new ArrayList<>();
        for (Student timkiem : studentList) {
            if (studentName.contains(timkiem.getName()))
                search.add(timkiem);
        }
        if (search.isEmpty()) {
            System.out.println("Name not match");
        } else search.forEach(System.out::println);
    }

    @Override
    public void searchBy(double score) {
        System.out.println("Enter student's score");
        double studentScore = input.nextDouble();
        List<Student> searchScore = studentList.stream()
                .filter(student -> student.getScore() == (studentScore))
                .collect(Collectors.toList());
        if (searchScore.isEmpty()) {
            System.out.println("Score not match");
        } else searchScore.forEach(System.out::println);

    }
}
