package midtermExam.p1;

import java.util.Objects;

/**
 * A concrete class representing contact information.
 */
public class ContactInfo {
  private Name name;
  private String address;
  private String phoneNumber;
  private String emailAddress;

  public ContactInfo(Name name, String address, String phoneNumber, String emailAddress) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public Name getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ContactInfo)) {
      return false;
    }
    ContactInfo that = (ContactInfo) o;
    return Objects.equals(name, that.name) && Objects
        .equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber)
        && Objects.equals(emailAddress, that.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, phoneNumber, emailAddress);
  }

  @Override
  public String toString() {
    return "ContactInfo{" +
        "name=" + name +
        ", address='" + address + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}
