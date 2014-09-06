# EMS - Enterprise Monitoring System

## Java SNMP Toolkit for POJOs

### Overview
Simple Network Management Protocol (SNMP) is an "Internet-standard protocol for managing devices on IP networks". Devices that typically support SNMP include routers, switches, servers, workstations, printers, modem racks and more. SNMP is used mostly in network management systems to monitor network-attached devices for conditions that warrant administrative attention. [RFC 1157 - Internet Engineering Task Force](https://www.ietf.org/rfc/rfc1157.txt).
JavaBeans are reusable software components for Java. They are classes that encapsulate many objects into a single object (the bean). They are serializable, have a 0-argument constructor, and allow access to properties using getter and setter methods. [See JavaBean specification](http://www.oracle.com/technetwork/java/javase/documentation/spec-136004.html)

### Project scope
Scope of the project is allows seamless integration between JavaBean and SNMP. Indeed integration can be strightforward: think that SNMP is a very simple protocol mainly based upon two command GET and SET, just like JavaBean property accessors. What we need to achive is to fill JavaBean fields with remote SNMP value in a transparent way. The magic is done by AOP that activates pointcut only in certain circumstances. When the GET accessor of a JavaBean property is called by a proper Object then, throught AOP, an SNMP remote GET call is executed, when the remote value is retrieved and assigned to the field and finally the field value is returned to the caller. The same approach is used when the SET accessor is called.   

### Technologies
 * Maven
 * Java
 * Spring AOP
 * AspectJ

### Usage

