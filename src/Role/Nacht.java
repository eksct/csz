package Role;

import Util.Util;

import javax.swing.*;
import java.util.List;

public class Nacht extends AbsRole{
    public Nacht() {
        this.name="眠";
        this.color="Null";
        this.maxAtk=200;
        this.minAtk=100;
        this.task= Util.getTask(2);
        this.start = "咱们来猜数字吧！";
        health =Integer.MAX_VALUE;
        addFightChar();
        addAbuseChar();
    }

    @Override
    protected void addFightChar() {
        fightChar.add("(☆——☆)哼~");
        fightChar.add("☆~也就~☆ 那样啦~");
        fightChar.add("是~~这样吗？ （--^^)");
    }

    @Override
    public String getPS(Integer number) {
        return this.random > number ? "小了哦~哼哼.是咱的胜利!（--^^)" : (this.random==number ? "kira ~☆~ kira ~☆~ ":"还差的远呢~");
    }

    @Override
    public String getMassage() {
        return "下次……你会全力以赴的对吧!";
    }
    @Override
    public void addAbuseChar() {
        abuseChar.add("不想打架......");
        abuseChar.add("为什么热衷于暴力");
        abuseChar.add("打架比猜数字好玩吗?");
        abuseChar.add("唉...你也想与他们为伍吗?");
        abuseChar.add("无趣");
    }
    /**
     * @return
     */
    @Override
    public String Mags() {
        js__();
        if (js==1){
            fightChar =abuseChar;
        }
        jsq();
        return "为什么不能和平相处呢?为什么要给别人带来苦难呢?";
    }

    /**
     * @return
     */
    @Override
    public List<String> getAbuseChar() {
        js__();
        jsq();
        return super.getAbuseChar();
    }
    public void jsq(){
        if (js>=3){
            JOptionPane.showMessageDialog(null,"事不过三,你的武器我收下了.下次继续");
            Util.getEquipmentBar().clear();
            Util.getForm7().removeAll();
            js=0;
        }
    }
}
