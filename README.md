
# BackendHospitalManagementSystem


🏥 Hospital Management System (Java - Console Based)

A console-based Java project using core OOP and switch-case logic to simulate basic hospital operations like managing doctors and patients. This is ideal for demonstrating Java programming skills in object-oriented design, user interaction, and simple database integration (optional).


---

📌 Features

👨‍⚕ Add & View Doctors

🧑‍🤝‍🧑 Add & View Patients

🗂 Search patient or doctor by name/id

🧾 View full hospital record summary

🖥 Menu-driven interface using switch-case



---

🧱 Project Structure

HospitalManagementSystem/
├── Main.java                     // Entry point with switch-case logic
├── Doctor.java                   // Doctor entity class
├── Patient.java                  // Patient entity class
├── HospitalManagementSystem.java// Service logic: stores/manages lists
└── README.md


---

🛠 Tech Stack

Component	Details

Language	Java (Core)
Interface	Console / CLI
Tools Used	IntelliJ / VS Code
Concepts	OOP, Classes, ArrayList, Switch-Case



---

▶ How to Run

1. Clone or Download

git clone https://github.com/kranthikiran07/BackendHospitalManagementSystem.git


2. Open in IntelliJ or VS Code


3. Run Main.java as your main class


4. You’ll see a menu like:



=== Hospital Management System ===
1. Add Doctor
2. View Doctors
3. Add Patient
4. View Patients
5. Exit

5. Enter your choice to interact with the system via switch-case.




---

💡 Sample Code Snippet (Main.java)

Scanner sc = new Scanner(System.in);
int choice;
do {
    System.out.println("1. Add Doctor\n2. View Doctors\n3. Add Patient\n4. View Patients\n5. Exit");
    choice = sc.nextInt();

    switch(choice) {
        case 1: hms.addDoctor(); break;
        case 2: hms.viewDoctors(); break;
        case 3: hms.addPatient(); break;
        case 4: hms.viewPatients(); break;
        case 5: System.out.println("Exiting..."); break;
        default: System.out.println("Invalid choice.");
    }
} while(choice != 5);


---

🧠 Learning Objectives

Understand Object-Oriented Design in Java

Practice user input, collections (ArrayList), and logic

Develop real-world use cases with class structures
