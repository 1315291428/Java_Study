package Homework;

public class Main {
    public static void main(String args[]){
        System.out.print("Hello, Java!\n");
        Student zhang = new Student();
        zhang.speak();
    }
}
class Student{
    void speak(){
        System.out.print("We are students.");
    }
}

