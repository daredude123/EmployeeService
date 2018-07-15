package AddUser.Implementation;

public enum ReturnState {

    SUCCESS("1"),
    FAILED("2");

    private String state;

    ReturnState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

