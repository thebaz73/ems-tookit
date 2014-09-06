package ems.snmp.toolkit.managed.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
public @interface ManagedObject {
    /**
     * MIB identity oid number
     *
     * @return identity oid number
     */
    int identity() default 0;

    /**
     * MIB name
     *
     * @return name
     */
    String mibName() default "";
}
