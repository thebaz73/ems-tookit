package ems.snmp.toolkit.monitor.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 */
@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface Monitor {
}
