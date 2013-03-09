package org.helgoboss.dominoe.service_providing

import org.osgi.framework.BundleContext
import org.helgoboss.module_support.ModuleContext
import org.helgoboss.dominoe.OsgiContext

/**
 * Created with IntelliJ IDEA.
 * User: bkl
 * Date: 09.03.13
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
trait ServiceProvider {
  protected def bundleContext: BundleContext
  protected def moduleContext: ModuleContext

  implicit def serviceToProvidableService(service: AnyRef) = new ProvidableService(service, moduleContext, bundleContext)
}

class SimpleServiceProvider(
    protected val moduleContext: ModuleContext,
    protected val bundleContext: BundleContext) extends ServiceProvider {

  def this(osgiContext: OsgiContext) = this(osgiContext, osgiContext.bundleContext)
}