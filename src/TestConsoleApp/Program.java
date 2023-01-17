package TestConsoleApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/*
*  TODO: Implement new Employment type: "Intern"
*  TODO: Import new employee file: employees2.csv
*  TODO: Intern employee is payed fixed rate 1000$
*  TODO: Implement logging errors to file "c:\log.txt"
*  TODO: Implement exporting payroll .txt file to folder "c:\payrolls\"
* */
public class Program {
    public static void main(String[] args) {

        Logger logger1 = new ConsoleLogger();
        List<Employee> list = new ArrayList<>();
        List<String> readText = getTextFromFile("employees.csv");
        readText.forEach(row -> {
            String[] splittedRow = row.split(";");
            list.add(new Employee(Integer.valueOf(splittedRow[0]), splittedRow[1], splittedRow[2], splittedRow[4],
                    splittedRow[6], Gender.valueOf(splittedRow[7]), Double.valueOf(splittedRow[8]),
                    EmploymentType.valueOf(splittedRow[9]), Double.valueOf(splittedRow[8])));
        });
        logger.log("## Payroll:");
        list.forEach(aEmployee -> {
            aEmployee.calculateSalary(new GregorianCalendar(2021, 10, 11).getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        });
    }

    private static List<String> getTextFromFile(String aFileName) {
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(aFileName))) {
            StringBuilder sb = new StringBuilder();
            br.readLine(); // skip 1st line
            String line = br.readLine();

            while (line != null && line.length() != 0) {
                list.add(line);
                line = br.readLine();
            }

        } catch (IOException aE) {
            System.out.println(aE.getMessage());
            throw new RuntimeException(aE);
        }
        return list;
    }
}
