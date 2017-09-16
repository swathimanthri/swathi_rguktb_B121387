import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException {
		// Add your implementation here
		if(this.students==null)
			throw new IllegalArgumentException();
		else
		{
			this.students=students;
		}
	
	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException {
		// Add your implementation here
		//return null;
		try{
			if(index<0||index>=this.students.length)
				throw new IllegalArgumentException();
			else
				return this.students[index];
			}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public void setStudent(Student student, int index)  throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=this.students.length||student==null)
				throw new IllegalArgumentException();
			else
				this.students[index]=student;	
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else
		{
			Student[] temp=new Student[this.students.length+1];
			temp[0]=student;
			for(int i=0;i<this.students.length;i++)
				temp[i+1]=this.students[i];
			this.students=temp;
		}
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else
		{
			Student[] temp=new Student[this.students.length+1];
			for(int i=0;i<this.students.length;i++)
				temp[i]=this.students[i];
			temp[this.students.length]=student;
			this.students=temp;
		}
	}

	@Override
	public void add(Student student, int index)throws IllegalArgumentException {
		// Add your implementation here
		if(index<0||index>=this.students.length||student==null)
				throw new IllegalArgumentException();
			else
			{
				Student[] temp=new Student[this.students.length+1];
				for(int i=0;i<index;i++)
					temp[i]=this.students[i];
				temp[index]=student;
			          for(int i=index+1;i<=this.students.length;i++)
			          	temp[i]=this.students[i-1];
				this.students=temp;
			}
	}

	@Override
	public void remove(int index) throws IllegalArgumentException {
		// Add your implementation here
		if(index<0||index>=this.students.length)
				throw new IllegalArgumentException();
			else
			{
				Student[] temp=new Student[this.students.length-1];
				int n=this.students.length;
				int check=0;
				for(int i=0;i<n;i++)
				{
					if(i==index)
						check=1;
					if(check+i<n)
						temp[i]=this.students[check+i];
				}
				this.students=temp;
			}
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException {
		// Add your implementation here
		 if(student==null)
			 throw new IllegalArgumentException();
		else
		{
				Student[] temp=new Student[this.students.length-1];
				int n=this.students.length;
				int flag=0;
	             		for(int i=0;i<n;i++){
	             			if(this.students[i].getId()==student.getId()&&this.students[i].getFullName().equals(student.getFullName())&&this.students[i].getBirthDate().compareTo(student.getBirthDate())==0&&this.students[i].getAvgMark()==student.getAvgMark())
	             				flag=1;
	             			if(flag+i<n)
	             				temp[i]=this.students[flag+i];
	             				}
	             		if(flag!=1)
	             			throw new IllegalArgumentException();
	             		this.students=temp;
		}
	}

	@Override
	public void removeFromIndex(int index)throws IllegalArgumentException {
		// Add your implementation here
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		    Student[] a=new Student[index+1];
		    for(int i=0;i<index;i++)
		        a[i]=students[i];
		    students=a;
	}

	@Override
	public void removeFromElement(Student student)throws IllegalArgumentException {
		// Add your implementation here
		int index=-1;
		if(student==null)
		    throw new IllegalArgumentException();
		int size=students.length;
		for(int i=0;i<size;i++)
		    if(students[i].equals(student))
		          index=i;
		    if(index!=-1)
		   {
		       removeFromIndex(index);
		    }
		    return;
	}

	@Override
	public void removeToIndex(int index) throws IllegalArgumentException{
		// Add your implementation here
		 if(index<0||index>=this.students.length)
			 throw new IllegalArgumentException();
		else{
			Student[] temp=new Student[this.students.length-index];
			int n=this.students.length-index;
			for(int i=0;i<n;i++)
			{
				temp[i]=this.students[index+i];
			}
			this.students=temp;
		}
	}

	@Override
	public void removeToElement(Student student)throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
			 throw new IllegalArgumentException();
		else{
			ArrayList<Student> a=new ArrayList<Student>();
			int n=this.students.length;
			boolean flag=false;
	   		for(int i=0;i<n;i++){
	   			if(this.students[i].getId()==student.getId()&&this.students[i].getFullName().equals(student.getFullName())&&this.students[i].getBirthDate().compareTo(student.getBirthDate())==0&&this.students[i].getAvgMark()==student.getAvgMark())
	   				flag=true;
	   			if(flag)
	   				a.add(this.students[i]);
	   				}
	   		this.students=a.toArray(new Student[a.size()]);
   		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for (int i=0; i<students.length; ++i) 
			for (int j=0;j<students.length-i-1 ; ++j) 
				if(students[j].compareTo(students[j+1])>0)
				{
					Student temp=students[j];
					students[j]=students[j+1];
					students[j+1]=temp;
				}
				return;
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
