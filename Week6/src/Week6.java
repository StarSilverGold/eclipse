import java.util.Scanner;

class Food{
	String name;
	int calorie;
}


abstract class Noodle extends Food {
	
	int numNoodle;
	abstract String getNoodleName();
	abstract int getNoodleCal();
	abstract int getNoodleCnt();
	abstract void order(int cnt);
	
}


abstract class Rice extends Food {
	
	int numRice;
	abstract String getRiceName();
	abstract int getRiceCal();
	abstract int getRiceCnt();
	abstract void order(int cnt);
	
}

class Ramen extends Noodle {

	Ramen (){
		name = "Ramen";
		calorie = 30;
	}
	
	String getNoodleName() {
		return name;
	}
	int getNoodleCal() {
		return calorie;
	}
	int getNoodleCnt() {
		return numNoodle;	
	}
	void order(int cnt) {
		numNoodle+=cnt;	
	}
}


class Fried extends Rice {
	Fried(){
		name = "Fried";
		calorie = 20;
	}

	String getRiceName() {
		return name;
	}
	int getRiceCal() {
		return calorie;
	}
	int getRiceCnt() {
		return numRice;	
	}
	void order(int cnt) {
		numRice+=cnt;	
	}
}


class Sushi extends Rice{
	
	Sushi(){
		name = "Sushi";
		calorie = 10;
	}

	String getRiceName() {
		return name;
	}
	int getRiceCal() {
		return calorie;
	}
	int getRiceCnt() {
		return numRice;	
	}
	void order(int cnt) {
		numRice+=cnt;	
	}
}

public class Week6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int input, cal=0;
		Ramen ramen = new Ramen();
		Fried fried = new Fried();
		Sushi sushi = new Sushi();
		
		System.out.println("Menu: Ramen, Fried, Sushi");
		System.out.println("Enter number (1: order), (2: check), (3: finish)");
		input = sc.nextInt();
		
		while(input!=3) {
			switch(input) {
			case 1:{
				sc.nextLine();
				System.out.println("Enter food to order");
				String name = sc.nextLine();
				if(name.equals(ramen.getNoodleName())) {
					System.out.println("Enter "+name+" count");
					int num = sc.nextInt();
					cal+=(ramen.getNoodleCal()*num);
					ramen.order(num);
					System.out.println(num+" "+name+"(s) ordered successfully");
				}
				else if(name.equals(fried.getRiceName())) {
					System.out.println("Enter "+name+" count");
					int num = sc.nextInt();
					cal+=(fried.getRiceCal()*num);
					fried.order(num);
					System.out.println(num+" "+name+"(s) ordered successfully");
				}
				else if(name.equals(sushi.getRiceName())) {
					System.out.println("Enter "+name+" count");
					int num = sc.nextInt();
					cal+=(sushi.getRiceCal()*num);
					sushi.order(num);
					System.out.println(num+" "+name+"(s) ordered successfully");
				}
				else
					System.out.println("You can only enter Ramen, Fried, or Sushi");
				break;
				}
			case 2:
				System.out.println("Ordered: Ramen-"+ramen.getNoodleCnt()+", Fried-"+fried.getRiceCnt()+", Sushi-"+sushi.getRiceCnt()+" / Total Calories: "+cal);
				break;
			}
			System.out.println("Enter number (1: order), (2: check), (3: finish)");
			input = sc.nextInt();
		}
		

	}

}