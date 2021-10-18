package question1;

public class MainStudent {


    public static void main(String[] args) {
        Student student=new Student();
        student.searchBy("abc");
        student.searchBy(9);
        student.add();
        student.edit();
    }
}
