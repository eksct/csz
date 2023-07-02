package task;

import From.From4;
import From.From5;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JbuttonTask extends JButton {
    String text;
    StringBuilder builder = new StringBuilder();
    public JbuttonTask(String text) {
        super(text);
        this.text= text;
        this.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < text.length(); i++) {
                    if (Character.isDigit(text.charAt(i))){
                        builder.append(text.charAt(i)-'0');
                    }
                }
                From5.setTaskList(From4.getFrom4(builder.toString()));
                builder.delete(0,builder.length());
            }
        });
    }
}
