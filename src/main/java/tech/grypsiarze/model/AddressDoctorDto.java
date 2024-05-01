package tech.grypsiarze.model;

import lombok.Data;

@Data
public class AddressDoctorDto {
  private AddressStructure addressData;
  private DoctorStructure doctorData;
}
