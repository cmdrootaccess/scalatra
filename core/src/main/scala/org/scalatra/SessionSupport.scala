package org.scalatra

/**
 * This trait provides abstract session support for stateful applications.
 * The session may be clientside or serverside.
 */
trait SessionSupport {
  /**
   * The type of session supported by this handler.  Must be viewable as
   * a [[org.scalatra.Request]].
   */
  type SessionT

  /**
   * A view of SessionT as a [[org.scalatra.Session]].  This allows
   * backward compatibility with Scalatra applications written directly
   * against the Servlet API.
   */
  protected implicit def sessionWrapper(session: SessionT): Session

  /**
   * The current session.  Creates a session if none exists.
   */
  implicit def session: SessionT

  /**
   * The current session.  If none exists, None is returned.
   */
  def sessionOption: Option[SessionT]
}
