package question2.entity;

public enum TransactionType {
    BALANCE("balance"),
    INVOICE("invoice"),
    DEPOSIT("deposit"),
    WITHDRAW("withdraw"),
    TRANSFER("transfer");

    private final String type ;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
