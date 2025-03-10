public class Main {
    public static void main(String[] args) {
        Handler handle1 = new Handler1(null);
        Handler handle20 = new Handler20(handle1);
        Handler handle500 = new Handler500(handle20);

        System.out.println(handle500.handle(6422));
    }
}