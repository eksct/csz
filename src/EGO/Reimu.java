package EGO;


import Util.Util;

public class Reimu extends AbsEgo{
    public Reimu() {
        name = "博丽神社御币";
        minAtk = 45;
        maxAtk =80;
        color = "Red";
        describe = new StringBuilder("博丽神社巫女使用的御币，现不明为何会落入此处;\n使用时+1点血量");
    }

    /**
     * 必要
     */
    @Override
    public void effect() {
        Util.setHealth(1);
    }
}
