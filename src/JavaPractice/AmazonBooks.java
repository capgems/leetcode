package JavaPractice;

public class AmazonBooks extends BaseFilter {

    AmazonBooks() {
        System.out.println("From amazon Constructor");
    }

    @Override
    public void display() {
        System.out.println("from " + baseName + "amazon book");
    }
}
