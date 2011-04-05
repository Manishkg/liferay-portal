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

package com.liferay.portalweb.portal.dbupgrade.sampledata523.stagingcommunity.quartz;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddSchedulerEventStagingCommunityQuartzTest extends BaseTestCase {
	public void testAddSchedulerEventStagingCommunityQuartz()
		throws Exception {
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
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Communities",
			RuntimeVariables.replace("Communities"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Community Staging Community Quartz"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isPartialText("//tr[3]/td[1]",
				"Community Staging Community Quartz"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//strong/span"));
		selenium.clickAt("//strong/span", RuntimeVariables.replace("Actions"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Manage Pages"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Publish to Live']",
			RuntimeVariables.replace("Publish to Live"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//li[@id='_134_exportPagesTabsschedulerTabsId']/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Scheduler"),
			selenium.getText(
				"//li[@id='_134_exportPagesTabsschedulerTabsId']/a"));
		selenium.clickAt("//li[@id='_134_exportPagesTabsschedulerTabsId']/a",
			RuntimeVariables.replace("Scheduler"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//input[@name='_134_description']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.type("//input[@name='_134_description']",
			RuntimeVariables.replace("Quartz Scheduler Event"));
		selenium.saveScreenShotAndSource();
		selenium.select("//select[@id='_134_schedulerStartDateMonth']",
			RuntimeVariables.replace("December"));
		selenium.select("//select[@id='_134_schedulerStartDateDay']",
			RuntimeVariables.replace("31"));
		selenium.select("//select[@id='_134_schedulerStartDateYear']",
			RuntimeVariables.replace("2011"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Add Event']",
			RuntimeVariables.replace("Add Event"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("Quartz Scheduler Event")
										.equals(selenium.getText(
								"//div[@id='_134_scheduledPublishEventsDiv']/div/table/tbody/tr[3]/td[1]"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Quartz Scheduler Event"),
			selenium.getText(
				"//div[@id='_134_scheduledPublishEventsDiv']/div/table/tbody/tr[3]/td[1]"));
	}
}