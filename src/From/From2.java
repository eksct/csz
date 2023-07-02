package From;

import EGO.End;
import Role.AbsRole;
import Util.Util;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.regex.Pattern;

public class From2 extends JFrame {
    int health = Util.getHp();
    AbsRole role = Util.getList().get(0).randNumber();
    int randNumber = role.getRandom();
    JButton exit = new JButton("退出战斗");
    JLabel label = new JLabel("生命：10");
    JTextField Input = new JTextField("猜测数字(输入正整数)");
    JButton InputE = new JButton("确定");
    JLabel labelBottom = new JLabel();
    JButton EGO = new JButton("E.G.O");

    public From2() throws HeadlessException {
        this.setTitle("战斗:"+role.getName());
        this.setLayout(null);
        this.setResizable(false);
        Util.fromCenter(this);
        this.add(EGO);
        Util.setForm7(form7.getFrom7());
        form7 formt = Util.getForm7();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        exit.setBounds(this.getWidth()-150,this.getHeight()-80,120,40);
        /*点击后返回主界面*/
        exit.addActionListener(e-> {
            JOptionPane.showMessageDialog(null,role.getName()+":"+role.getMassage());
            dispose();
            formt.dispose();
            From.getFrom();
        });
        this.add(exit);
        labelBottom.setVisible(true);
        labelBottom.setOpaque(true);
        EGO.setVisible(true);
        /*拼点系统，通过Util.returnAtk的返回值判定是否有武器*/
        EGO.addActionListener(e -> {
            Integer Atk =Util.returnAtk(role.getColor());
            if (Atk==-1){
                JOptionPane.showMessageDialog(null,"你还没有武器");
                return;
            }else if (Atk==-2){
                JOptionPane.showMessageDialog(null,"还需"+Util.getBur()+"回合才能使用武器");
                return;
            }
            Integer roleAtk = role.returnAtk();
            if (Atk > roleAtk){
                /*若点数大于boss投出点数则对其造成0.2倍伤害*/
                int atk = (int)(Atk*0.2);
                role.setHealth(-atk);
                JOptionPane.showMessageDialog(null,"对"+role.getName()+"造成"+atk+"点伤害");
                /*造成boss死亡则删除boss*/
                if (role.getHealth()<=0){
                    Integer id = Util.getList().get(0).getTask().getId();
                    if (Util.getTask(id).getPre_Task()==null){
                        Util.getTask(id).setComplete(true);
                        Util.getList().remove(0);
                    }else if ( Util.getTask(id).getPre_Task().isComplete()){
                        Util.getTask(id).setComplete(true);
                        Util.getList().remove(0);
                    }
                    if (Util.getList().size()==0) {
                        JOptionPane.showMessageDialog(null, "☆ 恭喜通关 ☆");
                    }
                    JOptionPane.showMessageDialog(null,
                            "恭喜击败"+role.getName()+"获得金币:"+Util.getGold().setGold(Util.getRandGold())+"\n"+"回营地休整一下吧");
                    dispose();
                    formt.dispose();
                    From.getFrom();
                    return;
                }
                labelBottom.setText(role.getName()+role.Mags());
            } else if (Atk < roleAtk) {
                labelBottom.setText(role.getName()+role.getAbuseChar().get(new Random().nextInt(role.getFightChar().size()-2)));
                label.setText("生命:"+(--health));
            }else{
                labelBottom.setText(role.getName()+role.getAbuseChar().get(new Random().nextInt(role.getFightChar().size()-2)));
            }
            /*减少装备（ego）冷却回合*/
            if (Util.getBur()>0){
                Util.bur();
            }
        });
        EGO.setBounds(10,this.getHeight()-80,120,50);
        labelBottom.setBackground(Color.white);
        labelBottom.setFont(new Font(null,Font.PLAIN,22));
        labelBottom.setBounds(0,(this.getHeight()-200),this.getWidth(),120);
        this.add(labelBottom);
        label.setSize(120,40);
        label.setOpaque(true);
        label.setBackground(Color.pink);
        label.setVisible(true);
        this.add(label);
        InputE.setVisible(true);
        InputE.setBounds(this.getWidth()-150,0,120,40);
        System.out.println(randNumber);
        labelBottom.setText(role.getName()+":"+role.getStart());
        /*猜数字*/
        InputE.addActionListener(e -> {
            String text = Input.getText();
            /*用util里的正则来判断是否整数*/
            if (Pattern.matches(Util.getNumP(),text)){
                int number = Integer.parseInt(text);
                if (number> randNumber){
                    labelBottom.setText("<html><body>"+role.getName()+":"+role.getFightChar().get(new Random().nextInt(role.getFightChar().size()))+"<br>"+role.getPS(number)+"<body></html>");
                    --health;
                } else if (number < randNumber) {
                    labelBottom.setText("<html><body>"+role.getName()+":"+role.getFightChar().get(new Random().nextInt(role.getFightChar().size()))+"<br>"+role.getPS(number)+"<body></html>");
                    --health;
                }else{
                    labelBottom.setText(role.getName()+role.getPS(number));
                    /*猜中则删除boss*/
                    Integer id = Util.getList().get(0).getTask().getId();
                    if (Util.getTask(id).getPre_Task()==null){
                        Util.getTask(id).setComplete(true);
                        Util.getList().remove(0);
                    }else if ( Util.getTask(id).getPre_Task().isComplete()){
                        Util.getTask(id).setComplete(true);
                        Util.getList().remove(0);
                    }
                    if (Util.getList().size()==0) {
                        JOptionPane.showMessageDialog(null, "☆ 恭喜通关 ☆");
                    }
                    JOptionPane.showMessageDialog(null,
                            "恭喜击败"+role.getName()+"获得金币:"+Util.getGold().setGold(Util.getRandGold())+"\n"+"回营地休整一下吧");
                    dispose();
                    formt.dispose();
                    From.getFrom();
                }

            }else{
                labelBottom.setText("要输入正整数哦");
                --health;
            }
            if (Util.getBur()>0){
                Util.bur();
            }
            label.setText("生命:"+(health));
            /*终末时钟特殊判定*/
            if (health<=0){
                if (Util.getEgoList().contains(new End())){
                    health=10;
                    Util.getEgoList().remove(new End());
                    JOptionPane.showMessageDialog(null,"随着指针的滴答作响,你发现你的视野明亮起来");
                    return;
                }
                JOptionPane.showMessageDialog(null,"你失败了");
                dispose();
                From.getFrom();
                formt.dispose();
            }
        });
        this.add(InputE);
        Input.setVisible(true);
        Input.setBounds(this.getWidth()-270,0,120,40);
        this.add(Input);


    }
    public static From2 From2(){
        return new From2();
    }
}
