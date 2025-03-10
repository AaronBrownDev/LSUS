public abstract class Handler {
    Handler successor;
    int billAmount;
    public abstract String handle(float amount);
}
