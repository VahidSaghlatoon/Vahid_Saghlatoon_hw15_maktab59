package question2.entity;

public enum AccountState {
    ACTIVE("active") ,
    INACTIVE("inactive");

    private final String state ;
    AccountState(String state) {
        this.state = state ;
    }

    public String getState() {
        return state;
    }
}
