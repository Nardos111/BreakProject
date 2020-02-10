import java.util.Date;

public class Task {
    private String taskid;
    private Date publishedDate;
    private Date assignedDate;
    private boolean checked;
    private int priority;
    private String comments;
    private String name;


    public Task() {
    }

    public Task(String taskid, String name, Date publishedDate, Date assignedDate, boolean checked, int priority, String comments) {
        this.taskid = taskid;
        this.name = name;
        this.publishedDate = publishedDate;
        this.assignedDate = assignedDate;
        this.checked = checked;
        this.priority = priority;
        this.comments = comments;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Task)) return false;
        Task o = (Task) obj;
        return o.taskid == this.taskid;
    }
}
