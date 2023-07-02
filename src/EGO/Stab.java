package EGO;

public class Stab extends AbsEgo{
    public Stab() {
        name = "刺剑";
        minAtk = 1;
        maxAtk =60;
        color = "White";
        describe = new StringBuilder("最基础的装备;\n+10拼点上下限");
    }

    @Override
    public void effect() {
        maxAtk+=10;
        minAtk+=10;
    }
}
