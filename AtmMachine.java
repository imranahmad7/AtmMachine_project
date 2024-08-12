import java.util.Scanner;
class Atm{
	float Balance;
	int PIN=1105;
	public void checkPin(){
		System.out.println("Enter PIN: ");
		Scanner sc=new Scanner(System.in);
		int enteredpin=sc.nextInt();
		if(enteredpin==PIN){
			menu();
		}else{
			System.out.println("enter a valid PIN");
			checkPin();
		}
	}
	public void menu(){
		System.out.println("enter your choice: ");
		System.out.println("1.check A/c Balance");
		System.out.println("2.Withdraw Money");
		System.out.println("3.Deposite Money");
		System.out.println("4.EXIT");
		Scanner sc=new Scanner(System.in);
		int opt=sc.nextInt();
		if(opt==1){
			checkBalance();
		}else if(opt==2){
			withdrawMoney();
		}else if(opt==3){
			depositeMoney();
		}else if(opt==4){
			return;
		}else{
			System.out.println("Enter a valid choice");
		}
	}
	public void checkBalance(){
		System.out.println("Balance: "+Balance);
		menu();
	}
	public void withdrawMoney(){
		System.out.println("Enter the amount to withdraw:");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		if(amount>Balance){
			System.out.println("Insufficient Balance");
		}else{
			Balance=Balance-amount;
			System.out.println("Money withdraw successful");
		}
		menu();
	}
	public void depositeMoney(){
		System.out.println("Enter the amount to deposite:");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		Balance=Balance+amount;
		System.out.println("Money deposit successful");
		menu();
	}

}
class AtmMachine{
	public static void main(String[] args){
		Atm obj=new Atm();
		obj.checkPin();
	}
}

























