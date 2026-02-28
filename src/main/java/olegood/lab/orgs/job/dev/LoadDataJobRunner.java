package olegood.lab.orgs.job.dev;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import olegood.lab.orgs.entity.organization.OrganizationRepository;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.JobExecutionException;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@RequiredArgsConstructor
@Component
public class LoadDataJobRunner {

  private final OrganizationRepository organizationRepository;

  private final JobOperator jobOperator;
  private final Job loadDataJob;

  @PostConstruct
  void postConstruct() throws JobExecutionException {
    if (organizationRepository.count() > 0) {
      return;
    }
    var params =
        new JobParametersBuilder().addLong("run.id", System.currentTimeMillis()).toJobParameters();
    jobOperator.start(loadDataJob, params);
  }
}
