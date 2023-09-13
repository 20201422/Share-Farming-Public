package Model;

public class Farming {

    private String Lno;
    private String Lna;
    private int Lar;
    private float Lpr;
    private String Pno;
    private String Pna;
    private String Ano;
    private int Fday;
    private String Ftp;
    private int Lst;
    private String Lpo;
    private String Fst;
    private String Uno;

    public String getLno() {
        return Lno;
    }

    public void setLno(String lno) {
        Lno = lno;
    }

    public String getLna() {
        return Lna;
    }

    public void setLna(String lna) {
        Lna = lna;
    }

    public int getLar() {
        return Lar;
    }

    public void setLar(int lar) {
        Lar = lar;
    }

    public float getLpr() {
        return Lpr;
    }

    public void setLpr(float lpr) {
        Lpr = lpr;
    }

    public String getPno() {
        return Pno;
    }

    public void setPno(String pno) {
        Pno = pno;
    }

    public String getPna() {
        return Pna;
    }

    public void setPna(String pna) {
        Pna = pna;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String ano) {
        Ano = ano;
    }

    public int getFday() {
        return Fday;
    }

    public void setFday(int fday) {
        Fday = fday;
    }

    public String getFtp() {
        return Ftp;
    }

    public void setFtp(String ftp) {
        Ftp = ftp;
    }

    public int getLst() {
        return Lst;
    }

    public void setLst(int lst) {
        Lst = lst;
    }

    public String getLpo() {
        return Lpo;
    }

    public void setLpo(String lpo) {
        Lpo = lpo;
    }

    public String getFst() {
		return Fst;
	}

	public void setFst(String fst) {
		Fst = fst;
	}

	public String getUno() {
		return Uno;
	}

	public void setUno(String uno) {
		Uno = uno;
	}

    @Override
    public String toString() {
        return "Farming{" +
                "Lno='" + Lno + '\'' +
                ", Lna='" + Lna + '\'' +
                ", Lar=" + Lar +
                ", Lpr=" + Lpr +
                ", Pno='" + Pno + '\'' +
                ", Pna='" + Pna + '\'' +
                ", Ano='" + Ano + '\'' +
                ", Fday=" + Fday +
                ", Ftp='" + Ftp + '\'' +
                ", Lst=" + Lst +
                ", Lpo=" + Lpo + '\'' +
                ", Lst=" + Lst + '\'' +
                '}';
    }
}
