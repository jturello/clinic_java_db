import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class PatientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void all_emptyAtFirst() {
    assertEquals(Patient.all().size(), 0);
  }

  @Test
  public void all_savesIntoDatabase_true() {
  Patient myPatient = new Patient("Jim", "02-04-1985", 3);
  myPatient.save();
  assertEquals(Patient.all().get(0).getName(), "Jim");
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
  Patient firstPatient = new Patient("Jim", "02-04-1985", 3);
  Patient secondPatient = new Patient("Jim", "02-04-1985", 3);
    assertTrue(firstPatient.equals(secondPatient));
  }

  @Test
  public void save_returnsTrueIfNamesAretheSame() {
  Patient myPatient = new Patient("Jim", "02-04-1985", 3);
  myPatient.save();
  assertTrue(Patient.all().get(0).equals(myPatient));
  }

  @Test
  public void save_assignsIdToObject() {
  Patient myPatient = new Patient("Jim", "02-04-1985", 3);
  myPatient.save();
  Patient savedPatient = Patient.all().get(0);
  assertEquals(myPatient.getId(), savedPatient.getId());
  }

  @Test
  public void find_findsPatientInDatabase_true() {
  Patient myPatient = new Patient("Jim", "02-04-1985", 3);
  myPatient.save();
  Patient savedPatient = Patient.find(myPatient.getId());
  assertTrue(myPatient.equals(savedPatient));
  }
  }
