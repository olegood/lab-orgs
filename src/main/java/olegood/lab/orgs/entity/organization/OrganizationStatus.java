package olegood.lab.orgs.entity.organization;

public enum OrganizationStatus {

  /**
   * The organization is known but not yet formally engaged. Data may be incomplete, and no
   * contractual or operational relationship exists yet.
   */
  PROSPECTIVE,

  /**
   * Used when onboarding, compliance checks, or audits are in progress. Activation requires
   * explicit approval steps.
   */
  UNDER_REVIEW,

  /**
   * The organization is fully operational and engaged. It can participate in projects and interact
   * with all relevant domain processes.
   */
  ACTIVE,

  /**
   * The organization exists but is temporarily restricted. This might be due to compliance issues,
   * payment problems, regulatory holds, or internal review. Reactivation is expected.
   */
  SUSPENDED,

  /**
   * The organization is no longer operating within the system but may still exist legally. No new
   * engagements are allowed, though historical data remains relevant.
   */
  INACTIVE,

  /**
   * The relationship has been formally ended. This status implies contractual closure and prevents
   * any future activity. The status is irreversible.
   */
  TERMINATED,

  /**
   * A purely technical status indicating the organization is retained only for historical or
   * reporting purposes.
   */
  ARCHIVED
}
