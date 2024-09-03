public class AmountUser {
    private Integer userId;
    private Double amount;

    private Double percentage;

    private Double splitAmount;

    public AmountUser(Integer userId, Double amount, Double percentage) {
        this.userId = userId;
        this.amount = amount;
        this.percentage = percentage;

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(Double splitAmount) {
        this.splitAmount = splitAmount;
    }
}
