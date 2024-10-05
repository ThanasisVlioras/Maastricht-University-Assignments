abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if (!(person instanceof Person)) return false;

        Person person = (Person)object;
        return person.name.equals(name) && person.age == age;
    }

    @Override 
    public String toString() {
        return name + "," + age;
    }
}

class Doctor extends Person {
    private String specialty;
    private double officeVisitFee;

    public Doctor(String name, int age, String specialty, double officeVisitFee) {
        super(name, age);
        this.specialty = specialty;
        this.officeVisitFee = officeVisitFee;
    }

    public String getSpecialty() {
        return specialty;
    }

    public double getOfficeVisitFee() {
        return officeVisitFee;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setOfficeVisitFee(double officeVisitFee) {
        this.officeVisitFee = officeVisitFee;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Doctor)) return false;

        Doctor doctor = (Doctor)object;
        return ((Person)doctor).equals(this) && doctor.specialty.equals(specialty) && doctor.officeVisitFee == officeVisitFee;
    }

    @Override 
    public String toString() {
        return getName() + "," + getAge() + "," + specialty + "," + officeVisitFee;
    }
}

class Patient extends Person {
    private String identificationNumber;

    public Patient(String name, int age, String identificationNumber) {
        super(name, age);
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public double setIdentificationNumber() {
        return identificationNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Patient)) return false;

        Patient patient = (Patient)object;
        return ((Person)patient).equals(this) && patient.identificationNumber.equals(identificationNumber);
    }

    @Override 
    public String toString() {
        return getName() + "," + getAge() + "," + identificationNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("John Doe", 25, "Surgeon", 999);
        System.out.println(doctor);
        System.out.println(doctor.equals(doctor));

        Patient patient = new Patient("John Doe", 25, "1234");
        System.out.println(patient);
        System.out.println(patient.equals(patient));
    }
}