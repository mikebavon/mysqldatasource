package tracom.academy.oopprinc;

public class TestingConstructor {

    private TestingConstructor(){
        System.out.println("constructor is called at instanciation");
    }

    public static void someStuff(){
        new TestingConstructor();
    }
}
