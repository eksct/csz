package Role;

import Util.Util;

public class Dante extends AbsRole{
    public Dante() {
        this.name = "但丁";
        this.random = getRandom();
        this.health = 100;
        this.color = "Red";
        setMaxAtk(50);
        setMinAtk(25);
        task = Util.getTask(1);
        start="滴答……";
        addFightChar();
        addAbuseChar();
    }
    @Override
    public String getMassage() {
        return "滴答滴答↗滴答→滴答滴答滴答♪(´▽｀)(得意的滴答声)";
    }

    @Override
    protected void addFightChar() {
        fightChar.add("滴答……(思考的滴答声)");
        fightChar.add("滴答滴答滴答滴答(略有急促的滴答声)");
        fightChar.add("滴答滴答(平静的滴答声)");
    }

    @Override
    public String getPS(Integer number) {
        return this.random > number ? "滴答滴答滴答滴答(嘲笑的滴答声)" : (this.random==number ? "滴答↗滴答↗滴答→滴答(惊讶的滴答声)":"滴答滴答滴答滴答(嘲笑的滴答声)");
    }

    @Override
    public void addAbuseChar() {
        abuseChar.add("滴答?");
        abuseChar.add("滴答滴答??");
        abuseChar.add("滴答滴答滴答???");

    }

    /**
     * @return
     */
    @Override
    public String Mags() {
        return "滴答!!!(慌乱的滴答声)";
    }
}
