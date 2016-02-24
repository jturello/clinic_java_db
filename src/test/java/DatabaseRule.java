import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/clinic_test", null, null);
   }

   protected void after() {
       try(Connection con = DB.sql2o.open()) {
         String deleteDoctorsQuery = "DELETE FROM doctors *;";
         String deletePatientsQuery = "DELETE FROM patients *;";
         con.createQuery(deleteDoctorsQuery).executeUpdate();
         con.createQuery(deletePatientsQuery).executeUpdate();
       }
   }
}
