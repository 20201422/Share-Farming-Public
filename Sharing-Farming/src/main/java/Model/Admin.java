package Model;

public class Admin {
	private String Ano;
	private String Apwd;
	public Admin() {
		
	}
	
	public Admin(String Ano,String Apwd) {
		this.Ano=Ano;
		this.Apwd=Apwd;
	}
	public String getAno() {
		return Ano;
	}
	public void setAno(String ano) {
		Ano = ano;
	}
	public String getApwd() {
		return Apwd;
	}
	public void setApwd(String apwd) {
		Apwd = apwd;
	}

	public String toString() {
		return "Admin{" +
				"Ano='" + Ano + '\'' +
				", Apwd='" + Apwd + '\'' +
				'}';
	}
	
}
