package Homework;

public class Homework2 {
    public static void main(String args[]){
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        a.fa();
        b.fb();
    }
}
class ClassA{
    public void fa(){
        System.out.println("I am A");
    }
}
class ClassB{
    public void fb(){
        System.out.println("I am B");
    }
}
