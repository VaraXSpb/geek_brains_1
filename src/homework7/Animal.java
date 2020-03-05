package homework7;

public class Animal {
    private String name;
    private  boolean isFeed;

    public void setFeed(boolean isFeed) {
        this.isFeed = isFeed;
    }

    public boolean isFeed() {
        return isFeed;
    }

    public void showFeedStatus(){
        if (isFeed) {
            System.out.println(name + " is full.");
        } else {
            System.out.println(name + " is hungry.");
        }
    }

    public Animal(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
