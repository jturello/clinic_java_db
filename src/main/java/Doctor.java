import java.util.List;
import org.sql2o.*;

public class Doctor {
  private int id;
  private String name;
  private int specialtyId;

  public Doctor(String name, int specialtyId) {
    this.name = name;
    this.specialtyId = specialtyId;
  }

  @Override
  public boolean equals(Object otherDoctor){
    if (!(otherDoctor instanceof Doctor)) {
      return false;
    } else {
      Doctor newDoctor = (Doctor) otherDoctor;
      System.out.println(this.getSpecialtyId());
      System.out.println(newDoctor.getSpecialtyId());
      return this.getName().equals(newDoctor.getName()) &&
             this.getId() == newDoctor.getId() &&
             this.getSpecialtyId() == newDoctor.getSpecialtyId();
    }
  }

  public void save() {
     try(Connection con = DB.sql2o.open()) {
       String sql = "INSERT INTO Doctors(name, specialtyId) VALUES (:name, :specialtyId)";
       this.id = (int) con.createQuery(sql, true)
         .addParameter("name", name)
         .addParameter("specialtyId", specialtyId)
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

  public int getSpecialtyId() {
   return specialtyId;
 }

  public static List<Doctor> all() {
    String sql = "SELECT id, name, specialtyId FROM doctors";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Doctor.class);
    }
  }

  public static Doctor find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM doctors where id=:id";
    Doctor doctor = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Doctor.class);
    return doctor;
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
