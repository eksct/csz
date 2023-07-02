package From;

import Util.Util;
import task.AbsTask;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class From4 extends JFrame {
    JLabel labelTask = new JLabel();
    JButton submit = new JButton("提交任务");
    AbsTask taskRole;
    public From4(String task){
        taskRole= Util.getTask(Integer.parseInt(task)-1);
        this.setTitle("未完成");
        if (!taskRole.isCompletePax()){
            submit.setEnabled(false);
        }
        if (taskRole.isComplete()){
            this.setTitle("已完成");
            submit.setEnabled(true);
        }
        if (taskRole.isCompletePax()){
            this.setTitle("已提交");
            submit.setEnabled(false);
        }
        this.setLayout(null);
        this.add(labelTask);
        this.add(submit);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                Util.setAns(Integer.parseInt(task)-1,false);
                From5.getTaskList().remove(From5.getTaskList().size()-1);
            }
        });
        this.setResizable(false);
        labelTask.setVisible(true);
        submit.setVisible(true);
        labelTask.setText(taskRole.getDescribe().toString());
        labelTask.setBounds((this.getWidth()>>1),0,100,100);
        submit.setBounds((this.getWidth()>>1),120,100,100);
        Util.fromCenter(this);
        this.setSize(250,300);
        this.setLocation(this.getX()+250,this.getY());
        submit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (taskRole.isComplete()){
                    Util.getGold().setGold(taskRole.getTaskGold());
                    submit.setEnabled(false);
                    taskRole.setCompletePax(true);
                }
            }
        });
    }
    public static From4 getFrom4(String task){
        Integer fx = Integer.parseInt(task)-1;
        if (!Util.getAns()[fx]){
            Util.setAns(fx,true);
            return new From4(task);
        }
        return null;
    }
}
