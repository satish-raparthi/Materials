public class TestAccount {
	public static void main(String[] args) {
		double b1, b2, aamt;
		try {
			Account a1 = new Account(105, "Pennant", 50000);
			Account a2 = new Account(106, "Nexgen", 30000);

			a1.deposit(53400);
			a1.withdraw(120000);
			a2.deposit(120000);
			b1 = a1.getbal();
			System.out.println("Balance at the end " + b1);

		} catch (TransException n) {
			b2 = n.getbal();
			aamt = n.getamt();
			System.out.println("Insufficient Funds");
			System.out.println("Balance in the account is only :" + b2 + "whle Asked amount :" + aamt);
		}
		 catch (TransedException n) {
			b2 = n.getbal();
			aamt = n.getamt();
			System.out.println("Insufficient Funds");
			System.out.println("Balance in the account is only :" + b2 + "whle Asked amount :" + aamt);
		}
	}

}

class TransException extends Exception {
	private static final long serialVersionUID = 1L;
	double bal;
	double amt;

	public TransException(double bal, double amt) {
		this.bal = bal;
		this.amt = amt;

	}

	public void setbal(double b) {
		bal = b;
	}

	public double getbal() {
		return bal;
	}

	public double getamt() {
		return amt;
	}
}
class TransedException extends Exception {
	private static final long serialVersionUID = 1L;
	double bal;
	double amt;

	public TransedException(double bal, double amt) {
		this.bal = bal;
		this.amt = amt;

	}

	public void setbal(double b) {
		bal = b;
	}

	public double getbal() {
		return bal;
	}

	public double getamt() {
		return amt;
	}
}

class Account {
	int aid;
	String aname;
	double bal;

	public Account(int aid, String aname, double bal) {
		this.aid = aid;
		this.aname = aname;
		this.bal = bal;
	}

	public double getbal() {
		return bal;
	}

	public void deposit(int amt) {
		bal = bal + amt;
	}

	public void withdraw(int amt) throws TransException,TransedException {
		if (amt < bal) {
			bal = bal - amt;
		} 
		else if(false){
			TransException te = new TransException(bal, amt);
			throw te;
		}
		else{
			TransedException te1 = new TransedException(bal, amt);
			throw te1;
		}
		
	}

}