public class Handler500 extends Handler {

    public Handler500(Handler handler) {
        this.successor = handler;
    }

    public String handle(float amount) {
        String s = "";
        if (amount >= 500) {
            s = (int)amount / 500 + " bill(s) of $500\n";
        }
        return s + successor.handle(amount % 500);
    }
}
