package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JTextPane textPane1;
    //private JList list1;
    private JButton deleteButton;
    private JButton editButton;
    private JButton compileButton;

    public MainForm(){
        this.setSize(500,500);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        Init Menu
         */
        var menu = new MenuBar();
        this.setMenuBar(menu);

        /*
        File Menu
         */
        var file=new Menu("File");
        menu.add(file);

        var open =new MenuItem("Open");
        open.setActionCommand("fuck");
        open.setShortcut(new MenuShortcut(KeyEvent.VK_O));

        file.add(open);

        var _new =new MenuItem("New");
        _new.setShortcut(new MenuShortcut(KeyEvent.VK_N));
        file.add(_new);

        var save =new MenuItem("Save");
        save.setShortcut(new MenuShortcut(KeyEvent.VK_S));
        file.add(save);

        var export =new MenuItem("Export");
        file.add(export);

        /*
        Edit Menu
        */
        var edit=new Menu("Edit");
        menu.add(edit);

        var clear=new MenuItem("Clear Keybinds");
        edit.add(clear);

        var reset=new MenuItem("Reset LUA");
        edit.add(reset);

        /*
        Tool Menu
         */
        var tool=new Menu("Tools");
        menu.add(tool);

        var log=new MenuItem("Ouput Log");
        tool.add(log);

        var keyRef=new MenuItem("Key Reference");
        tool.add(keyRef);

        var quick=new MenuItem("Quick Keybind");
        tool.add(quick);

        /*
        Quick Keybind Helper
         */
        var quickHelper=new Menu("Press any key");
        menu.add(quickHelper);
     //   list1.setListData(new Object[]{"one","two","three"});
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
