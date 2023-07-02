package EGO;

import Util.Util;

import java.util.Random;

public class Ⅲ extends AbsEgo{
    public Ⅲ() {
        name ="瞬间恢复Ⅲ";
        color ="pink";
        describe = new StringBuilder("恢复你的生命;\n使用时恢复1-3点血量");
    }

    /**
     * 必要
     */
    @Override
    public void effect() {
        Util.setHealth((int)(Math.random()*5)+1);
    }
}
