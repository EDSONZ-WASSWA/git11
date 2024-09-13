package myHotel;

import java.util.Scanner;

 class Hotel 
 {
	static holder hotel_ob= new holder();
	static Scanner sc = new Scanner(System.in);
	static void CustDetails(int i, int rn) 
	{
		String name,contact,gender;
		String name2 = null, contact2 = null;                            //rn-----> room number
		String gender2 ="";                                              //rtype----> room type  
		System.out.print("\nEnter Customer Name:");
		name = sc.next();
		System.out.print("Enter Contact Number:");
		contact = sc.next();
		System.out.print("Enter your Gender:");
		gender = sc.next();
		if(i<3) 
		{
			System.out.print("Enter Second Customer Name:");
			name2 = sc.next();
			System.out.print("Enter Second Customer Contact Number:");
			contact2 =sc.next();
			System.out.println("Enter gender:");
			gender2 = sc.next();
		}
		switch(i) {
		case 1: hotel_ob.luxury_doubleroom[rn] = new DoubleRoom(name,contact,gender,name2,contact2,gender2);
		break;
		case 2: hotel_ob.deluxe_doubleroom[rn] = new DoubleRoom(name,contact,gender,name2,contact2,gender2);
		break;
		case 3: hotel_ob.luxury_singleroom[rn] = new SingleRoom(name,contact,gender);
		break;
		case 4: hotel_ob.deluxe_singleroom[rn] = new SingleRoom(name,contact,gender);//we shall only have  to fill the arguments
		break;
		default: System.out.println("Wrong Option");
		break;
		}
	}


	static void bookroom(int i) 
	{
		int j;
		int rn;
		System.out.println("Choose Room Number from Displayed nes:");//the case we are linked in is by the choice we made (ch2)-
		switch(i) {
		case 1:
			for(j=0;j<hotel_ob.luxury_doubleroom.length;j++) 
			{
					if(hotel_ob.luxury_doubleroom[j]==null) 
					{
						System.out.print(j+1+",");
					}
			}
		
		System.out.println("\nEnter room Number");
		try {
			rn = sc.nextInt();
			rn--;
			if(hotel_ob.luxury_doubleroom[rn]!=null)
				throw new NotAvailable();
			CustDetails(i,rn);
		}
		catch(Exception e) 
		{
		System.out.println("Invalid Option");
		return;
		}
		break;
	case 2:
			for(j=0;j<hotel_ob.deluxe_doubleroom.length;j++) 
			{
			if(hotel_ob.deluxe_doubleroom[j]==null) 
			{
				System.out.println(j+11+",");
			}
	}
			System.out.println("\nEnter Room Number");
			try {
				rn =sc.nextInt();
				rn = rn-11;
				if(hotel_ob.deluxe_doubleroom[rn]!=null) 
					throw new NotAvailable();
				CustDetails(i,rn);
			}
			catch(Exception e) 
			{
				System.out.println("Invalid option");
				return;
			}
			break;
	case 3:
		for(j=0;j<hotel_ob.luxury_singleroom.length;j++) 
		{
			if(hotel_ob.luxury_singleroom[j]==null) 
			{
				System.out.println(j+31+",");
			}
		}
System.out.println("\nEnter Room Number");
try {
	rn = sc.nextInt();
	rn =rn-31;
	if(hotel_ob.luxury_singleroom[rn]!=null) 
		throw new NotAvailable();
		CustDetails(i,rn);
		
	}
     catch(Exception e) 
    {
	System.out.println("Invalid option");
	return;
	}
	break;
	case 4: //we chose 4 thats y we are at case 4<<the ch >>
		for(j=0;j<hotel_ob.deluxe_singleroom.length;j++) 
		{
			if(hotel_ob.deluxe_singleroom[j]==null)
			{
			System.out.println(j+41+",");//sorts out rooms to be booked and displays them
				
			}
		}
		System.out.println("\nEnter Room Number");
		try {
			rn =sc.nextInt();
			rn=rn-41;
			if(hotel_ob.deluxe_singleroom[rn]!=null) 
				throw new NotAvailable();
				CustDetails(i,rn);
			}
		catch(Exception e) 
		{
		System.out.println(".....Room Taken Already!!....");
		return;
			
		}
break;

default : System.out.println("Invalid Option Chosen");
break;
		}
System.out.println("Room is Booked ");
    }
	
	
	static void features(int i) 
	{
		switch(i) {
		case 1:
		System.out.println("Number of Double Beds: \nAC :Yes\nFree BreakFirst :Yes\nCharge per day:4000");
			break;
		case 2:
		System.out.println("Number of Double Beds: \nAC :No\nFree BreakFirst :Yes\nCharge per day:3000");
			break;
		case 3:
		System.out.println("Number of Single Beds: \nAC :Yes\nFree BreakFirst :Yes\nCharge per day:2200");
		break;
		case 4:
		System.out.println("Number of Single Beds: \nAC :No\nFree BreakFirst :Yes\nCharge per day:1200");
			break;
			default:System.out.println("Enter A Valid Option");
		break;
		
		}
	}
	
	static void availability(int i) 
	{
		int j, count =0;
		switch(i) {
		case 1:
			for(j=0;j<10;j++) 
			{ 
				if(hotel_ob.luxury_doubleroom[j]==null) 
					count++;
				
		    }
			break;
		case 2:
			for(j=0;j<hotel_ob.deluxe_doubleroom.length;j++) 
			{
				
		
				if(hotel_ob.deluxe_doubleroom[j]==null) 
				                                        
					count++;
			}
				
			break;
		case 3:
			for(j=0;j<hotel_ob.luxury_singleroom.length;j++) 
			{
				if(hotel_ob.luxury_singleroom[j]==null) 
					count ++;
				}
			
			break;
		case 4:
			for(j=0;j<hotel_ob.deluxe_singleroom.length;j++) 
			{
				if(hotel_ob.deluxe_singleroom[j]==null) 
					count ++;
				}
			break;
			default:
				System.out.println("You have Entered a Wrong option");
				break;
	}
	
	System.out.println("Number of room available:" + count);
}
	static void Bill(int rn, int rtype) {
		double amount =0;
		String list[] ={"Cheaps","Chicken","Liver","Wines"};
		System.out.println("\n***************");
		System.out.println("--BILL--");
		System.out.println("*****************");
		    
		   switch(rtype) {
		   case 1:
			   amount += 4000;
			   System.out.println("\n Room Charge -"+4000);
			   System.out.println("\n====================");
			   System.out.println("Food Charges:-");
			   System.out.println("======================");
			   System.out.println("Item       Quantity    Price");
			   System.out.println("-----------------------------");
			   for(Food obb:hotel_ob.luxury_doubleroom[rn].food) {
				   amount+=obb.price;
				   String format ="%-10s%-10s%-10s%n";
				   System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price);
			   }
			   break;
		   case 2:
			   amount += 3000;
			   System.out.println("\n Room Charge -"+3000);
			   System.out.println("\n====================");
			   System.out.println("Food Charges:-");
			   System.out.println("======================");
			   System.out.println("Item       Quantity    Price");
			   System.out.println("-----------------------------");
			   for(Food obb:hotel_ob.deluxe_doubleroom[rn].food) {
				   amount+=obb.price;
				   String format ="%-10s%-10s%-10s%n";
				   System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price);
			   }
			   break;
		   case 3:
			   amount +=2200;
			   System.out.println("\n Room Charge -"+2200);
			   System.out.println("\n====================");
			   System.out.println("Food Charges:-");
			   System.out.println("======================");
			   System.out.println("Item       Quantity    Price");
			   System.out.println("-----------------------------");
			   for(Food obb:hotel_ob.luxury_singleroom[rn].food) {
				   amount+=obb.price;
				   String format ="%-10s%-10s%-10s%n";
				   System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price);
			   }
			   break;
		   case 4:
			   amount +=1200;
			   System.out.println("\n Room Charge -"+1200);
			   System.out.println("\n====================");
			   System.out.println("Food Charges:-");
			   System.out.println("======================");
			   System.out.println("Item       Quantity    Price");
			   System.out.println("-----------------------------");
			   for(Food obb:hotel_ob.deluxe_singleroom[rn].food) {
				   amount+=obb.price;
				   String format ="%-10s%-10s%-10s%n";
				   System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price);
			   }
			   break;
			   default:
				   System.out.println("Not Valid");
		   }
		System.out.println("\nTotal Amount-"+amount);
		
	}
	
	static void Deallocation(int rn, int rtype){
		int j;
		char w;
		switch(rtype) {
		case 1:
			if(hotel_ob.luxury_doubleroom[rn]!=null)
				System.out.println("Room is occupied by "+hotel_ob.luxury_doubleroom[rn].name);
			else {
				System.out.println("Room Ready For Use");
				return;
		}
			System.out.println("Do you want to Check it out?(y/n)");
			w=sc.next().charAt(0);
			if(w=='y'||w=='Y') {
				Bill(rn,rtype);
				hotel_ob.luxury_doubleroom[rn]=null;
						System.out.println("Deal Succesfull");
				
			}
			break;
		case 2:
			if(hotel_ob.deluxe_doubleroom[rn]!=null)
				System.out.println("Room is occupied by "+hotel_ob.deluxe_doubleroom[rn].name);
			else {
				System.out.println("Room Ready For Use");
				return;
		}
			System.out.println("Do you want to Check it out?(y/n)");
			w=sc.next().charAt(0);
			if(w=='y'||w=='Y') {
				Bill(rn,rtype);
				hotel_ob.deluxe_doubleroom[rn]=null;
						System.out.println("Deal Succesfull");
				
			}
			break;
		case 3:
			if(hotel_ob.luxury_singleroom[rn]!=null)
				System.out.println("Room is occupied by "+hotel_ob.luxury_singleroom[rn].name);
			else {
				System.out.println("Room Ready For Use");
				return;
		}
			System.out.println("Do you want to Check it out?(y/n)");
			w=sc.next().charAt(0);
			if(w=='y'||w=='Y') {
				Bill(rn,rtype);
				hotel_ob.luxury_singleroom[rn]=null;
						System.out.println("Deal Succesfull");
				
			}
			break;
		case 4:
			if(hotel_ob.deluxe_singleroom[rn]!=null)
				System.out.println("Room is occupied by "+hotel_ob.deluxe_singleroom[rn].name);
			else {
				System.out.println("Room Ready For Use");
				return;
		}
			System.out.println("Do you want to Check it out?(y/n)");
			w=sc.next().charAt(0);
			if(w=='y'||w=='Y') {
				Bill(rn,rtype);
				hotel_ob.deluxe_singleroom[rn]=null;
						System.out.println("Deal Succesfull");
					}
			break;
			default:
				System.out.println("You Entered a Wrong Option");
	
      }

  }
	static void order(int rn, int rtype) {
		int i,q;
		char wish;
		try {
			System.out.println("\n=====================\n  Menu:   \n\n1.Cheaps\tUGX.5000\n2.Chicken\tUGX.7000\n3.Liver\t\tUGX.8000\n4.Wines\t\tGX.10000");
			do {
				i =sc.nextInt();
				System.out.println("Quantity-");
				q =sc.nextInt();

				
				switch(rtype) {
				  case 1: hotel_ob.luxury_doubleroom[rn].food.add(new Food(i,q));
	                break;
	            case 2: hotel_ob.deluxe_doubleroom[rn].food.add(new Food(i,q));
	                break;
	            case 3: hotel_ob.luxury_singleroom[rn].food.add(new Food(i,q));
	                break;
	            case 4: hotel_ob.deluxe_singleroom[rn].food.add(new Food(i,q));
	                break;     
				}
				System.out.println("Do you wish to order anything Else? (y/n");
				wish =sc.next().charAt(0);
			}
				while(wish=='y'||wish=='Y');
			
			    }
		catch(NullPointerException e) {
			System.out.println("Room not booked");
		}
		catch (Exception e) {
			System.out.println("Can Not perform Task Given");
		}
	}
	}




