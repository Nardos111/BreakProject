public class ForumUser {
    private String name;
    private long id;

    public ForumUser(String name, long id){
        this.name = name;
        this.id = id;
    }
    public void createForum(String title, String description){

    }
    public void createCommunity(String title, String tag, String description){

    }
    public String getName(){
        return name;
    }

    public long getId(){
        return id;
    }

    public void addComment(Forum f, String c){}
}

