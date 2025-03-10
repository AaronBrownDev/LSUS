public class Handler1 extends Handler {

    public Handler1(Handler next) {
        this.successor = next;
    }

    @Override
    public String handle(float amount) {
        String s = "";
        if (amount >= 1) {
            s += (int)amount + " bill(s) of $1";
        }
        if (this.successor != null) {
            return s + successor.handle(amount % 1);
        } else {
            return s;
        }

    }
}
