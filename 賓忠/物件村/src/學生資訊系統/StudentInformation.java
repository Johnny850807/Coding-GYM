package 厩ネ戈癟╰参;


public class StudentInformation {
	private float high;          //private絋玂┦
	private float weight;
	private int grade;
	private String id;
	
	public StudentInformation(float high, float weight, int grade, String id){
		this.high=high;          //this.high ,肚把计倒StudentInformation Instance variable
		this.weight=weight;      //篶Α把计籔ン戈Θ,this跋
		this.grade=grade;
		this.id=id;
	}
	public String toString(){
		return "Student [height=" + high + ", weight=" + weight + ", grades=" + grade + ", id=" + id + "]";
	}
	public void setHigh(float fhigh){     //publicノよ猭ㄓ北
		high = fhigh;
	}
	public float getHigh(){
		return high;
	}
	public void setWeight(float fweight){
		weight = fweight;
	}
	public float getWeight(){
		return weight;
	}
	public void setGrade(int igrade){
		if(igrade>=0){         //絋玂Θ罿ぃ穦琌璽计(⊿ΤΘ..)
		grade = igrade;
		}
	}
	public int getGrade(){
		return grade;
	}
	public void setId(String sid){
		id = sid;
	}
	public String getId(){
		return id;
	}
	
	

}
