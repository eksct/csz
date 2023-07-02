package task;

public abstract class AbsTask {
    Integer id;
    StringBuilder Describe;
    boolean complete;
    AbsTask pre_Task;
    Integer taskGold;
    boolean completePax;

    public boolean isCompletePax() {
        return completePax;
    }

    public void setCompletePax(boolean completePax) {
        this.completePax = completePax;
    }

    public StringBuilder getDescribe() {
        return Describe;
    }

    public void setDescribe(StringBuilder describe) {
        Describe = describe;
    }
    public boolean pre_Task(AbsTask task){
        return false;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public AbsTask getPre_Task() {
        return pre_Task;
    }

    public AbsTask setPre_Task(AbsTask pre_Task) {
        this.pre_Task = pre_Task;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskGold() {
        return taskGold;
    }

    public void setTaskGold(Integer taskGold) {
        this.taskGold = taskGold;
    }
}
