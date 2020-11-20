package org.sonar.zaproxy.parser;

/*-
 * #%L
 * ZAP Plugin for SonarQube
 * %%
 * Copyright (C) 2015 - 2020 Gene Gotimer <eugene.gotimer@steampunk.com>
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.sonar.api.config.Settings;
import org.sonar.zaproxy.ZapSensorConfiguration;
import org.sonar.zaproxy.base.ZapConstants;

public class ZapSensorConfigurationTest {

  private Settings settings;
  private ZapSensorConfiguration sensorConfiguration;

  @Before
  public void init() {
    this.settings = mock(Settings.class);
    this.sensorConfiguration = new ZapSensorConfiguration(this.settings);
  }

  @Test
  public void testGetReportPath() {
    when(this.settings.getString(ZapConstants.REPORT_PATH_PROPERTY)).thenReturn("location");
    assertThat(this.sensorConfiguration.getReportPath()).isEqualTo("location");
  }
}