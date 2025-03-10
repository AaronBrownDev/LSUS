public class HandleBills extends Handler {

    public HandleBills(Handler successor, int billAmount) {
        this.successor = successor;
        this.billAmount = billAmount;
    }

    @Override
    public String handle(float amount) {
        String s = "";
        if (amount > billAmount){
            s = ((int)amount / billAmount) + " bills of $" + this.billAmount + " dispensed --";
        }
        if (successor != null) {
            return s + successor.handle(amount % billAmount);
        } else {
            return s;
        }
    }
}
