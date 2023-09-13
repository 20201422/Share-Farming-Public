package JavaBean;

import Model.Land;
import Model.Report;

import java.sql.*;
import java.util.List;

public class ProgressReportBean extends BaseDao{
	public void SaveReport(Report report) {
        String sql = "insert into Report values(?,?,?,?,?,?)";
        update(sql, report.getLno(), report.getPlant(), report.getAno(), report.getWork(), report.getDate(), report.getDetail());
    }

    public List<Report> ShowReport(String lno){//展示进展报告
        return queryForList(Report.class, "select Ano,Pna,Work,Date,Detail from Report where Lno=?",lno);
    }//展示进展报告

}
