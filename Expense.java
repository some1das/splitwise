import java.util.ArrayList;
import java.util.List;

public class Expense {
    private Integer id;

    private Double amount;
    private Integer paidByUserId;
    private Stratagy stratagy;

    private List<AmountUser> expenseUsers;

    public Expense(Integer id, Double amount, Integer paidByUserId, Stratagy stratagy) {
        this.id = id;
        this.paidByUserId = paidByUserId;
        this.stratagy = stratagy;
        this.amount = amount;
        this.expenseUsers = new ArrayList<>();
    }

    private boolean isPercentageExceed(Double percentage) {
        Double totalPercentage = 0d;
        for(AmountUser amountUser: expenseUsers) {
            totalPercentage += amountUser.getPercentage();
        }
        if(totalPercentage + percentage > 100) {
            return false;
        }
        return true;
    }

    public String addExpenseUser(Integer userId, Double percentage, Double splitAmount) {
        if((this.stratagy == Stratagy.PERCENTAGE && percentage == null) || (this.stratagy != Stratagy.PERCENTAGE && percentage != null)) {
            return "Please check the input";
        }
        if(percentage != null && splitAmount != null) {
            return "Error: Please Enter only one parameter";
        } else if(percentage != null && percentage > 100) {
            return "Percentage can not be greater than 100";
        } else if(percentage != null && isPercentageExceed(percentage)) {
            return "Sum of all percentage can not be greater than 100";
        }
        if(stratagy.equals(Stratagy.PERCENTAGE)) {
            expenseUsers.add(new AmountUser(userId, null, percentage));
        }
        if(stratagy.equals(Stratagy.EQUAL)) {
            expenseUsers.add(new AmountUser(userId, null, null));
        }
        if(stratagy.equals(Stratagy.AMOUNT)) {
            expenseUsers.add(new AmountUser(userId, null, null));
        }
        return "Added Successfully";

    }

    public void calculateSplit() {
        if(stratagy.equals(Stratagy.EQUAL)) {
            Integer len = expenseUsers.size() + 1;
            Double perUserAmount = (amount / len);
            for(AmountUser amountUser: expenseUsers) {
                amountUser.setSplitAmount(perUserAmount);
            }
        }
    }

    public List<AmountUser> getAllExpenseUsers() {
        return this.expenseUsers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaidByUserId() {
        return paidByUserId;
    }

    public void setPaidByUserId(Integer paidByUserId) {
        this.paidByUserId = paidByUserId;
    }

    public Stratagy getStratagy() {
        return stratagy;
    }

    public void setStratagy(Stratagy stratagy) {
        this.stratagy = stratagy;
    }


}
