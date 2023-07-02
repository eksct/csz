package task;

public class TaskThree extends AbsTask{
    public TaskThree() {
        setId(2);
        setTaskGold(100);
        setDescribe(new StringBuilder(
                "<html><body>Task Three:<br>"
                        + " 击败 ☆ 夜裳眠 <br>报酬:"+getTaskGold()+"</body></html>"
        ));

    }
}
