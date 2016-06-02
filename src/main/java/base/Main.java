package base;

import java.sql.Connection;

/**OLA	user2@//localhost:1521/xe
 * Created by Администратор on 28.05.2016.
 */
public class Main {
    public static void main(String[] args) {


       /* ArrayList<String> a = new ArrayList<String>();
        a.add("ID");
        a.add("NAME");

        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(0);
        b.add(1);

        TableProperty diag = new TableProperty(2,a,b);

        //Table DIAGNOSIS = new Table(diag,"DIAGNOSIS");

            diag.header.set(0,"");
            diag.header.set(1,"Dead");
            //  DIAGNOSIS.Add(diag,c);*/
        MainFrame MainFrame = new MainFrame();
        MainFrame.run();




    }
}
