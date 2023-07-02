package Util;

import EGO.*;
import From.form7;
import Role.*;
import task.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Util {
    public static void fromCenter(JFrame from){
        int fWidth = 800;
        int fHeight =600;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        from.setBounds((width-fWidth)>>1,(height-fWidth)>>1,fWidth,fHeight);
        from.setVisible(true);
    }
    /**
     * 正则表达式
     * */
    public static String getNumP(){
        return "[0-9]+";
    }
    static Gold gold = new Gold();
    public static Gold getGold(){
        return gold;
    }
    /**
     * boss与任务
     * */
    static java.util.List<AbsRole> roleList = new LinkedList<>();
    static java.util.List<AbsTask> taskList = new LinkedList<>();
    public static java.util.List<AbsRole> getList(){
        return roleList;
    }
    public static AbsTask getTask(Integer id){
        return taskList.get(id);
    }
    public static Integer getTaskSize(){
        return taskList.size();
    }
    /**
     * 任务、角色、装备（ego）初始化
     * */
    public static void initList(){
        taskList.clear();
        AbsTask task[] = {
                new TaskOne(),
                new TaskTwo(),
                new TaskThree()
        };
        taskList.add(task[0]);
        taskList.add(task[1].setPre_Task(task[0]));
        taskList.add(task[2]);
        roleList.add(new Lls());
        roleList.add(new Dante());
        roleList.add(new Nacht());
        initEgo();
    }
    public static void initAns(){
        ans =   new boolean[getTaskSize()];
    }
    public static Integer getRandGold(){
        return new Random().nextInt(100);
    }
    /**
     *ans[]标记任务窗口，避免单个任务开多个窗口
     */
    static boolean ans[];
    public static boolean[] getAns(){
        return ans;
    }
    public static void setAns(Integer id,boolean flag){
        ans[id] = flag;
    }
    /**
     * 卡池初始化
     * */
    static java.util.List<AbsEgo> ego;
    public static void initEgo(){
        ego = new LinkedList<>();
        EquipmentBar = new HashSet<>();
        for(int i=1;i<=3;i++){
            ego.add(new Stab().setName("刺剑"+i));
            ego.add(new Reimu().setName("博丽神社御币"+i));
        };
        ego.add(new Ⅲ());
        ego.add(new End());
        ego.add(new Red());
        ego.add(new hat());
    }
    public static List<AbsEgo> getEgoList(){
        return ego;
    }
    /**
     * 装备栏
     * */
    static HashSet<AbsEgo> EquipmentBar;
    public static void setEquipmentBar(AbsEgo ego){
        EquipmentBar.add(ego);
    }

    public static HashSet<AbsEgo> getEquipmentBar() {
        return EquipmentBar;
    }

    static int burial=0;
    /**
     * i EGO拼点点数
     * 没有武器则无法实现拼点
     * 具体在AbsEgo
     * */
    public static Integer returnAtk(String color){
        if (EquipmentBar.size()==0){
            return -1;
        }
        if (burial!=0){
            return -2;
        }
        Integer max = 0;
        Integer min = 0;
        for(AbsEgo ego1 : EquipmentBar){
            if (ego1.isFlag()){continue;}
            ego1.effect();
            max = Math.max(max,ego1.getMaxAtk());
            min = Math.max(min,ego1.getMinAtk());
            if (ego1.getColor().equals(color)){
                min+=(int)(min*0.3);
            }
        }
        burial=3;
        int i=0;
        if (max!=0){
            i = (int)((Math.random()*max+1)+min);
        }
        return i;
    }
    /**
     * 拼点之后的冷却回合数
     * */
    public static void bur(){
        --burial;
    }
    public static Integer getBur(){
        return burial;
    }
    static int health = 10;
    public static Integer getHp(){
        return health;
    }

    public static void setHealth(int health) {
        Util.health += health;
        if (Util.health>10){
            Util.health=10;
        }
    }

    public static void setBurial(Integer value){
        burial = value;
    }
    /**
     * 只有一个装备栏
     * */
    static form7 form7;

    public static form7 getForm7() {
        return form7;
    }

    public static void setForm7(form7 form) {
        Util.form7 = form;
    }
}
