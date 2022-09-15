package UI;

import javax.swing.*;

public class JNonEditableTable  extends JTable {
    public boolean isCellEditable(int row, int column){
        return false;
    }
}
