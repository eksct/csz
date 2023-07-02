package From;

import Util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class From extends JFrame {
    JButton start = new JButton("Start☆开始");
    JButton exit = new JButton("Exit(退出)");
    JButton cardPond = new JButton("E.G.O");
    JButton Taskbar = new JButton("任务栏");
    JLabel gold = new JLabel();
    JLabel titles = new JLabel();

    public From(boolean visible){
        gold.setText("金钱:"+Util.getGold().getGold());
        this.setTitle("这或许是个游戏");
        this.add(titles);
        titles.setText("这确实是个猜数字游戏");
        Util.fromCenter(this);
        titles.setBounds(20,0,360,120);
        titles.setFont(new Font(null,Font.BOLD,22));
        start.setVisible(visible);
        exit.setVisible(visible);
        exit.setBounds(20,this.getHeight()-150,150,50);
        cardPond.setVisible(visible);
        cardPond.setBounds(20,this.getHeight()-exit.getHeight()-163,150,50);
        start.setBounds(20,this.getHeight()-exit.getHeight()-225,150,50);
        this.setLayout(null);
        this.add(start);
        this.add(exit);
        this.add(cardPond);
        this.add(gold);
        gold.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);
        this.add(Taskbar);
        Taskbar.setVisible(visible);
        Taskbar.setBounds(this.getWidth()-150,20,120,60);
        Taskbar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                From5.getFrom5();
            }
        });
        gold.setBounds(Taskbar.getX(),Taskbar.getY()+50,120,60);
        start.addActionListener(e -> {
            if(Util.getList().size()!=0) {
                dispose();
                From2.From2();

            }else{
                Util.initList();
                dispose();
                From2.From2();
            }
            Util.setBurial(0);
        });
        cardPond.addActionListener(e -> {
            dispose();
            From3.getFrom3();
        });
        exit.addActionListener(e->System.exit(0));
        gold.setFont(new Font(null,Font.PLAIN,25));
    }
    public static From getFrom(){
        return new From(true);
    }
}
