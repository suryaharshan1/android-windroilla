package com.littleturn.todo;

public class RowItem {
	private int imageId;
    private String title;
    private String time;
    private String priority;
    private String category;
     
    public RowItem(int imageId, String title, String time,String priority,String Category) {
        this.imageId = imageId;
        this.title = title;
        this.time = time;
        this.priority = priority;
        this.category = category;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getDesc() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
    @Override
    public String toString() {
        return title + "\n" + time + "\n" + priority + "\n" + category;
    }   
}
