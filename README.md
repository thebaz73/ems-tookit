# EMS - Enterprise Monitoring System

## Java SNMP Toolkit for POJOs

### Overview
Simple Network Management Protocol (SNMP) is an "Internet-standard protocol for managing devices on IP networks". Devices that typically support SNMP include routers, switches, servers, workstations, printers, modem racks and more. SNMP is used mostly in network management systems to monitor network-attached devices for conditions that warrant administrative attention. [RFC 1157 - Internet Engineering Task Force](https://www.ietf.org/rfc/rfc1157.txt).

JavaBeans are reusable software components for Java. They are classes that encapsulate many objects into a single object (the bean). They are serializable, have a 0-argument constructor, and allow access to properties using getter and setter methods. [See JavaBean specification](http://www.oracle.com/technetwork/java/javase/documentation/spec-136004.html).

### Project scope
Scope of the project is allows seamless integration between JavaBean and SNMP. Indeed integration can be strightforward: think that SNMP is a very simple protocol mainly based upon two command GET and SET, just like JavaBean property accessors. What we need to achive is to fill JavaBean fields with remote SNMP value in a transparent way. The magic is done by AOP that activates [pointcuts](http://eclipse.org/aspectj/doc/released/progguide/language-joinPoints.html) only in certain circumstances. 

When the GET accessor of a JavaBean property is called by a proper Object then, throught AOP, an SNMP remote GET call is executed, when the remote value is retrieved and assigned to the field and finally the field value is returned to the caller. The same approach is used when the SET accessor is called.

See it in action in samples contained in test folder. Here follows some code samples to allow better explaination.

``` Java
@Monitor
public class MonitorSample implements SnmpConfiguration {
    public void printValues(IfMib ifMib) {
        LoggingResponseHandler responseHandler = new LoggingResponseHandler(ifMib);
        ifMib.addResponseHandler(responseHandler);
        System.out.println("ifNumber = " + ifMib.getIfNumber());
        System.out.println("ifType column = " + Arrays.toString(ifMib.getIfType()));
        System.out.println("ifIndex column = " + Arrays.toString(ifMib.getIfIndex()));
        System.out.println("ifDescr column = " + Arrays.toString(ifMib.getIfDescr()));
        System.out.println("ifTable = " + Arrays.toString(ifMib.getIfTable()));
        System.out.println("ifXTable = " + Arrays.toString(ifMib.getIfXTable()));
        System.out.println("ifStackTable = " + Arrays.toString(ifMib.getIfStackTable()));
        ifMib.removeResponseHandler(responseHandler);
    }
}
```
The Object is a simple POJO. Two 'special' thing define the ojbect:
 * The **@Monitor** annotation which is a simple mark-up annotation defined into the toolkit.
 * The SnmpConfiguration interface which is a [mixin](http://en.wikipedia.org/wiki/Mixin) and adds to the **MonitorSamle** object some utility methods the retrieve SNMP and device configuration parameters (for example ip address or SNMP read community).

All the work is executed into the **printValues** method. When the following code is executed the magic begins:

``` Java
  System.out.println("ifNumber = " + ifMib.getIfNumber());
```
First an SNMP GET command is executed and the interface number of the router is read remotely, then is assigned to the **ifNumber** field of the ojbect **IfMib** and, in the end, passed to the System.out output stream and printed to console. Please note that also SNMP multiple values (SNMP OID tables) are correctly handled by JavaBean multiple values properties for example:

``` Java
        System.out.println("ifType column = " + Arrays.toString(ifMib.getIfType()));
```
or reading table by column:
``` Java
        System.out.println("ifTable = " + Arrays.toString(ifMib.getIfTable()));
```

To understand why let's have a look at **IfMib** JavaBean:

``` Java
/**
 * Created by EMS Mib Compiler.
 * Do not edit
 */
@SuppressWarnings("UnusedDeclaration")
@ManagedObject
public class IfMib implements ConfigurationAware, SnmpEnquirer {

    /*
    * Property accessors for: ifNumber
    * Node type: SNMPv2-SMI: Integer32
    * Node base type: JSMIPARSER_HARDCODED_MIB: INTEGER
    * OID: 1.3.6.1.2.1.2.1
    * Access: read-only
    * Description: The number of network interfaces (regardless of their
            current state) present on this system.
    */

    private Integer ifNumber;

    @OidProperty(oid = "1.3.6.1.2.1.2.1.0", oidName = "ifNumber", fieldName = "ifNumber")
    public Integer getIfNumber() {
        return ifNumber;
    }

    private void setIfNumber(Integer ifNumber) {
        this.ifNumber = ifNumber;
    }
...
}
```

Again let's describe the **IfMib** object. First of all it is marked by the **@ManagedObject** annotation and implements **ConfigurationAware** and **SnmpEnquirer** interfaces.
 * **@ManagedObject** is a simple mark-up annotation defined into the toolkit.
 * **ConfigurationAware** and **SnmpEnquirer** are [mixin](http://en.wikipedia.org/wiki/Mixin)s to which and AOP Aspect add all SNMP functionalities.
 * **@OidProperty** annotation that mark **public Integer getIfNumber()** method identifies the AOP [pointcut](http://eclipse.org/aspectj/doc/released/progguide/language-joinPoints.html).
 * Method **private void setIfNumber(Integer ifNumber)** can be accessed only by the "SNMP capable" Aspect because is private. Moreover it is private and it is not annotated because the ifNumber SNMP OId is read-only.

### Technologies
 * Maven
 * Java
 * Spring AOP
 * AspectJ

### Usage
Clone project and compile. Check out for samples in test folder. For a full satisfying experience check out also following projects:
 * SMI Parser: https://github.com/thebaz73/smiparser
 * EMS MIB Compiler: https://github.com/thebaz73/ems-compiler
