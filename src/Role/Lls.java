package Role;

import Util.Util;

public class Lls extends AbsRole{
    public Lls() {
        this.name = "莉莉丝";
        this.random = getRandom();
        this.health = 100;
        this.color ="White";
        setMaxAtk(45);
        setMinAtk(20);
        task = Util.getTask(0);
        addFightChar();
        this.start="嘁，麻烦的家伙";
        addAbuseChar();
    }

    public String getMassage(){
        return "废物";
    }

    @Override
    protected void addFightChar() {
        fightChar.add("你急了");
        fightChar.add("典中典");
        fightChar.add("乐");
        fightChar.add("孝死我了");
        fightChar.add("绷不住了");
        fightChar.add("赢麻了属于是");
    }

    @Override
    public String getPS(Integer number) {
        return this.random > number ? "你好小哦~呵呵" : (this.random==number ? "怎么会是这样...":"你是不是太得意忘形了?");
    }

    @Override
    public void addAbuseChar() {
        abuseChar.add("你怎么能斗得过我呢?");
        abuseChar.add("也不看看自己几斤几两");
        abuseChar.add("能不能不要再玩你的小玩具了?");
        abuseChar.add("真没意思");
    }

    /**
     * @return
     */
    @Override
    public String Mags() {
        return "嘁，麻烦了";
    }
}
