package From;

import EGO.AbsEgo;
import Util.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class From3 extends JFrame {
    JButton spellCardExtract  =new JButton("提取");
    JButton exit = new JButton("<<<");
    List<AbsEgo> ego = Util.getEgoList();
    JLabel gold = new JLabel("金钱"+ Util.getGold().getGold());
    JButton shop = new JButton("商店");
    public From3() {
        setTitle("E.G.O");
        this.setLayout(null);
        this.add(shop);
        shop.setVisible(true);
        this.setResizable(false);
        Util.fromCenter(this);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        spellCardExtract.setVisible(true);
        this.add(spellCardExtract);
        this.add(exit);
        spellCardExtract.setVisible(true);
        spellCardExtract.setBounds(this.getWidth()-170,this.getHeight()-120,120,60);
        exit.setBounds(0,0,60,40);
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                From.getFrom();
            }
        });
        spellCardExtract.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int spend = 160;
                if (Util.getGold().getGold() >= spend ){
                    Util.getGold().setGold(-160);
                    gold.setText("金钱："+Util.getGold().getGold());
                    getCard();
                }else {
                    JOptionPane.showMessageDialog(null,"金钱数量不足");
                }
            }
        });
        this.add(gold);
        gold.setVisible(true);
        shop.setBounds(this.getWidth()-150,50,120,50);
        shop.addActionListener(e->{
            dispose();
            From6.getFrom6();
        });
        gold.setBounds(this.getWidth()-150,0,120,40);
    }
    public static From3 getFrom3(){
        return new From3();
    }
    Random random = new Random();

    public synchronized void getCard() {
        int i =0;
        Integer total = 6;
        try{
            for (int index=random.nextInt(total);;){
                i++;
                if (i==total){
                    JOptionPane.showMessageDialog(null,"中奖"+ego.get(index).getName());
                    Util.setEquipmentBar(ego.get(index));
                    break;
                }
                sleep(230);
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
