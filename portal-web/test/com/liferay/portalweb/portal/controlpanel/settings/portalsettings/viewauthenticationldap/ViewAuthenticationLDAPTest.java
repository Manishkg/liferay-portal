/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.controlpanel.settings.portalsettings.viewauthenticationldap;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewAuthenticationLDAPTest extends BaseTestCase {
	public void testViewAuthenticationLDAP() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//a[@id='_130_authenticationLink']",
			RuntimeVariables.replace(""));
		selenium.clickAt("link=LDAP", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"_130_settings--ldap.auth.enabled--Checkbox")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isElementPresent(
				"_130_settings--ldap.auth.enabled--Checkbox"));
		assertTrue(selenium.isElementPresent(
				"_130_settings--ldap.auth.required--Checkbox"));
		assertTrue(selenium.isElementPresent("_130_ldapImportEnabledCheckbox"));
		assertTrue(selenium.isElementPresent("_130_ldapExportEnabledCheckbox"));
		assertTrue(selenium.isElementPresent(
				"_130_settings--ldap.password.policy.enabled--Checkbox"));
		selenium.clickAt("//div/span/span/input",
			RuntimeVariables.replace("Add"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals("ldap://localhost:10389",
			selenium.getValue("_130_settings--ldap.base.provider.url--"));
		selenium.clickAt("//input[@name='_130_defaultLdap' and @value='microsoft']",
			RuntimeVariables.replace(""));
		selenium.clickAt("//div[2]/span/span/input",
			RuntimeVariables.replace("Reset Values"));
		assertEquals("ldap://localhost:389",
			selenium.getValue("_130_settings--ldap.base.provider.url--"));
		assertTrue(selenium.isElementPresent(
				"//input[@value='Test LDAP Connection']"));
		assertTrue(selenium.isElementPresent(
				"//input[@value='Test LDAP Users']"));
		assertTrue(selenium.isElementPresent(
				"//input[@value='Test LDAP Groups']"));
	}
}