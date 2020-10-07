package JavaPractice;

public abstract class BaseFilter implements Book {

    protected static final String baseName = "abstractBook";

    BaseFilter() {
        System.out.println("Base Filter");
    }

}
