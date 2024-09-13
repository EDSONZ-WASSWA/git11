package myHotel;

import java.io.Serializable;

 class Food implements Serializable {
	int itemNo;
	int quantity;
	float price;
	public Food(int itemNo, int quantity) {
		this.itemNo = itemNo;
		this.quantity = quantity;
		switch(itemNo) {
		case 1: price = quantity*5000;
		break;
		case 2: price = quantity*7000;
		break;
		case 3: price = quantity*8000;
		break;
		case 4:price = quantity*10000;
		break;
		}
	}
	
	

}
