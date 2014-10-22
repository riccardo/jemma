/**
 * This file is part of JEMMA - http://jemma.energy-home.org
 * (C) Copyright 2013 Telecom Italia (http://www.telecomitalia.it)
 *
 * JEMMA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License (LGPL) version 3
 * or later as published by the Free Software Foundation, which accompanies
 * this distribution and is available at http://www.gnu.org/licenses/lgpl.html
 *
 * JEMMA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License (LGPL) for more details.
 *
 */
package org.energy_home.jemma.ah.zigbee.appliances;

import java.util.Dictionary;

import org.energy_home.jemma.ah.hac.ApplianceException;
import org.energy_home.jemma.ah.hac.IEndPointTypes;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.general.ZclBasicServer;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.general.ZclIdentifyServer;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.general.ZclPowerConfigurationServer;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.measurement.ZclRelativeHumidityMeasurementServer;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.measurement.ZclTemperatureMeasurementServer;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclAppliance;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclEndPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZclTemperatureHumidityAppliance extends ZclAppliance {
	private ZclEndPoint endPoint = null;

	private static final Logger LOG = LoggerFactory.getLogger( ZclTemperatureHumidityAppliance.class );

	public static final String ENDPOINT_TYPE = IEndPointTypes.ZIGBEE_TEMPERATURE_SENSOR; //"Sensor Temperature & Humidity";//

	public ZclTemperatureHumidityAppliance(String pid, Dictionary config) throws ApplianceException {
		super(pid, config);
		endPoint = this.zclAddEndPoint(IEndPointTypes.ZIGBEE_TEMPERATURE_SENSOR);

		// Server Clusters
		endPoint.addServiceCluster(new ZclBasicServer());
		endPoint.addServiceCluster(new ZclIdentifyServer());
		endPoint.addServiceCluster(new ZclPowerConfigurationServer());
		endPoint.addServiceCluster(new ZclTemperatureMeasurementServer());
		endPoint.addServiceCluster(new ZclRelativeHumidityMeasurementServer());
	}

	protected void attached() {
		LOG.debug("ZclTemperatureHumidityAppliance attached");
	}

	protected void detached() {
		LOG.debug("ZclTemperatureHumidityAppliance detached");
	}
}
