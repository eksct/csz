package EGO;

import java.util.Random;

public class hat extends AbsEgo{
    public hat() {
        name = "恋恋的帽子";
        describe = new StringBuilder("一顶不明所以的帽子，时刻小心");
    }

    /**
     * 必要
     */
    @Override
    public void effect() {
        maxAtk = new Random().nextInt(301);
        minAtk = new Random().nextInt(2);
    }
}
