package arrays;

public class Overriding {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        b.process(c);
    }

    static class A{
        public void process(A a){
            System.out.println("A");
        }
    }
    static class B extends  A{
        public void process(B a){
            System.out.println("B");
        }
    }
    static class C extends  A{
        public void process(B a){
            System.out.println("C");
        }
    }
}
