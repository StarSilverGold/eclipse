import java.util.Random;
import java.util.Scanner;

public class Hotel {
	void checkin(int n, int j, Room[] r)
	{
		if(r[n].States == true)
			System.out.println("Check in error : already occupied");
		else
		{
			if(r[n].Capacity < j)
				System.out.println("Check in error : capacity exceed.");
			else 
			{
			r[n].States = true;
			System.out.println("Check in Success");
			}
		}
	}
	void checkout(int n, Room[] r)
	{
		if(r[n].States == false)
			System.out.println("Check out error : already checked out");
		else
			{
			r[n].States = false;
			System.out.println("Check out Success");
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		Scanner sc = new Scanner(System.in);
		
		
		Hotel H = new Hotel();
		Room[] RoomArr = new Room[10];
		for(int i=0;i<10;i++)
		{
			RoomArr[i]=new Room(random.nextInt(4)+1,false);
		}
		
		for(int i=0;i<10;i++)
		{
			System.out.print(RoomArr[i].Capacity+" ");
		}
		System.out.println();
		System.out.println("Enter number (1 : checkin), (2 : checkout), (3 : Finish)");
		int input = sc.nextInt();
		int num, peop;
		while(input != 3)
		{
			switch(input) {
			case 1: 
			{
				System.out.println("Enter room number");
				num = sc.nextInt();
				System.out.println("How many people?");
				peop = sc.nextInt();
				H.checkin(num,peop, RoomArr);
				break;
			}
			case 2:
			{
				System.out.println("Enter room number");
				num= sc.nextInt();
				H.checkout(num,RoomArr);
				break;
			}
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}
			System.out.println("Enter number (1 : checkin), (2 : checkout), (3 : Finish)");
			input = sc.nextInt();
		}
	}

}

class Room{
	boolean States = false;
	
	int Capacity; 
	
	Room(){}
	Room(int Capacity, boolean States){
		this.Capacity = Capacity;
		this.States = States;
	}
}

