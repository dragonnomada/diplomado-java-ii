import entities.Robot;

public class A01_TestRobot {

    public static void main(String[] args) {

        Robot r1 = new Robot();          // entities.Robot@65ab7765
        Robot r2 = new Robot(7, 6); // entities.Robot@1b28cdfa
        Robot r3 = new Robot(7, 6); // entities.Robot@1b28cdfa

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

    }

}
