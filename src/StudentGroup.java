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
		
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException{
		// Add your implementation here
		if(students==null)
		    throw new IllegalArgumentException();
		 this.students=students;
	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		 return students[index];
	}

	@Override
	public void setStudent(Student student, int index)throws IllegalArgumentException {
		// Add your implementation here
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		 this.students[index]=student;
		     
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
		    throw new IllegalArgumentException();
		int size=students.length;
		    Student[] a=new Student[size+1];
		    a[0]=student;
		    for(int i=1;i<=size;i++)
		        a[i]=students[i-1];
		 students=a;
	}

	@Override
	public void addLast(Student student)throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
		    throw new IllegalArgumentException();
		int size=students.length;
		    Student[] a=new Student[size+1];
		    for(int i=0;i<size;i++)
		        a[i]=students[i];
		   a[size]=student;
		 students=a;
	}

	@Override
	public void add(Student student, int index)throws IllegalArgumentException{
		// Add your implementation here
		if(student==null)
		    throw new IllegalArgumentException();
		int size=students.length;
		    Student[] a=new Student[size+1];
		    for(int i=0;i<index;i++)
		        a[i]=students[i];
		   a[index]=student;
		   for(int i=index+1;i<=size;i++)
		        a[i]=students[i-1];
		 students=a;
	}

	@Override
	public void remove(int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		     int size=students.length;
		    Student[] a=new Student[size-1];
		    for(int i=0;i<index;i++)
		        a[i]=students[i];
		   for(int i=index;i<size-1;i++)
		        a[i]=students[i+1];
		 students=a;
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException{
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
		        Student[] a=new Student[size-1];
		        for(int i=0;i<index;i++)
		            a[i]=students[i];
		       for(int i=index;i<size-1;i++)
		            a[i]=students[i+1];
		     students=a;
		    }
		    return;
	}

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		    Student[] a=new Student[index+1];
		    for(int i=0;i<index;i++)
		        a[i]=students[i];
		    students=a;
	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException{
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
		int j=0;
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		    Student[] a=new Student[students.length-index];
		    for(int i=index;i<students.length;i++)
		        a[j++]=students[i];
		    students=a;
	}

	@Override
	public void removeToElement(Student student) throws IllegalArgumentException{
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
		       removeToIndex(index);
		    }
		    return;
	}

	@Override
	public void bubbleSort() {
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
	public Student getNextStudent(Student student)throws IllegalArgumentException {
		if(student==null)
		    throw new IllegalArgumentException();
		for(int i=0;i<students.length;++i)
		    if(students[i]==student)
		        return students[i+1];
		return null;
	}
}
