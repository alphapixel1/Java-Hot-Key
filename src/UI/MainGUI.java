package UI;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Modifier;

public class MainGUI {
    public static void Show(){
        var jframe=new JFrame("Title");
        jframe.setSize(800,400);
        jframe.show();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var menu = new MenuBar();
        jframe.setMenuBar(menu);

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


        /*
        Panel for kbs
         */
        var kbPanel=new JPanel();
        kbPanel.setBackground(Color.red);
        kbPanel.setLayout(new BorderLayout());
        jframe.add(kbPanel);

        /*
        Boxes Setup
         */
        var kbBox=new JPanel();
        kbBox.setLayout(new BoxLayout(kbBox,BoxLayout.Y_AXIS));
        kbBox.setBackground(Color.red);


        var b=new Button("The");
        //why doesnt this work b.setSize(500,200);
        kbBox.add(b);
        //kbBox.setSize(500,500);
        kbPanel.add(kbBox,BorderLayout.WEST);
        kbPanel.add(new JButton("Center"),BorderLayout.CENTER);
        jframe.pack();
    }
}
