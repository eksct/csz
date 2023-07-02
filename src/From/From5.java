package From;

import Util.Util;
import task.JbuttonTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

public class From5 extends JFrame {
    public From5() throws HeadlessException {
        this.setTitle("任务栏");
        Util.initAns();
        this.setLayout(new GridLayout(5,1,0,10));
        this.setResizable(false);
        initTaskButton();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                try {
                    for (JFrame jf : taskList) {
                        jf.dispose();
                    }
                }catch (Exception t){
                }finally {
                    From.getFrom();
                }

            }
        });
        Util.fromCenter(this);
        this.setSize(125,450);
        this.setVisible(true);
        taskList= new LinkedList<>();
    }
    private void initTaskButton(){
        for (int i=0;i<3;i++){
            this.add(new JbuttonTask("任务"+(i+1)));
        }
    }
    static java.util.List<JFrame> taskList ;
    public static From5 getFrom5(){
        return new From5();
    }
    public static List<JFrame> getTaskList(){
        return taskList;
    }
    public static void setTaskList(JFrame jf){
        taskList.add(jf);
    }
}
