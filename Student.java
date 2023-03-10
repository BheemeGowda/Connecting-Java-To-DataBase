package studentDatabase.ty;

import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		StudentInterface si=new StudentImplementation();
		while(true) {
			System.out.println("STUDENT DATABASE");
			System.out.println("1:saveStudent\n2:deleteStudent\n3:updateStudent\n4:getStudentByMArks\n5:getAllStudent");
			System.out.println("enter the choice 1 to 5");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				si.saveStudent();
				break;
			case 2:
				si.deleteStudent();
				break;
			case 3:
				si.updateStudent();
				break;
			case 4:
				si.getStudentByMarks();
				break;
			case 5:
				si.getAllStudent();
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}

}
