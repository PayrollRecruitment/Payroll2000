package TestConsoleApp;


import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class Employee {
    public int id;
    public String firstName;
    public String lastName;
    public String jobType;
    public String email;
    public Gender gender;
    public double hourlyRate;
    public EmploymentType employmentType;
    private Logger logger;
    public double salary;

    public void calculateSalary(LocalDateTime aFrom, LocalDateTime aUntil) {
        logger = new ConsoleLogger();
        long daysBetween = Duration.between(aFrom, aUntil).toDays();
        int workingDays = 0;

        //calculate how many working days in given period
        for (int i = 0; i < daysBetween; i++) {
            if(aFrom.plusDays(i).getDayOfWeek() != DayOfWeek.SATURDAY && aFrom.plusDays(i).getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingDays++;
            }
        }

        switch (employmentType) {
            case FullTime:
                this.salary += this.hourlyRate * 8 * workingDays;
                break;
            case HalfTime:
                this.salary += this.hourlyRate * 8 * workingDays / 2;
                break;
            default:
                logger.changeOutputColour(Colour.Red);
                logger.log(employmentType.toString() + " is not supported");
                logger.changeOutputColour(Colour.Reset);
                break;
        }
        logger.log(firstName + " " + lastName + " [" + jobType + "] Salary: " + salary);
    }

    public Employee(int aId, String aFirstName, String aLastName, String aJobType, String aEmail, Gender aGender,
                    double aHourlyRate, EmploymentType aEmploymentType, double aSalary) {
        id = aId;
        firstName = aFirstName;
        lastName = aLastName;
        jobType = aJobType;
        email = aEmail;
        gender = aGender;
        hourlyRate = aHourlyRate;
        employmentType = aEmploymentType;
        salary = aSalary;
    }
}

