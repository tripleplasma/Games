package Teach;

public class Test {

    public static void main(String[] args){
        Person Keng = new Person("Keng",17,"Black");
        Person Tom = new Person("Tom",19,"blond");
        Person[] people = {Keng,Tom};
        System.out.println(Keng.info());
    }

}
