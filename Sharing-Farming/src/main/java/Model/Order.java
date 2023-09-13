package Model;

import java.util.List;

public class Order{
	
	
	private int Ono;
	private int QuHuoFangShi;
	private String Uno;
	private String UName;
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}

	private String Contact;
	private String Address;
	private float Price;
	private List<Goods> orderGoodsList;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int QuHuoFangShi,String Uno,String Contact,String Address,float Price,String UName) {
		super();
		this.Address=Address;
		this.Contact=Contact;
		this.Price=Price;
		this.Uno=Uno;
		this.QuHuoFangShi=QuHuoFangShi;
		this.UName=UName;
	}
	public List<Goods> getOrderGoodsList() {
		return orderGoodsList;
	}

	public void setOrderGoodsList(List<Goods> orderGoodsList) {
		this.orderGoodsList = orderGoodsList;
	}

	public int getOno() {
		return Ono;
	}

	public void setOno(int ono) {
		Ono = ono;
	}

	public int getQuHuoFangShi() {
		return QuHuoFangShi;
	}

	public void setQuHuoFangShi(int quHuoFangShi) {
		QuHuoFangShi = quHuoFangShi;
	}

	public String getUno() {
		return Uno;
	}

	public void setUno(String uno) {
		Uno = uno;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}


	
	
	
}
