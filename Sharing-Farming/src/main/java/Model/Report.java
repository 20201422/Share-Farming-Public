package Model;

public class Report {

    private	String lno;
    private String plant;
    private String ano;
    private String work;
    private String date;
    private String detail;
    public Report() {}
    public Report(String lno,String plant,String ano,String work,String date,String detail) {
        this.lno=lno;
        this.plant=plant;
        this.ano=ano;
        this.work=work;
        this.date=date;
        this.detail=detail;
    }

    public String getLno() {
        return lno;
    }
    public void setLno(String lno) {
        this.lno = lno;
    }
    public String getPlant() {
        return plant;
    }
    public void setPlant(String plant) {
        this.plant = plant;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getWork() {
        return work;
    }
    public void setWork(String work) {
        this.work = work;
    }

    public String toString() {
        return "Report{" +
                "lno='" + lno + '\'' +
                ", plant='" + plant + '\'' +
                ", ano='" + ano + '\'' +
                ", work='" + work + '\'' +
                ", date='" + date + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

}
