package ems.snmp.toolkit.configuration;

import ems.snmp.toolkit.monitor.mixin.SnmpConfiguration;

import java.util.WeakHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: thebaz
 * Date: 2/18/12
 * Time: 6:34 PM
 */
public class ConfigSpaceRepository {
    private static ConfigSpaceRepository instance;
    private WeakHashMap<String, SnmpConfiguration> configurationMap = new WeakHashMap<String, SnmpConfiguration>();

    public ConfigSpaceRepository() {
    }

    public static ConfigSpaceRepository getInstance() {
        if(instance == null) {
            instance = new ConfigSpaceRepository();
        }
        return instance;
    }
    
    public void addConfiguration(SnmpConfiguration configuration) {
        configurationMap.put(configuration.getSessionUid(), configuration);
    }

    public SnmpConfiguration getConfiguration(String sessionUid) {
        return configurationMap.get(sessionUid);
    }
}
