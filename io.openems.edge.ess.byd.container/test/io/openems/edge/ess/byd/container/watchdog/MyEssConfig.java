package io.openems.edge.ess.byd.container.watchdog;

import io.openems.common.utils.ConfigUtils;
import io.openems.edge.common.test.AbstractComponentConfig;
import io.openems.edge.ess.byd.container.Config;

@SuppressWarnings("all")
public class MyEssConfig extends AbstractComponentConfig implements Config {

	protected static class Builder {
		private String id;
		private boolean readonly;
		private String modbusId0;
		private String modbusId1;
		private String modbusId2;

		private Builder() {
		}

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setModbusId0(String modbusId0) {
			this.modbusId0 = modbusId0;
			return this;
		}

		public Builder setModbusId1(String modbusId1) {
			this.modbusId1 = modbusId1;
			return this;
		}

		public Builder setModbusId2(String modbusId2) {
			this.modbusId2 = modbusId2;
			return this;
		}

		public Builder setReadonly(boolean readonly) {
			this.readonly = readonly;
			return this;
		}

		public MyEssConfig build() {
			return new MyEssConfig(this);
		}
	}

	/**
	 * Create a Config builder.
	 * 
	 * @return a {@link Builder}
	 */
	public static Builder create() {
		return new Builder();
	}

	private final Builder builder;

	private MyEssConfig(Builder builder) {
		super(Config.class, builder.id);
		this.builder = builder;
	}

	@Override
	public boolean readonly() {
		return this.builder.readonly;
	}

	@Override
	public String modbus_id0() {
		return this.builder.modbusId0;
	}

	@Override
	public String modbus_id1() {
		return this.builder.modbusId1;
	}

	@Override
	public String modbus_id2() {
		return this.builder.modbusId2;
	}

	@Override
	public String Modbus_target() {
		return ConfigUtils.generateReferenceTargetFilter(this.id(), this.modbus_id0());
	}

	@Override
	public String modbus1_target() {
		return ConfigUtils.generateReferenceTargetFilter(this.id(), this.modbus_id1());
	}

	@Override
	public String modbus2_target() {
		return ConfigUtils.generateReferenceTargetFilter(this.id(), this.modbus_id2());
	}

}