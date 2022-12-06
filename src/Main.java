import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.teacher;
import dto.userinfo;
import service.TeacherService;
import service.TeacherServiceImpl;
import service.userService;
import service.userServiceImpl;

public class Main {

	private static userService userService = new userServiceImpl();
	private static TeacherService teacherService = new TeacherServiceImpl();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter The login credentials :");
		try {
			String start = "y";
			while (start == "y") {
				System.out.println("Enter The Operation :\n1. register\n2. alredy a User Login");
				int srt = scan.nextInt();
				switch (srt) {
				case 1:
					System.out.println("Enter The UserName :");
					String userName = scan.next();
					System.out.println("Enter The Password :");
					String password = scan.next();
					userinfo addeduser = userService.adduser(new userinfo(userName, password));
					System.out.println("user " + addeduser.getUserName() + " created");
					break;

				case 2:
					List<userinfo> usercheck = new ArrayList<>();
					System.out.println("Enter The userName");
					String userName1 = scan.next();
					System.out.println("enter the Password");
					String password2 = scan.next();

					userinfo validateUser = userService.validateUser(userName1, password2);
					if (validateUser == null) {
						System.out.println("invalid");

					} else {
						System.out.println("validated");
						String temp = "y";
						while (temp == "y") {
							System.out.println(
									"Enter The Operation To perform\n1. For Creating Records\n2. To Show All Records\n3. To show Records BY ID\n4. Update By ID\n5. Delete BY ID\n6. Exit");
							int tmp = scan.nextInt();
							switch (tmp) {
							case 1:
								System.out.println("enter the Teacher to add in school :");
								try {
									teacher teacher = null;
									while (true) {
										System.out.println("enter the teacher ID :");
										int id = scan.nextInt();
										System.out.println("enter the teacher name :");
										String name = scan.next();
										System.out.println("enter the teacher salary :");
										double salary = scan.nextDouble();
										teacher = teacherService.createTeacher(new teacher(id, name, salary));
										// System.out.println("Teacher created successfully !" + teacher);

										System.out.println("Teacher " + teacher.getName() + " created successfully!");
										System.out.println("do you want to add more teacher :");
										String ans = scan.next();
										if ("NO".equalsIgnoreCase(ans)) {
											break;
										}
									}

								} catch (Exception e) {
									System.out.println("colude not save " + e);
								}
								break;
							// --------------------------------------------------------------------------------------
							case 2:
								System.out.println("----------------------------------------------");

								try {
									System.out.println(teacherService.getAllTeacher());
								} catch (Exception e) {
									System.out.println("Could't not fetch Teacher Records:" + e.getMessage());
								}
								break;
							// --------------------------------------------------------------------------------------
							case 3:
								System.out.println("----------------------------------------------");
								try {
									System.out.println("Enter the Teacher ID :");
									int id = scan.nextInt();
									teacher teacherById = teacherService.getTeacherById(id);
									System.out.println(teacherById);
								} catch (Exception e) {
									System.out.println("Could't not fetch Teacher Records:" + e.getMessage());

								}
								break;
							// -----------------------------------------------------------------------------------
							case 4:
								System.out.println("------------------------------------------------");

								try {
									System.out.println("Enter The ID to Update :");
									int id = scan.nextInt();
									System.out.println("Enter The Name :");
									String name = scan.next();
									System.out.println("Enter the salary to Update :");
									double salary = scan.nextDouble();
									teacher updateTec = new teacher(id, name, salary);
									if (teacherService.UpdateTeacher(updateTec) != null)
										;
									System.out.println("Teacher Updated :" + updateTec);
								} catch (Exception e) {
									System.out.println("could not updated Teacher record.");

								}
								break;
							// -------------------------------------------------------------------------------
							case 5:
								System.out.println("-------------------------------------------");
								try {
									System.out.println("Enter the ID to delete :");
									int id = scan.nextInt();
									if (teacherService.deleteTeacherByID(id)) {
										System.out.println("Teacher deleted having id :" + id);
									} else {
										System.out.println("Teacher could not be deleted :");
									}
								} catch (Exception e) {
									System.out.println(e);
								}
								break;
							// -----------------------------------------------------------------------------
							case 6:
								System.exit(0);
							default:
								System.out.println("Enter the valid choice");
							}
						}
					}

				default:
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("colude not create " + e);

		}

	}
}
