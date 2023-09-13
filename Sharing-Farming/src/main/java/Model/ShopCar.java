package Model;

import java.util.ArrayList;
import java.util.List;

public class ShopCar {
	private String Uno;
	private List<Goods> goodsList;
	public ShopCar() {
		goodsList=new ArrayList<Goods>();
	}
	public String getUno() {
		return Uno;
	}
	public void setUno(String uno) {
		Uno = uno;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public void addGoodsList(Goods goods) {
		this.goodsList.add(goods);
	}
	
}
