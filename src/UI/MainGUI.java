package UI;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.InputEvent;
import java.lang.reflect.Modifier;

public class MainGUI {
    public static void Show(){
        var jframe=new JFrame("Title");
        jframe.show();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var panel=new JPanel();

        panel.setLayout(new BorderLayout());
        //panel.setLayout();
        jframe.add(panel,BorderLayout.NORTH);

        var menu = new JMenuBar();

        panel.add(menu);
        /*
        File Menu
         */
        var file=new JMenu("File");
        menu.add(file);

        var open =new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK ));
        file.add(open);

        var _new =new JMenuItem("New");
        _new.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK ));
        file.add(_new);

        var save =new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK ));
        file.add(save);

        var export =new JMenuItem("Export");
        file.add(export);

        /*
        Edit Menu
        */
        var edit=new JMenu("Edit");
        menu.add(edit);

        var clear=new JMenuItem("Clear Keybinds");
        edit.add(clear);

        var reset=new JMenuItem("Reset LUA");
        edit.add(reset);

        jframe.pack();
    }
}
