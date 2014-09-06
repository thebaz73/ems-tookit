package ems.snmp.toolkit.managed.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 * Date: 2/19/12
 * Time: 2:27 PM
 */
@Target(value = {ElementType.TYPE, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface OidBind {
    String oid();
}
