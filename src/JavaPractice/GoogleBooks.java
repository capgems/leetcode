package JavaPractice;

public class GoogleBooks extends BaseFilter {

    GoogleBooks() {
        System.out.println("From google constructor");
    }

    @Override
    public void display() {
        System.out.println("from " + baseName + "google book");
    }
}
