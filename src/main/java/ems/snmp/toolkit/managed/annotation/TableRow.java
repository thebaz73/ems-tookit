package ems.snmp.toolkit.managed.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface TableRow {
}
