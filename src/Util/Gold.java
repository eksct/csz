package Util;

public class Gold {
    private Integer gold;

    public Integer getGold() {
        return gold;
    }

    public Integer setGold(Integer gold) {
        this.gold += gold;
        return gold;
    }
    public Gold() {
        gold = 160;
    }
}
