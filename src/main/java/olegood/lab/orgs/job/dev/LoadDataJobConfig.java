package olegood.lab.orgs.job.dev;

import java.net.MalformedURLException;
import lombok.extern.slf4j.Slf4j;
import olegood.lab.orgs.entity.organization.Organization;
import olegood.lab.orgs.entity.organization.OrganizationRepository;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileUrlResource;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class LoadDataJobConfig {

  @Bean
  public Job loadDataJob(JobRepository jobRepository, Step loadOrganizations) {
    return new JobBuilder(jobRepository).start(loadOrganizations).build();
  }

  @Bean
  public Step loadOrganizations(
      JobRepository jobRepository,
      PlatformTransactionManager txManager,
      FlatFileItemReader<Organization> organizationDataItemReader,
      ItemWriter<Organization> organizationDataItemWriter) {
    return new StepBuilder(jobRepository)
        .<Organization, Organization>chunk(400)
        .transactionManager(txManager)
        .reader(organizationDataItemReader)
        .writer(organizationDataItemWriter)
        .build();
  }

  @Bean
  public FlatFileItemReader<Organization> organizationDataItemReader()
      throws MalformedURLException {
    return new FlatFileItemReaderBuilder<Organization>()
        .name("organizationDataItemReader")
        .resource(new FileUrlResource("./.testdata/organizations-2000000.csv"))
        .delimited()
        .names(
            "Index",
            "Organization Id",
            "Name",
            "Website",
            "Country",
            "Description",
            "Founded",
            "Industry",
            "Number of employees")
        .fieldSetMapper(new OrganizationFieldSetMapper())
        .linesToSkip(1)
        .build();
  }

  @Bean
  public ItemWriter<Organization> organizationDataItemWriter(OrganizationRepository repository) {
    return repository::saveAll;
  }
}
