package org.jenkinsci.plugins.workflow.cps;

import org.jenkinsci.plugins.workflow.steps.Step;
import org.jenkinsci.plugins.workflow.steps.StepContext;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Indicates that the method is only meant to be called by
 * a thread that runs {@link CpsThreadGroup#runner}
 *
 * <p>
 * There are two patterns of this.
 *
 * <ul>
 *     <li>Method on {@link CpsThreadGroup} that mutates its internal state. Marked as "root"
 *     <li>Methods elsewhere that calls methods that have {@link CpsVmThreadOnly}.
 * </ul>
 *
 * @author Kohsuke Kawaguchi
 * @see CpsVmThread
 * @see CpsThreadGroup#assertVmThread()
 */
@Target({METHOD, CONSTRUCTOR})
public @interface CpsVmThreadOnly {
    String value() default "";
}
