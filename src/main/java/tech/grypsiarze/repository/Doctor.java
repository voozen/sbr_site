package tech.grypsiarze.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.grypsiarze.implementations.DoctorImp;
import tech.grypsiarze.model.AddressStructure;
import tech.grypsiarze.model.DoctorStructure;
@Repository
public class Doctor implements DoctorImp {
  @Autowired EntityManager entityManager;

  @Override
  public List<DoctorStructure> findDoctors(String category, String city) {
    return entityManager
        .createQuery("SELECT d FROM DoctorStructure d WHERE d.city LIKE :cit " +
                     "AND d.category LIKE :cat")
        .setParameter("cit", city)
        .setParameter("cat", category)
        .getResultList();
  }

  @Override
  @Transactional
  public String saveDoctor(AddressStructure theAddress,
                           DoctorStructure theDoctor) {
    List<AddressStructure> addressQuery =
        entityManager
            .createQuery("SELECT a FROM AddressStructure a WHERE a.street = " +
                         ":street AND a.city = :city AND a.postal_code = " +
                         ":postal_code AND a.country = :country")
            .setParameter("street", theAddress.getStreet())
            .setParameter("city", theAddress.getCity())
            .setParameter("postal_code", theAddress.getPostal_code())
            .setParameter("country", theAddress.getCountry())
            .getResultList();
    System.out.println(addressQuery);
    if (addressQuery.isEmpty()) {
      entityManager.persist(theAddress);
      theDoctor.setAddressID(theAddress.getAddressID());
      theDoctor.setCity(theAddress.getCity());
      entityManager.persist(theDoctor);
    } else {
      AddressStructure firstAddress = addressQuery.get(0);
      int myAddressID = firstAddress.getAddressID();
      String myAddressCity = firstAddress.getCity();
      theDoctor.setAddressID(myAddressID);
      theDoctor.setCity(myAddressCity);
      entityManager.persist(theDoctor);
    }
    return "Saved Doctor";
  }
}
