package io.openems.edge.ess.mr.gridcon;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import io.openems.edge.ess.mr.gridcon.enums.InverterCount;

@ObjectClassDefinition( //
		name = "MR Gridcon PCS", //
		description = "Implements the MR Gridcon PCS system")
public
@interface Config {
	String id() default "gridcon0";

	@AttributeDefinition(name = "Alias", description = "Human-readable name of this Component; defaults to Component-ID")
	String alias() default "";

	@AttributeDefinition(name = "Is enabled?", description = "Is this Component enabled?")
	boolean enabled() default true;
	
	@AttributeDefinition(name = "Invertercount?", description = "number of inverters")
	InverterCount inverterCount() default InverterCount.ONE ;

	@AttributeDefinition(name = "Modbus-ID", description = "ID of Modbus brige.")
	String modbus_id() default "modbus0";
	
	@AttributeDefinition(name = "Modbus-Unit-ID", description = "Unit ID of Modbus brige.")
	int unit_id() default 0;
	
	@AttributeDefinition(name = "Efficieny Factor Discharge", description = "Allowed Power at inverter is decreased with this factor")
	double efficiencyLossDischargeFactor() default GridconPCSImpl.EFFICIENCY_LOSS_DISCHARGE_FACTOR;
	
	@AttributeDefinition(name = "Efficieny Factor Charge", description = "Allowed Power at inverter is increased with this factor")
	double efficiencyLossChargeFactor() default GridconPCSImpl.EFFICIENCY_LOSS_CHARGE_FACTOR;
	
	@AttributeDefinition(name = "Modbus target filter", description = "This is auto-generated by 'Modbus-ID'.")
	String Modbus_target() default "";
	
	String webconsole_configurationFactory_nameHint() default "MR Gridcon PCS [{id}]";
}
