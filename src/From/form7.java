package From;

import EGO.AbsEgo;
import Util.Util;

import javax.swing.*;
import java.awt.*;
public class form7 extends JFrame {
    int fWidth = 800;
    int fHeight =-400;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public form7() {
        setTitle("装备栏");
        Util.fromCenter(this);
        this.setLayout(new GridLayout(1,5,5,10));
        this.setBounds((width-fWidth)>>1,(height-fHeight)>>1,800,120);
        for (AbsEgo e : Util.getEquipmentBar()){
            JButton jButton = new JButton();
            jButton.setSize(120,50);
            jButton.setText(e.getName());
            jButton.setVisible(true);
            AbsEgo es = e;
            jButton.addActionListener( fx ->{
                es.setFlag(!es.isFlag());
            });
            this.add(jButton);
        }

    }
    public static form7 getFrom7() {
        return new form7();
    }
}
