package myHotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class HotelSystem {

	public static void main(String[] args) {
		System.out.println("WELCOME OUR CUSTOMER");
		try 
		{
			File f = new File("Backup");//
			if(f.exists()) {
				try(FileInputStream fin=new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fin)){
				Hotel.hotel_ob=(holder)ois.readObject();
			ois.close();
				} catch (Exception e) {
				      //  System.out.println("Error in Reading:);
				    }
			
				
			}
			Scanner sc = new Scanner(System.in);
			int ch, ch2;
			char wish;

			x:
				do {
					System.out.println("**Enter your Choice**\n1.Display Room Details\n2.Display Rooms Available\n3.Make Booking\n4.Order Food\n5.Checkout\n6.Exit");//we are supposed to in put the fore details of the program
					ch =sc.nextInt();
					switch(ch) {
					case 1:
					System.out.println("\nChoose Room Type\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
						ch2 = sc.nextInt();
						Hotel.features(ch2);
					break;
					case 2:
						System.out.println("\nChoose Room Type\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
						ch2 = sc.nextInt();
						Hotel.availability(ch2);
						break;
					case 3:
						System.out.println("\nChoose Room Type\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
						ch2 = sc.nextInt();
						Hotel.bookroom(ch2);//this throws us in book-room class and in the switch we are linked in a case made by ch number
						break;
					case 4:
						System.out.println("Choose Room Number-");
						ch2 = sc.nextInt();
						if(ch2>60) 
							System.out.println("Room Does Not Exist");
						 else if(ch2>40)
						Hotel.order(ch2-41, 4);
						 else if(ch2 >30)
							 Hotel.order(ch2-31,3);
						 else if(ch2 >10)
							 Hotel.order(ch2-11,2);
						 else if(ch2>0)
							 Hotel.order(ch2-1,1 );
						 else
							 System.out.println("That Room Is Still Under Construction");
						break;
					case 5:
						System.out.println("Room Number?-");
						ch2 = sc.nextInt();
						if(ch2>60)
							System.out.println("Room Does Not Exist Here");
						 else if(ch2>40)
								Hotel.Deallocation(ch2-41, 4);
								 else if(ch2 >30)
									 Hotel.Deallocation(ch2-31, 3);
								 else if(ch2 >10)
									 Hotel.Deallocation(ch2-11, 2);
								 else if(ch2>0)
									 Hotel.Deallocation(ch2-1, 1);
								 else
									 System.out.println("That Room Is Still Under Construction");
								break;
					case 6:break x;
			}
					System.out.println("\nContinue : (y/n)");
					wish = sc.next().charAt(0);
					if(!(wish =='y'|| wish =='Y'|| wish =='n'||wish=='N'))
					{
						System.out.println("Invalid Option");
						System.out.println("\nContinue : (y/n)");
						wish = sc.next().charAt(0);
					}
					
				}while(wish=='y'||wish=='Y');
			Thread t = new Thread(new Write(Hotel.hotel_ob));//when you accept to continues the program should save your inputs
			t.start();//Enable the process of saving to start
		    }
		catch (Exception e)
		    {
			System.out.println("Sorry maybe our system is down\nTry again later ");
			
			}
		
			}
		}

	


