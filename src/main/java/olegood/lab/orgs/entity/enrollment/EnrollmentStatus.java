package olegood.lab.orgs.entity.enrollment;

/**
 * Enum representing the various statuses associated with an {@link Enrollment}.
 */
public enum EnrollmentStatus {

  /**
   * Represents the initial phase where the enrollment is being set up.
   * During this stage, the enrollment is undergoing configuration and preparation
   * before becoming fully operational.
   */
  ONBOARDING,

  /**
   * Indicates that the enrollment is currently active and operational.
   * Enrollments in this state are fully functional and participating in the system.
   */
  ACTIVE,

  /**
   * Denotes that the enrollment is in the process of being terminated.
   * This is a transitional state where shutdown procedures are being executed
   * before the enrollment reaches its final retired state.
   */
  IN_TERMINATION,

  /**
   * Marks the completion stage where the enrollment is no longer active.
   * Enrollments in this state have completed their lifecycle and are no longer
   * operational in the system.
   */
  RETIRED
}
