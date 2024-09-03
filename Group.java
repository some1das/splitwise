import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    private Integer id;
    private String name;
    private List<User> members;

    private List<Expense> expenses;

    private Map<Integer, Map<Integer, Double>> track;

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();

    }

    public void addMember(User member) {
        members.add(member);
    }

    public void settleExpenses() {
        track = new HashMap<>();
        for(Expense expense: expenses) {
            for(AmountUser amountUser: expense.getAllExpenseUsers()) {
                if(track.containsKey(amountUser.getUserId())
                        && track.get(amountUser.getUserId()).containsKey(expense.getPaidByUserId())) {
                    track.get(amountUser.getUserId()).put(expense.getPaidByUserId(), track.get(amountUser.getUserId()).get(expense.getPaidByUserId()) - amountUser.getSplitAmount());

                }
                else if(track.containsKey(expense.getPaidByUserId())) {
                    if(track.get(expense.getPaidByUserId()).containsKey(amountUser.getUserId())) {
                        track.get(expense.getPaidByUserId()).put(amountUser.getUserId(), track.get(expense.getPaidByUserId()).get(amountUser.getUserId()) + amountUser.getSplitAmount());
                    }
                    else {
                        track.get(expense.getPaidByUserId()).put(amountUser.getUserId(), amountUser.getSplitAmount());
                    }

                } else {
                    Map<Integer, Double> fromUser = new HashMap<>();
                    fromUser.put(amountUser.getUserId(), amountUser.getSplitAmount());
                    track.put(expense.getPaidByUserId(),fromUser);
                }

            }
        }


    }

    public void printTracker() {
        for(Map.Entry<Integer, Map<Integer, Double>> entry: track.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for(Map.Entry<Integer, Double> entry2: entry.getValue().entrySet()) {
                System.out.print("("+entry2.getKey() + "," + entry2.getValue() + ")");
            }
            System.out.println("\n---------------------------------------");
        }
    }

    public void addExpnse(Expense expense) {
        this.expenses.add(expense);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
