package UserImplementation.Implementation;

public enum ReturnState {

    SUCCESS("Success"),
    FAILED("Failed");

    private String state;

    ReturnState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

