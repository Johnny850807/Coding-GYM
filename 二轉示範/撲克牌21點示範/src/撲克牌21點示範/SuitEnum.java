package ���J�P21�I�ܽd;

public enum SuitEnum {
	PLUM("����") , DIAMOND("�٧�") , HEART("�R��") , SPADE("�®�");
	String name;
	private SuitEnum(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}

}
