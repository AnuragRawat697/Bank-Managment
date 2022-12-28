import java.io.*;
import java.util.*;

public class MainC {
	public static int choice;
	public static String FirstName;
	public static String LastName;
	public static double Money;
	public static String hashString;
	static Hashtable<Integer, MemberInfo> hashT1 = new Hashtable<>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		do {
			menu();
			System.out.print("Enter your choice: ");
			try {
				choice = input.nextInt();
			}

			catch (Exception ex) {
				System.out.println("Non-numeric input");
				System.out.println();
				break;
			}
			switch (choice) {
			case 1:
				MemberInfo member = getAccountDetails(input);
				addAccount(member);
				break;
			case 2:

				System.out.print("Enter id you want to delete: ");
				int id = input.nextInt();
				deleteAccount(id);
				break;
			case 3:

				balanceDetails(input);
				break;

			case 4:
				getAccountUpdateDetails(input);
				break;
			case 5:
				break;
			default:
				System.out.println("Make a selection according to menu");
				break;
			}
		} while (choice != 5);
	}

	public static MemberInfo getAccountDetails(Scanner input) {
		MemberInfo member = new MemberInfo();

		System.out.print("Enter first name: ");
		FirstName = input.next();
		System.out.print("Enter last name: ");
		LastName = input.next();

		System.out.print("Enter the amount you want to start: ");
		Money = input.nextDouble();
		System.out.println("Account has been added\n");
		int idNum = (int) (Math.random() * 20000);
		System.out.println(FirstName + " Your account id number is " + idNum);

		member.setFName(FirstName);
		member.setLName(LastName);
		member.setId(idNum);
		member.setBalance(Money);

		return member;
	}

	public static void addAccount(MemberInfo memberToBeAdded) {
		hashT1.put(memberToBeAdded.getId(), memberToBeAdded);
	}

	public static void deleteAccount(int id) {

		if (hashT1.containsKey(id)) {
			hashT1.remove(id);
			System.out.println("Id has been removed");
		}

		else {
			System.out.println("You have entered the wrong ID.");
		}

	}

	public static void balanceDetails(Scanner input) {
		double addMoney;
		double withdrawMoney;
		double newBalance = 0;
		System.out.print("Enter your account number: ");
		int accNum = input.nextInt();
		System.out.print("Enter 'A' to add money or enter 'W' to withdraw money: ");
		String userChoice = input.next();
		if (userChoice.equals("A")) {
			System.out.print("Enter the amount to be added: ");
			addMoney = input.nextDouble();
			updateBalance(accNum, userChoice, addMoney);
		} else if (userChoice.equals("W")) {
			System.out.print("Enter the amount to withdraw: ");
			withdrawMoney = input.nextDouble();
			updateBalance(accNum, userChoice, withdrawMoney);
		} else {
			System.out.println("Enter either 'A' or 'B'");
		}

	}

	public static void updateBalance(int accNum, String userChoice, double money) {

		double newBalance = 0;

		if (hashT1.containsKey(accNum)) {
			MemberInfo account = hashT1.get(accNum);

			double currentBal = account.getBalance();
			if (userChoice.equals("A")) {
				System.out.print("Enter the amount to be added: ");
				newBalance = currentBal + money;
				System.out.println(money + " has been added to your account");
				System.out.println("Current balance: " + currentBal);
				System.out.println("Updated balance: " + newBalance);
			} else if (userChoice.equals("W")) {
				newBalance = currentBal - money;
				System.out.println(money + " has been withdrawn to your account");
				System.out.println("Current balance: " + currentBal);
				System.out.println("Updated balance: " + newBalance);
			} else {
				System.out.println("Enter either 'A' or 'B'");
			}
			account.setBalance(newBalance);

		}
	}

	public static void getAccountUpdateDetails(Scanner input) {

		System.out.print("Enter your account number: ");
		int accNum = input.nextInt();
		System.out.println("Select your choice");
		System.out.println("1. Change your first name");
		System.out.println("2. Change your last name");
		System.out.print("Enter: ");
		int updateChoice = input.nextInt();
		System.out.print("Enter your first name: ");
		String newFirstName = input.next();
		System.out.print("Enter your last name: ");
		String newLastName = input.next();
		updateAccount(accNum, updateChoice, newFirstName, newLastName);
	}

	public static void updateAccount(int accountToBeUpdated, int choice, String newFirstName, String newLastName) {

		if (hashT1.containsKey(accountToBeUpdated)) {
			MemberInfo account = hashT1.get(accountToBeUpdated);
			String currentFName = account.getFName();
			String currentLName = account.getLName();
			if (choice == 1) {
				System.out.println("Your current first name in our data is " + currentFName);
				account.setFName(newFirstName);
			}
			if (choice == 2) {
				System.out.println("Your current last name in our data is " + currentLName);
				account.setLName(newLastName);
			}

		} else {
			System.out.println("Account not found");
		}
	}

	public static void menu() {

		System.out.println("\n Choose the option to perform the operation: ");
		System.out.println("	1.	Open an account");
		System.out.println("	2.	Delete an account");
		System.out.println("	3.	ADD or Withdraw Money");
		System.out.println("	4.	Make changes to your account");
		System.out.println("	5.	Exit");
		System.out.println();
	}

}

class MemberInfo {
	String fName;
	String lName;
	int id;
	double balance;

	public String getFName() {
		return this.fName;
	}

	public String getLName() {
		return this.lName;
	}

	public int getId() {
		return this.id;
	}

	public double getBalance() {
		return this.balance;
	}

	protected void setFName(String fName) {
		this.fName = fName;
	}

	protected void setLName(String lName) {
		this.lName = lName;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}
}