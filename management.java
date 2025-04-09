import java.io.*;
import java.util.*;

interface Selection {
    String select();
}

class DepartmentSelect implements Selection {
    Scanner sc = new Scanner(System.in);
    String[] departments = {"Cardiology", "Neurology", "Orthopedics", "Pediatrics", "General Medicine"};

    public String select() {
        while (true) {
            System.out.println("Available Departments:");
            for (int i = 0; i < departments.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + departments[i]);
            }

            int choice = getValidIntegerInput("Select Department: ");
            if (choice >= 1 && choice <= departments.length) {
                return departments[choice - 1];
            } else {
                System.out.println("Invalid choice selected! Please try again.");
            }
        }
    }

    private int getValidIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // clear input
            }
        }
    }
}

class DoctorSelect implements Selection {
    Scanner sc = new Scanner(System.in);
    String[] cardiology = {"Dr. Alan Smith", "Dr. Barbara Lee"};
    String[] neurology = {"Dr. Charles Brown", "Dr. Diane Moore"};
    String[] orthopedics = {"Dr. Edward Johnson", "Dr. Fiona Clark"};
    String[] pediatrics = {"Dr. George Hall", "Dr. Hannah Adams"};
    String[] general = {"Dr. Ian Baker", "Dr. Julia Davis"};

    public String selectDoctor(String department) {
        String[] doctors;
        switch (department) {
            case "Cardiology": doctors = cardiology; break;
            case "Neurology": doctors = neurology; break;
            case "Orthopedics": doctors = orthopedics; break;
            case "Pediatrics": doctors = pediatrics; break;
            case "General Medicine": doctors = general; break;
            default: doctors = new String[]{}; break;
        }

        while (true) {
            System.out.println("Available Doctors in " + department + ":");
            for (int i = 0; i < doctors.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + doctors[i]);
            }

            int choice = getValidIntegerInput("Select Doctor: ");
            if (choice >= 1 && choice <= doctors.length) {
                return doctors[choice - 1];
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }

    @Override
    public String select() {
        return null; // Not used here
    }

    private int getValidIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear input
            }
        }
    }
}

class TimeSelect implements Selection {
    Scanner sc = new Scanner(System.in);
    String[] times = {"9:00 AM", "10:00 AM", "11:00 AM", "1:00 PM", "2:00 PM"};
    List<String> bookedSlots = new ArrayList<>();

    public String select(String doctor, String department) {
        while (true) {
            System.out.println("Available Appointment Times:");
            for (int i = 0; i < times.length; i++) {
                System.out.println("\t" + (i + 1) + ". " + times[i]);
            }

            int choice = getValidIntegerInput("Select Appointment Time: ");
            if (choice >= 1 && choice <= times.length) {
                String selectedTime = times[choice - 1];
                String key = department + "-" + doctor + "-" + selectedTime;

                if (bookedSlots.contains(key)) {
                    System.out.println("Sorry, this slot is already booked! Try another.");
                } else {
                    bookedSlots.add(key);
                    return selectedTime;
                }
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }

    @Override
    public String select() {
        return null; // Not used
    }

    private int getValidIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }
        }
    }
}

class AppointmentDetails {
    Scanner sc = new Scanner(System.in);
    int patientAge;
    String patientName, department, doctor, time;

    public void getAppointmentDetails() {
        System.out.print("Enter Patient Name: ");
        patientName = sc.nextLine();

        while (true) {
            System.out.print("Enter Patient Age: ");
            try {
                patientAge = sc.nextInt();
                sc.nextLine(); // clear newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid age! Try again.");
                sc.nextLine(); // clear input
            }
        }
    }

    public void displayAppointmentDetails() {
        System.out.println("\n--- Appointment Details ---");
        System.out.println("Patient Name   : " + patientName);
        System.out.println("Patient Age    : " + patientAge);
        System.out.println("Department     : " + department);
        System.out.println("Doctor         : " + doctor);
        System.out.println("Appointment    : " + time);
        System.out.println("----------------------------\n");
    }

    public void saveToFile() {
        try (Writer writer = new FileWriter("appointments.txt", true)) {
            writer.write("Patient Name   : " + patientName + "\n");
            writer.write("Patient Age    : " + patientAge + "\n");
            writer.write("Department     : " + department + "\n");
            writer.write("Doctor         : " + doctor + "\n");
            writer.write("Appointment    : " + time + "\n");
            writer.write("--------------------------------------\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class management {
    public static void main(String[] args) {
        DepartmentSelect deptSelect = new DepartmentSelect();
        DoctorSelect doctorSelect = new DoctorSelect();
        TimeSelect timeSelect = new TimeSelect();
        AppointmentDetails appointment = new AppointmentDetails();

        appointment.department = deptSelect.select();
        appointment.doctor = doctorSelect.selectDoctor(appointment.department);
        appointment.time = timeSelect.select(appointment.doctor, appointment.department);
        appointment.getAppointmentDetails();
        appointment.displayAppointmentDetails();
        appointment.saveToFile();
    }
}
