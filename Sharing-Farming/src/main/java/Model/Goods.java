package Model;
public class Goods{
	private String Cna;
	private float Cpr;
	private String LocalUrl;
	private int Num;
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(String Cna,int Num) {
		super();
		// TODO Auto-generated constructor stub
		this.Cna=Cna;
		this.Num=Num;
	}
	public String getCna() {
		return Cna;
	}
	public void setCna(String cna) {
		Cna = cna;
	}
	public float getCpr() {
		return Cpr;
	}
	public void setCpr(float cpr) {
		Cpr = cpr;
	}
	public String getLocalUrl() {
		return LocalUrl;
	}
	public void setLocalUrl(String localUrl) {
		LocalUrl = localUrl;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	
}
