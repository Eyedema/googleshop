package core.categories;

public abstract class Category {
	
	private String desc;
	
	public Category(String desc) {
		this.desc = desc;
	}
	
	public String getDesc(){
		return desc;
	}
	
	@Override
	public String toString(){
		return "Category: "+getDesc();
	}

}
