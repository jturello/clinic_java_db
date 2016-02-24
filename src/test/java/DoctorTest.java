import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class DoctorTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void all_emptyAtFirst() {
    assertEquals(Doctor.all().size(), 0);
  }

  @Test
  public void all_savesIntoDatabase_true() {
  Doctor myDoctor = new Doctor("John", 1);
  myDoctor.save();
  assertEquals(Doctor.all().get(0).getName(), "John");
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
  Doctor firstDoctor = new Doctor("John", 1);
  Doctor secondDoctor = new Doctor("John", 1);
    assertTrue(firstDoctor.equals(secondDoctor));
  }

  @Test
  public void save_returnsTrueIfNamesAretheSame() {
  Doctor myDoctor = new Doctor("John", 1);
  myDoctor.save();
  assertTrue(Doctor.all().get(0).equals(myDoctor));
  }

  @Test
  public void save_assignsIdToObject() {
  Doctor myDoctor = new Doctor("John", 1);
  myDoctor.save();
  Doctor savedDoctor = Doctor.all().get(0);
  assertEquals(myDoctor.getId(), savedDoctor.getId());
  }

  @Test
  public void find_findsDoctorInDatabase_true() {
  Doctor myDoctor = new Doctor("John", 1);
  myDoctor.save();
  Doctor savedDoctor = Doctor.find(myDoctor.getId());
  assertTrue(myDoctor.equals(savedDoctor));
  }
  }
