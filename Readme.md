# 🏥 Hospital Management System in Java

This is a **console-based Java application** developed as part of the Object Oriented Programming through Java course (23CS3305). The system simulates a **hospital appointment management process**, allowing users to select departments, doctors, time slots, enter patient details, and save them persistently to a file.

---

## 🎯 Features

- ✅ Select department (e.g., Cardiology, Neurology, Pediatrics)
- ✅ Select doctor based on chosen department
- ✅ Choose appointment time from available slots
- ✅ Enter and validate patient details
- ✅ Prevent double-booking of time slots
- ✅ Save appointment details to a file (`appointments.txt`)
- ✅ View confirmation summary after booking

---

## 📁 Project Structure

```
HospitalManagementSystem/
├── HospitalManagement.java
├── appointments.txt         ← stores all patient appointment records
├── README.md                ← this file
```

---

## 🚀 How to Compile and Run

### 🧑‍💻 Requirements:
- JDK installed (Java 8 or above)
- Command line terminal (or IDE like VS Code / IntelliJ)

### 🛠️ Steps:

1. Open terminal or command prompt.
2. Navigate to the folder where `HospitalManagement.java` is saved.
3. Compile the program:
   ```bash
   javac HospitalManagement.java
   ```
4. Run the program:
   ```bash
   java HospitalManagement
   ```

---

## 💡 Technologies Used

- **Java** (Core)
- **OOP Principles** – Inheritance, Interfaces, Encapsulation
- **Exception Handling**
- **File Handling** – `FileWriter`, `Scanner`
- **User Input** – via `Scanner`

---

## 🧪 Sample Output

```
Available Departments:
    1. Cardiology
    2. Neurology
    3. Orthopedics
    ...

Select Doctor:
    1. Dr. Alan Smith
    2. Dr. Barbara Lee
    ...

Available Appointment Times:
    1. 9:00 AM
    2. 10:00 AM
    ...

Enter Patient Name: Mahesh
Enter Patient Age: 20

--- Appointment Details ---
Patient Name   : Mahesh
Patient Age    : 20
Department     : Neurology
Doctor         : Dr. Charles Brown
Appointment    : 10:00 AM
---------------------------
```

---

## 🧾 File Output (appointments.txt)

```
Patient Name   : Mahesh
Patient Age    : 20
Department     : Neurology
Doctor         : Dr. Charles Brown
Appointment    : 10:00 AM
--------------------------------------
```

---

## 📚 Academic Info

- **Course**: 23CS3305 – Object Oriented Programming through Java  
- **Assignment**: Home Assignment  
- **Title**: Hospital Management System  
- **Submitted by**:  
  - 238W1A05H7  
  - 238W1A05H0  
  - 238W1A05D7  
- **Institution**: Siddhartha Academy of Higher Education  
- **Department**: Computer Science and Engineering (B.Tech – III Sem)

---

## 🙌 Acknowledgements

Thanks to faculty and mentors who guided us in understanding Java and OOP principles.

---

## ✍️ Author

**Mahesh**  
GitHub: [your-github-username]  
Vice President, Creatix Club | Student Coordinator, NSS  
Siddhartha Academy of Higher Education, CSE

---

## 📌 Note

This project is purely academic and console-based. For real-world implementation, database integration, GUI design (like JavaFX or Swing), and backend validation would be necessary.
