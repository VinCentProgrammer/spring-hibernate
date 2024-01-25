package com.dungken.SpringHibernate;

import com.dungken.SpringHibernate.dao.CourseDAO;
import com.dungken.SpringHibernate.dao.StudentDAO;
import com.dungken.SpringHibernate.dao.TeacherDAO;
import com.dungken.SpringHibernate.dao.TeacherDetailDAO;
import com.dungken.SpringHibernate.entity.Course;
import com.dungken.SpringHibernate.entity.Student;
import com.dungken.SpringHibernate.entity.Teacher;
import com.dungken.SpringHibernate.entity.TeacherDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class SpringHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO,
											   TeacherDetailDAO teacherDetailDAO,
											   CourseDAO courseDAO,
											   StudentDAO studentDAO) {
		return runner -> {
			//createTeacher(teacherDAO);

			//findTeacherById(teacherDAO, 1);
			//findTeacherDetailById(teacherDetailDAO, 1);

			//createCourse(teacherDAO, courseDAO);

			//findTeacherWithCourses(teacherDAO, 1);
			//findTeacherWithCourses(teacherDAO, 2);

			//findTeacherWithCourses_LAZY(teacherDAO, courseDAO, 1);
			//findTeacherWithCourses_LAZY(teacherDAO, courseDAO, 2);

			//findTeacherWithCourses_JOIN_FETCH(teacherDAO,2);
			//findTeacherWithCourses_JOIN_FETCH(teacherDAO,3);

			//createStudentAndCourse(courseDAO, studentDAO);

			findCourseAndStudent(courseDAO, 6);
			//findCourseAndStudent(studentDAO, 1);
		};
	}

	private void findCourseAndStudent(StudentDAO studentDAO, int id) {
		//Student student = studentDAO.findStudentById(id);
		Student student = studentDAO.findStudentAndCourseByStudentId(id);
		System.out.println("Courses: " + student.getCourses());
		System.out.println("Student's of course: " + student);
	}

	private void findCourseAndStudent(CourseDAO courseDAO, int id) {
//		Course course = courseDAO.findCourseById(id);
		Course course = courseDAO.findCourseAndStudentByCourseId(id);
		System.out.println("Courses: " + course);
		System.out.println("Student's of course: " + course.getStudents());
	}

	private void createStudentAndCourse(CourseDAO courseDAO, StudentDAO studentDAO) {
		Course course = new Course();
		course.setTitle("Design Web");

		Student st1 = new Student();
		st1.setFullname("Van Dung");

		Student st2 = new Student();
		st2.setFullname("Minh Nhat");

		course.addStudent(st1);
		course.addStudent(st2);

		courseDAO.save(course);
	}

	private void findTeacherWithCourses_JOIN_FETCH(TeacherDAO teacherDAO, int id) {
		Teacher teacher = teacherDAO.findTeacherByIdJoinFetch(id);

		System.out.println("Teacher's info: " + teacher);
		System.out.println("Courses of teacher: " + teacher.getCourses());
	}

	private void findTeacherWithCourses_LAZY(TeacherDAO teacherDAO, CourseDAO courseDAO, int id) {
		Teacher teacher = teacherDAO.findTeacherById(id);

		System.out.println("Teacher's info: " + teacher);

		List<Course> courses = courseDAO.findCoursesByTeacherId(id);

		System.out.println("Courses of teacher: " + courses);
	}

	private void findTeacherWithCourses(TeacherDAO teacherDAO, int id) {
		Teacher teacher = teacherDAO.findTeacherById(id);

		System.out.println("Teacher's info: " + teacher);
		System.out.println("Courses of teacher: " + teacher.getCourses());
	}

	@Transactional
	public void createCourse(TeacherDAO teacherDAO, CourseDAO courseDAO) {
		Teacher teacher = new Teacher();
		teacher.setFirstName("Ken");
		teacher.setLastName("Dev");
		teacher.setEmail("kendev@gmail.com");

		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setAddress("Gia Lai - Viet Nam");
		teacherDetail.setGender(true);
		teacher.setTeacherDetail(teacherDetail);

		Course c1 = new Course("Spring and Hibernate", "Description", null, null);
		Course c2 = new Course("Spring Boot and React", "Description", null, null);

		teacher.addCourse(c1);
		teacher.addCourse(c2);

		System.out.println("Teacher saving...");
		teacherDAO.save(teacher);
		System.out.println("Done!");
	}

	public void findTeacherDetailById(TeacherDetailDAO teacherDetailDAO, int id) {
		TeacherDetail teacherDetail = teacherDetailDAO.findTeacherDetailById(id);
		System.out.println("TeacherDetail: " + teacherDetail);
		System.out.println("Teacher: " + teacherDetail.getTeacher());
	}

	public void findTeacherById(TeacherDAO teacherDAO, int id) {
		Teacher teacher = teacherDAO.findTeacherById(id);
		System.out.println("Teacher: " + teacher);
		System.out.println("TeacherDetail: " + teacher.getTeacherDetail());
	}

	public void createTeacher(TeacherDAO teacherDAO) {
		Teacher teacher = new Teacher();
		teacher.setFirstName("Dung");
		teacher.setLastName("Ha");
		teacher.setEmail("dungken@gmail.com");

		TeacherDetail teacherDetail = new TeacherDetail();
		teacherDetail.setAddress("Gia Lai");
		teacherDetail.setGender(true);

		teacher.setTeacherDetail(teacherDetail);

		// Save
		System.out.println("Saving teacher " + teacher);
		teacherDAO.save(teacher);
		System.out.println("Done!");
	}
}
