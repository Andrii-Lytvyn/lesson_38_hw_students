import java.io.*;
import java.util.ArrayList;
import java.util.List;

import students.Student;


public class Main {

  // написать базу данных студентов
  // студенты могут находиться в группах

  // красиво вывести состав групп на экран
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    File studentsFile = new File("res/studentslist.txt");
    BufferedReader fileReader = new BufferedReader(new FileReader(studentsFile));
    List<Student> students = new ArrayList<>();
    // прочитать количество групп
    int groups = 1;
    for (int groupId = 0; groupId < groups; ++groupId) {
      // для каждой группы:
      readGroup(br, students,studentsFile);
    }
    for (Student student : students) {
      System.out.printf("%s (%s) в группе %s%n", student.getName(), student.getEMail(),
          student.getGroup());
    }
  }

  // - прочитать название группы
  // - прочитать количество студентов
  // - прочитать информацию о студентах - "имя" или "имя,e-mail" для каждого в отдельной строке
  private static void readGroup(BufferedReader br, List<Student> students, File studentsFile) throws IOException {
    BufferedReader fileReader = new BufferedReader(new FileReader(studentsFile));

    //int studentsNumber = Integer.parseInt(br.readLine());
   for(String line = fileReader.readLine();line!=null; line= fileReader.readLine())
   {
     String groupName = line.substring(0,line.indexOf(":"));
      //String line = br.readLine();
      Student student = Student.parseStudent(groupName, line);
      students.add(student);
    }

  }
}
