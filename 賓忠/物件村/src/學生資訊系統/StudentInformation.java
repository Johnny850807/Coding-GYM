package �ǥ͸�T�t��;


public class StudentInformation {
	private float high;          //private�T�O�w����
	private float weight;
	private int grade;
	private String id;
	
	public StudentInformation(float high, float weight, int grade, String id){
		this.high=high;          //this.high �ۤv���V�ۤv,�ǤJ���Ѽƪ��ȵ�StudentInformation ��Instance variable�s��
		this.weight=weight;      //�غc���ѼƻP�����Ʀ����P�W��,this�[�H�ϧO
		this.grade=grade;
		this.id=id;
	}
	public String toString(){
		return "Student [height=" + high + ", weight=" + weight + ", grades=" + grade + ", id=" + id + "]";
	}
	public void setHigh(float fhigh){     //public�Q�Τ�k�ӱ���
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
		igrade = igrade < 0 ? 0 : igrade;  //�p�G�O�t�ƴN��0
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
