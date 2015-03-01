

public class BankProgram
{
  public static void main(String[] args)
  {
    char choice;
    int size;


    System.out.print("Maximum number of accounts? ");
    size = EasyScanner.nextInt();

    // create Bank object
    Bank myBank = new Bank(size);

    // offer menu
    do
    {
      System.out.println();
      System.out.println("1. Create new account");
      System.out.println("2. Remove an account");
      System.out.println("3. Deposit money");
      System.out.println("4. Withdraw money");
      System.out.println("5. Check account details");
      System.out.println("6. Quit");
      System.out.println();
      System.out.print("Enter choice [1-6]: ");

      // get choice
      choice = EasyScanner.nextChar();
      System.out.println();

      // process menu options
      switch (choice)
      {
        case '1': option1(myBank);
                  break;
        case '2': option2(myBank);
                  break;
        case '3': option3(myBank);
                  break;
        case '4': option4(myBank);
                  break;
        case '5': option5(myBank);
                  break;
        case '6': break;

        default:  System.out.println("Invalid entry");
      }
    }
    while (choice != '6');
  }

  // add account
  private static void option1(Bank myBankIn)
  {
    // get details from user
    System.out.print("Enter account number: ");
    String number = EasyScanner.nextString();
    System.out.print("Enter account name: ");
    String name = EasyScanner.nextString();


    // create new account
    BankAccount account = new BankAccount(number, name);
    // add account to list



    boolean ok = myBankIn.add(account);
    if (!ok)           //if(ok == false)
    {
      System.out.println("The list is full");
    }
    else
    {
      System.out.println("Account created");
    }
  }

  // remove account
  private static void option2(Bank myBankIn)
  {
    // get account number of account to remove
    System.out.print("Enter account number: ");
    String number = EasyScanner.nextString();
    // delete item if it exists
    boolean ok = myBankIn.remove(number);
    if (!ok)
    {
      System.out.println("No such account number");
    }
    else
    {
      System.out.println("Account removed");
    }
  }

  // deposit money in an account
  private static void option3(Bank myBankIn)
  {
    // get details from user
    System.out.print("Enter account number: ");
    String number = EasyScanner.nextString();
    System.out.print("Enter amount to deposit: ");
    double amount = EasyScanner.nextDouble();
    boolean ok = myBankIn.depositMoney(number, amount); // attempt to deposit
    if (!ok)
    {
      System.out.println("No such account number");
    }
    else
    {
      System.out.println("Money deposited");
    }
  }

  // withdraw money from an account
  private static void option4(Bank myBankIn)
  {
    // get details from user
    System.out.print("Enter account number: ");
    String number = EasyScanner.nextString();
    System.out.print("Enter amount to withdraw: ");
    double amount = EasyScanner.nextDouble();
    boolean ok = myBankIn.withdrawMoney(number, amount); // attempt to withdraw
    if (!ok)
    {
      System.out.println("No such account number");
    }
    else
    {
      System.out.println("Money withdrawn");
    }
  }

  // check account details
  private static void option5(Bank myBankIn)
  {
    // get details from user
    System.out.print("Enter account number ");
    String number = EasyScanner.nextString();
    BankAccount account = myBankIn.getItem(number);
    if (account == null)
    {
      System.out.println("No such account number");
    }
    else
    {
      System.out.println("Account number: " + account.getAccountNumber());
      System.out.println("Account name: " + account.getAccountName());
      System.out.println("Balance: " + account.getBalance());
      System.out.println();
    }
  }
}
