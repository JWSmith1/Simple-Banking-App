import java.util.Scanner;

public class Account {
    /**
     * Variables for each user's account
     */
    int balance;
    int pastTransaction;
    String name;
    String customerID;

    /**
     *
     * @param name Name of Customer
     * @param customerID ID of Customer
     */
    public Account(String name, String customerID) {
        this.name = name;
        this.customerID = customerID;
    }

    /**
     *
     * @param amount Given value of money to be deposited to bank account
     */
    void depoist(int amount){
        if (amount != 0){
            balance += amount;
            pastTransaction = amount;
        }
        else{
            System.out.println("Must deposit valid amount");
        }

    }

    /**
     *
     * @param amount Given value of money to be withdrawn from bank account
     */
    void withdraw(int amount){
        if (amount != 0){
            balance -= amount;
            pastTransaction = -1 * amount;
        }
        else{
            System.out.println("Must deposit valid amount");
        }
    }

    /**
     * Function allows user to visualize their past transaction type and amount
     */
    void checkPreviousTransaction(){
        if (pastTransaction > 0){
            System.out.println("Depositied: " + pastTransaction);
        }
        else if (pastTransaction < 0){
            System.out.println("Withdrew: " + Math.abs(pastTransaction));
        }
        else{
            System.out.println("No Transaction");
        }
    }

    /**
     * Fuction allows users to calcualte the amount of intersted earned on a given amount of money(their balance)
     * over a given time frame at a given interest rate
     * @param years length of time for investment
     */
    void calcInterest(int years){
        double interestRate = .0185;
        double balanceWithInterest = (balance * interestRate * years) + balance;
        System.out.println("The current interst rate is: " + (100 * interestRate) + " %");
        System.out.println("Your new balance after " + years + " is: " + balanceWithInterest);
    }

    /**
     * Method that includes all functionality implemented above and allows the user to dicate which actions to perform
     */
    void displayMenu() {
        char choice = '\0';
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome, " + name + "!");
        System.out.println("Your ID number is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Make a Deposit");
        System.out.println("C. Make a Withdraw");
        System.out.println("D. View Previous Transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit");

        char option;
        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scnr.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("*****************");
                    System.out.println("Balance = $" + balance);
                    System.out.println("*****************");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("Enter an amount to deposit:");
                    int amount = scnr.nextInt();
                    depoist(amount);
                    System.out.println("Your new balance is: $" + balance);
                    break;

                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int withdrawAmt = scnr.nextInt();
                    withdraw(withdrawAmt);
                    System.out.println("Your new balance is: $" + balance);
                    break;

                case 'D':
                    System.out.println("*****************");
                    checkPreviousTransaction();
                    System.out.println("*****************");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("Enter how many years you want to accure interest: ");
                    int years = scnr.nextInt();
                    calcInterest(years);
                    break;

                case 'F':
                    System.out.println("***************");
                    break;

                default:
                    System.out.println("Error: Invalid Option. Please enter A, B, C, D, E, or F");
                    break;


            }


        } while (option != 'F');
        System.out.println("Thanks for banking with us!!");


    }




}
