package base;

/**
 * Created by Администратор on 31.05.2016.
 */

import java.util.ArrayList;

public class TableProperty {

    private int size;
    public ArrayList<String> header  = new ArrayList<String>();
    public ArrayList<Integer> headtype  = new ArrayList<Integer>();  //  0 - int 1 - String;

    public TableProperty(TableProperty a){
        size = a.getSize();
        header =(ArrayList<String>) a.header.clone();
        headtype =(ArrayList<Integer>) a.headtype.clone();
    }
    public TableProperty(int s, ArrayList<String> h, ArrayList<Integer> t) {

        size = s;
        header =(ArrayList<String>) h.clone();
        headtype =(ArrayList<Integer>) t.clone();

    }
    public int getSize(){
        return size;
    }


}
