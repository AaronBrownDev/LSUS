public class Handler20 extends Handler {
    public Handler20(Handler handler) {
        this.successor = handler;
    }

    @Override
    public String handle(float amount) {
        String s = "";
        if (amount >= 20) {
            s = (int)amount / 20 + " bill(s) of $20\n";
        }
        if (this.successor != null) {
            return s + successor.handle(amount % 20);
        } else {
            return s;
        }
    }
}
