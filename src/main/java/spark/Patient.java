import java.util.List;
import org.sql2o.*;

public class Patient {
  private int id;
  private String name;
  private String birthday;
  private int doctorId;

  public Patient(String name, String birthday, int doctorId) {
    this.name = name;
    this.birthday = birthday;
    this.doctorId = doctorId;
  }

  @Override
  public boolean equals(Object otherPatient){
    if (!(otherPatient instanceof Patient)) {
      return false;
    } else {
      Patient newPatient = (Patient) otherPatient;
      System.out.println(this.getDoctorId());
      System.out.println(newPatient.getDoctorId());
      return this.getName().equals(newPatient.getName()) &&
             this.getId() == newPatient.getId() &&
             this.getBirthday().equals(newPatient.getBirthday()) &&
             this.getDoctorId() == newPatient.getDoctorId();
    }
  }

  public void save() {
     try(Connection con = DB.sql2o.open()) {
       String sql = "INSERT INTO Patients(name, birthday, doctorId) VALUES (:name, :birthday, :doctorId)";
       this.id = (int) con.createQuery(sql, true)
         .addParameter("name", name)
         .addParameter("birthday", birthday)
         .addParameter("doctorId", doctorId)
         .executeUpdate()
         .getKey();
     }
   }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getBirthday() {
    return birthday;
  }

  public int getDoctorId() {
   return doctorId;
 }

  public static List<Patient> all() {
    String sql = "SELECT id, name, birthday, doctorId FROM patients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Patient.class);
    }
  }

  public static Patient find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM patients where id=:id";
    Patient patient = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Patient.class);
    return patient;
  }
 }
 // public void update(String name) {
 //     try(Connection con = DB.sql2o.open()) {
 //       String sql = "UPDATE doctors SET name = :name WHERE id = :id";
 //       con.createQuery(sql)
 //         .addParameter("name", name)
 //         .addParameter("id", id)
 //         .executeUpdate();
 //     }
 //   }
 //
 //   public void delete() {
 //    try(Connection con = DB.sql2o.open()) {
 //    String sql = "DELETE FROM doctors WHERE id = :id;";
 //      con.createQuery(sql)
 //        .addParameter("id", id)
 //        .executeUpdate();
 //    }
  // }

}
