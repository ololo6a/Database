package base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.StringBuilder;
/**
 * Created by Администратор on 31.05.2016.
 */
public class Table {
    private  String TABLENAME;
    private TableProperty object;
    public Table(TableProperty object, String S) {
        this.object= new TableProperty(object);
        TABLENAME=S;
    }

    public void Delete(TableProperty o, Connection conn)
    {

    };

    public void Update(TableProperty o, Connection conn){

    };
    public void commit( Connection conn){
        Statement st = null;
        try {
            st = conn.createStatement();
            st.execute("commit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void roolback( Connection conn){
        Statement st = null;
        try {
            st = conn.createStatement();
            st.execute("roolback");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  void Add(TableProperty o, Connection conn){


        Statement st = null;
        StringBuilder sql= new StringBuilder();
        sql.append("insert into ");
        sql.append(TABLENAME);
        sql.append('(');
        for (int i = 1; i < object.getSize(); i++) {    // i=0  == ID , AUTOINC
            sql.append(object.header.get(i));
            if (i!=object.getSize()-1) sql.append(','); else sql.append(") ");
        }
        sql.append("values  (");

        for (int i = 1; i < object.getSize(); i++) {
            if (object.headtype.get(i)==0) {
                sql.append(o.header.get(i));
            }
            if (object.headtype.get(i)!=0) {
                sql.append('\'');
                sql.append(o.header.get(i));
                sql.append('\'');
            }
            if (i!=object.getSize()-1) sql.append(','); else sql.append(")");
        }

        try {
            st = conn.createStatement();
            st.execute(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    };


}
