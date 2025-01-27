package org.examples.smart_city_traffic.infrastructure;

import org.cloudbus.cloudsim.core.Simulation;
import org.cloudbus.cloudsim.power.models.PowerModelHostSimple;
import org.leaf.host.HostFactory;
import org.leaf.infrastructure.ComputeNode;
import org.leaf.location.Location;

import java.util.List;

import static org.examples.smart_city_traffic.Settings.*;

/**
 * A fog data center.
 */
public class DatacenterFog extends ComputeNode {

    private Location location;

    public DatacenterFog(Simulation simulation, Location location, int shutdownDeadline) {
        super(simulation, FOG_MIPS, new PowerModelHostSimple(FOG_MAX_POWER, FOG_STATIC_POWER), shutdownDeadline);
        this.location = location;
    }

    @Override
    public Location getLocation() {
        if (location == Location.NULL) {
            throw new RuntimeException("No location has been set for " + this);
        }
        return location;
    }
}
