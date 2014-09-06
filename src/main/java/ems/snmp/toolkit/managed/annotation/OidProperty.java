package ems.snmp.toolkit.managed.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface OidProperty {
    /**
     * OID representation
     *
     * @return OID
     */
    String oid() default "";

    /**
     * Absolute OID name starting from iso.dod...
     *
     * @return OID name
     */
    String oidName() default "";

    /**
     * Referred field name
     *
     * @return field name
     */
    String fieldName() default "";
}
