package task;

public class TaskTwo extends AbsTask{
    public TaskTwo() {
        setId(1);
        setTaskGold(600);
        setDescribe(new StringBuilder(
                "<html><body>Task Two:<br>"
                        + "  击败 ☆ 但丁<br>报酬:"+getTaskGold()+"</body></html>"
        ));

    }
}
