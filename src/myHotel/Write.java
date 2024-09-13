package myHotel;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

 class Write implements Runnable{
    holder hotel_ob;
    Write(holder hotel_ob){
    	 this.hotel_ob =  hotel_ob;
    	 
    }
    
    @Override
    public void run() {
    	try {
    		FileOutputStream fout = new FileOutputStream("Backup");
    		ObjectOutputStream oos = new ObjectOutputStream(fout);
    		oos.writeObject(hotel_ob);//
    	}
    	catch(Exception e) {
    	System.out.println("Error in Writing"+e);
    }
   
}
}
