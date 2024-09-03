import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user1 = new User(1, "Suman", "suman.das@gmail.com");
        User user2 = new User(2, "Pawan", "pawandeep.singh@gmail.com");
        User user3 = new User(3, "Aman", "aman.birla@gmail.com");
        User user4 = new User(4, "KP", "kp@gmail.com");

        Group splitBills = new Group(1, "Split Bills" );
        splitBills.addMember(user1);
        splitBills.addMember(user2);
        splitBills.addMember(user3);
        splitBills.addMember(user4);

        Expense e1 = new Expense(1, 300d, 1, Stratagy.EQUAL);

        e1.addExpenseUser(2, null, null);
        e1.addExpenseUser(3, null, null);

        e1.calculateSplit();
        splitBills.addExpnse(e1);


        Expense e2 = new Expense(2, 300d, 2, Stratagy.EQUAL);

        e2.addExpenseUser(1, null, null);
        e2.addExpenseUser(3, null, null);

        e2.calculateSplit();

        splitBills.addExpnse(e2);

        Expense e3 = new Expense(3, 900d, 2, Stratagy.EQUAL);

        e3.addExpenseUser(1, null, null);
        e3.addExpenseUser(3, null, null);
        e3.addExpenseUser(4, null, null);

        e3.calculateSplit();

        splitBills.addExpnse(e3);

        splitBills.settleExpenses();
        splitBills.printTracker();

    }
}
