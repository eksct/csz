package EGO;
/**
 * @author g
 * 装备抽象类
 * @color: 颜色,攻击boss时武器如有与boss相同的颜色，则对本次区间下限+30%，最终伤害区间以一次为准;
 * @Atk: 护甲没有伤害,武器伤害将在上下限中随机，多把武器将取全部武器的最大上限与最大下限;使用武器攻击将进行拼点判定
 * @effect: 效果
 * @describe: 描述
 * @flag 标记是否在拼点时使用
 */
public abstract class AbsEgo {
    String name;
    Integer eid;
    Integer minAtk;
    Integer maxAtk;
    String color;
    String effect;
    StringBuilder describe;
    boolean flag;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public AbsEgo setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getMinAtk() {
        return minAtk;
    }

    public void setMinAtk(Integer minAtk) {
        this.minAtk = minAtk;
    }

    public Integer getMaxAtk() {
        return maxAtk;
    }

    public void setMaxAtk(Integer maxAtk) {
        this.maxAtk = maxAtk;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public StringBuilder getDescribe() {
        return describe;
    }

    public void setDescribe(StringBuilder describe) {
        this.describe = describe;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (getName().equals(((AbsEgo)obj).getName())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "AbsEgo{" +
                "name='" + name + '\'' +
                '}';
    }
    /**
     *必要
     * */
    public abstract void effect();

}
