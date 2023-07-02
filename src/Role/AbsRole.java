package Role;

import task.AbsTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbsRole {
    String name;
    int random =new Random().nextInt(1001);
    AbsTask task;
    Integer health;
    Integer minAtk;
    Integer maxAtk;
    String color;
    String skill;
    List<String> fightChar = new ArrayList<>();

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer returnAtk(){
        return (int)(Math.random()*(maxAtk+1)+minAtk);
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

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health += health;
    }

    public AbsTask getTask() {
        return task;
    }

    public void setTask(AbsTask task) {
        this.task = task;
    }

    public  Integer getRandom(){
        return random;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRandom(int random) {
        this.random = random;
    }
    public AbsRole randNumber(){
        this.random = new Random().nextInt(1001);
        return this;
    }
    public String getMassage(){
        return null;
    }

    public List<String> getFightChar() {
        return fightChar;
    }

    public void setFightChar(List<String> fightChar) {
        this.fightChar = fightChar;
    }

    @Override
    public String toString() {
        return "AbsRole{" +
                "name='" + name + '\'' +
                '}';
    }
    protected abstract void addFightChar();
    String start;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
    public abstract String getPS(Integer number);
    List<String> abuseChar = new ArrayList<>();
    public  List<String> getAbuseChar(){
        return abuseChar;
    }
    public abstract void addAbuseChar();
    public abstract String Mags();
    int js;

    public int getJs() {
        return js;
    }

    public void js__() {
        ++js;
    }
}
