package uttu.student;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class student 
{
	String name,grade;
	int rollno,physicsMarks,chemistryMarks,mathsMarks,totalMarks;
	double average;
	public student() {}
	
	public student(String name, int rollno, int physicsMarks, int chemistryMarks, int mathsMarks) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.physicsMarks = physicsMarks;
		this.chemistryMarks = chemistryMarks;
		this.mathsMarks = mathsMarks;
		this.totalMarks=chemistryMarks+mathsMarks+physicsMarks;
		this.average=this.totalMarks/3;
		if(this.average>=90)this.grade="A";
		else if(this.average>=80)this.grade="B";
		else if(this.average>=70)this.grade="C";
		else this.grade="D";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getPhysicsMarks() {
		return physicsMarks;
	}
	public void setPhysicsMarks(int physicsMarks) {
		this.physicsMarks = physicsMarks;
	}
	public int getChemistryMarks() {
		return chemistryMarks;
	}
	public void setChemistryMarks(int chemistryMarks) {
		this.chemistryMarks = chemistryMarks;
	}
	public int getMathsMarks() {
		return mathsMarks;
	}
	public void setMathsMarks(int mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
		
}
