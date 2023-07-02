package From;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import EGO.*;
import Util.Util;

public class From6 extends JFrame {
    String[] shelves = {"刺剑","瞬间回复Ⅲ","博丽神社御币","终末时钟","血雾","恋恋的帽子"};
    JButton goldUp = new JButton("金钱:"+ Util.getGold().getGold());
    Integer cost[] ={170,200,600,1000,1400,2000};
    Object[] shopEgo = {new Stab(),new Ⅲ(),new Reimu(),new End(),new Red(),};
    public From6() {
        this.setLayout(null);
        this.setVisible(true);
        Util.fromCenter(this);
        for(int i=1;i<=6;i++){
            JButton jButton = new JButton();
            if (i <= 3) {
                jButton.setBounds(i * 170, 150, 120, 50);
            } else {
                jButton.setBounds((i-3) * 170, 250, 120, 50);
            }
            jButton.setVisible(true);
            jButton.setText(shelves[i-1]);
            int fxi = i;
            jButton.addActionListener(e -> {
                int cos = cost[fxi-1];
                Object article = shopEgo[fxi-1];
                if (Util.getGold().getGold()>=cos){
                    JOptionPane.showMessageDialog(null,"购买成功！");
                    Util.getGold().setGold(-cos);
                    Util.setEquipmentBar((AbsEgo) article);
                }else{
                    JOptionPane.showMessageDialog(null,"购买失败！金钱不足!");
                }
            });
            this.add(jButton);
        }
        this.add(goldUp);
        goldUp.setBounds(this.getWidth()-150,20,120,50);
        goldUp.addActionListener(e ->{
            Util.getGold().setGold(2);
            goldUp.setText("金钱:"+Util.getGold().getGold());
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                From3.getFrom3();
            }
        });

    }


    public static From6 getFrom6(){
        return new From6();
    }
}
