package olegood.lab.orgs.job.dev;

import java.util.concurrent.ThreadLocalRandom;
import olegood.lab.orgs.entity.organization.Organization;
import olegood.lab.orgs.entity.organization.OrganizationStatus;
import org.springframework.batch.infrastructure.item.file.mapping.FieldSetMapper;
import org.springframework.batch.infrastructure.item.file.transform.FieldSet;

public class OrganizationFieldSetMapper implements FieldSetMapper<Organization> {

  @Override
  public Organization mapFieldSet(FieldSet fieldSet) {
    return new Organization()
        .setId(fieldSet.readLong("Index"))
        .setCode(fieldSet.readString("Organization Id"))
        .setName(fieldSet.readString("Name"))
        .setWebsite(fieldSet.readString("Website"))
        .setCountry(fieldSet.readString("Country"))
        .setDescription(fieldSet.readString("Description"))
        .setFounded(fieldSet.readInt("Founded"))
        .setIndustry(fieldSet.readString("Industry"))
        .setNumberOfEmployees(fieldSet.readInt("Number of employees"))
        .setStatus(getRandomStatus());
  }

  private OrganizationStatus getRandomStatus() {
    OrganizationStatus[] statuses = OrganizationStatus.values();
    int randomIndex = ThreadLocalRandom.current().nextInt(statuses.length);
    return statuses[randomIndex];
  }
}
