import java.util.Random;
import java.util.Scanner;

class Course{
	String name;
	int grade;
	int limit = 1;
	boolean registered = false;
	
	Course(){}
	Course(int grade, int limit){
		this.grade = grade;
		this.limit = limit;
	}
}

class College{
	Course[] Coursearr = new Course[4];
	int register(String courseName, int grade) {
		for(int i=0;i<4;i++)
		{
			if(this.Coursearr[i].name.equals(courseName)) {
				if(this.Coursearr[i].grade<=grade) {
					if(this.Coursearr[i].registered==true)
						return -1;
					else {
						if(this.Coursearr[i].limit==0)
							return -2;
						else {
						this.Coursearr[i].registered=true;
						return this.Coursearr[i].grade;
						}
					}
				}
				else
					return -3;
			}
		}
		return -4;
	}
	int withdraw(String courseName) {
		for(int i=0;i<4;i++) {
			if(this.Coursearr[i].name.equals(courseName)) {
				if(this.Coursearr[i].registered == true) {
					this.Coursearr[i].registered=false;
					return this.Coursearr[i].grade;
					}
				else
					return -6;
			}
		}
		return -7;
	}
}


public class Week4 {	

	static int printmessage(int num) {
		switch(num) {
			case -1:
			{
				System.out.println("Register error: already registered");
				break;
			}
			case -2:
			{
				System.out.println("Register error: register capacity exceeded");
				break;
			}
			case -3:
			{
				System.out.println("Register error: unapplicable grade");
				break;
			}
			case -4:
			{
				System.out.println("Register error: nonexistent course");
				break;
			}
			case -6:
			{
				System.out.println("Withdraw error: nonregistered course");
				break;
			}
			case -7:
			{
				System.out.println("Withdraw error: nonexistent course");
				break;
			}
			default:
				break;
		}
		return 0;
}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		Scanner sc = new Scanner(System.in);
		
		College SKKU = new College();
		
		for(int i=0;i<4;i++)
		{
			SKKU.Coursearr[i]= new Course(random.nextInt(4)+1,random.nextInt(2));
		}
		
		SKKU.Coursearr[0].name = "English";
		SKKU.Coursearr[1].name = "Math";
		SKKU.Coursearr[2].name = "Korean";
		SKKU.Coursearr[3].name = "Science";
		for(int i=0;i<4;i++)
		{
			System.out.print(SKKU.Coursearr[i].name+"-"+SKKU.Coursearr[i].grade+"-"+SKKU.Coursearr[i].limit+" ");
		}
		
		System.out.println();
		System.out.println("Enter your grade");
		int grade = sc.nextInt();
		System.out.println("Enter number (1 : register), (2 : withdraw), (3 : Finish)");
		int input = sc.nextInt();
		while(input != 3) {
			switch(input) {
			case 1:{
				sc.nextLine();
				System.out.println("Enter course name to register");
				String name = sc.nextLine();
				int i = SKKU.register(name,grade);
				if(i>0) {
					System.out.println("Register success");
					grade -=i ;
				}
				else
					printmessage(i);
				break;
			}
			case 2:{
				sc.nextLine();
				System.out.println("Enter course name to register");
				String name = sc.nextLine();
				int i =SKKU.withdraw(name); 
				if(i>0) {
					System.out.println("Withdraw success");
					grade +=i;
				}
				else
					printmessage(i);
				break;
			}
			default:
				break;
			}
			System.out.println("Enter number (1 : register), (2 : withdraw), (3 : Finish)");
			input = sc.nextInt();
		}
		
	}

}
