package EGO;

public class End  extends AbsEgo{
    public End() {
        name = "终末时钟";
        color = "purple";
        describe = new StringBuilder("造型奇怪的时钟\n在你濒临死亡时复活你");
        flag = true;
    }

    /**
     * 必要
     */
    @Override
    public void effect() {

    }
}
