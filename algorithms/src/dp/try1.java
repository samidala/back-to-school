package dp;


public class try1 {
        public static void main(String[] args) {
            String name1;
            int age1;
            Dog poodle;

            poodle= new Dog();
            name1="joe";
            poodle.setName1(name1);
            age1=9;
            poodle.setAge1(age1);
            System.out.println("dog's name is "+poodle.getName1());
            System.out.println("Dog's age is "+poodle.getage1());

        }
}

class Dog{
    private String name = "d";
    private int age = 20;

 
    public boolean setName1(String name1) {
        if (name.length()<1||name.length()>20)
            return false;
        name=name1;
        return true;
    }
    public boolean setAge1(int age1) {
        if(age1<0||age1>20)
            return false;
        age=age1;
        return true;
    }
    public String getName1() {
        return name;    
    }
    public int getage1() {
        return age;
    }
}