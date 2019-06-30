package dataStructure;

public class MyClass {
int id;  
int num ; 

MyClass(int id,int num){
	this.id = id ;
	this.num = num ;
}



@Override
public String toString() {
	return "MyClass [id=" + id + ", num=" + num + "]";
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	MyClass other = (MyClass) obj;
	if (id != other.id)
		return false;
	return true;
}



}
