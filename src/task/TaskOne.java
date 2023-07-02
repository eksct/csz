package task;

public class TaskOne extends AbsTask{
    public TaskOne() {
        setId(0);
        setTaskGold(380);
        setDescribe(new StringBuilder(
                "<html><body>Task One:<br>"
                        + "  击败 ☆ 莉莉丝<br>报酬:"+getTaskGold()+"</body></html>"
        ));
    }
}
